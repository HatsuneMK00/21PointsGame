package makise.ooad.lab2.controller;

import makise.ooad.lab2.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//负责处理和所有游戏进程相关的请求
@Controller
@ResponseBody
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("hit/{id}")
    public void hit(@PathVariable("id") Integer playerId){

    }

    @GetMapping("split/{id}")
    public void split(@PathVariable("id") Integer playerId){

    }

    @GetMapping("stand/{id}")
    public void stand(@PathVariable("id") Integer playerId){

    }

}
