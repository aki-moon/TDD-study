package oopexcersise.vendingmachine.src;

public class Dime extends Coin {

	@Override
	protected int getWeight() {
		return 20;
	}

	@Override
	protected int getDiameter() {
		return 3;
	}

}
