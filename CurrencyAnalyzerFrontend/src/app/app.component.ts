import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CurrencyResponseDto} from "./dtos/currency-response-dto";
import {FormBuilder} from "@angular/forms";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{

    private URL_PREFIX = 'http://localhost:8080/currency';
    private data: CurrencyResponseDto;

    filter = this.formBuilder.group({
        currencyCode: 'USD',
        startDate: this.getYearBeforeDate(),
        endDate: this.getTodayDate(),
    });

    bidTrace = {
        x: [''],
        y: [0],
        mode: 'lines',
        line: {
            color: 'rgb(55, 128, 191)',
            width: 1.5
        },
        name: 'bidPrice'
    };

    saleTrace = {
        x: [''],
        y: [0],
        mode: 'lines',
        line: {
            color: 'rgb(191, 55, 55)',
            width: 1.5
        },
        name: 'salePrice'
    };

    bidDifferenceTrace = {
        x: [''],
        y: [0],
        mode: 'lines',
        line: {
            color: 'rgb(55, 128, 191)',
            width: 1
        },
        name: 'bidPriceDifference'
    };

    saleDifferenceTrace = {
        x: [''],
        y: [0],
        mode: 'lines',
        line: {
            color: 'rgb(191, 55, 55)',
            width: 1
        },
        name: 'salePriceDifference'
    };

    layout = {
        title: '',
        xaxis: {
            type: 'date'
        },
        yaxis: {
            type: 'linear'
        }
    };

    priceTraces = [this.bidTrace, this.saleTrace];
    differenceTraces = [this.bidDifferenceTrace, this.saleDifferenceTrace];

    constructor(private http: HttpClient, private formBuilder: FormBuilder) {
        this.data = new CurrencyResponseDto();
    }

    ngOnInit() {
        this.getData();
    }

    onSubmit() {
        this.getData();
    }

    private getData() {
        let currencyCode = this.filter.controls['currencyCode'].value;
        let startDate = this.filter.controls['startDate'].value;
        let endDate = this.filter.controls['endDate'].value;
        this.http.post<CurrencyResponseDto>(`${this.URL_PREFIX}`,
          {currencyCode: currencyCode, startDate: startDate, endDate: endDate})
            .subscribe(data => {
                this.data = data;
                this.createPricePlotTraces();
                this.createDifferencePlotTraces();
                this.layout.title = this.data.name + ' (' + this.filter.controls['currencyCode'].value + ')';
            }, error => console.log(error));
    }

    private createPricePlotTraces(){

        this.bidTrace.x = this.data.records.map(record => record.date);
        this.bidTrace.y = this.data.records.map(record => record.bidPrice);

        this.saleTrace.x = this.data.records.map(record => record.date);
        this.saleTrace.y = this.data.records.map(record => record.salePrice);

        this.priceTraces = [this.bidTrace, this.saleTrace];

    }

    private createDifferencePlotTraces(){

        this.bidDifferenceTrace.x = this.data.recordsDifferences.map(record => record.date);
        this.bidDifferenceTrace.y = this.data.recordsDifferences.map(record => record.bidPriceDifference);

        this.saleDifferenceTrace.x = this.data.recordsDifferences.map(record => record.date);
        this.saleDifferenceTrace.y = this.data.recordsDifferences.map(record => record.salePriceDifference);

        this.differenceTraces = [this.bidDifferenceTrace, this.saleDifferenceTrace];

    }

    private getTodayDate(){
        let today = new Date();
        let dd = String(today.getDate()).padStart(2, '0');
        let mm = String(today.getMonth() + 1).padStart(2, '0');
        let yyyy = today.getFullYear();
        return yyyy + '-' + mm + '-' + dd;
    }

    private getYearBeforeDate(){
        let today = new Date();
        let dd = String(today.getDate()).padStart(2, '0');
        let mm = String(today.getMonth() + 1).padStart(2, '0');
        let yyyy = today.getFullYear() - 1;
        return yyyy + '-' + mm + '-' + dd;
    }

}
