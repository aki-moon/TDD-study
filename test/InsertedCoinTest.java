package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.InsertedCoin;
import oopexcersise.vendingmachine.src.cointype.Coin;
import oopexcersise.vendingmachine.src.cointype.Nickel;

class InsertedCoinTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void ニッケルを1枚入れるとコインの合計金額が5セントとなること() {
		InsertedCoin insertedCoin = new InsertedCoin();
		Coin coin = new Nickel();
		insertedCoin.putCoin(coin);
		assertEquals(insertedCoin.totalAmount(), 5);
	}

}
