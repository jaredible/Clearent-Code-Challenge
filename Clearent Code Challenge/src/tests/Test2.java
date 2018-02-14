package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import data.cards.CardBase;
import data.cards.CardMastercard;
import data.cards.CardVisa;
import data.users.User;
import data.wallets.Wallet;

class Test2 {
	@Test
	void test() {
		int numMonths = 1;

		User joy = User.createUser(0, "Joy");
		CardBase mc0 = new CardMastercard(0, joy, 100.0);
		CardBase visa0 = new CardVisa(1, joy, 100.0);
		Wallet wallet0 = new Wallet("Joy's Wallet", joy, mc0, visa0);
		joy.addWallet(wallet0);
		double joysInterest = joy.calculateInterest(numMonths);
		double joysWalletInterest = wallet0.calculateInterest(numMonths);

		User jen = User.createUser(1, "Jen");
		CardBase visa1 = new CardVisa(0, jen, 100.0);
		CardBase mc1 = new CardMastercard(1, jen, 100.0);
		Wallet wallet1 = new Wallet("Jen's Wallet", jen, visa1, mc1);
		jen.addWallet(wallet1);
		double jensInterest = jen.calculateInterest(numMonths);
		double jensWalletInterest = wallet1.calculateInterest(numMonths);

		System.out.println(joy.toString());
		System.out.println(mc0.toString());
		System.out.println(visa0.toString());
		System.out.println(wallet0.toString());
		System.out.println("Joy's simple interest: " + joysInterest);
		System.out.println("Joy's wallet simple interest: " + joysWalletInterest);
		System.out.println();
		System.out.println(jen.toString());
		System.out.println(visa1.toString());
		System.out.println(mc1.toString());
		System.out.println(wallet1.toString());
		System.out.println("Jen's simple interest: " + jensInterest);
		System.out.println("Jen's wallet simple interest: " + jensWalletInterest);

		assertEquals(100.0 * 0.05 + 100.0 * 0.1, joysInterest);
		assertEquals(100.0 * 0.05 + 100.0 * 0.1, joysWalletInterest);
		assertEquals(100.0 * 0.1 + 100.0 * 0.05, jensInterest);
		assertEquals(100.0 * 0.1 + 100.0 * 0.05, jensWalletInterest);
	}
}
