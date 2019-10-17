package makise.ooad.lab2.pointgame;

import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    public void getHandTest(){
        Dealer dealer = new Dealer();
        Hand hand = dealer.start();
    }
}
