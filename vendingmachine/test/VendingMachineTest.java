package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.VendingMachine;
import oopexcersise.vendingmachine.src.cointype.Coin;

class VendingMachineTest {
	private VendingMachine vendingMachine;

	@BeforeEach
	void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

	@Nested
	class 自動販売機に合計金額が正しく表示されること {
		@Test
		void コインを一枚も入れないとINSERTCOINと表示されること() {
			assertEquals("INSERTCOIN", vendingMachine.display());
		}

		@Test
		void ダイムを1枚入れるとコインの合計金額が10セントと表示されること() {
			Coin dime = new Coin(2.268, 17.91);
			vendingMachine.insertedCoin(dime);
			assertEquals("10", vendingMachine.display());
		}

		@Test
		void ニッケルを1枚入れるとコインの合計金額が5セントと表示されること() {
			Coin nickel = new Coin(5, 21.21);
			vendingMachine.insertedCoin(nickel);
			assertEquals("5", vendingMachine.display());
		}

		@Test
		void クオーターを1枚入れるとコインの合計金額が1セントと表示されること() {
			Coin quarter = new Coin(5.67, 24.26);
			vendingMachine.insertedCoin(quarter);
			assertEquals("1", vendingMachine.display());
		}

		@Test
		void ニッケルとダイムとクオーターを1枚ずつ入れるとコインの合計金額が16セントと表示されること() {
			Coin dime = new Coin(2.268, 17.91);
			Coin nickel = new Coin(5, 21.21);
			Coin quarter = new Coin(5.67, 24.26);
			vendingMachine.insertedCoin(dime);
			vendingMachine.insertedCoin(nickel);
			vendingMachine.insertedCoin(quarter);
			assertEquals("16", vendingMachine.display());
		}
	}

	@Nested
	class 自動販売機に入れた無効なコインが返ってくること {
		@Test
		void コインを一枚も入れないとreturnedCoinには何も入っていないこと() {
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void ダイムを1枚入れるとreturnedCoinには何も入っていないこと() {
			Coin dime = new Coin(2.268, 17.91);
			vendingMachine.insertedCoin(dime);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void ニッケルを1枚入れるとreturnedCoinには何も入っていないこと() {
			Coin nickel = new Coin(5, 21.21);
			vendingMachine.insertedCoin(nickel);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void クオーターを1枚入れるとreturnedCoinには何も入っていないこと() {
			Coin quarter = new Coin(5.67, 24.26);
			vendingMachine.insertedCoin(quarter);
			assertTrue(vendingMachine.returnedCoin().size() == 0);
		}

		@Test
		void 定義されていないコインを1枚入れるとreturnedCoinに返却されること() {
			Coin undefinedCoin = new Coin(5.66, 24.26);
			vendingMachine.insertedCoin(undefinedCoin);
			assertEquals(undefinedCoin, vendingMachine.returnedCoin().get(0));
		}
	}

	@Nested
	class 自動販売機に入れた有効なコインが貯蔵されること {
		@Test
		void コインを一枚も入れないとsavedCoinには何も入っていないこと() {
			assertTrue(vendingMachine.savedCoin().size() == 0);
		}

		@Test
		void ダイムを1枚入れるとsavedCoinにはダイムが入っていること() {
			Coin dime = new Coin(2.268, 17.91);
			vendingMachine.insertedCoin(dime);
			assertEquals(vendingMachine.savedCoin().get(0), dime);
		}

		@Test
		void ニッケルを1枚入れるとsavedCoinにはダイムが入っていること() {
			Coin nickel = new Coin(5, 21.21);
			vendingMachine.insertedCoin(nickel);
			assertEquals(vendingMachine.savedCoin().get(0), nickel);
		}

		@Test
		void クオーターを1枚入れるとsavedCoinにはダイムが入っていること() {
			Coin quarter = new Coin(5.67, 24.26);
			vendingMachine.insertedCoin(quarter);
			assertEquals(vendingMachine.savedCoin().get(0), quarter);
		}

		@Test
		void 定義されていないコインを1枚入れるとsavedCoinには何も入っていないこと() {
			Coin undefinedCoin = new Coin(5.66, 24.26);
			vendingMachine.insertedCoin(undefinedCoin);
			assertTrue(vendingMachine.savedCoin().size() == 0);
		}
	}

}
