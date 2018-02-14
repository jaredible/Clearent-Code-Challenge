package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import data.cards.CardBase;
import data.cards.CardDiscover;
import data.cards.CardMastercard;
import data.cards.CardVisa;
import data.users.User;
import data.wallets.Wallet;

class Test0 {
	@Test
	void test() {
		int numMonths = 1;

		User bob = User.createUser(0, "Bob");
		CardBase visa = new CardVisa(0, bob, 100.0);
		CardBase mc = new CardMastercard(1, bob, 100.0);
		CardBase discover = new CardDiscover(2, bob, 100.0);
		Wallet wallet = new Wallet("Bob's Wallet", bob, visa, mc, discover);
		bob.addWallet(wallet);
		double bobsInterest = bob.calculateInterest(numMonths);
		double bobsWalletInterest = wallet.calculateInterest(numMonths);

		System.out.println(bob.toString());
		System.out.println(visa.toString());
		System.out.println(mc.toString());
		System.out.println(discover.toString());
		System.out.println(wallet.toString());
		System.out.println("Bob's simple interest: " + bobsInterest);
		System.out.println("Bob's wallet simple interest: " + bobsWalletInterest);

		assertEquals(100.0 * 0.1 + 100.0 * 0.05 + 100.0 * 0.01, bobsInterest);
		assertEquals(100.0 * 0.1 + 100.0 * 0.05 + 100.0 * 0.01, bobsWalletInterest);
	}
}
