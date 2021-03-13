package oopexcersise.vendingmachine.src;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class VendingMachine {
	List<Coin> insertedCoinList = new ArrayList<Coin>();

	// TODO 無効なコインが複数入った場合を想定する
	public Coin returnedCoin() {
		return null;
	}

	// TODO 無効なコインが複数入った場合を想定する
	public Coin savedCoin() {
		return null;
	}

	public String display() {
		int totalamount = totalAmount();
		if (totalamount == 0) {
			return "INSERTCOIN";
		}
		return String.valueOf(totalamount);
	}

	public void insertedCoin(Coin coin) {
		insertedCoinList.add(coin);
	}

	private int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : insertedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}

}
