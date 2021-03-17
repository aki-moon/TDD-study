package oopexcersise.vendingmachine.src;

import static oopexcersise.vendingmachine.src.cointype.CoinType.*;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

public class VendingMachine {
	List<Coin> insertedCoinList = new ArrayList<Coin>();
	List<Coin> savedCoinList = new ArrayList<Coin>();

	public List<Coin> returnedCoin() {
		List<Coin> returnedCoinList = new ArrayList<Coin>();
		for (Coin coin : insertedCoinList) {
			if (CoinChecker.checkCoin(coin) == UNDEFINED) {
				returnedCoinList.add(coin);
			}
		}
		return returnedCoinList;
	}

	public List<Coin> savedCoin() {
		List<Coin> savedCoinList = new ArrayList<Coin>();
		for (Coin coin : insertedCoinList) {
			if (CoinChecker.checkCoin(coin) != UNDEFINED) {
				savedCoinList.add(coin);
			}
		}
		return savedCoinList;
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
