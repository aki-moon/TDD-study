package vendingmachine.src.product;

import java.math.BigDecimal;

import vendingmachine.src.coin.Price;

public enum Product {
	COLA(100), CANDY(65), CHIPS(50);

	private Price price;

	Product(int value) {
		this.price = new Price(value);
	}

	public BigDecimal price() {
		return price.value();
	}

	public boolean canPurchase(int amount) {
		return amount >= price.value().intValue();
	}
}
