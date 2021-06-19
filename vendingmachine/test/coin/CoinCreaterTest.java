package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinType.*;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinCreater;

class CoinCreaterTest {
	@Test
	void ニッケルが作られること() {
		assertEquals(CoinAssorter.checkCoin(CoinCreater.createNickel()), NICKEL_TYPE);
	}

	@Test
	void ダイムが作られること() {
		assertEquals(CoinAssorter.checkCoin(CoinCreater.createDime()), DIME_TYPE);
	}

	@Test
	void クオーターが作られること() {
		assertEquals(CoinAssorter.checkCoin(CoinCreater.createQuarter()), QUARTER_TYPE);
	}

	@Test
	void 無効なコインが作られること() {
		assertEquals(CoinAssorter.checkCoin(CoinCreater.createUnValidCoin()), UNVALID_TYPE);
	}
}
