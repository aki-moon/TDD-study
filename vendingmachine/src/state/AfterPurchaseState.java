package oopexcersise.vendingmachine.src.state;

public class AfterPurchaseState implements DisplayPanelState {
	private static AfterPurchaseState state = new AfterPurchaseState();

	private AfterPurchaseState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}
}
