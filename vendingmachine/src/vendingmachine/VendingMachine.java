package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;
import oopexcersise.vendingmachine.src.product.Product;
import oopexcersise.vendingmachine.src.state.DisplayPanelState;
import oopexcersise.vendingmachine.src.state.RequestCoinState;
import oopexcersise.vendingmachine.src.state.ShowAmountState;

public class VendingMachine {
	private List<Coin> savedCoinList = new ArrayList<Coin>();
	private List<Coin> returnedCoinList = new ArrayList<Coin>();
	private DisplayPanelState state = RequestCoinState.getInstance();
	private Product selectedProduct;

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
		if (coin.isValidCoin()) {
			savedCoinList.add(coin);
			state = ShowAmountState.getInstance();
		}
		if (!coin.isValidCoin()) {
			returnedCoinList.add(coin);
		}
	}

	public void pushButton(Product product) {
		selectedProduct = product;
	}

	public void check() {
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (selectedProduct.value() == totalAmount()) {
			returnedProduct = selectedProduct;
			clearSelectedProduct();
			state = RequestCoinState.getInstance();
		}
		return returnedProduct;
	}

	private Product clearSelectedProduct() {
		return selectedProduct = null;
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
