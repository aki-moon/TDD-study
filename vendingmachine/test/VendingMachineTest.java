package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.VendingMachine;
import oopexcersise.vendingmachine.src.cointype.Coin;

class VendingMachineTest {
	private VendingMachine vendingMachine;

	@BeforeEach
	void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

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
