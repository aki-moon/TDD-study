package vendingmachine.src.coin;

import java.math.BigDecimal;

public class CoinChecker {
	private static final BigDecimal NICKEL_WEIGHT = BigDecimal.valueOf(5.0);
	private static final double NICKEL_DIAMETER = 21.21;
	private static final BigDecimal DIME_WEIGHT = BigDecimal.valueOf(2.268);
	private static final double DIME_DIAMETER = 17.91;
	private static final BigDecimal QUARTER_WEIGHT = BigDecimal.valueOf(5.67);
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
		return CoinType.UNVALID;
	}

	private static boolean isNickel(Coin coin) {
		return (coin.weight().compareTo(NICKEL_WEIGHT) == 0) && coin.diameter() == NICKEL_DIAMETER;
	}

	private static boolean isDime(Coin coin) {
		System.out.println("diameter" + coin.diameter());
		System.out.println("weight" + coin.weight());
		return (coin.weight().compareTo(DIME_WEIGHT) == 0) && coin.diameter() == DIME_DIAMETER;
	}

	private static boolean isQuarter(Coin coin) {
		return (coin.weight().compareTo(QUARTER_WEIGHT) == 0) && coin.diameter() == QUARTER_DIAMETER;
	}

}
