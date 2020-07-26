1.集合和数组的区别
数组：大小固定，只能存储相同类型的数据，基本数据类型存储的是值，引用类型存储的是地址值，执行效率高。
集合：大小可变，可以存储不同类型的数据，存储基本数据类型会自动装箱变成对象，软件开发效率高。

2.集合实现类
主要分为3种类型:
List: 有序列表的集合，有ArrayList, LinkedList
Set: 没有重复数据的集合，无序：HashSet, EnumSet, LinkedHashSet 有序：TreeSet
Map: key-value的集合，有：EnumMap, HashMap, LinkedHashMap, TreeMap


3.斗地主

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 装牌
        List<String> pokerList = new ArrayList<>(54);
        List<String> pokerColor = List.of("黑桃", "红桃", "方块", "梅花");
        List<String> pokerNum = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        List<String> pokerKing = List.of("大王", "小王");
        for (String color : pokerColor) {
            for (String num : pokerNum) {
                pokerList.add(color + num);
            }
        }
        pokerList.addAll(pokerKing);

        // 洗牌
        Collections.shuffle(pokerList);

        // 发牌
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> cards = new ArrayList<>();
        // 取底牌
        for (int i = 0; i < 3; i++) {
            cards.add(pokerList.remove(pokerList.size() - 1));
        }
        // 轮流发牌
        for (int i = 0; i < pokerList.size(); i++) {
            if (i % 3 == 0) {
                player1.add(pokerList.get(i));
            } else if (i % 3 == 1) {
                player2.add(pokerList.get(i));
            } else {
                player3.add(pokerList.get(i));
            }
        }

        // 选地主
        List<String> players = List.of("player1", "player2", "player3");
        String landLord = players.get((int) (Math.random() * 3));
        System.out.println("地主是" + landLord);
        switch (landLord) {
            case "player1":
                player1.addAll(cards);
                break;
            case "player2":
                player2.addAll(cards);
                break;
            default:
                player3.addAll(cards);
                break;
        }

        // 看牌
        System.out.println("玩家1的牌： " + player1);
        System.out.println("玩家2的牌： " + player2);
        System.out.println("玩家3的牌： " + player3);
    }
}