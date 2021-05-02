package vendingmachine.src.coin;

import java.util.ArrayList;
import java.util.List;

public class ReturnedCoin {
	private List<Coin> returnedCoinList = new ArrayList<Coin>();

	public List<Coin> coinList() {
		return returnedCoinList;
	}

	public void add(Coin coin) {
		returnedCoinList.add(coin);
	}
}
