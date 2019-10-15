package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;

import java.util.ArrayList;

public class StandHandler extends Handler {
    @Override
    protected String getHandlerLevel() {
        return "stand";
    }

//    处理一次玩家stand的逻辑
//    玩家id和所有可能的需要的数据都在request里面
    @Override
    protected ArrayList<GameStatus> echo(Request request) {
        return null;
    }
}
