package oopexcersise.vendingmachine.src.product;

public enum Product {
	COLA(100),
	CANDY(65),
	CHIPS(50);

	private int value;

	Product(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	};
}
