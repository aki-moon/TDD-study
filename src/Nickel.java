package oopexcersise.vendingmachine.src;

public class Nickel extends Coin {

	@Override
	protected int getWeight() {
		return 10;
	}

	@Override
	protected int getDiameter() {
		return 2;
	}

}
