package oopexcersise.vendingmachine.src.coin;

public class Coin {
	private double weight;
	private double diameter;

	public Coin(double weight, double diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}

	public double weight() {
		return weight;
	};

	public double diameter() {
		return diameter;
	};

	@Override
	public boolean equals(Object coin) {
		if(coin instanceof Coin) {
			return this.weight == ((Coin) coin).weight() && this.diameter == ((Coin) coin).diameter();
		}
		return false;
	}

}
