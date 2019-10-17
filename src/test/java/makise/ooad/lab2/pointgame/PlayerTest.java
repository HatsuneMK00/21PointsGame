package makise.ooad.lab2.pointgame;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void getHandTest(){
        Player player= new Player(1,"Harvey",2000);
        player.getHand(new Dealer());
        System.out.println(player.getHand().getCards().get(0).getType());
        System.out.println(player.getHand().getCards().get(0).getPoint());
        System.out.println(player.getHand().getCards().get(1).getType());
        System.out.println(player.getHand().getCards().get(1).getPoint());
    }
}
