package oopexcersise.vendingmachine.src;

public class CoinChecker {

	public CoinType checkCoin(Coin coin) {
		if (isNickel(coin)) {
			return CoinType.Nickel;
		}
		if (isDime(coin)) {
			return CoinType.Dime;
		}
		return null;
	}

	private boolean isDime(Coin coin) {
		return coin.getWeight() == 20 && coin.getDiameter() == 3;
	}

	private boolean isNickel(Coin coin) {
		return coin.getWeight() == 10 && coin.getDiameter() == 2;
	}

}
