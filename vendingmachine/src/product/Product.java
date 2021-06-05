package vendingmachine.src.product;

import java.math.BigDecimal;

public enum Product {
	COLA(100),
	CANDY(65),
	CHIPS(50);

	private BigDecimal value;

	Product(int value) {
		this.value = BigDecimal.valueOf(value);
	}

	public BigDecimal value() {
		return value;
	};
}
