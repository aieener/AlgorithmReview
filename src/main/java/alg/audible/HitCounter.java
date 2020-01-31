package alg.audible;

public interface HitCounter {
    /*
        刷题网伞留二变体。改成return某个id是否在一定时间内hit了超过m次。
        Design a hit counter which counts the number of hits received in the past 5 minutes.
        5min = 60 * 5 = 300
     */
    void hit(int timestamp);

    int getHits(int timestamp);
}
