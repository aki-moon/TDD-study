package oopexcersise.vendingmachine.src.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;
import oopexcersise.vendingmachine.src.state.AfterPurchaseState;
import oopexcersise.vendingmachine.src.state.DisplayPanelState;
import oopexcersise.vendingmachine.src.state.RequestCoinState;
import oopexcersise.vendingmachine.src.state.ShowAmountState;

public class DisplayPanel {
	private DisplayPanelState state = RequestCoinState.getInstance();
	private List<Coin> savedCoinList = new ArrayList<Coin>();

	public String display() {
		return state.display(this);
	}

	public void addCoin(Coin coin) {
		savedCoinList.add(coin);
		state = ShowAmountState.getInstance();
	}

	public void returnedProduct() {
		state = AfterPurchaseState.getInstance();
	}

	public List<Coin> savedCoinList() {
		return savedCoinList;
	}

	public int totalAmount() {
		int totalAmount = 0;
		for (Coin coin : savedCoinList) {
			CoinType coinType = CoinChecker.checkCoin(coin);
			totalAmount += coinType.coinValue();
		}
		return totalAmount;
	}

}
