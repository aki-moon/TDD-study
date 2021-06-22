package vendingmachine.src.coin;

import java.math.BigDecimal;

public class CoinConstant {
	public static final Coin NICKEL = nickel();
	public static final Coin DIME = dime();
	public static final Coin QUARTER = quarter();
	public static final Coin UNVALID = unValid();

	private CoinConstant() {
		// do nothing
	}

	private static Coin unValid() {
		Weight unValidCoinweight = new Weight(BigDecimal.valueOf(10));
		Diameter unValidCoinDiameter = new Diameter(BigDecimal.valueOf(3));
		return new Coin(unValidCoinweight, unValidCoinDiameter);
	}

	private static Coin nickel() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Diameter nickelDiameter = new Diameter(BigDecimal.valueOf(21.21));
		return new Coin(nickelWeight, nickelDiameter);
	}

	private static Coin dime() {
		Weight dimeWeight = new Weight(BigDecimal.valueOf(2.268));
		Diameter dimeDiameter = new Diameter(BigDecimal.valueOf(17.91));
		return new Coin(dimeWeight, dimeDiameter);
	}

	private static Coin quarter() {
		Weight quarterWeight = new Weight(BigDecimal.valueOf(5.67));
		Diameter quarterDiameter = new Diameter(BigDecimal.valueOf(24.26));
		return new Coin(quarterWeight, quarterDiameter);
	}
}