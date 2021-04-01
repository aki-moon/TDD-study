package oopexcersise.vendingmachine.src.state;

import oopexcersise.vendingmachine.src.vendingmachine.DisplayPanel;

public class RequestCoinState implements DisplayPanelState {
	private static RequestCoinState state = new RequestCoinState();

	private RequestCoinState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}

	@Override
	public String display(DisplayPanel displayPanel) {
		return "INSERTCOIN";
	}
}
