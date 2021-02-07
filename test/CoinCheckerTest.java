package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.Coin;
import oopexcersise.vendingmachine.src.CoinChecker;
import oopexcersise.vendingmachine.src.CoinType;
import oopexcersise.vendingmachine.src.Dime;
import oopexcersise.vendingmachine.src.Nickel;

class CoinCheckerTest {
	private CoinChecker coinChecker;

	@BeforeEach
	void setUp(){
		coinChecker = new CoinChecker();
	}

	@Test
	void コインの重さが10gで直径が2cmの場合_コインの種類がニッケルと判定されること() {
		Coin coin = new Nickel();
		assertEquals(CoinType.Nickel, coinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが20gで直径が3cmの場合_コインの種類がダイムと判定されること() {
		Coin coin = new Dime();
		assertEquals(CoinType.Dime, coinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが30gで直径が5cmの場合_コインの種類がクォーターと判定されること() {
		Coin coin = new Quater();
		assertEquals(CoinType.Quater, coinChecker.checkCoin(coin));
	}

}
