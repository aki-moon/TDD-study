package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.CoinChecker;
import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;

class CoinCheckerTest {
	@Test
	void コインの重さが10gで直径が2cmの場合_コインの種類がニッケルと判定されること() {
		Coin coin = new Coin(10, 2);
		assertEquals(CoinType.NICKEL, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが20gで直径が3cmの場合_コインの種類がダイムと判定されること() {
		Coin coin = new Coin(20, 3);
		assertEquals(CoinType.DIME, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが30gで直径が5cmの場合_コインの種類がクォーターと判定されること() {
		Coin coin = new Coin(30, 5);
		assertEquals(CoinType.QUARTER, CoinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが31gで直径が5cmの場合_コインの種類がUNKNOWNと判定されること() {
		Coin coin = new Coin(31, 5);
		assertEquals(CoinType.UNDEFINED, CoinChecker.checkCoin(coin));
	}
}
