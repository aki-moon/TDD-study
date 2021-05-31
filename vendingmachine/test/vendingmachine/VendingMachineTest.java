package vendingmachine.test.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.product.Product.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinCreater;
import vendingmachine.src.coin.CoinType;
import vendingmachine.src.product.Product;
import vendingmachine.src.vendingmachine.VendingMachine;

class VendingMachineTest {
	private VendingMachine vendingMachine = new VendingMachine();
	private Coin unValidCoin = CoinCreater.createUnValidCoin();
	private Coin nickel = CoinCreater.createNickel();
	private Coin dime = CoinCreater.createDime();
	private Coin quarter = CoinCreater.createQuarter();

	@Nested
	class 自動販売機の画面表示の確認 {
		@Test
		void コインを一枚も入れないとINSERTCOINと表示されること() {
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void ダイムを1枚入れるとコインの合計金額が0_1ドルと表示されること() {
			vendingMachine.insertCoin(dime);
			assertEquals("0.1", vendingMachine.display());
		}

		@Test
		void ニッケルを1枚入れるとコインの合計金額が0_05ドルと表示されること() {
			vendingMachine.insertCoin(nickel);
			assertEquals("0.05", vendingMachine.display());
		}

		@Test
		void クオーターを1枚入れるとコインの合計金額が0_25ドルと表示されること() {
			vendingMachine.insertCoin(quarter);
			assertEquals("0.25", vendingMachine.display());
		}

		@Test
		void ニッケルとダイムとクオーターを1枚ずつ入れるとコインの合計金額が0_4ドルと表示されること() {
			vendingMachine.insertCoin(dime);
			vendingMachine.insertCoin(nickel);
			vendingMachine.insertCoin(quarter);
			assertEquals("0.4", vendingMachine.display());
		}

		@Test
		void プロダクト購入後にTHANKYOUが表示されること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.returnedProduct();
			assertEquals("THANKYOU", vendingMachine.display());
		}

		@Test
		void プロダクト購入後THANKYOUが表示された後に再度表示を確認するとINSERTCOINが表示されること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.returnedProduct();
			vendingMachine.check();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void プロダクト購入できるだけの金額が投入されていない場合_プロダクトの金額が表示されて再度表示を確認するとINSERTCOINが表示されること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(quarter);
			assertEquals("0.5", vendingMachine.display());
			vendingMachine.check();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void お釣り返却ボタンを押した後はINSERTCOINが表示されること() {
			vendingMachine.insertCoin(quarter);
			vendingMachine.pushChangeButton();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void 選択した商品の在庫がない場合SOLDOUTが表示されること() {
			vendingMachine.takeOutAllInventory();
			vendingMachine.insertCoin(nickel);
			vendingMachine.pushProductButton(CHIPS);
			assertEquals("SOLDOUT", vendingMachine.display());
		}
	}

	@Nested
	class 自動販売機に入れた無効なコインが返ってくるかの確認 {
		@Test
		void コインを一枚も入れないとreturnedCoinには何も入っていないこと() {
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void ダイムを1枚入れるとreturnedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(dime);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void ニッケルを1枚入れるとreturnedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(nickel);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void クオーターを1枚入れるとreturnedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(quarter);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void 定義されていないコインを1枚入れるとreturnedCoinに返却されること() {
			vendingMachine.insertCoin(unValidCoin);
			assertEquals(unValidCoin, vendingMachine.returnedCoin().get(0));
		}
	}

	@Nested
	class 自動販売機に入れた有効なコインが貯蔵されるかの確認 {
		@Test
		void コインを一枚も入れないとsavedCoinには何も入っていないこと() {
			assertTrue(vendingMachine.savedCoin().size() == 0);
		}

		@Test
		void ダイムを1枚入れるとsavedCoinにはダイムが入っていること() {
			vendingMachine.insertCoin(dime);
			assertEquals(vendingMachine.savedCoin().get(0), dime);
		}

		@Test
		void ニッケルを1枚入れるとsavedCoinにはニッケルが入っていること() {
			vendingMachine.insertCoin(nickel);
			assertEquals(vendingMachine.savedCoin().get(0), nickel);
		}

		@Test
		void クオーターを1枚入れるとsavedCoinにはクオーターが入っていること() {
			vendingMachine.insertCoin(quarter);
			assertEquals(vendingMachine.savedCoin().get(0), quarter);
		}

		@Test
		void 定義されていないコインを1枚入れるとsavedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(unValidCoin);
			assertTrue(vendingMachine.savedCoin().size() == 0);
		}
	}

	@Nested
	class 商品よりも高い金額を入れるとお釣りが返ってくるかの確認 {
		@Test
		void _75セント入れて65セントの商品を買うと10セント返ってくること() {
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.returnedProduct();
			assertEquals(CoinAssorter.checkCoin(dime), CoinAssorter.checkCoin(vendingMachine.returnedCoin().get(0)));
		}
	}

	@Nested
	class ボタンを押して選択したプロダクトが一定金額を入れれば買えるかの確認 {
		@Test
		void コーラが1ドルで購入できること() {
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(COLA, returnedProduct);
		}

		@Test
		void キャンディが65セントで購入できること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(dime);
			vendingMachine.insertCoin(nickel);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CANDY, returnedProduct);
		}

		@Test
		void チップスが50セントで購入できること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CHIPS, returnedProduct);
		}

		@Test
		void _65セントよりも高い金額を払えばキャンディが購入できること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CANDY, returnedProduct);
		}

		@Test
		void _1ドルよりも少ない金額ではコーラが購入できないこと() {
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertNull(returnedProduct);
		}

		@Test
		void キャンディのボタンを押した後にコーラのボタンを押した場合コーラが買えること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(COLA, returnedProduct);
		}
	};

	@Nested
	class 返却ボタンを押すと投入したコインが返ってくるかの確認 {
		@Test
		void _65セント入れた状態で返却ボタンを押すと65セントが返ってくること() {
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(quarter);
			vendingMachine.insertCoin(dime);
			vendingMachine.insertCoin(nickel);
			vendingMachine.pushChangeButton();
			assertEquals(changeAmount(), 65);
		}

		private int changeAmount() {
			List<Coin> returnedCoinList = vendingMachine.returnedCoin();
			int returnedCoinAmount = 0;
			for (Coin coin : returnedCoinList) {
				CoinType coinType = CoinAssorter.checkCoin(coin);
				returnedCoinAmount += coinType.value();
			}
			return returnedCoinAmount;
		}
	}

}
