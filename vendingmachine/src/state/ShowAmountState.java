package oopexcersise.vendingmachine.src.state;

import oopexcersise.vendingmachine.src.vendingmachine.DisplayPanel;

public class ShowAmountState implements DisplayPanelState {
	private static ShowAmountState state = new ShowAmountState();

	private ShowAmountState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}

	@Override
	public String display(DisplayPanel displayPanel) {
		return String.valueOf(displayPanel.totalAmount());
	}

}
