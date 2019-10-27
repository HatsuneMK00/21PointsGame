# 21PointsGame

## api使用说明

启动SpringBoot程序后，访问http://localhost:8080/swagger-ui.html可以看到接口的文档

## 使用示例

* 开始游戏：gameProgress/bet?bets=30 一位玩家参加游戏，下注30

* 抽牌：gameProgress/hit?id=1 1号玩家抽一张牌

* 翻倍：gameProgress/double?id=1 1号玩家翻倍

* 停牌：gameProgress/stand?id=1 1号玩家停牌

* 重新开始：gameProgress/reset?id=0 重置游戏

## 注意事项

### 单个玩家的情况

1. double按钮需要判断在本金够的时候才可以点击，否则是不可以点击的状态
2. 玩家id按照response中gameStatus中定义的来，0号玩家是庄家
3. 前端需要做一些输入合法性检查，比如赌注金额小于本金（现在可以先不做）
4. gameStatus里的turn表示现在轮到哪个玩家行动，非有效玩家id则表示轮到庄家（由于庄家是模拟的，因此此时已经行动完了，所有此时的gameStatus已经是结束的状态）
5. gameStatus每个玩家里的isWin表示该玩家是否胜利，2表示游戏未结束还未知，1表示硬，-1表示输

** 如果还有其他的问题再来问我就可以喇 **
