package oopexcersise.vendingmachine.test;

import oopexcersise.vendingmachine.src.Coin;

public class Quater extends Coin {

	@Override
	protected int getWeight() {
		return 30;
	}

	@Override
	protected int getDiameter() {
		return 5;
	}

}
