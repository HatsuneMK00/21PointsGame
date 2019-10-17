package makise.ooad.lab2.controller;

import makise.ooad.lab2.entity.Request;
import makise.ooad.lab2.entity.Response;
import makise.ooad.lab2.gamerunner.GameRunner;
import makise.ooad.lab2.gamerunner.StartGameGameRunner;
import makise.ooad.lab2.pointgame.PointGame;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class BetControllerTest {
    @Autowired
    PointGame game;

    @Test
    void bet() {
        Request request = new Request();
        request.setLevel("start");
        HashMap<String, Object> map = new HashMap<>();
        int[] bets = {30};
        map.put("bets",bets);
        assertNotNull(game);
        map.put("game",game);
        request.setRequestContent(map);
        GameRunner gameRunner = new StartGameGameRunner();
        Response response = gameRunner.handleRequest(request);
        assertNotNull(response);
        System.out.println(response);
    }
}