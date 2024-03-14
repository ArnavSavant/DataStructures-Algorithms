import java.util.Arrays;

public class Leetcode_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power = power - tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            } else if (score >= 1) {
                power = power + tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
/*
The `bagOfTokensScore` method plays a game involving tokens and power to maximize a score. Given an array of token values (`tokens`) and an initial amount of power, the method seeks the highest possible score under the following rules:

1. Playing a token face up consumes power equal to the token's value and gains 1 score.
2. Playing a token face down gains power equal to the token's value and loses 1 score.

The tokens can be played in any order, and the goal is to maximize the score. The method returns the highest score achievable given the initial power and the token values.

### Algorithm

1. **Initialization**: Sort the `tokens` array to play tokens in ascending order when increasing the score and in descending order when needing to gain power.
2. **Play Tokens**: Iterate through the tokens with two pointers (`i` for the lowest value token not yet played face up, and `j` for the highest value token not yet played face down) and follow the rules:
   - If there's enough power to play the lowest value token face up, do so to increase the score.
   - If not enough power and there's at least 1 score, play the highest value token face down to gain power.
   - Continue until there are no more tokens to play or it's not possible to play any tokens due to insufficient power and score.
3. **Maximize Score**: Keep track of the maximum score achieved throughout the game.

### Time and Space Complexity

- **Time Complexity**: O(n log n), where n is the number of tokens. The most time-consuming operation is sorting the tokens array. The subsequent while loop has a linear time complexity, O(n), iterating through the tokens at most twice.
- **Space Complexity**: O(1), as the algorithm operates in place and only uses a fixed amount of extra space for variables regardless of the input size.

### Summary

The `bagOfTokensScore` method efficiently calculates the maximum score achievable by strategically playing tokens face up or face down based on the current power and the game's rules. By initially sorting the tokens, the method ensures that the gameplay strategy maximizes the score by always playing the least power-consuming tokens for score increases and the highest value tokens for power gains when necessary.
 */