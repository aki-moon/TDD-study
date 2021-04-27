package vendingmachine.src.coin;

import static vendingmachine.src.coin.CoinType.*;

import java.math.BigDecimal;

public class Coin {
	private Weight weight;
	private Diameter diameter;

	public Coin(Weight weight, Diameter diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}

	public BigDecimal weight() {
		return weight.value();
	};

	public BigDecimal diameter() {
		return diameter.value();
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
			return this.weight().equals(((Coin) coin).weight()) && this.diameter().equals(((Coin) coin).diameter());
		}
		return false;
	}

}
