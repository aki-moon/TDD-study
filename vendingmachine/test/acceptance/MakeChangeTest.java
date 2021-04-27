package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.product.Product.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinChecker;
import vendingmachine.src.coin.Diameter;
import vendingmachine.src.coin.Weight;
import vendingmachine.src.vendingmachine.VendingMachine;

class MakeChangeTest {

	@Test
	void makeChangeTest() {
		VendingMachine vendingMachine = new VendingMachine();
		Weight quarterWeight = new Weight(BigDecimal.valueOf(5.67));
		Diameter quarterDiameter = new Diameter(BigDecimal.valueOf(24.26));
		Coin quarter = new Coin(quarterWeight, quarterDiameter);
		Weight dimeWeight = new Weight(BigDecimal.valueOf(2.268));
		Diameter dimeDiameter = new Diameter(BigDecimal.valueOf(17.91));
		Coin dime = new Coin(dimeWeight, dimeDiameter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.insertedCoin(quarter);
		vendingMachine.pushButton(CANDY);
		assertEquals(dime, CoinChecker.checkCoin(vendingMachine.returnedCoin().get(0)));
	}

}
