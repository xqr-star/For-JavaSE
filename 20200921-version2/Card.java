package pocker;

import java.util.Objects;

public class Card {
    String suit;
    int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        //  errror -- 这里写错过      if (o == null || !(o instanceof Player) return false;
        if (o == null || !(o instanceof Card)) return false;
//        Card objectCard = (Card) o;
//        objectCard.suit == this.suit && objectCard.rank == this.rank
//        return true;
        Card card = (Card) o;
        return rank==card.rank && suit.equals(card.suit);//这里用的是sting 的equals方法
         //return rank==card.rank && suit == card.suit;
    }



}
