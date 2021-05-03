package vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.src.coin.Coin;

public class Change {
	private List<Coin> returnedCoinList = new ArrayList<Coin>();

	public List<Coin> coinList() {
		return returnedCoinList;
	}

	public void add(Coin coin) {
		returnedCoinList.add(coin);
	}
}
