package game;

import java.util.LinkedList;

public class Deck extends LinkedList<Card>{

	private static final long serialVersionUID = -3938621188766515471L;

	public Deck() {
		for(int i = 1; i <= 13; i++) {
			add(new Card(i, "hearts"));
			add(new Card(i, "diamonds"));
			add(new Card(i, "clubs"));
			add(new Card(i, "spades"));
		}
	}
}
