package vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.coin.CoinType;

public class InsertedCoin {
	private List<Coin> insertedCoinList = new ArrayList<Coin>();

	public void add(Coin coin) {
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
			totalAmount += coinType.value();
		}
		return totalAmount;
	}
}
