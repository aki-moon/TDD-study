package oopexcersise.vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.coin.CoinChecker;
import oopexcersise.vendingmachine.src.coin.CoinType;

class CoinCheckerTest {
	@Test
	void コインの重さが5gで直径が21_21mmの場合_コインの種類がニッケルと判定されること() {
		Coin coin = new Coin(5, 21.21);
		assertEquals(CoinType.NICKEL, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが2_268gで直径が17_91mmの場合_コインの種類がダイムと判定されること() {
		Coin coin = new Coin(2.268, 17.91);
		assertEquals(CoinType.DIME, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが5_67gで直径が24_26cmの場合_コインの種類がクォーターと判定されること() {
		Coin coin = new Coin(5.67, 24.26);
		assertEquals(CoinType.QUARTER, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが5_67gで直径が24_27cmの場合_コインの種類がUNKNOWNと判定されること() {
		Coin coin = new Coin(5.67, 24.27);
		assertEquals(CoinType.UNDEFINED, CoinChecker.checkCoin(coin));
	}
}
