package vendingmachine.src.vendingmachine;

import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.product.Product;
import vendingmachine.src.state.ShowProductPriceState;

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

	public void insertCoin(Coin coin) {
		if (isReturnAsChange(coin)) {
			change.add(coin);
			return;
		}
		insertedCoin.add(coin);
		savedCoin.add(coin);
		if (canPurchaseProduct()) {
			displayPanel.add(coin);
		}
	}

	private boolean canPurchaseProduct() {
		if (selectedProduct == null) {
			return true;
		}
		if (selectedProduct.canPurchase(insertedCoin.totalAmount())) {
			return true;
		}
		return false;
	}

	public Product returnedProduct() {
		Product returnedProduct = null;
		if (canPurchaseProduct()) {
			returnedProduct = selectedProduct;
			makeChange();
			clearSelectedProduct();
			insertedCoin.clear();
			displayPanel.clear();
		}
		return returnedProduct;
	}

	public void pushProductButton(Product product) {
		if (inventory.isSoldOut()) {
			return;
		}
		this.selectedProduct = product;
		ShowProductPriceState.getInstance().productPrice(product.price());
		displayPanel.pushProductButton();
	}

	public void pushChangeButton() {
		for (Coin coin : insertedCoin.insertedCoinList()) {
			change.add(coin);
		}
		insertedCoin.clear();
		check();
	}

	public void takeOutAllInventory() {
		inventory.takeOutAll();
		displayPanel.soldOut();
	}

	public String display() {
		return displayPanel.display(insertedCoin.totalAmount());
	}

	public void check() {
		if (insertedCoin.totalAmount() != 0) {
			displayPanel.add(null);
			return;
		}
		displayPanel.check();
	}

	private boolean isReturnAsChange(Coin coin) {
		if (inventory.isSoldOut()) {
			return true;
		}
		if (coin.isUnvalidCoin()) {
			return true;
		}
		return false;
	}

	private void makeChange() {
		int totalChange = insertedCoin.totalAmount() - selectedProduct.price();
		Coin changeCoin = CoinAssorter.makeChange(totalChange);
		if (changeCoin != null) {
			change.add(changeCoin);
		}
	}

	private void clearSelectedProduct() {
		selectedProduct = null;
	}
}
