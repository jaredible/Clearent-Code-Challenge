package data.cards;

import data.users.User;

public class CardMastercard extends CardBase {
	public CardMastercard(int id, User owner, double balance) {
		super(id, owner, balance);
	}

	public double getInterestRate() {
		return 0.05;
	}
}
