package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.Coin;
import oopexcersise.vendingmachine.src.CoinChecker;
import oopexcersise.vendingmachine.src.CoinType;
import oopexcersise.vendingmachine.src.Nickel;

class CoinCheckerTest {

	@Test
	void コインの重さが10gで直径が2cmの場合_コインの種類がニッケルと判定されること() {
		CoinChecker coinChecker = new CoinChecker();
		Coin coin = new Nickel();
		assertEquals(CoinType.Nickel, coinChecker.checkCoin(coin));
	}

}
