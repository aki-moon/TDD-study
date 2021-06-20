package vendingmachine.src.product;

import vendingmachine.src.coin.Price;

public enum Product {
	COLA(100), CANDY(65), CHIPS(50);

	private Price price;

	Product(int price) {
		this.price = new Price(price);
	}

	public int price() {
		return price.value();
	}

	public boolean canPurchase(int amount) {
		return amount >= price.value();
	}
}
