import {CurrencyRecordResponseDto} from "./currency-record-response-dto";
import {CurrencyRecordDifferenceResponseDto} from "./currency-record-difference-response-dto";

export class CurrencyResponseDto {

    name: string;

    code: string;

    records: CurrencyRecordResponseDto[];

    recordsDifferences: CurrencyRecordDifferenceResponseDto[];

    constructor() {
        this.name = '';
        this.code = '';
        this.records = [];
        this.records.push(new CurrencyRecordResponseDto())
        this.recordsDifferences = [];
        this.recordsDifferences.push(new CurrencyRecordDifferenceResponseDto())
    }

}
