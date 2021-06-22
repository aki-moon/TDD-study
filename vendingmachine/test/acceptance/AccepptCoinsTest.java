package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinConstant.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.vendingmachine.VendingMachine;

class AccepptCoinsTest {
	private VendingMachine vendingMachine = new VendingMachine();

	@Test
	void コインが挿入されていない場合はINSERTCOINを表示し_有効なコインが挿入されると表示が更新されて現在投入している金額が表示されること() {
		String messageWhenInputNothing = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputNothing);

		vendingMachine.insertCoin(UNVALID);
		String messageWhenInputUnValidCoin = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputUnValidCoin);

		vendingMachine.insertCoin(NICKEL);
		String messageWhenInputNickel = vendingMachine.display();
		assertEquals("0.05", messageWhenInputNickel);
	}

	@Test
	void 有効なコインは自動販売機に貯蔵され_無効なコインはコイン返却口に返ってくること() {
		vendingMachine.insertCoin(UNVALID);
		vendingMachine.insertCoin(NICKEL);
		List<Coin> returnedCoin = vendingMachine.returnedCoin();
		assertEquals(UNVALID, returnedCoin.get(0));
		List<Coin> savedCoin = vendingMachine.savedCoin();
		assertEquals(NICKEL, savedCoin.get(0));
	};

}
