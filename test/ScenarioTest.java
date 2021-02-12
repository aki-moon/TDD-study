package oopexcersise.vendingmachine.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import oopexcersise.vendingmachine.src.CoinReturn;
import oopexcersise.vendingmachine.src.CoinStrage;
import oopexcersise.vendingmachine.src.Customer;
import oopexcersise.vendingmachine.src.cointype.Coin;

class ScenarioTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void acceptCoinTest() {
		// 顧客がコインを入れる
		// INSERTCOINが表示される
		// 有効なコインを入れると、入れたコインの金額が画面表示される
		// 無効なコインを入れると、コインがコインリターンに帰ってくる
		// 入れられたコインは貯まる
		Coin nickel = new Coin(10, 2);
		Customer customer = new Customer();
		customer.insertCoin(nickel);
		Coin undefinedCoin = new Coin(10, 3);
		customer.insertCoin(undefinedCoin);

		CoinReturn coinReturn = new CoinReturn();
		Coin returnedCoin = coinReturn.getCoins();

		assertEquals(undefinedCoin, returnedCoin);

		CoinStrage coinStrage = new CoinStrage();
		List<Coin> coinList = coinStrage.getCoins();

		List<Coin> savedCoinList = new ArrayList<Coin>();
		savedCoinList.add(nickel);

		for (int i = 0; i < coinList.size(); i++) {
			assertEquals(coinList.get(i), savedCoinList.get(i));
		}
	}

}
