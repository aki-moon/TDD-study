package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinCreater;
import vendingmachine.src.vendingmachine.VendingMachine;

class AccepptCoinsTest {
	private VendingMachine vendingMachine = new VendingMachine();
	private Coin unValidCoin = CoinCreater.createUnValidCoin();;
	private Coin nickel = CoinCreater.createNickel();

	@Test
	void コインが挿入されていない場合はINSERTCOINを表示し_有効なコインが挿入されると表示が更新されて現在投入している金額が表示されること() {
		String messageWhenInputNothing = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputNothing);

		vendingMachine.insertCoin(unValidCoin);
		String messageWhenInputUnValidCoin = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputUnValidCoin);

		vendingMachine.insertCoin(nickel);
		String messageWhenInputNickel = vendingMachine.display();
		assertEquals("0.05", messageWhenInputNickel);
	}

	@Test
	void 有効なコインは自動販売機に貯蔵され_無効なコインはコイン返却口に返ってくること() {
		vendingMachine.insertCoin(unValidCoin);
		vendingMachine.insertCoin(nickel);
		List<Coin> returnedCoin = vendingMachine.returnedCoin();
		assertEquals(unValidCoin, returnedCoin.get(0));
		List<Coin> savedCoin = vendingMachine.savedCoin();
		assertEquals(nickel, savedCoin.get(0));
	};

}
