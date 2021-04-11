package vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.coin.CoinType;

public class SavedCoin {
	private List<Coin> savedCoinList = new ArrayList<Coin>();

	public void add(Coin coin) {
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
