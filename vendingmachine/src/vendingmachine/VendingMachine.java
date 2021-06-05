package vendingmachine.src.vendingmachine;

import java.util.List;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinType;
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

	public String display() {
		return displayPanel.display(insertedCoin.totalAmount());
	}

	public void insertCoin(Coin coin) {
		if (isReturnAsChange(coin)) {
			change.add(coin);
			return;
		}
		insertedCoin.add(coin);
		savedCoin.add(coin);
		if (selectedProduct == null || canPurchaseProduct()) {
			displayPanel.add(coin);
			return;
		}
	}

	private boolean canPurchaseProduct() {
		return insertedCoin.totalAmount() >= selectedProduct.price().intValue();
	}

	private boolean isReturnAsChange(Coin coin) {
		return inventory.isSoldOut() || coin.isUnvalidCoin();
	}

	public void pushProductButton(Product product) {
		if (inventory.isSoldOut()) {
			return;
		}
		this.selectedProduct = product;
		ShowProductPriceState.getInstance().productPrice(product.price().intValue());;
		displayPanel.pushProductButton();
	}

	public void check() {
		displayPanel.check();
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

	private void makeChange() {
		int totalChange = insertedCoin.totalAmount() - selectedProduct.price().intValue();
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
