package oopexcersise.vendingmachine.src.cointype;

public enum CoinType {
	DIME(10)//
	, NICKEL(5)//
	, QUARTER(1)//
	, UNDEFINED(0);

	private int coinValue;

	CoinType(int coinValue) {
		this.coinValue = coinValue;
	}

	public int coinValue() {
		return coinValue;
	}
}
