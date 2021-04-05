package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.product.Product;
import oopexcersise.vendingmachine.src.product.SelectedProduct;

public class VendingMachine {
	private List<Coin> returnedCoinList = new ArrayList<Coin>();
	private DisplayPanel displayPanel = new DisplayPanel();
	private SelectedProduct selectedProduct = new SelectedProduct();
	private SavedCoin savedCoin = new SavedCoin();
	private InsertedCoin insertedCoin = new InsertedCoin();

	public List<Coin> returnedCoin() {
		return returnedCoinList;
	}

	public List<Coin> savedCoin() {
		return savedCoin.savedCoinList();
	}

	public String display() {
		return displayPanel.display(insertedCoin.totalAmount());
	}

	public void insertedCoin(Coin coin) {
		if (coin.isValidCoin()) {
			insertedCoin.addCoin(coin);
			savedCoin.addCoin(coin);
			displayPanel.addCoin(coin);
		}
		if (coin.isUnvalidCoin()) {
			returnedCoinList.add(coin);
		}
	}

	public void pushButton(Product product) {
		selectedProduct.setProduct(product);
	}

	public void check() {
		displayPanel.check();
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (selectedProduct.value() == insertedCoin.totalAmount()) {
			returnedProduct = selectedProduct.product();
			clearSelectedProduct();
			insertedCoin.clear();
		}
		return returnedProduct;
	}

	private void clearSelectedProduct() {
		selectedProduct = null;
	}

}
