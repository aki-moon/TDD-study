package vendingmachine.src.vendingmachine;

import vendingmachine.src.state.AfterPurchaseState;
import vendingmachine.src.state.DisplayPanelState;
import vendingmachine.src.state.RequestCoinState;
import vendingmachine.src.state.ShowAmountState;
import vendingmachine.src.state.ShowProductPriceState;
import vendingmachine.src.state.SoldOutState;

public class DisplayPanel {
	private DisplayPanelState state = RequestCoinState.getInstance();

	public String display(int totalAmount) {
		return state.display(totalAmount);
	}

	public void showAmount() {
		state = ShowAmountState.getInstance();
	}

	public void check() {
		state = RequestCoinState.getInstance();
	}

	public void clear() {
		state = AfterPurchaseState.getInstance();
	}

	public void soldOut() {
		state = SoldOutState.getInstance();
	}

	public void pushProductButton() {
		state = ShowProductPriceState.getInstance();
	}

}
