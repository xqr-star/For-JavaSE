package pocker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    //初始化扑克牌
    public static void initialCards(List<Card> cardsList ) {
        //定义了一个 放card类型的顺序表

        for(String suit:new String[]{"♠","♦","♥","♣"}) {
            for(int rank = 1;rank<=5;rank++) {
                Card card = new Card(suit, rank);
                cardsList.add(card);
            }
        }
    }

    public static void main(String[] args) {
        String [] suit1 = {"♠","♦","♥","♣"};
        String [] suit2 = new String[]{"♠","♦","♥","♣"};

        //定义五个玩家
        List<Player> playerList = new ArrayList<>() ;
        //往顺序表里面添加玩家
        //new Player("周润发")
        //playerList.add("周润发");？？

        //等效代码
//        Player player1 = new Player("周润发");
//        playerList.add(player1);

        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("高博"));
        playerList.add(new Player("陈沛鑫"));
        playerList.add(new Player("解淇茹"));


        //初始化扑克牌
        List<Card> cardsList = new ArrayList<>();
        initialCards(cardsList);


        System.out.println(cardsList);//为什么可以实现打印这个顺序表
        
        //洗牌
        //collection jdk 下的shuffle

        Collections.shuffle(cardsList);
        System.out.println(cardsList);

        //发牌
           int n = 4; //每一名玩家的发牌数
        for(int i = 0;i<n; i++) {
            for (Player player : playerList) {//每一名玩家依次发牌

                //从牌组中，抽出一张牌来  需要把这个牌保存一下
                Card card = cardsList.remove(0);//取出0 号下标的元素

                //把牌发给玩家
                player.cardList.add(card);

            }
        }

        System.out.println("现在牌组中剩余的牌：");
        System.out.println(cardsList);

        //展示每一名玩家的手牌
        for(Player player: playerList) {
            //不懂为什么这样打印  -- player.cardList 到底干了些什么
            //注意打印的方式是格式化输出
            System.out.printf("玩家[%s]的手牌  %s%n",player.name,player.cardList);
        }

        //拿到黑桃1 的玩家获胜
        Card toFundCard  = new Card("♠",1);
        for(Player player:playerList) {
            //for(Card card : cardsList) 和 player.cardList 是区别的
            for(Card card : player.cardList) {
                //判断每一张牌是不是要找的那张
                //if(toFundCard.equals(card) == true) {
                if(card.equals(toFundCard) == true) {
                    System.out.printf("%s 玩家获胜",player.name);
                    //注意这里的写法 是return 直接程序结束
                    return;
                }
            }
        }
        System.out.println("无人获胜");






    }
}
