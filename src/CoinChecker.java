package oopexcersise.vendingmachine.src;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class CoinChecker {

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
		return coin.weight() == 10 && coin.diameter() == 2;
	}

	private static boolean isDime(Coin coin) {
		return coin.weight() == 20 && coin.diameter() == 3;
	}

	private static boolean isQuarter(Coin coin) {
		return coin.weight() == 30 && coin.diameter() == 5;
	}

}
