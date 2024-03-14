import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Leetcode_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(beginWord)));
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            List<String> list = queue.poll();
            if (list.size() > level) {
                level++;
                for (String s : usedOnLevel) {
                    set.remove(s);
                }
                usedOnLevel.clear();
            }
            String lastWord = list.get(list.size() - 1);
            if (lastWord.equals(endWord)) {
                if (ans.size() == 0) {
                    ans.add(new ArrayList<>(list));
                } else if (ans.get(0).size() == list.size()) {
                    ans.add(new ArrayList<>(list));
                }
            }
            for (int i = 0; i < lastWord.length(); i++) {
                for (char x = 'a'; x <= 'z'; x++) {
                    char[] replacedWordArray = lastWord.toCharArray();
                    replacedWordArray[i] = x;
                    String replacedWord = new String(replacedWordArray);
                    if (set.contains(replacedWord)) {
                        list.add(replacedWord);
                        queue.add(new ArrayList<>(list));
                        usedOnLevel.add(replacedWord);
                        list.remove(replacedWord);
                    }
                }
            }
        }
        return ans;
    }
}
/*
The provided `findLadders` method is an implementation designed to find all the shortest transformation sequences from a `beginWord` to an `endWord`, given a dictionary `wordList`. Each transformation sequence must follow the rule that only one letter can be changed at a time, and each transformed word must exist in the word list. This solution employs breadth-first search (BFS) to explore all possible paths, efficiently finding the shortest sequences.

### Algorithm

1. **Initialization**: A list `ans` to store the final transformation sequences, a `Set` to efficiently check if a word is in the word list, and a queue for BFS that stores paths are initialized.

2. **BFS**:
   - Start by adding `beginWord` as the first path into the queue.
   - As long as the queue is not empty, remove paths from the queue one by one and explore all possible one-letter transformations of the last word in each path.
   - If a transformation reaches `endWord`, add the current path to `ans` if it matches the shortest sequence length found so far.
   - To optimize the search, words used in the current level are removed from the set at the end of each level, preventing revisits.

3. **Transformation & Exploration**:
   - For each word in the current path, generate all possible one-letter transformations.
   - If a transformation is in `wordList` and hasn't been used in the current BFS level, add the transformed word to the current path and enqueue this new path for future exploration.

4. **Shortest Paths Collection**:
   - The first time `endWord` is reached, the current path length becomes the benchmark for the shortest path length.
   - All subsequent paths reaching `endWord` are added to `ans` if they match this length.

### Why It Works

The method works by exploring all paths from `beginWord` to `endWord` through BFS, ensuring that the shortest paths are discovered first. By storing complete paths instead of individual words in the queue, the method is able to directly add these paths to the answer list once `endWord` is encountered. The use of a level-wise approach to remove used words ensures that only paths of minimum length are considered, optimizing the search for shortest paths and avoiding unnecessary exploration of longer sequences.

### Time and Space Complexity

- **Time Complexity**: O(N * M^2), where N is the number of words in `wordList` and M is the length of each word. For each word, generating all possible one-letter transformations involves O(M^2) operations (M replacements at M positions), and each transformation is checked against the `wordList`.
  
- **Space Complexity**: O(N * M), primarily for storing the BFS queue and the `Set` of words. In the worst case, the queue may need to store a large number of paths, each up to M length.

### Summary

The `findLadders` method provides a comprehensive solution to finding all the shortest transformation sequences from a starting word to a target word, given a set of intermediate words. Through careful application of BFS and path tracking, it efficiently identifies all shortest paths, ensuring optimal performance by pruning paths that cannot lead to the shortest sequences.
 */