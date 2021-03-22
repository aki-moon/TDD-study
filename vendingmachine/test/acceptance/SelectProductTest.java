package oopexcersise.vendingmachine.test.acceptance;

import static oopexcersise.vendingmachine.src.Product.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.coin.Coin;
import oopexcersise.vendingmachine.src.vendingmachine.VendingMachine;

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

		vendingMachine.pushButton(COLA);
		Coin quarter = new Coin(5.67, 24.26);
		vendingMachine.insertedCoin(quarter);
		String messageWhenInputQuarterOne = vendingMachine.display();
		assertEquals("0.25", messageWhenInputQuarterOne);

		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		String messageWhenInputQuarterFour = vendingMachine.display();
		assertEquals("1", messageWhenInputQuarterFour);

		vendingMachine.check();
		String messageWhenAfterCheck = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenAfterCheck);
	}
}
