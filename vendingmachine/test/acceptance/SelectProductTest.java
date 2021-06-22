package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinConstant.*;
import static vendingmachine.src.product.Product.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.src.product.Product;
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
		vendingMachine.insertCoin(QUARTER);
		String messageWhenInputQuarterOne = vendingMachine.display();
		assertEquals("1", messageWhenInputQuarterOne);

		vendingMachine.insertCoin(QUARTER);
		vendingMachine.insertCoin(QUARTER);
		vendingMachine.insertCoin(QUARTER);
		String messageWhenInputQuarterFour = vendingMachine.display();
		assertEquals("1", messageWhenInputQuarterFour);

		Product product = vendingMachine.returnedProduct();
		assertEquals(COLA, product);
		vendingMachine.check();
		String messageWhenAfterCheck = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenAfterCheck);
	}
}
