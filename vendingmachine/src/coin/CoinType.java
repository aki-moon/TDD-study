package vendingmachine.src.coin;

public enum CoinType {
	QUARTER(25)//
	, DIME(10)//
	, NICKEL(5)//
	, UNDEFINED(0);

	private int coinValue;

	CoinType(int coinValue) {
		this.coinValue = coinValue;
	}

	public int coinValue() {
		return coinValue;
	}
}
