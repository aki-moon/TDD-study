package oopexcersise.vendingmachine.src.vendingmachine;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.state.AfterPurchaseState;
import oopexcersise.vendingmachine.src.state.DisplayPanelState;
import oopexcersise.vendingmachine.src.state.RequestCoinState;
import oopexcersise.vendingmachine.src.state.ShowAmountState;

public class DisplayPanel {
	private DisplayPanelState state = RequestCoinState.getInstance();

	public String display(int totalAmount) {
		return state.display(totalAmount);
	}

	public void addCoin(Coin coin) {
		state = ShowAmountState.getInstance();
	}

	public void returnedProduct() {
		state = AfterPurchaseState.getInstance();
	}

}
