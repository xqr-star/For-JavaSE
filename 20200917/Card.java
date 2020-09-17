package pocker;

import java.util.Objects;

public class Card {
    public int rank;//牌面值
    public String suit;//花色

    public Card(String suit,int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    //Object 类是所有类的父类
    public boolean equals(Object o) {

        if (this == o) return true;//两个引用指向用一个对象
        if (o == null || !(o instanceof Card) ) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;

    }



    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
        //???
//        static String format(Locale l, String format, Object... args)
//        使用指定的区域设置、格式字符串和参数返回格式化的字符串。
//        static String format(String format, Object... args)
//        使用指定的格式字符串和参数返回格式化的字符串


    }
}
