package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.product.Product.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinCreater;
import vendingmachine.src.vendingmachine.VendingMachine;

class SelectProductTest {
	VendingMachine vendingMachine;

	@BeforeEach
	void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

	@Test
	void コーラを買った後はマシンにTHANKYOUが表示され_チェックするとINSERTCOINが表示されること() {
		String messageWhenInputNothing = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputNothing);

		vendingMachine.pushProductButton(COLA);
		Coin quarter = CoinCreater.createQuarter();
		vendingMachine.insertCoin(quarter);
		String messageWhenInputQuarterOne = vendingMachine.display();
		assertEquals("1", messageWhenInputQuarterOne);

		vendingMachine.insertCoin(quarter);
		vendingMachine.insertCoin(quarter);
		vendingMachine.insertCoin(quarter);
		String messageWhenInputQuarterFour = vendingMachine.display();
		assertEquals("1", messageWhenInputQuarterFour);

		vendingMachine.check();
		String messageWhenAfterCheck = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenAfterCheck);
	}
}
