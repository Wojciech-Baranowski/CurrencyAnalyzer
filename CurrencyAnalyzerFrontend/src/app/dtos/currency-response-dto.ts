import {CurrencyRecordResponseDto} from "./currency-record-response-dto";
import {CurrencyRecordDifferenceResponseDto} from "./currency-record-difference-response-dto";

export interface CurrencyResponseDto {

  name: string;

  code: string;

  records: CurrencyRecordResponseDto[];

  recordsDifferences: CurrencyRecordDifferenceResponseDto[];

}
