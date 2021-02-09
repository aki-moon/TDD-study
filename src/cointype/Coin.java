package oopexcersise.vendingmachine.src.cointype;

public class Coin {
	private int weight;
	private int diameter;

	public Coin(int weight, int diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}

	public int weight() {
		return weight;
	};

	public int diameter() {
		return diameter;
	};

}
