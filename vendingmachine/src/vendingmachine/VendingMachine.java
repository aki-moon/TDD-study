package oopexcersise.vendingmachine.src.vendingmachine;

import static oopexcersise.vendingmachine.src.coin.CoinType.*;
import static oopexcersise.vendingmachine.src.product.Product.*;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;
import oopexcersise.vendingmachine.src.product.Product;

public class VendingMachine {
	List<Coin> savedCoinList = new ArrayList<Coin>();
	List<Coin> returnedCoinList = new ArrayList<Coin>();

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
		if (isValidCoin(coin)) {
			returnedCoinList.add(coin);
		}
		if (!isValidCoin(coin)) {
			savedCoinList.add(coin);
		}
	}

	public void pushButton(Product cola) {
	}

	public void check() {
	}

	public Product returnedProduct() {
		return COLA;
	}

	private boolean isValidCoin(Coin coin) {
		return CoinChecker.checkCoin(coin) == UNDEFINED;
	}

	private int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : savedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}

}
