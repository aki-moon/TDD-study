package vendingmachine.src.coin;

import java.math.BigDecimal;

public class CoinCreater {
	private CoinCreater() {
		// do nothing
	}

	public static Coin createUnValidCoin() {
		Weight unValidCoinweight = new Weight(BigDecimal.valueOf(10));
		Diameter unValidCoinDiameter = new Diameter(BigDecimal.valueOf(3));
		return new Coin(unValidCoinweight, unValidCoinDiameter);
	};

	public static Coin createNickel() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Diameter nickelDiameter = new Diameter(BigDecimal.valueOf(21.21));
		return new Coin(nickelWeight, nickelDiameter);
	};

	public static Coin createDime() {
		Weight dimeWeight = new Weight(BigDecimal.valueOf(2.268));
		Diameter dimeDiameter = new Diameter(BigDecimal.valueOf(17.91));
		return new Coin(dimeWeight, dimeDiameter);
	};

	public static Coin createQuarter() {
		Weight quarterWeight = new Weight(BigDecimal.valueOf(5.67));
		Diameter quarterDiameter = new Diameter(BigDecimal.valueOf(24.26));
		return new Coin(quarterWeight, quarterDiameter);
	};
}