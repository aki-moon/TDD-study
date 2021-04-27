package vendingmachine.test.acceptance;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.Diameter;
import vendingmachine.src.coin.Weight;
import vendingmachine.src.vendingmachine.VendingMachine;

class AccepptCoinsTest {
	private VendingMachine vendingMachine = new VendingMachine();
	private Coin unValidCoin = createUnValidCoin();;
	private Coin nickel = createNickel();

	@Test
	void コインが挿入されていない場合はINSERTCOINを表示し_有効なコインが挿入されると表示が更新されて現在投入している金額が表示されること() {
		String messageWhenInputNothing = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputNothing);

		vendingMachine.insertedCoin(unValidCoin);
		String messageWhenInputUnValidCoin = vendingMachine.display();
		assertEquals("INSERTCOIN", messageWhenInputUnValidCoin);

		vendingMachine.insertedCoin(nickel);
		String messageWhenInputNickel = vendingMachine.display();
		assertEquals("0.05", messageWhenInputNickel);
	}

	@Test
	void 有効なコインは自動販売機に貯蔵され_無効なコインはコイン返却口に返ってくること() {
		vendingMachine.insertedCoin(unValidCoin);
		vendingMachine.insertedCoin(nickel);
		List<Coin> returnedCoin = vendingMachine.returnedCoin();
		assertEquals(unValidCoin, returnedCoin.get(0));
		List<Coin> savedCoin = vendingMachine.savedCoin();
		assertEquals(nickel, savedCoin.get(0));
	}

	private Coin createUnValidCoin() {
		Weight unValidCoinweight = new Weight(BigDecimal.valueOf(10));
		Diameter unValidCoinDiameter = new Diameter(BigDecimal.valueOf(3));
		return new Coin(unValidCoinweight, unValidCoinDiameter);
	};

	private Coin createNickel() {
		Weight nickelWeight = new Weight(BigDecimal.valueOf(5));
		Diameter nickelDiameter = new Diameter(BigDecimal.valueOf(21.21));
		return new Coin(nickelWeight, nickelDiameter);
	};

}
