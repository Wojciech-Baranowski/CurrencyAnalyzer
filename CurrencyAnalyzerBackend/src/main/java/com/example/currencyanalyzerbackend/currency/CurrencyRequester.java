package com.example.currencyanalyzerbackend.currency;

import com.example.currencyanalyzerbackend.currency.dto.CurrencyRequestedDto;
import com.example.currencyanalyzerbackend.currencyRecord.dto.CurrencyRecordRequestedDto;
import com.example.currencyanalyzerbackend.date.RequestDataDto;
import com.example.currencyanalyzerbackend.exceptions.BadRequestException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.currencyanalyzerbackend.date.DateMapper.dateToString;
import static com.example.currencyanalyzerbackend.date.DateMapper.stringToDate;
import static com.example.currencyanalyzerbackend.date.DateService.*;

public class CurrencyRequester {

    private static final String URL_PREFIX = "https://api.nbp.pl/api/exchangerates/rates/C/";

    private final HttpClient client;

    public CurrencyRequester() {
        client = HttpClient.newHttpClient();
    }

    public CurrencyRequestedDto getRequestedCurrency(RequestDataDto fullRequestDataDto) {
        List<CurrencyRequestedDto> shortRequestedCurrencyDtos = getShortRequestedCurrencyDtos(fullRequestDataDto);

        return CurrencyRequestedDto.builder()
                .tableId(shortRequestedCurrencyDtos.get(0).getTableId())
                .code(shortRequestedCurrencyDtos.get(0).getCode())
                .name(shortRequestedCurrencyDtos.get(0).getName())
                .records(mergeRequestedCurrencyRecordsDtos(shortRequestedCurrencyDtos))
                .build();
    }

    private List<CurrencyRecordRequestedDto> mergeRequestedCurrencyRecordsDtos(
            List<CurrencyRequestedDto> shortRequestedCurrencyDtos) {
        return shortRequestedCurrencyDtos.stream()
                .map(CurrencyRequestedDto::getRecords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<CurrencyRequestedDto> getShortRequestedCurrencyDtos(RequestDataDto fullRequestDataDto){
        return getShortRequestDataDtos(fullRequestDataDto).stream()
                .map(this::request)
                .collect(Collectors.toList());
    }

    private List<RequestDataDto> getShortRequestDataDtos(RequestDataDto fullRequestDataDto) {
        List<RequestDataDto> shortRequestDataDtos = new LinkedList<>();
        Date endDate = stringToDate(fullRequestDataDto.getEndDate());
        Date currentStartDate = weekBefore(stringToDate(fullRequestDataDto.getStartDate()));

        while (currentStartDate.before(endDate) || currentStartDate.equals(endDate)) {
            shortRequestDataDtos.add(getShortRequestDataDto(fullRequestDataDto, currentStartDate));
            currentStartDate = yearAndDayAfter(currentStartDate);
        }
        return shortRequestDataDtos;
    }

    private RequestDataDto getShortRequestDataDto(RequestDataDto fullRequestDataDto, Date currentRequestStartDate){
        Date yearAfterCurrentStartDate = yearAfter(currentRequestStartDate);
        Date endDate = stringToDate(fullRequestDataDto.getEndDate());
        Date currentRequestEndDate = chooseEarlierDate(yearAfterCurrentStartDate, endDate);

        return RequestDataDto.builder()
                .currencyCode(fullRequestDataDto.getCurrencyCode())
                .startDate(dateToString(currentRequestStartDate))
                .endDate(dateToString(currentRequestEndDate))
                .build();
    }

    private CurrencyRequestedDto request(RequestDataDto requestDataDto){
        HttpRequest request = createRequest(requestDataDto);

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(this::handleRequestErrors)
                .thenApply(HttpResponse::body)
                .thenApply(CurrencyMapper::jsonStringToRequestedDto)
                .join();
    }

    private HttpResponse<String> handleRequestErrors(HttpResponse<String> response) {
        int status = response.statusCode();
        switch (status){
            case 400: throw new BadRequestException("Invalid Request data");
            default: return response;
        }
    }

    private HttpRequest createRequest(RequestDataDto requestDataDto) {
        String url = createUrl(requestDataDto);
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    private String createUrl(RequestDataDto requestDataDto) {
        return new StringBuffer()
                .append(URL_PREFIX)
                .append(requestDataDto.getCurrencyCode())
                .append('/')
                .append(requestDataDto.getStartDate())
                .append('/')
                .append(requestDataDto.getEndDate())
                .toString();
    }

}


