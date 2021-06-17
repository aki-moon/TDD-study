package vendingmachine.src.coin;

import static vendingmachine.src.coin.CoinType.*;

public class CoinAssorter {
	private static final Coin NICKEL = CoinCreater.createNickel();
	private static final Coin DIME = CoinCreater.createDime();
	private static final Coin QUARTER = CoinCreater.createQuarter();

	private CoinAssorter() {
		// do nothing
	}

	public static CoinType checkCoin(Coin coin) {
		if (isNickel(coin)) {
			return NICKEL_TYPE;
		}
		if (isDime(coin)) {
			return DIME_TYPE;
		}
		if (isQuarter(coin)) {
			return QUARTER_TYPE;
		}
		return UNVALID_TYPE;
	}

	public static CoinType checkCoin(int coinValue) {
		if (coinValue == NICKEL_TYPE.value()) {
			return NICKEL_TYPE;
		}
		if (coinValue == DIME_TYPE.value()) {
			return DIME_TYPE;
		}
		if (coinValue == QUARTER_TYPE.value()) {
			return QUARTER_TYPE;
		}
		return UNVALID_TYPE;
	}

	public static Coin createCoin(CoinType coinType) {
		if (coinType == NICKEL_TYPE) {
			return CoinCreater.createNickel();
		}
		if (coinType == DIME_TYPE) {
			return CoinCreater.createDime();
		}
		if (coinType == QUARTER_TYPE) {
			return CoinCreater.createQuarter();
		}
		return null;
	}

	public static Coin changeCoin(int totalChange) {
		CoinType changeCoinType = checkCoin(totalChange);
		Coin changeCoin = createCoin(changeCoinType);
		return changeCoin;
	}

	private static boolean isNickel(Coin coin) {
		return coin.equals(NICKEL);
	}

	private static boolean isDime(Coin coin) {
		return coin.equals(DIME);
	}

	private static boolean isQuarter(Coin coin) {
		return coin.equals(QUARTER);
	}
}