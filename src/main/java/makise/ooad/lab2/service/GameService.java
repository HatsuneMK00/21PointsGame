package makise.ooad.lab2.service;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.pointgame.GameRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//这边考虑要不要把这个类变成一个抽象基类或者接口？（模板方法模式 游戏的实现会更加具有扩展性）
//或者是把gameRunner抽象为一个基类 效果一样但是多了一层 不知道有没有用 可以将实现的包和Service包完全分隔开
//还是挺有用的
@Service
public class GameService {
    private GameRunner gameRunner = new GameRunner();

    public ArrayList<GameStatus> startGame(int[] bets){
        gameRunner.initGameSetting(bets);
        return gameRunner.startGame();
    }

    public ArrayList<GameStatus> hit(int id){
        return gameRunner.hit(id);
    }

    public ArrayList<GameStatus> split(int id){
        return gameRunner.split(id);
    }

    public ArrayList<GameStatus> stand(int id){
        return gameRunner.stand(id);
    }

    public ArrayList<GameStatus> doubleBet(int id){
        return gameRunner.doubleBet(id);
    }
}
