package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;

public class SavedCoin {
	private List<Coin> savedCoinList = new ArrayList<Coin>();

	public void addCoin(Coin coin) {
		savedCoinList.add(coin);
	}

	public List<Coin> savedCoinList() {
		return savedCoinList;
	}

	public int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : savedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}

}
