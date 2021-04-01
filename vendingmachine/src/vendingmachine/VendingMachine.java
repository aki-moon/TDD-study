package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.SelectedProduct;
import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.product.Product;

public class VendingMachine {
	private List<Coin> returnedCoinList = new ArrayList<Coin>();
	private DisplayPanel displayPanel = new DisplayPanel();
	private SelectedProduct selectedProduct = new SelectedProduct();

	public List<Coin> returnedCoin() {
		return returnedCoinList;
	}

	public List<Coin> savedCoin() {
		return displayPanel.savedCoinList();
	}

	public String display() {
		return displayPanel.display();
	}

	public void insertedCoin(Coin coin) {
		if (coin.isValidCoin()) {
			displayPanel.addCoin(coin);
		}
		if (!coin.isValidCoin()) {
			returnedCoinList.add(coin);
		}
	}

	public void pushButton(Product product) {
		selectedProduct.setProduct(product);
	}

	public void check() {
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (selectedProduct.value() == displayPanel.totalAmount()) {
			returnedProduct = selectedProduct.product();
			clearSelectedProduct();
			displayPanel.returnedProduct();
		}
		return returnedProduct;
	}

	private void clearSelectedProduct() {
		selectedProduct = null;
	}

}
