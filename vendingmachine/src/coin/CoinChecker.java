package vendingmachine.src.coin;

public class CoinChecker {
	private static final double NICKEL_WEIGHT = 5.0;
	private static final double NICKEL_DIAMETER = 21.21;
	private static final double DIME_WEIGHT = 2.268;
	private static final double DIME_DIAMETER = 17.91;
	private static final double QUARTER_WEIGHT = 5.67;
	private static final double QUARTER_DIAMETER = 24.26;

	public static CoinType checkCoin(Coin coin) {
		if (isNickel(coin)) {
			return CoinType.NICKEL;
		}
		if (isDime(coin)) {
			return CoinType.DIME;
		}
		if (isQuarter(coin)) {
			return CoinType.QUARTER;
		}
		return CoinType.UNDEFINED;
	}

	private static boolean isNickel(Coin coin) {
		return coin.weight() == NICKEL_WEIGHT && coin.diameter() == NICKEL_DIAMETER;
	}

	private static boolean isDime(Coin coin) {
		return coin.weight() == DIME_WEIGHT && coin.diameter() == DIME_DIAMETER;
	}

	private static boolean isQuarter(Coin coin) {
		return coin.weight() == QUARTER_WEIGHT && coin.diameter() == QUARTER_DIAMETER;
	}

}
