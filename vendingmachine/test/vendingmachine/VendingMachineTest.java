package vendingmachine.test.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.src.coin.CoinConstant.*;
import static vendingmachine.src.product.Product.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import vendingmachine.src.coin.Coin;
import vendingmachine.src.coin.CoinAssorter;
import vendingmachine.src.coin.CoinType;
import vendingmachine.src.product.Product;
import vendingmachine.src.vendingmachine.VendingMachine;

class VendingMachineTest {
	private VendingMachine vendingMachine = new VendingMachine();

	@Nested
	class 自動販売機の画面表示の確認 {
		@Test
		void コインを一枚も入れないとINSERTCOINと表示されること() {
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void ダイムを1枚入れるとコインの合計金額が0_1ドルと表示されること() {
			vendingMachine.insertCoin(DIME);
			assertEquals("0.1", vendingMachine.display());
		}

		@Test
		void ニッケルを1枚入れるとコインの合計金額が0_05ドルと表示されること() {
			vendingMachine.insertCoin(NICKEL);
			assertEquals("0.05", vendingMachine.display());
		}

		@Test
		void クオーターを1枚入れるとコインの合計金額が0_25ドルと表示されること() {
			vendingMachine.insertCoin(QUARTER);
			assertEquals("0.25", vendingMachine.display());
		}

		@Test
		void ニッケルとダイムとクオーターを1枚ずつ入れるとコインの合計金額が0_4ドルと表示されること() {
			vendingMachine.insertCoin(DIME);
			vendingMachine.insertCoin(NICKEL);
			vendingMachine.insertCoin(QUARTER);
			assertEquals("0.4", vendingMachine.display());
		}

		@Test
		void プロダクト購入後にTHANKYOUが表示されること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.returnedProduct();
			assertEquals("THANKYOU", vendingMachine.display());
		}

		@Test
		void プロダクト購入後THANKYOUが表示された後に再度表示を確認するとINSERTCOINが表示されること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.returnedProduct();
			vendingMachine.check();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void プロダクトが購入できない場合はプロダクトの価格を表示し_コインを入れられていない場合はINSERTCOINを表示すること() {
			vendingMachine.pushProductButton(CHIPS);
			assertEquals("0.5", vendingMachine.display());
			vendingMachine.check();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void プロダクトが購入できない場合はプロダクトの価格を表示し_その後の表示確認でコインの合計金額を表示すること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(DIME);
			assertEquals("0.5", vendingMachine.display());
			vendingMachine.check();
			assertEquals("0.1", vendingMachine.display());
		}

		@Test
		void お釣り返却ボタンを押した後はINSERTCOINが表示されること() {
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.pushChangeButton();
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void 選択した商品の在庫がない場合SOLDOUTが表示されること() {
			vendingMachine.takeOutAllInventory();
			vendingMachine.insertCoin(NICKEL);
			vendingMachine.pushProductButton(CHIPS);
			assertEquals("SOLDOUT", vendingMachine.display());
		}

		@Test
		void マシンに硬貨を入れた状態でSOLDOUT表示後に画面を確認すると残っている金額が表示されること() {
			vendingMachine.insertCoin(NICKEL);
			vendingMachine.takeOutAllInventory();
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.check();
			assertEquals("0.05", vendingMachine.display());
		}

		@Test
		void マシンに硬貨がない状態でSOLDOUT表示後に画面を確認するとINSERTCOINが表示されること() {
			vendingMachine.takeOutAllInventory();
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.check();
			assertEquals("INSERTCOIN", vendingMachine.display());
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
			vendingMachine.insertCoin(DIME);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void ニッケルを1枚入れるとreturnedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(NICKEL);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void クオーターを1枚入れるとreturnedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(QUARTER);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void 定義されていないコインを1枚入れるとreturnedCoinに返却されること() {
			vendingMachine.insertCoin(UNVALID);
			assertEquals(UNVALID, vendingMachine.returnedCoin().get(0));
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
			vendingMachine.insertCoin(DIME);
			assertEquals(vendingMachine.savedCoin().get(0), DIME);
		}

		@Test
		void ニッケルを1枚入れるとsavedCoinにはニッケルが入っていること() {
			vendingMachine.insertCoin(NICKEL);
			assertEquals(vendingMachine.savedCoin().get(0), NICKEL);
		}

		@Test
		void クオーターを1枚入れるとsavedCoinにはクオーターが入っていること() {
			vendingMachine.insertCoin(QUARTER);
			assertEquals(vendingMachine.savedCoin().get(0), QUARTER);
		}

		@Test
		void 定義されていないコインを1枚入れるとsavedCoinには何も入っていないこと() {
			vendingMachine.insertCoin(UNVALID);
			assertTrue(vendingMachine.savedCoin().size() == 0);
		}
	}

	@Nested
	class お釣りを返却する機能の確認 {
		@Test
		void _75セント入れて65セントの商品を買うと10セント返ってくること() {
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.returnedProduct();
			CoinType dimeType = CoinAssorter.checkCoin(DIME);
			CoinType returnedCoinType = CoinAssorter.checkCoin(vendingMachine.returnedCoin().get(0));
			assertEquals(dimeType, returnedCoinType);
		}

		@Test
		void _65セント入れて65セントの商品を買うとお釣りが返ってこないこと() {
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(DIME);
			vendingMachine.insertCoin(NICKEL);
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.returnedProduct();
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void _50セント入れて65セントの商品を押してもお釣りが返ってこないこと() {
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.returnedProduct();
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}
	}

	@Nested
	class ボタンを押して選択したプロダクトが一定金額を入れれば買えるかの確認 {
		@Test
		void コーラが1ドルで購入できること() {
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(COLA, returnedProduct);
		}

		@Test
		void キャンディが65セントで購入できること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(DIME);
			vendingMachine.insertCoin(NICKEL);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CANDY, returnedProduct);
		}

		@Test
		void チップスが50セントで購入できること() {
			vendingMachine.pushProductButton(CHIPS);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CHIPS, returnedProduct);
		}

		@Test
		void _65セントよりも高い金額を払えばキャンディが購入できること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(CANDY, returnedProduct);
		}

		@Test
		void _1ドルよりも少ない金額ではコーラが購入できないこと() {
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertNull(returnedProduct);
		}

		@Test
		void キャンディのボタンを押した後にコーラのボタンを押した場合コーラが買えること() {
			vendingMachine.pushProductButton(CANDY);
			vendingMachine.pushProductButton(COLA);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			Product returnedProduct = vendingMachine.returnedProduct();
			assertEquals(COLA, returnedProduct);
		}
	}

	@Nested
	class 返却ボタンを押すと投入したコインが返ってくるかの確認 {
		@Test
		void _65セント入れた状態で返却ボタンを押すと65セントが返ってくること() {
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(QUARTER);
			vendingMachine.insertCoin(DIME);
			vendingMachine.insertCoin(NICKEL);
			vendingMachine.pushChangeButton();
			assertEquals(change(), 65);
		}

		@Test
		void 何もお金を入れていない状態で返却ボタンを押すと何も返ってこないこと() {
			vendingMachine.pushChangeButton();
			assertEquals(change(), 0);
		}

		private int change() {
			List<Coin> returnedCoinList = vendingMachine.returnedCoin();
			int change = 0;
			for (Coin coin : returnedCoinList) {
				CoinType coinType = CoinAssorter.checkCoin(coin);
				change += coinType.value();
			}
			return change;
		}
	}

}
