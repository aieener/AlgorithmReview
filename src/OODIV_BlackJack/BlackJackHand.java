package OODIV_BlackJack;

import java.util.ArrayList;
import java.util.List;

/**
 * 麻烦点：
 *      A can be both 1 and 11
 *      One might have multiple A
 *
 */
public class BlackJackHand extends Hand{

    /**
     * Find all possible scores: permutation Question
     *      BFS or DFS
     */
    @Override
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE; // max <= 21
        int minOver = Integer.MAX_VALUE; // min > 21

        for(int score : scores) {
            if(score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    /**
     * Do a dfs here and return all possible scores!
     * @return
     */
    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();

        for(Card card: cards) {
            updateScore(card, scores); // dfs
        }
        return scores;
    }

    private void updateScore(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card);
        if(scores.isEmpty()) {
            for(int score : toAdd) {
                scores.add(score);
            }
        } else {
            final int length = scores.size();
            for(int i = 0; i < length; i++) {
                int oldScore = scores.get(i);
                scores.set(i, oldScore + toAdd[0]);
                for(int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
            }
        }
    }

    private int[] getScores(Card card) {
        if(card.value() > 1) {
            return new int[]{Math.min(card.value(), 10)};
        } else { // == 1 ==> Ace
            return new int[]{1, 11};

        }
    }
}
