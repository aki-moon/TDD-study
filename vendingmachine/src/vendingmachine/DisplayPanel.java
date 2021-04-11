package vendingmachine.src.vendingmachine;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.state.AfterPurchaseState;
import vendingmachine.src.state.DisplayPanelState;
import vendingmachine.src.state.RequestCoinState;
import vendingmachine.src.state.ShowAmountState;

public class DisplayPanel {
	private DisplayPanelState state = RequestCoinState.getInstance();

	public String display(int totalAmount) {
		return state.display(totalAmount);
	}

	public void add(Coin coin) {
		state = ShowAmountState.getInstance();
	}

	public void check() {
		state = RequestCoinState.getInstance();
	}

	public void clear() {
		state = AfterPurchaseState.getInstance();
	}

}
