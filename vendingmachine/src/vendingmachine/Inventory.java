package vendingmachine.src.vendingmachine;

public class Inventory {

	private boolean isSoldOut;

	public void takeOutAll() {
		isSoldOut = true;
	}

	public boolean isSoldOut() {
		return isSoldOut;
	}

}
