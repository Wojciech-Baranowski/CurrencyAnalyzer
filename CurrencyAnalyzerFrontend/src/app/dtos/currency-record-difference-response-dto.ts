export class CurrencyRecordDifferenceResponseDto{

  date: string;

  bidPriceDifference: number;

  salePriceDifference: number;

  constructor() {
      this.date = '';
      this.bidPriceDifference = 0;
      this.salePriceDifference = 0;
  }

}
