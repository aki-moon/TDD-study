package vendingmachine.src.state;

import java.math.BigDecimal;

public class ShowProductPriceState implements DisplayPanelState {
	private static ShowProductPriceState state = new ShowProductPriceState();
	private BigDecimal ProductPrice;

	private ShowProductPriceState() {
	}

	public static ShowProductPriceState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmountOfCent) {
		return String.valueOf(ProductPrice.divide(BigDecimal.valueOf(100)));
	}

	public void productPrice(BigDecimal productPrice) {
		ProductPrice = productPrice;
	}

}
