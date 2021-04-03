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
		BigDecimal totalAmountOfDollers = BigDecimal.valueOf(totalAmountOfCent).divide(BigDecimal.valueOf(100));
		return String.valueOf(totalAmountOfDollers);
	}

}
