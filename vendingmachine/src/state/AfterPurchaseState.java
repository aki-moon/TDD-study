package oopexcersise.vendingmachine.src.state;

public class AfterPurchaseState implements DisplayPanelState {
	private static AfterPurchaseState state = new AfterPurchaseState();

	private AfterPurchaseState() {
	}

	public DisplayPanelState getInstance(){
		return state;
	}
}
