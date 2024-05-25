import java.util.HashMap;
import java.util.Map;

public class Leetcode_1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char x : letters) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        int[] maxScore = new int[1];
        solve(words, mp, score, 0, 0, maxScore);
        return maxScore[0];
    }

    public void solve(String[] words, Map<Character, Integer> mp, int[] score, int ind, int currScore, int[] maxScore) {
        if (ind == words.length) {
            maxScore[0] = Math.max(maxScore[0], currScore);
            return;
        }
        solve(words, mp, score, ind + 1, currScore, maxScore);
        String currWord = words[ind];
        boolean canUseWord = true;
        int wordScore = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < currWord.length(); i++) {
            char ch = currWord.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            if (counts.get(ch) > mp.getOrDefault(ch, 0)) {
                canUseWord = false;
                break;
            }
            wordScore += score[ch - 'a'];
        }

        if (canUseWord) {
            for (char ch : currWord.toCharArray()) {
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 0) {
                    mp.remove(ch);
                }
            }
            solve(words, mp, score, ind + 1, currScore + wordScore, maxScore);
            for (char ch : currWord.toCharArray()) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            }
        }
    }
}
