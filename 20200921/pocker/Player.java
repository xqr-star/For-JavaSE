package pocker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    //玩家手牌
    List<Card> playerCardlist = new ArrayList<>();

    String name;

    public Player(String name) {
        this.name = name;
    }




    //重写玩家的TO string 只是因为当类型是玩家类型的变量时 方便打印显示
//    @Override
//    public String toString() {
//        return String.format("玩家 %s",name);
//    }
}
