package vendingmachine.src.state;

import java.math.BigDecimal;

public class ShowProductPriceState implements DisplayPanelState {
	private static ShowProductPriceState state = new ShowProductPriceState();
	private int productPriceByCent;

	private ShowProductPriceState() {
		// do nothing
	}

	public static ShowProductPriceState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmountOfCent) {
		return String.valueOf(convertPriceDollarFromCent());
	}

	public void productPrice(int productPrice) {
		productPriceByCent = productPrice;
	}

	private BigDecimal convertPriceDollarFromCent() {
		return BigDecimal.valueOf(productPriceByCent).divide(BigDecimal.valueOf(100));
	}
}
