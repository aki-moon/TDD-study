package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.InsertedCoin;
import oopexcersise.vendingmachine.src.cointype.Coin;

class InsertedCoinTest {
	private InsertedCoin insertedCoin;

	@BeforeEach
	void setUp() throws Exception {
		insertedCoin = new InsertedCoin();
	}

	@Test
	void ダイムを1枚入れるとコインの合計金額が10セントとなること() {
		Coin dime = new Coin(2.268, 17.91);
		insertedCoin.putCoin(dime);
		assertEquals(insertedCoin.totalAmount(), 10);
	}

	@Test
	void ニッケルを1枚入れるとコインの合計金額が5セントとなること() {
		Coin nickel = new Coin(5, 21.21);
		insertedCoin.putCoin(nickel);
		assertEquals(insertedCoin.totalAmount(), 5);
	}

	@Test
	void クオーターを1枚入れるとコインの合計金額が1セントとなること() {
		Coin quarter = new Coin(5.67, 24.26);
		insertedCoin.putCoin(quarter);
		assertEquals(insertedCoin.totalAmount(), 1);
	}

	@Test
	void ニッケルとダイムとクオーターを1枚ずつ入れるとコインの合計金額が16セントとなること() {
		Coin dime = new Coin(2.268, 17.91);
		Coin nickel = new Coin(5, 21.21);
		Coin quarter = new Coin(5.67, 24.26);
		insertedCoin.putCoin(dime);
		insertedCoin.putCoin(nickel);
		insertedCoin.putCoin(quarter);
		assertEquals(insertedCoin.totalAmount(), 16);
	}

}
