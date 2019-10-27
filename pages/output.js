function requestServer(url){
    console.log(url);
    jQuery.getJSON(url,
        {
            "bets": $("#player_bet").val()
        },
        function (data) {
            //牌放置位置的起点
            let base_left = $("#house_card_container").position().left;
            //每张牌的span
            console.log(data);
            let dom_str = '<span class="{type}" id="{type}_{point}" style="left: {left}px"><img src="img/{type}-{point}.png" style="height: 100px; width: 70px"></span>';
            function init(){//初始化：每人两张牌
                houseInit();
                playerInit();
            }
            function createCard(point, type, left){//生成牌（根据点数、花色和位置）
                let tmp_str = dom_str.replace(/{type}/g,type).replace(/{point}/g,point).replace(/{left}/g,left);
                return tmp_str;
            }
            function houseInit() {
                let n = data.gameStatus[0].hand.length;
                let house_box = '<span class="back" id="back" style="left: 10px" ><img src="img/back.png" style="height: 100px; width: 70px"></span>';
                for(let i=1;i<n;i++){
                    let tmp_left = base_left + 100*n;
                    house_box += createCard(data.gameStatus[0].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                }
                $("#house_card_container").html(house_box);
                console.log("nmsl");
            }
            function playerInit() {
                let n = data.gameStatus[1].hand.length;
                let player_box = '';
                for(let i=0;i<n;i++){
                    let tmp_left = base_left + 100*n;
                    player_box += createCard(data.gameStatus[1].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                }
                $("#player_card_container").html(player_box);
            }
            init();
        })
}