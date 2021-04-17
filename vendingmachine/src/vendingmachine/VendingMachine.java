package vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.product.Product;

public class VendingMachine {
	private List<Coin> returnedCoinList = new ArrayList<Coin>();
	private DisplayPanel displayPanel = new DisplayPanel();
	private Product selectedProduct;
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
			insertedCoin.add(coin);
			savedCoin.add(coin);
			displayPanel.add(coin);
		}
		if (coin.isUnvalidCoin()) {
			returnedCoinList.add(coin);
		}
	}

	public void pushButton(Product product) {
		this.selectedProduct = product;
	}

	public void check() {
		displayPanel.check();
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (selectedProduct.value() == insertedCoin.totalAmount()) {
			returnedProduct = selectedProduct;
			clearSelectedProduct();
			insertedCoin.clear();
			displayPanel.clear();
		}
		return returnedProduct;
	}

	private void clearSelectedProduct() {
		selectedProduct = null;
	}

}
