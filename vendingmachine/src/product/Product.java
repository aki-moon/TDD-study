package vendingmachine.src.product;

import java.math.BigDecimal;

public enum Product {
	COLA(100),
	CANDY(65),
	CHIPS(50);

	private int value;

	Product(int value) {
		this.value = value;
	}

	public int amount() {
		return value;
	};

	public BigDecimal value() {
		return BigDecimal.valueOf(value);
	};
}
