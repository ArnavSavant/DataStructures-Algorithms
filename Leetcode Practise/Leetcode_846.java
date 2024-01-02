import java.util.SortedMap;
import java.util.TreeMap;

public class Leetcode_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        SortedMap<Integer, Integer> mp = new TreeMap<>();
        for (int h : hand) {
            if (mp.containsKey(h)) {
                mp.put(h, mp.get(h) + 1);
            } else {
                mp.put(h, 1);
            }
        }
        while (mp.size() > 0) {
            int minimum = mp.firstKey();
            mp.put(minimum, mp.get(minimum) - 1);
            if (mp.get(minimum) == 0) {
                mp.remove(minimum);
            }
            int next = minimum + 1;
            for (int i = 1; i < groupSize; i++) {
                if (mp.containsKey(next)) {
                    mp.put(next, mp.get(next) - 1);
                    if (mp.get(next) == 0) {
                        mp.remove(next);
                    }
                    next = next + 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
Problem Description:
Given an array hand representing the initial cards in a hand and an integer groupSize, the task is to determine whether it's possible to divide the hand into groups of groupSize consecutive cards.

Code Explanation:
Check if Division is Possible:

The first step checks if the total number of cards (n) in the hand is divisible evenly by the group size (groupSize). If not, it returns false because an equal division is not possible.
Create a TreeMap to Count Occurrences:

A SortedMap<Integer, Integer> named mp (using a TreeMap) is created to store the count of each unique card in the hand. The keys are the card values, and the values are the counts of each card.
Iterate through the Hand and Populate the Map:

The code iterates through the hand array and updates the count of each card in the mp map.
Check for Consecutive Groups:

The main logic involves repeatedly selecting the minimum card from the map and checking if it's possible to form a consecutive group of size groupSize.
The minimum card is retrieved using mp.firstKey().
The count of this card is decreased by 1, and if its count becomes zero, the card is removed from the map.
Then, starting from the next consecutive card (next = minimum + 1), the code checks if the next groupSize - 1 consecutive cards are present in the map. If so, their counts are updated, and if any of them reach a count of zero, they are removed from the map.
Repeat Until Map is Empty:

The process is repeated until the map becomes empty. If at any point, it's not possible to form a consecutive group, the function returns false.
Return True if Successful:

If the loop completes successfully for all consecutive groups, the function returns true.
Intuition:
The code uses a TreeMap to keep track of the count of each card, and it iterates through the cards, trying to form consecutive groups of size groupSize. The logic ensures that for each minimum card, the next consecutive cards are present in the map, and their counts are appropriately updated.

Complexity Analysis:
Time Complexity:
The loop iterates through the cards, and for each card, it may perform operations on the TreeMap (insertion, removal, and checking) in O(log n) time, where 'n' is the size of the TreeMap.
The overall time complexity is O(n log n) due to the TreeMap operations.
Space Complexity:
The TreeMap (mp) stores the counts of unique cards, so the space complexity is O(n), where 'n' is the number of unique cards in the hand.
Summary:
The code efficiently determines whether it's possible to divide a given array of cards into consecutive groups of a specified size. It uses a TreeMap to keep track of the counts of each card, and the main logic ensures that consecutive groups can be formed. The time complexity is O(n log n), and the space complexity is O(n).
 */