package data.cards;

import data.users.User;

public class CardVisa extends CardBase {
	public CardVisa(int id, User owner, double balance) {
		super(id, owner, balance);
	}

	public double getInterestRate() {
		return 0.1;
	}
}
