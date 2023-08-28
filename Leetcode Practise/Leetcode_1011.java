public class Leetcode_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = findSum(weights);
        int minCapacity = findMax(weights);
        int capacity = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (mid < minCapacity) {
                low = mid + 1;
                continue;
            }
            int noOfDays = calculateDays(weights, mid);
            if (noOfDays <= days) {
                capacity = Math.min(capacity, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return capacity;
    }

    public int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public int calculateDays(int weights[], int capacity) {
        int noOfDays = 0;
        int temp = capacity;
        for (int i = 0; i < weights.length; i++) {
            temp = temp - weights[i];
            if (temp < 0) {
                noOfDays++;
                temp = capacity;
                i--;
            }
        }
        noOfDays++;
        return noOfDays;
    }

    public int findMax(int weights[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }
        return max;
    }

    /*
     * The problem is about finding the minimum capacity of a ship required to ship
     * the weights within a given number of days. Let's break down the code and
     * understand the logic and intuition behind it.
     ** 
     * Intuition:**
     * 
     * 1. **Binary Search:** The capacity of the ship lies between the heaviest
     * weight (`minCapacity`) and the total sum of weights (`high`). This range is
     * set based on two conditions:
     * - The ship must be able to carry the heaviest package.
     * - In the best scenario, if there's only one day to deliver all weights, the
     * capacity must be the total sum of all weights.
     * 
     * 2. **Feasibility Check:** Once we decide a mid value in the range as the
     * current capacity of the ship, we need to check if it's feasible to ship all
     * weights within the given days.
     * 
     * Let's delve into the code details:
     * 
     * 1. **Initialization:**
     * ```java
     * int low = 0;
     * int high = findSum(weights);
     * int minCapacity = findMax(weights);
     * int capacity = Integer.MAX_VALUE;
     * ```
     * Here, we set the initial range for binary search. `minCapacity` is the
     * heaviest package and `high` is the sum of all weights. `capacity` will be
     * used to store the result, initialized with a very large value
     * (`Integer.MAX_VALUE`).
     * 
     * 2. **Binary Search:**
     * ```java
     * while (low <= high) {
     * int mid = high - (high - low) / 2;
     * ...
     * }
     * ```
     * We iterate until `low` is less than or equal to `high`. The `mid` is
     * calculated in each iteration and represents the current capacity of the ship
     * we want to test.
     * 
     * 3. **Capacity Check:**
     * ```java
     * if (mid < minCapacity) {
     * low = mid + 1;
     * continue;
     * }
     * ```
     * If the `mid` (current capacity) is smaller than the heaviest package, it's
     * not feasible, so we should search on the right side (`low = mid + 1`).
     * 
     * 4. **Feasibility Check:**
     * ```java
     * int noOfDays = calculateDays(weights, mid);
     * if (noOfDays <= days) {
     * capacity = Math.min(capacity, mid);
     * high = mid - 1;
     * } else {
     * low = mid + 1;
     * }
     * ```
     * `calculateDays` determines how many days are required to ship all weights
     * with a ship capacity of `mid`. If `noOfDays` is less than or equal to the
     * given `days`, it means the capacity `mid` is feasible and might be the
     * answer. We also look for smaller capacities (`high = mid - 1`). Otherwise, we
     * need a bigger capacity (`low = mid + 1`).
     * 
     * 5. **calculateDays Function:**
     * ```java
     * int noOfDays = 0;
     * int temp = capacity;
     * for (int i = 0; i < weights.length; i++) {
     * temp = temp - weights[i];
     * if (temp < 0) {
     * noOfDays++;
     * temp = capacity;
     * i--;
     * }
     * }
     * noOfDays++;
     * return noOfDays;
     * ```
     * This function calculates the number of days required to ship all weights with
     * a given capacity. It starts iterating over weights and subtracts each weight
     * from the current capacity (`temp`). When `temp` goes negative, it means we
     * need a new day and we reset the `temp` to the ship's capacity and reconsider
     * the weight (`i--`). After the loop, we add 1 to `noOfDays` for the current
     * day.
     * 
     * 6. **Utility Functions:**
     * - `findSum` returns the sum of all weights.
     * - `findMax` returns the heaviest weight.
     * 
     * In conclusion, this code uses a binary search on ship capacity to determine
     * the minimum capacity required to ship all weights within the given days. The
     * feasibility of each capacity is determined by simulating the shipping
     * process.
     */
}
