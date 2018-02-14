package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import data.cards.CardBase;
import data.cards.CardDiscover;
import data.cards.CardMastercard;
import data.cards.CardVisa;
import data.users.User;
import data.wallets.Wallet;

class Test1 {
	@Test
	void test() {
		int numMonths = 1;

		User dan = User.createUser(0, "Dan");
		CardBase visa = new CardVisa(0, dan, 100.0);
		CardBase discover = new CardDiscover(1, dan, 100.0);
		CardBase mc = new CardMastercard(0, dan, 100.0);
		Wallet wallet0 = new Wallet("Dan's First Wallet", dan, visa, discover);
		Wallet wallet1 = new Wallet("Dan's Second Wallet", dan, mc);
		dan.addWallets(wallet0, wallet1);
		double dansInterest = dan.calculateInterest(numMonths);
		double dansWalletInterest0 = wallet0.calculateInterest(numMonths);
		double dansWalletInterest1 = wallet1.calculateInterest(numMonths);

		System.out.println(dan.toString());
		System.out.println(visa.toString());
		System.out.println(discover.toString());
		System.out.println(mc.toString());
		System.out.println(wallet0.toString());
		System.out.println(wallet1.toString());
		System.out.println("Dan's simple interest: " + dansInterest);
		System.out.println("Dan's first wallet simple interest: " + dansWalletInterest0);
		System.out.println("Dan's second wallet simple interest: " + dansWalletInterest1);

		assertEquals(100.0 * 0.1 + 100.0 * 0.01 + 100.0 * 0.05, dansInterest);
		assertEquals(100.0 * 0.1 + 100.0 * 0.01, dansWalletInterest0);
		assertEquals(100.0 * 0.05, dansWalletInterest1);
	}
}
