package oopexcersise.vendingmachine.src.state;

import oopexcersise.vendingmachine.src.vendingmachine.DisplayPanel;

public class AfterPurchaseState implements DisplayPanelState {
	private static AfterPurchaseState state = new AfterPurchaseState();

	private AfterPurchaseState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}

	@Override
	public String display(DisplayPanel displayPanel) {
		return "THANKYOU";
	}
}
