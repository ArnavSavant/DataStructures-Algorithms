import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Leetcode_127 {
    class Pair {
        String word;
        int distance;

        Pair(String word, int dist) {
            this.word = word;
            this.distance = dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> mp = new HashMap<>();
        for (String word : wordList) {
            mp.put(word, true);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        if (mp.containsKey(beginWord)) {
            mp.remove(beginWord);
        }
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            if (node.word.equals(endWord)) {
                return node.distance;
            }
            for (int i = 0; i < node.word.length(); i++) {
                for (char x = 'a'; x <= 'z'; x++) {
                    char[] replacedWordArray = node.word.toCharArray();
                    replacedWordArray[i] = x;
                    String replacedWord = new String(replacedWordArray);
                    if (mp.containsKey(replacedWord)) {
                        queue.add(new Pair(replacedWord, node.distance + 1));
                        mp.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode_127 obj = new Leetcode_127();
        String beginWord = "leet";
        String endWord = "code";
        List<String> wordList = new ArrayList<>(Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost"));
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }
}
/*
### Documentation for the `ladderLength` Method

#### Overview

The `ladderLength` method calculates the shortest transformation sequence length from a `beginWord` to an `endWord`, using a given list of words (`wordList`). Each word can only be transformed to another word in `wordList` by changing exactly one letter at a time, and each transformed word must exist in the word list. The transformation sequence's length is defined by the number of steps from `beginWord` to `endWord`, including the start and end words.

#### Algorithm

1. **Map Initialization**: Initializes a HashMap `mp` with all words in `wordList` as keys, mapped to `true`, to indicate they are unvisited.

2. **Queue Initialization**: A Queue of `Pair` objects (where each `Pair` contains a word and its distance from `beginWord`) is initialized, starting with `beginWord` at a distance of 1.

3. **BFS Traversal**:
   - While the queue is not empty, remove a pair from the queue.
   - If the word in the pair is `endWord`, return its distance as the shortest path length.
   - Otherwise, generate all possible one-letter transformations of the word.
   - For each valid transformation that exists in `mp`, enqueue a new pair with the transformed word and the incremented distance. Mark the word as visited by removing it from `mp`.

4. **End Condition**: If the queue becomes empty without finding `endWord`, return 0, indicating that no transformation sequence exists.

#### Why It Works

The method effectively finds the shortest transformation sequence by exploring all possible transformations breadth-first. This ensures that the first time `endWord` is reached, the corresponding path length is the shortest possible. By marking words as visited (removing them from `mp` upon first visit), the algorithm avoids cycles and redundant transformations, focusing only on progressing towards `endWord`.

#### Time Complexity

- **O(N * M^2)**, where `N` is the number of words in `wordList` and `M` is the length of each word. The complexity arises from iterating over every word (`N`), and for each word, generating all possible one-letter transformations (`M` transformations each of `M` length).

#### Space Complexity

- **O(N)**, mainly due to the space required for the queue and the HashMap. In the worst case, all words from `wordList` might end up in the queue or remain as keys in the HashMap during the execution.

#### Summary

The `ladderLength` method provides a solution to find the length of the shortest transformation sequence from `beginWord` to `endWord` using BFS. This approach ensures that the search is efficient and that the sequence, if found, is indeed the shortest by leveraging the breadth-first nature of the search and avoiding revisits to previously encountered words.
 */