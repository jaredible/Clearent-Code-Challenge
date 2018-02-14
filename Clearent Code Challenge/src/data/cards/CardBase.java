package data.cards;

import data.users.User;

public abstract class CardBase {
	protected int id;
	protected User owner;
	protected double balance = 0;

	public CardBase(int id, User owner, double balance) {
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}

	public double calculateInterest(int numMonths) {
		return balance * getInterestRate() * numMonths;
	}

	public int getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public double getBalance() {
		return balance;
	}

	public abstract double getInterestRate();

	public String toString() {
		return "[" + getClass().getSimpleName().substring(0, 4) + "] - id: " + id + ", owner_name: " + owner.getName() + ", balance: " + balance + ", type: " + getClass().getSimpleName().substring(4);
	}
}
