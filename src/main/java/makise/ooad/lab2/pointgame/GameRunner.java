package makise.ooad.lab2.pointgame;

import makise.ooad.lab2.entity.GameStatus;

import java.util.ArrayList;

//里面的所有方法都需要返回一个GameStatus对象的数组
//GameStatus中的数据详见对应java文件
//应该是不用担心对象状态不被保存的问题 我把GameRunner类的引用放在了一个常驻的对象里面
//所以这个类和他依赖的所有类应该都不会被回收
//每次调用的时候都可以继续执行下去
//测试了符合我上面说的
public class GameRunner {
    //    可以将0号玩家固定为庄家
    private ArrayList<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private Judge judge = new Judge();
    private int round = 0;

//    游戏各个玩家赌注的初始化
//    庄家没有赌注 玩家0号为庄家！
    public void initGameSetting(int[] bets) {

    }
//    这个方法调用后为各发两张牌的状态
    public ArrayList<GameStatus> startGame(){
        return null;
    }
//    这个方法调用后为用户id为{id}的用户抽了一张牌后的状态
    public ArrayList<GameStatus> hit(int id){
        return null;
    }
//    这个方法调用后为用户id为{id}的用户分牌后的状态
    public ArrayList<GameStatus> split(int id){
        return null;
    }
//    类似上面的说明
    public ArrayList<GameStatus> stand(int id) {
        return null;
    }
//类似上面的说明
    public ArrayList<GameStatus> doubleBet(int id) {
        return null;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
