package vendingmachine.src.state;

import java.math.BigDecimal;

public class ShowProductPriceState implements DisplayPanelState {
	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
	private static ShowProductPriceState state = new ShowProductPriceState();
	private int ProductPrice;

	private ShowProductPriceState() {
	}

	public static ShowProductPriceState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmountOfCent) {
		return String.valueOf(BigDecimal.valueOf(ProductPrice).divide(HUNDRED));
	}

	public void productPrice(int productPrice) {
		ProductPrice = productPrice;
	}
}
