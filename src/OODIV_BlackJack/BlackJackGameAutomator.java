package OODIV_BlackJack;

/**
 * 归根结底其实是一个state machine
 * While loop! : same as Pente BattleShip etc..
 */
public class BlackJackGameAutomator {
    // composition 关系
    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;
}
