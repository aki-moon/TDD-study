package vendingmachine.src.vendingmachine;

import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinType;
import vendingmachine.src.product.Product;

public class VendingMachine {
	private DisplayPanel displayPanel = new DisplayPanel();
	private Change change = new Change();
	private SavedCoin savedCoin = new SavedCoin();
	private InsertedCoin insertedCoin = new InsertedCoin();
	private Product selectedProduct;
	private Inventory inventory = new Inventory();

	public List<Coin> returnedCoin() {
		return change.coinList();
	}

	public List<Coin> savedCoin() {
		return savedCoin.savedCoinList();
	}

	public String display() {
		return displayPanel.display(insertedCoin.totalAmount());
	}

	public void insertCoin(Coin coin) {
		if (inventory.isSoldOut()) {
			change.add(coin);
			return;
		}
		if (coin.isValidCoin()) {
			insertedCoin.add(coin);
			savedCoin.add(coin);
			displayPanel.add(coin);
		}
		if (coin.isUnvalidCoin()) {
			change.add(coin);
		}
	}

	public void pushProductButton(Product product) {
		this.selectedProduct = product;
	}

	public void check() {
		displayPanel.check();
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (insertedCoin.totalAmount() >= selectedProduct.amount()) {
			returnedProduct = selectedProduct;
			makeChange();
			clearSelectedProduct();
			insertedCoin.clear();
			displayPanel.clear();
		}
		return returnedProduct;
	}

	private void makeChange() {
		int totalChange = insertedCoin.totalAmount() - selectedProduct.amount();
		CoinType changeCoinType = CoinAssorter.checkCoin(totalChange);
		Coin changeCoin = CoinAssorter.createCoin(changeCoinType);
		change.add(changeCoin);
	}

	private void clearSelectedProduct() {
		selectedProduct = null;
	}

	public void pushChangeButton() {
		for (Coin coin : insertedCoin.insertedCoinList()) {
			change.add(coin);
		}
		check();
	}

	public void takeOutAllInventory() {
		inventory.takeOutAll();
		displayPanel.soldOut();
	}

}
