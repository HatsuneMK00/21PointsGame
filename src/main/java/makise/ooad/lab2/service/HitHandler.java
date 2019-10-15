package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;

import java.util.ArrayList;

public class HitHandler extends Handler {
    @Override
    protected String getHandlerLevel() {
        return "hit";
    }

//    处理一次玩家hit的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    //    这个方法调用后为用户id为{id}的用户抽了一张牌后的状态

    @Override
    protected ArrayList<GameStatus> echo(Request request) {
        return null;
    }
}