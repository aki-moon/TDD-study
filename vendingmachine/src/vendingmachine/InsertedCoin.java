package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;

public class InsertedCoin {
	private List<Coin> insertedCoinList = new ArrayList<Coin>();

	public void addCoin(Coin coin) {
		insertedCoinList.add(coin);
	}

	public List<Coin> insertedCoinList() {
		return insertedCoinList;
	}

	public void clear() {
		insertedCoinList.clear();
	}

	public int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : insertedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}
}
