package makise.ooad.lab2.pointgame;

public class Judge {
    //    这边可以考虑把给钱的方法提取出去（即按照我画的顺序图的流程做）
    //    也可以直接写在函数里面
    private void giveMoneyTo(Gambler o, int amount) {
        o.money.addMoney(amount);
    }

    public int judge(House house, Player player) {
        if (house.getHand().isBusted()) {
            giveMoneyTo(player, player.getBetNum() * 2);
            return 1;
        }
        if (player.getHand().isBusted()) {
            giveMoneyTo(house, player.getBetNum() * 2);
            return -1;
        }
        if (player.getHand().getHandPoint() > house.getHand().getHandPoint()) {
            giveMoneyTo(player, player.getBetNum() * 2);
            return 1;
        }
        if (player.getHand().getHandPoint() < house.getHand().getHandPoint()) {
            giveMoneyTo(house, player.getBetNum() * 2);
            return -1;
        }
        if (player.getHand().getHandCardAmount() < house.getHand().getHandCardAmount()) {
            giveMoneyTo(player, player.getBetNum() * 2);
            return 1;
        }
        if (player.getHand().getHandCardAmount() > house.getHand().getHandCardAmount()) {
            giveMoneyTo(house, player.getBetNum() * 2);
        }
        giveMoneyTo(player, player.getBetNum());
        giveMoneyTo(house, player.getBetNum());
        return 0;
    }

}
