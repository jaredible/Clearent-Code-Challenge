package data.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.Utility;
import data.cards.CardBase;
import data.wallets.Wallet;

public class User {
	public static final int MAX_USERS = 2;
	public static final User[] USERS = new User[MAX_USERS];

	private int id;
	private String name;
	private Map<String, Wallet> wallets = new HashMap<String, Wallet>();

	private User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static User createUser(int id, String name) {
		User user = null;

		if (USERS[id] == null) {
			user = new User(id, name);
			USERS[id] = user;
		}

		return user;
	}

	public double calculateInterest(int numMonths) {
		double result = 0.0;

		for (Entry<String, Wallet> map : wallets.entrySet()) {
			result += map.getValue().calculateInterest(numMonths);
		}

		return result;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean addWallets(Wallet... wallets) {
		boolean result = true;

		int length = wallets.length;
		for (int i = 0; i < length; i++) {
			if (addWallet(wallets[i]) != null) {
				result = false;
			}
		}

		return result;
	}

	public boolean addWallet(String name, CardBase... cards) {
		boolean result = true;

		int length = cards.length;
		for (int i = 0; i < length; i++) {
			if (addWallet(new Wallet(name, this, cards[i])) != null) {
				result = false;
			}
		}

		return result;
	}

	public Wallet addWallet(Wallet wallet) {
		if (!wallets.containsKey(wallet.getName())) {
			wallets.put(wallet.getName(), wallet);
		} else {
			System.err.println(wallet.getName() + " could not be added!");
		}

		return wallet;
	}

	public Wallet getWallet(String name) {
		return wallets.get(name);
	}

	public List<Wallet> getWallets() {
		return Utility.mapToList(wallets);
	}

	public int getNumWallets() {
		return wallets.size();
	}

	public String toString() {
		return "[" + getClass().getSimpleName() + "] - id: " + id + ", name: " + name + ", numWallets: " + wallets.size();
	}
}
