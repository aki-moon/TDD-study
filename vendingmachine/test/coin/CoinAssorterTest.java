package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinCreater;
import vendingmachine.src.coin.CoinType;

class CoinAssorterTest {
	@Test
	void コインの重さが5gで直径が21_21mmの場合_コインの種類がニッケルと判定されること() {
		Coin nickel = CoinCreater.createNickel();
		assertEquals(CoinType.NICKEL, CoinAssorter.checkCoin(nickel));
	}

	@Test
	void コインの重さが2_268gで直径が17_91mmの場合_コインの種類がダイムと判定されること() {
		Coin dime = CoinCreater.createDime();
		assertEquals(CoinType.DIME, CoinAssorter.checkCoin(dime));
	}

	@Test
	void コインの重さが5_67gで直径が24_26cmの場合_コインの種類がクォーターと判定されること() {
		Coin quarter = CoinCreater.createQuarter();
		assertEquals(CoinType.QUARTER, CoinAssorter.checkCoin(quarter));
	}

	@Test
	void コインの重さが5_67gで直径が24_27cmの場合_コインの種類がUNKNOWNと判定されること() {
		Coin unValidCoin = CoinCreater.createUnValidCoin();
		assertEquals(CoinType.UNVALID, CoinAssorter.checkCoin(unValidCoin));
	}

}
