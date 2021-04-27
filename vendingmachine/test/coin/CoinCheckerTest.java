package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.coin.CoinType;
import vendingmachine.src.coin.Diameter;
import vendingmachine.src.coin.Weight;

class CoinCheckerTest {
	@Test
	void コインの重さが5gで直径が21_21mmの場合_コインの種類がニッケルと判定されること() {
		Coin nickel = createNickel();
		assertEquals(CoinType.NICKEL, CoinChecker.checkCoin(nickel));
	}

	@Test
	void コインの重さが2_268gで直径が17_91mmの場合_コインの種類がダイムと判定されること() {
		Coin dime = createDime();
		assertEquals(CoinType.DIME, CoinChecker.checkCoin(dime));
	}

	@Test
	void コインの重さが5_67gで直径が24_26cmの場合_コインの種類がクォーターと判定されること() {
		Coin quarter = createQuarter();
		assertEquals(CoinType.QUARTER, CoinChecker.checkCoin(quarter));
	}

	@Test
	void コインの重さが5_67gで直径が24_27cmの場合_コインの種類がUNKNOWNと判定されること() {
		Coin unValidCoin = createUnValidCoin();
		assertEquals(CoinType.UNVALID, CoinChecker.checkCoin(unValidCoin));
	}

	private Coin createUnValidCoin() {
		Weight unValidCoinweight = new Weight(BigDecimal.valueOf(10));
		Diameter unValidCoinDiameter = new Diameter(BigDecimal.valueOf(3));
		return new Coin(unValidCoinweight, unValidCoinDiameter);
	};

	private Coin createNickel() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Diameter nickelDiameter = new Diameter(BigDecimal.valueOf(21.21));
		return new Coin(nickelWeight, nickelDiameter);
	};

	private Coin createDime() {
		Weight dimeWeight = new Weight(BigDecimal.valueOf(2.268));
		Diameter dimeDiameter = new Diameter(BigDecimal.valueOf(17.91));
		return new Coin(dimeWeight, dimeDiameter);
	};

	private Coin createQuarter() {
		Weight quarterWeight = new Weight(BigDecimal.valueOf(5.67));
		Diameter quarterDiameter = new Diameter(BigDecimal.valueOf(24.26));
		return new Coin(quarterWeight, quarterDiameter);
	};
}
