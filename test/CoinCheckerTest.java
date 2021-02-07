package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.CoinChecker;
import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.CoinType;
import oopexcersise.vendingmachine.src.cointype.Dime;
import oopexcersise.vendingmachine.src.cointype.Nickel;
import oopexcersise.vendingmachine.src.cointype.Penny;
import oopexcersise.vendingmachine.src.cointype.Quater;

class CoinCheckerTest {
	private CoinChecker coinChecker;

	@BeforeEach
	void setUp(){
		coinChecker = new CoinChecker();
	}

	@Test
	void コインの重さが10gで直径が2cmの場合_コインの種類がニッケルと判定されること() {
		Coin coin = new Nickel();
		assertEquals(CoinType.NICKEL, coinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが20gで直径が3cmの場合_コインの種類がダイムと判定されること() {
		Coin coin = new Dime();
		assertEquals(CoinType.DIME, coinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが30gで直径が5cmの場合_コインの種類がクォーターと判定されること() {
		Coin coin = new Quater();
		assertEquals(CoinType.QUARTER, coinChecker.checkCoin(coin));
	}

	@Test
	void コインの重さが31gで直径が5cmの場合_コインの種類がUNKNOWNと判定されること() {
		Coin coin = new Penny();
		assertEquals(CoinType.UNDEFINED, coinChecker.checkCoin(coin));
	}
}
