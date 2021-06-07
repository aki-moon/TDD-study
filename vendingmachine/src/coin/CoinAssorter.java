package vendingmachine.src.coin;

import static vendingmachine.src.coin.CoinType.*;

import java.math.BigDecimal;

public class CoinAssorter {
	private static final BigDecimal NICKEL_WEIGHT = BigDecimal.valueOf(5.0);
	private static final BigDecimal NICKEL_DIAMETER = BigDecimal.valueOf(21.21);
	private static final BigDecimal DIME_WEIGHT = BigDecimal.valueOf(2.268);
	private static final BigDecimal DIME_DIAMETER = BigDecimal.valueOf(17.91);
	private static final BigDecimal QUARTER_WEIGHT = BigDecimal.valueOf(5.67);
	private static final BigDecimal QUARTER_DIAMETER = BigDecimal.valueOf(24.26);

	private CoinAssorter() {
		// do nothing
	}

	public static CoinType checkCoin(Coin coin) {
		if (isNickel(coin)) {
			return NICKEL;
		}
		if (isDime(coin)) {
			return DIME;
		}
		if (isQuarter(coin)) {
			return QUARTER;
		}
		return UNVALID;
	}

	public static CoinType checkCoin(int coinValue) {
		if (coinValue == NICKEL.value()) {
			return NICKEL;
		}
		if (coinValue == DIME.value()) {
			return DIME;
		}
		if (coinValue == QUARTER.value()) {
			return QUARTER;
		}
		return UNVALID;
	}

	public static Coin createCoin(CoinType coinType) {
		if (coinType == NICKEL) {
			return CoinCreater.createNickel();
		}
		if (coinType == DIME) {
			return CoinCreater.createDime();
		}
		if (coinType == QUARTER) {
			return CoinCreater.createQuarter();
		}
		return null;
	}

	private static boolean isNickel(Coin coin) {
		return (coin.weight().compareTo(NICKEL_WEIGHT) == 0) && (coin.diameter().compareTo(NICKEL_DIAMETER) == 0);
	}

	private static boolean isDime(Coin coin) {
		return (coin.weight().compareTo(DIME_WEIGHT) == 0) && (coin.diameter().compareTo(DIME_DIAMETER) == 0);
	}

	private static boolean isQuarter(Coin coin) {
		return (coin.weight().compareTo(QUARTER_WEIGHT) == 0) && (coin.diameter().compareTo(QUARTER_DIAMETER) == 0);
	}
}