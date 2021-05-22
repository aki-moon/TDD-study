package vendingmachine.src.state;

public class SoldOutState implements DisplayPanelState {
	private static SoldOutState state = new SoldOutState();

	private SoldOutState() {
	}

	public static DisplayPanelState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmount) {
		return "SOLDOUT";
	}

}
