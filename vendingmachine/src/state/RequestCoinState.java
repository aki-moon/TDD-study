package oopexcersise.vendingmachine.src.state;

public class RequestCoinState implements DisplayPanelState {
	private static RequestCoinState state = new RequestCoinState();

	private RequestCoinState() {
	}

	public static DisplayPanelState getInstance(){
		return state;
	}

	@Override
	public String display() {
		return "INSERTCOIN";
	}
}
