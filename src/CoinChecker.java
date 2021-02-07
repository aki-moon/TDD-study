package oopexcersise.vendingmachine.src;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class CoinChecker {

	public CoinType checkCoin(Coin coin) {
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

	private boolean isQuarter(Coin coin) {
		return coin.getWeight() == 30 && coin.getDiameter() == 5;
	}

	private boolean isDime(Coin coin) {
		return coin.getWeight() == 20 && coin.getDiameter() == 3;
	}

	private boolean isNickel(Coin coin) {
		return coin.getWeight() == 10 && coin.getDiameter() == 2;
	}

}
