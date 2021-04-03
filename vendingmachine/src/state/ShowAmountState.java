package oopexcersise.vendingmachine.src.state;

import java.math.BigDecimal;

public class ShowAmountState implements DisplayPanelState {
	private static ShowAmountState state = new ShowAmountState();

	private ShowAmountState() {
	}

	public static DisplayPanelState getInstance() {
		return state;
	}

	@Override
	public String display(int totalAmountOfCent) {
		BigDecimal totalAmountOfDollers = changeAmountFromDollerToCent(totalAmountOfCent);
		return String.valueOf(totalAmountOfDollers);
	}

	private BigDecimal changeAmountFromDollerToCent(int totalAmountOfCent) {
		return BigDecimal.valueOf(totalAmountOfCent).divide(BigDecimal.valueOf(100));
	}

}
