package oopexcersise.vendingmachine.src.state;

public class ShowAmountState implements DisplayPanelState {
	private static ShowAmountState state = new ShowAmountState();

	private ShowAmountState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}

	@Override
	public String display() {
		return null;
	}
}
