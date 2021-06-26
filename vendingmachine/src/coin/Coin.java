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
	}

	public BigDecimal diameter() {
		return diameter.value();
	}

	public boolean isValidCoin() {
		return CoinAssorter.checkCoin(this) != UNVALID_TYPE;
	}

	public boolean isUnvalidCoin() {
		return CoinAssorter.checkCoin(this) == UNVALID_TYPE;
	}

	@Override
	public boolean equals(Object coin) {
		if (coin instanceof Coin) {
			return weight().equals(((Coin) coin).weight()) && diameter().equals(((Coin) coin).diameter());
		}
		return false;
	}

}
