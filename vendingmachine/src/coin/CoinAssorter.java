package vendingmachine.src.coin;

import static vendingmachine.src.coin.CoinConstant.*;
import static vendingmachine.src.coin.CoinType.*;

public class CoinAssorter {
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
			return NICKEL;
		}
		if (coinType == DIME_TYPE) {
			return DIME;
		}
		if (coinType == QUARTER_TYPE) {
			return QUARTER;
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