package vendingmachine.src.coin;

public enum CoinType {
	QUARTER(25), DIME(10), NICKEL(5), UNVALID(0);

	private int value;

	CoinType(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}