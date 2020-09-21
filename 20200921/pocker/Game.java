package pocker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();

        //初始化牌组
        initializeCard(cardList);
        //System.out.println(cardList);
        //Collections 下的 洗牌
        Collections.shuffle(cardList);
        System.out.println(cardList);
        //发牌；

        List<Player> playerList = new ArrayList<>();

        //playerList.add("周润发");// 添加进去的必须是个Player 类型
        //但现在是一个string
        playerList.add(new Player("周润发"));
        //等效如下代码
        Player player1 = new Player("高博");
        playerList.add(player1);
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("陈沛鑫"));
        playerList.add(new Player("解淇茹"));

        //重写玩家的TO string 只是因为当类型是玩家类型的变量时 方便打印显示
        //System.out.println(playerList);



        int n = 4;//每一名玩家的牌组数目

        for( int i =0;i< n;i++) {
            for (Player player : playerList) {
                //从当前牌组抽出来
                Card currentCard = cardList.remove(0);
                //放到玩家牌组中
                //-- error 通过类名.方法playerList.add(currentCard);
                player.playerCardlist.add(currentCard);
            }
        }


        System.out.println("现在牌组中的牌");
        System.out.println(cardList);
        System.out.println("玩家手中的牌");
        for(Player player:playerList) {
            //这里的%n是换行的格式字符串,只能用在print输出语句中, 而\n是回车字符, 可以用在所有的字符串中.
            //打印的格式不清楚
            //playerList 是一个card 类型 因为重写过tostring  所以可以打印
            System.out.printf("玩家 [%s]手中的牌是%s %n",player.name,player.playerCardlist);
        }


        //黑桃A 在哪名玩家手中，哪名玩家获胜
        Card keyCard = new Card("♠",1);

        //遍历玩家手中所有的牌
        for(Player player :playerList) {
            for(Card card : player.playerCardlist) {
                //看看是否是同一个牌

                //返回此列表中指定元素的第一个出现的索引
                // -如果此列表不包含元素返回- 1。
                if(player.playerCardlist.indexOf(keyCard) !=-1) {
                    System.out.println("玩家" + player.name+"获胜");
                    return;
                }
                /**
                if(player.playerCardlist.contains(keyCard)) {
                    System.out.println("玩家" + player.name+"获胜");
                    return;
                }*/

                /**
                if(keyCard.equals(card)) {
                    System.out.println("玩家" + player.name+"获胜");
                    return;
                }*/
            }
        }
        System.out.println("无人获胜");
    }





    //初始化牌组的方法
    //传参进来的是一个Card 类型的链表
    private static void initializeCard(List<Card> cards) {
        for (String suit : new String[] {"♠", "♥", "♦", "♣"}) {
            for (int rank = 1; rank <= 5; rank++) {
                Card card = new Card(suit, rank);
                // 把扑克牌放入牌组中
                cards.add(card);
            }
        }
    }
}
