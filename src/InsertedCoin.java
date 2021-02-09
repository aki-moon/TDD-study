package oopexcersise.vendingmachine.src;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class InsertedCoin {
	List<Coin> insertedCoinList = new ArrayList<Coin>();

	public int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : insertedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}

	public void putCoin(Coin coin) {
		insertedCoinList.add(coin);
	}

}
