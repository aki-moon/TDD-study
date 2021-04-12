package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.product.Product.*;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.vendingmachine.VendingMachine;

class MakeChangeTest {

	@Test
	void makeChangeTest() {
		VendingMachine vendingMachine = new VendingMachine();
		Coin quarter = new Coin(5.67, 24.26);
		Coin dime = new Coin(2.268, 17.91);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.pushButton(CANDY);
		assertEquals(dime, CoinChecker.checkCoin(vendingMachine.returnedCoin().get(0)));
	}

}
