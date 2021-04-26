package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.coin.CoinType;
import vendingmachine.src.coin.Weight;

class CoinCheckerTest {
	@Test
	void コインの重さが5gで直径が21_21mmの場合_コインの種類がニッケルと判定されること() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Coin nickel = new Coin(nickelWeight, 21.21);
		assertEquals(CoinType.NICKEL, CoinChecker.checkCoin(nickel));
	}

	@Test
	void コインの重さが2_268gで直径が17_91mmの場合_コインの種類がダイムと判定されること() {
		Weight dimeWeight = new Weight(BigDecimal.valueOf(2.268));
		Coin dime = new Coin(dimeWeight, 17.91);
		assertEquals(CoinType.DIME, CoinChecker.checkCoin(dime));
	}

	@Test
	void コインの重さが5_67gで直径が24_26cmの場合_コインの種類がクォーターと判定されること() {
		Weight quarterWeight = new Weight(BigDecimal.valueOf(5.67));
		Coin quarter = new Coin(quarterWeight, 24.26);
		assertEquals(CoinType.QUARTER, CoinChecker.checkCoin(quarter));
	}

	@Test
	void コインの重さが5_67gで直径が24_27cmの場合_コインの種類がUNKNOWNと判定されること() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Coin unValidCoin = new Coin(nickelWeight, 21.21);
		assertEquals(CoinType.UNVALID, CoinChecker.checkCoin(unValidCoin));
	}
}
