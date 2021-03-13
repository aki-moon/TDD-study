package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.VendingMachine;
import oopexcersise.vendingmachine.src.cointype.Coin;

class ScenarioTest {
	VendingMachine vendingMachine;

	@BeforeEach
	void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

	@Test
	void コインが挿入されていない場合はINSERTCOINを表示し_有効なコインが挿入されると表示が更新されて現在投入している金額が表示されること() {
		String messageWhenInputNothing = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputNothing);

		Coin undefinedCoin = new Coin(10, 3);
		vendingMachine.insertedCoin(undefinedCoin);
		String messageWhenInputUndefinedCoin = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputUndefinedCoin);

		Coin nickel = new Coin(5, 21.21);
		vendingMachine.insertedCoin(nickel);
		String messageWhenInputNickel = vendingMachine.display();
		assertEquals("5", messageWhenInputNickel);
	}

	@Test
	void 有効なコインは自動販売機に貯蔵され_無効なコインはコイン返却口に返ってくること() {
		Coin undefinedCoin = new Coin(10, 3);
		Coin nickel = new Coin(5, 21.21);

		vendingMachine.insertedCoin(undefinedCoin);
		vendingMachine.insertedCoin(nickel);
		Coin returnedCoin = vendingMachine.returnedCoin();
		assertEquals(undefinedCoin, returnedCoin);
		Coin savedCoin = vendingMachine.savedCoin();
		assertEquals(nickel, savedCoin);
	}

}
