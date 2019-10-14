package makise.ooad.lab2.entity;

import java.util.ArrayList;

//这个类的数组将被json化发给前端
public class GameStatus {
//    用户id
    int id;
//    赌注金额
    int betNum;
//    balance小于0则游戏结束
    int balance;
//    手牌数组 按照发牌顺序 每次在最后添加
    ArrayList<Integer> hand;
//    指示一轮是否结束
    boolean isEnd;
//    指示是否爆牌
    boolean isBust;
//    用于显示这是当前的第几轮
    int round;
//    用于指示接下来是玩家行动还是电脑行动
//    0表示电脑 其他数字对应玩家id
//    这个属性注意保持数组中所有对象一致
    int turn;
}
