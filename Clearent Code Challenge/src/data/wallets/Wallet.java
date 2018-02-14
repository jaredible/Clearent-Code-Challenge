package data.wallets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.Utility;
import data.cards.CardBase;
import data.users.User;

public class Wallet {
	private String name;
	private User owner;
	private Map<Integer, CardBase> cards = new HashMap<Integer, CardBase>();

	public Wallet(User owner, CardBase... cards) {
		this("wallet_" + owner.getNumWallets(), owner, cards);
	}

	public Wallet(String name, User owner, CardBase... cards) {
		this.name = name;
		this.owner = owner;

		addCards(cards);
	}

	public double calculateInterest(int numMonths) {
		double result = 0.0;

		for (Entry<Integer, CardBase> map : cards.entrySet()) {
			result += map.getValue().calculateInterest(numMonths);
		}

		return result;
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public boolean addCards(CardBase... cards) {
		boolean result = true;

		int length = cards.length;
		for (int i = 0; i < length; i++) {
			if (addCard(cards[i]) != null) {
				result = false;
			}
		}

		return result;
	}

	public CardBase addCard(CardBase card) {
		if (!cards.containsKey(card.getId())) {
			cards.put(card.getId(), card);
		} else {
			System.err.println(card.getOwner().getName() + "'s card with id " + card.getId() + " could not be added!");
		}

		return card;
	}

	public CardBase getCard(int identifier) {
		return cards.get(identifier);
	}

	public List<CardBase> getCards() {
		return Utility.mapToList(cards);
	}

	public int getNumCards() {
		return cards.size();
	}

	public String toString() {
		return "[" + getClass().getSimpleName() + "] - name: " + name + ", owner_name: " + owner.getName() + ", numCards: " + cards.size();
	}
}
