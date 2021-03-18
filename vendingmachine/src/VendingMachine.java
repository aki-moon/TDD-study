package oopexcersise.vendingmachine.src;

import static oopexcersise.vendingmachine.src.cointype.CoinType.*;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class VendingMachine {
	List<Coin> savedCoinList = new ArrayList<Coin>();
	List<Coin> returnedCoinList = new ArrayList<Coin>();
	List<Coin> insertedCoinList = new ArrayList<Coin>();

	public List<Coin> returnedCoin() {
		return returnedCoinList;
	}

	public List<Coin> savedCoin() {
		return savedCoinList;
	}

	public String display() {
		if (totalAmount() == 0) {
			return "INSERTCOIN";
		}
		return String.valueOf(totalAmount());
	}

	public void insertedCoin(Coin coin) {
		if (CoinChecker.checkCoin(coin) == UNDEFINED) {
			returnedCoinList.add(coin);
		}
		if (CoinChecker.checkCoin(coin) != UNDEFINED) {
			savedCoinList.add(coin);
		}
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
