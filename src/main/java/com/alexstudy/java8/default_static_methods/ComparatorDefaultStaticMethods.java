package com.alexstudy.java8.default_static_methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

interface Card extends Comparator<Card> {
    Card.Suit getSuit();

    Card.Rank getRank();

    enum Suit {
        DIAMONDS(1, "Diamonds"),
        CLUBS(2, "Clubs"),
        HEARTS(3, "Hearts"),
        SPADES(4, "Spades");

        private final int value;
        private final String text;

        Suit(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public int value() {
            return value;
        }

        public String text() {
            return text;
        }
    }

    enum Rank {
        DEUCE(2, "Two"),
        THREE(3, "Three"),
        FOUR(4, "Four"),
        FIVE(5, "Five"),
        SIX(6, "Six"),
        SEVEN(7, "Seven"),
        EIGHT(8, "Eight"),
        NINE(9, "Nine"),
        TEN(10, "Ten"),
        JACK(11, "Jack"),
        QUEEN(12, "Queen"),
        KING(13, "King"),
        ACE(14, "Ace");
        private final int value;
        private final String text;

        Rank(int value, String text) {
            this.value = value;
            this.text = text;
        }

        public int value() {
            return value;
        }

        public String text() {
            return text;
        }
    }
}

interface Deck {

    List<Card> getCards();

    Deck deckFactory();

    int size();

    void addCard(Card card);

    void addCards(List<Card> cards);

    void addDeck(Deck deck);

    void shuffle();

    void sort();

    void sort(Comparator<Card> c);

    String deckToString();

    Map<Integer, Deck> deal(int players, int numberOfCards)
            throws IllegalArgumentException;

}

/**
 * Created by apop on 4/13/2017.
 */
public class ComparatorDefaultStaticMethods {
    public static void main(String[] args) {
        StandardDeck deck = new StandardDeck();
        deck.shuffle();

        // old comparator
        deck.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getRank().value() - o2.getRank().value();
            }
        });

        // lambda comparator
        deck.sort((o1, o2) -> o1.getRank().value() - o2.getRank().value());

        // method reference comparator
        deck.sort(Comparator.comparing(
                (o) -> o.getRank().value(),
                Integer::compareTo
        ));

        // new way to compare stuff
        deck.sort(Comparator.comparing(Card::getRank));

        deck.sort(Comparator
                .comparing(Card::getRank)
                .thenComparing(Comparator.comparing(Card::getSuit)));

        deck.sort(Comparator
                .comparing(Card::getRank)
                .reversed()
                .thenComparing(Comparator.comparing(Card::getSuit)));
    }
}

class StandardDeck implements Deck {

    private List<Card> entireDeck;

    @Override
    public List<Card> getCards() {
        return null;
    }

    @Override
    public Deck deckFactory() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addCard(Card card) {

    }

    @Override
    public void addCards(List<Card> cards) {

    }

    @Override
    public void addDeck(Deck deck) {

    }

    @Override
    public void shuffle() {

    }

    public void sort() {
//        Collections.sort(entireDeck);
    }

    @Override
    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    @Override
    public String deckToString() {
        return null;
    }

    @Override
    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
        return null;
    }

    // ...
}




