package vendingmachine.src.coin;

import java.math.BigDecimal;

public class Weight {
	private BigDecimal value;

	public Weight(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal value() {
		return value;
	}

}
