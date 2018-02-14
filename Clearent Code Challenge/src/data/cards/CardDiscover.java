package data.cards;

import data.users.User;

public class CardDiscover extends CardBase {
	public CardDiscover(int id, User owner, double balance) {
		super(id, owner, balance);
	}

	public double getInterestRate() {
		return 0.01;
	}
}
