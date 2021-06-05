package vendingmachine.src.state;

public class ShowProductPriceState implements DisplayPanelState {
	private static ShowProductPriceState state = new ShowProductPriceState();
	private int ProductPrice;

	private ShowProductPriceState() {
	}

	public static ShowProductPriceState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmountOfCent) {
		return String.valueOf(ProductPrice /100);
	}

	public void productPrice(int productPrice) {
		ProductPrice = productPrice;
	}

}
