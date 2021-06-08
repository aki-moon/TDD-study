package vendingmachine.src.coin;

public enum CoinType {
	QUARTER_TYPE(25), DIME_TYPE(10), NICKEL_TYPE(5), UNVALID_TYPE(0);

	private int value;

	CoinType(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}