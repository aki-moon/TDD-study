package vendingmachine.src.coin;

import java.math.BigDecimal;

public class Price {
	private BigDecimal value;

	public Price(BigDecimal value) {
		this.value = value;
	}

	public Price(int value) {
		this.value = BigDecimal.valueOf(value);
	}

	public BigDecimal value() {
		return value;
	}

}
