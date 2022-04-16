export class CurrencyRecordResponseDto{

    date: string;

    bidPrice: number;

    salePrice: number;

    constructor() {
        this.date = '';
        this.bidPrice = 0;
        this.salePrice = 0;
    }

}
