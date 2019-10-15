package makise.ooad.lab2.controller;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

//负责处理和所有游戏进程相关的请求
@Controller
@ResponseBody
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("hit/{id}")
    public ArrayList<GameStatus> hit(@PathVariable("id") int playerId){
        Request request = new Request();
        request.setLevel("hit");
        HashMap<String, Object> requestContent = new HashMap<>();
        requestContent.put("playerId",playerId);

        return gameService.hit(playerId);
    }

    @GetMapping("split/{id}")
    public ArrayList<GameStatus> split(@PathVariable("id") int playerId){
        return gameService.split(playerId);
    }

    @GetMapping("stand/{id}")
    public ArrayList<GameStatus> stand(@PathVariable("id") int playerId){
        return gameService.stand(playerId);
    }

}
