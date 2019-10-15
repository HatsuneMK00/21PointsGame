package makise.ooad.lab2.controller;

import makise.ooad.lab2.entity.GameStatus;
import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

//负责处理和所有游戏进程相关的请求
@Controller
@ResponseBody
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("gameProgress/{type}")
    public Response gameProgress(@PathVariable("type") String type, @RequestParam("id") int playerId){
        Request request = new Request();
        request.setLevel(type);
        HashMap<String, Object> requestContent = new HashMap<>();
        requestContent.put("playerId",playerId);
        request.setRequestContent(requestContent);
        return gameService.gameContinue(request);
    }

    @GetMapping("hit/{id}")
    public Response hit(@PathVariable("id") int playerId){
        Request request = new Request();
        request.setLevel("hit");
        HashMap<String, Object> requestContent = new HashMap<>();
        requestContent.put("playerId",playerId);
        request.setRequestContent(requestContent);
        return gameService.gameContinue(request);
    }

    @GetMapping("split/{id}")
    public Response split(@PathVariable("id") int playerId){
        Request request = new Request();
        request.setLevel("split");
        HashMap<String, Object> requestContent = new HashMap<>();
        requestContent.put("playerId",playerId);
        request.setRequestContent(requestContent);
        return gameService.gameContinue(request);
    }

    @GetMapping("stand/{id}")
    public Response stand(@PathVariable("id") int playerId){
        return null;
    }

    @GetMapping("double/{id}")
    public Response doubleBet(@PathVariable("id") int playerId){
        return null;
    }

}
