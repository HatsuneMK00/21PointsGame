//牌放置位置的起点
let base_left = $("#house_card_container").position().left;
//每张牌的span
let dom_str = '<span class="{type}" id="{type}_{point}" style="left: {left}px"><img src="img/{type}-{point}.png" style="height: 100px; width: 70px"></span>';
//初始化轮数及余额
$("#game_round").val("0");
$("#player_balance").val("2000");

function createCard(point, type, left){//生成牌（根据点数、花色和位置）
    let tmp_str = dom_str.replace(/{type}/g,type).replace(/{point}/g,point).replace(/{left}/g,left);
    return tmp_str;
};

function clear(){//清除庄家和玩家的牌堆
    $("#player_card_container").empty();
    $("#house_card_container").empty();
}

function reset() {//重置
    jQuery.getJSON(
        'http://localhost:8080/gameProgress/reset?id=0');
    clear();
    $("#game_round").val("0");
    $("#player_balance").val("2000");

}

function bet() {//下注
    jQuery.getJSON(
        'http://localhost:8080/gameProgress/bet',
        {
            "bets": $("#player_bet").val()
        },
        function (data) {
            function houseInit() {//更新庄家两张牌
                let house_box = '<span class="back" id="back" style="left: 10px" ><img src="img/back.png" style="height: 100px; width: 70px"></span>';
                for(let i=1;i<2;i++){
                    let tmp_left = base_left + 100*i;
                    if(data.gameStatus[0].hand[i].point === 11) {
                        house_box += createCard(data.gameStatus[0].hand[i].point-10,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                    else{
                        house_box += createCard(data.gameStatus[0].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                    }

                }
                $("#house_card_container").html(house_box);
            };
            function playerInit() {//更新玩家两张牌
                let n = data.gameStatus[1].hand.length;
                let player_box = '';
                for(let i=0;i<2;i++){
                    let tmp_left = base_left + 100*i;
                    if(data.gameStatus[1].hand[i].point === 11){
                        player_box += createCard(data.gameStatus[1].hand[i].point-10,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                    else{
                        player_box += createCard(data.gameStatus[1].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                }
                $("#player_card_container").html(player_box);
            };
            function init(){//初始化：每人两张牌
                clear();
                houseInit();
                playerInit();
            };
            
            //余额
            let balance = data.gameStatus[1]["balance"]; 
            //赌注
            let bet = data.gameStatus[1]["betNum"];
            console.log(data);

            //显示轮数及余额
            $("#game_round").val(data.round);
            $("#player_balance").val(data.gameStatus[1].balance);

            //下注  游戏开始
            if(balance>=bet)
                init();
            else
                alert("余额不足");



        }
    )
};

function hit() {//拿牌
    jQuery.getJSON(
        'http://localhost:8080/gameProgress/hit?id=1',
        {

        },
        function (data) {


            console.log(data);
            let start_left = base_left + 200;
            let num = data.gameStatus[1].hand.length;
            let html = document.getElementById("player_card_container").innerHTML;
            if(data.gameStatus[1].hand[num-1].point === 11){
                document.getElementById("player_card_container").innerHTML = html + createCard(data.gameStatus[1].hand[num-1].point-10, data.gameStatus[1].hand[num-1].type, start_left + (num - 3) * 100);
            }
            else {
                document.getElementById("player_card_container").innerHTML = html + createCard(data.gameStatus[1].hand[num - 1].point, data.gameStatus[1].hand[num - 1].type, start_left + (num - 3) * 100);
            }
            function houseImitate() {//渲染庄家的牌堆
                $("#house_card_container").empty();
                let n = data.gameStatus[0].hand.length;
                let house_box = '';
                for(let i=0;i<n;i++){
                    let tmp_left = base_left + 100*i;
                    if(data.gameStatus[0].hand[i].point === 11){
                        house_box += createCard(data.gameStatus[0].hand[i].point-10,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                    else{
                        house_box += createCard(data.gameStatus[0].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                }
                $("#house_card_container").html(house_box);
            }

            if(data.gameStatus[1].bust === true){

                setTimeout("alert('爆了！');",0.1);
                houseImitate();
                if(data.gameStatus[1].isWin === -1){
                    $('<div>').appendTo('body').addClass('alert alert-success').html('你输了').show().delay(3500).fadeOut();
                    //显示轮数及余额
                    $("#game_round").val(data.round);
                    $("#player_balance").val(data.gameStatus[1].balance);
                }
                else if(data.gameStatus[1].isWin === 0){
                    $('<div>').appendTo('body').addClass('alert alert-success').html('平局').show().delay(3500).fadeOut();
                    //显示轮数及余额
                    $("#game_round").val(data.round);
                    $("#player_balance").val(data.gameStatus[1].balance);
                }


                //显示轮数及余额
                $("#game_round").val(data.round);
                $("#player_balance").val(data.gameStatus[1].balance);
                // clear();
            }
        }
    )
};

function double() {//加倍
    jQuery.getJSON(
        'http://localhost:8080/gameProgress/double?id=1',
        function (data) {
            //余额
            let balance = data.gameStatus[1]["balance"];
            //赌注
            let bet = data.gameStatus[1]["betNum"];
            //下注  游戏开始
            if(balance<bet*2){
                alert("余额不足！请重置！");
            }
            console.log(data);
            let start_left = base_left + 200;
            let num = data.gameStatus[1].hand.length;
            let html = document.getElementById("player_card_container").innerHTML;
            if(data.gameStatus[1].hand[num-1].point === 11){
                document.getElementById("player_card_container").innerHTML = html + createCard(data.gameStatus[1].hand[num-1].point-10, data.gameStatus[1].hand[num-1].type, start_left + (num - 3) * 100);
            }
            else {
                document.getElementById("player_card_container").innerHTML = html + createCard(data.gameStatus[1].hand[num - 1].point, data.gameStatus[1].hand[num - 1].type, start_left + (num - 3) * 100);
            }
            function houseImitate() {//渲染庄家的牌堆
                $("#house_card_container").empty();
                let n = data.gameStatus[0].hand.length;
                let house_box = '';
                for(let i=0;i<n;i++){
                    let tmp_left = base_left + 100*i;
                    if(data.gameStatus[0].hand[i].point === 11){
                        house_box += createCard(data.gameStatus[0].hand[i].point-10,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                    else{
                        house_box += createCard(data.gameStatus[0].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                }
                $("#house_card_container").html(house_box);
            }

            if(data.gameStatus[1].bust === true){//判断是否爆牌

                setTimeout("alert('爆了！');houseImitate();",0);
                if(data.gameStatus[1].isWin === -1){
                    $('<div>').appendTo('body').addClass('alert alert-success').html('你输了').show().delay(2500).fadeOut();
                    //显示轮数及余额
                    $("#game_round").val(data.round);
                    $("#player_balance").val(data.gameStatus[1].balance);
                }
                else if(data.gameStatus[1].isWin === 0){
                    $('<div>').appendTo('body').addClass('alert alert-success').html('平局').show().delay(2500).fadeOut();
                    //显示轮数及余额
                    $("#game_round").val(data.round);
                    $("#player_balance").val(data.gameStatus[1].balance);
                }


                //显示轮数及余额
                $("#game_round").val(data.round);
                $("#player_balance").val(data.gameStatus[1].balance);
                // clear();
            }
        }

    )
}
function stand() {
    jQuery.getJSON('http://localhost:8080/gameProgress/stand?id=1',
        function (data) {
            function houseImitate() {
                $("#house_card_container").empty();
                let n = data.gameStatus[0].hand.length;
                let house_box = '';
                for(let i=0;i<n;i++){
                    let tmp_left = base_left + 100*i;
                    if(data.gameStatus[0].hand[i].point === 11){
                        house_box += createCard(data.gameStatus[0].hand[i].point-10,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                    else{
                        house_box += createCard(data.gameStatus[0].hand[i].point,data.gameStatus[0].hand[i].type,tmp_left);
                    }
                }
                $("#house_card_container").html(house_box);
            }
            houseImitate();
            if(data.gameStatus[1].isWin === 1){
                $('<div>').appendTo('body').addClass('alert alert-success').html('你赢了').show().delay(2500).fadeOut();
                //显示轮数及余额
                $("#game_round").val(data.round);
                $("#player_balance").val(data.gameStatus[1].balance);
            }
            else if(data.gameStatus[1].isWin === -1){
                $('<div>').appendTo('body').addClass('alert alert-success').html('你输了').show().delay(2500).fadeOut();
                //显示轮数及余额
                $("#game_round").val(data.round);
                $("#player_balance").val(data.gameStatus[1].balance);
            }
            else{
                $('<div>').appendTo('body').addClass('alert alert-success').html('平局').show().delay(2500).fadeOut();
                //显示轮数及余额
                $("#game_round").val(data.round);
                $("#player_balance").val(data.gameStatus[1].balance);

            }
        }
        )
}

