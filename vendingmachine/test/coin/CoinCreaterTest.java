package vendingmachine.test.coin;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinConstant.*;
import static vendingmachine.src.coin.CoinType.*;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.CoinAssorter;

class CoinCreaterTest {
	@Test
	void ニッケルが作られること() {
		assertEquals(CoinAssorter.checkCoin(NICKEL), NICKEL_TYPE);
	}

	@Test
	void ダイムが作られること() {
		assertEquals(CoinAssorter.checkCoin(DIME), DIME_TYPE);
	}

	@Test
	void クオーターが作られること() {
		assertEquals(CoinAssorter.checkCoin(QUARTER), QUARTER_TYPE);
	}

	@Test
	void 無効なコインが作られること() {
		assertEquals(CoinAssorter.checkCoin(UNVALID), UNVALID_TYPE);
	}
}
