package pocker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    //一个类里面又嵌套了一个类？
    public List<Card> cardList = new ArrayList();

    public Player(String name) {
        this.name = name;
    }
}
