package vendingmachine.src.coin;

import static vendingmachine.src.coin.CoinType.*;

import java.math.BigDecimal;

public class Coin {
	private Weight weight;
	private double diameter;

	public Coin(Weight weight, double diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}

	public BigDecimal weight() {
		return weight.value();
	};

	public double diameter() {
		return diameter;
	};

	public boolean isValidCoin() {
		return CoinChecker.checkCoin(this) != UNVALID;
	}

	public boolean isUnvalidCoin() {
		return CoinChecker.checkCoin(this) == UNVALID;
	}

	@Override
	public boolean equals(Object coin) {
		if (coin instanceof Coin) {
			return this.weight().equals(((Coin) coin).weight()) && this.diameter == ((Coin) coin).diameter();
		}
		return false;
	}

}
