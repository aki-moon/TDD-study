package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinConstant.*;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinType;

class CoinAssorterTest {
	@Test
	void コインの重さが5gで直径が21_21mmの場合_コインの種類がニッケルと判定されること() {
		assertEquals(CoinType.NICKEL_TYPE, CoinAssorter.checkCoin(NICKEL));
	}

	@Test
	void コインの重さが2_268gで直径が17_91mmの場合_コインの種類がダイムと判定されること() {
		assertEquals(CoinType.DIME_TYPE, CoinAssorter.checkCoin(DIME));
	}

	@Test
	void コインの重さが5_67gで直径が24_26cmの場合_コインの種類がクォーターと判定されること() {
		assertEquals(CoinType.QUARTER_TYPE, CoinAssorter.checkCoin(QUARTER));
	}

	@Test
	void コインの重さが5_67gで直径が24_27cmの場合_コインの種類がUNKNOWNと判定されること() {
		assertEquals(CoinType.UNVALID_TYPE, CoinAssorter.checkCoin(UNVALID));
	}

}
