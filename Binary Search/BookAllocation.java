public class BookAllocation {
    public int allocateBooks(int books[], int m) {
        int low = findMax(books);
        int high = findSum(books);
        int minPages = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int students = findNumberOfStudents(books, mid);
            if (students <= m) {
                minPages = Math.min(minPages, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minPages;
    }

    private int findNumberOfStudents(int[] books, int maxPages) {
        int students = 0;
        int currentPages = 0;
        for(int i=0;i<books.length;i++) {
            if(currentPages+books[i]<=maxPages) {
                currentPages = currentPages + books[i];
            }
            else {
                students++;
                currentPages = books[i];
            }
        }
        return students;
    }

    private int findMax(int[] books) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < books.length; i++) {
            max = Math.max(max, books[i]);
        }
        return max;
    }

    private int findSum(int[] books) {
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i];
        }
        return sum;
    }
}
/*
 Alright, let's break this down step by step! This code is related to the problem of allocating books to students such that the maximum number of pages allocated to a student is minimized. This is a classic example of a "Minimum of Max" problem. 

### **Problem Statement**:
You are given `n` books with a certain number of pages. The task is to allocate books to `m` students so that:
- Each book is allocated to exactly one student.
- Each student has at least one book.
- The maximum number of pages allocated to a student is minimized.

### **Intuition**:
Imagine if you had to give all the books to one student. In this scenario, the student would have the maximum number of pages, which would be the sum of all the book pages. On the other end, if you had an unlimited number of students, you'd give each student the book with the maximum number of pages, making the maximum pages a student has equivalent to the book with the most pages. This gives the lower and upper bounds of the binary search: `findMax(books)` and `findSum(books)` respectively.

Now, between these two extremes, the problem is to figure out the optimum number of pages (let's call it `maxPages`) that a student should get, such that only `m` students are sufficient to allocate all the books. If a certain `maxPages` requires more than `m` students, it's too low; if it requires less, it's potentially too high.

### **Logic and Explanation of Code**:

1. **findMax() and findSum()**:
    - `findMax` finds the book with the maximum pages. This is the minimum possible value of `maxPages` since even if you have `n` students, the student who gets the book with the most pages will at least get this many pages.
    - `findSum` calculates the total number of pages in all the books. This gives the upper bound for the binary search.

2. **Binary Search**:
    - The binary search is applied over the number of pages (and not directly over the books or students). This is the crux of the "binary search on answer space" technique.
    - `low` starts with the maximum number of pages in any book (as returned by `findMax`) and `high` starts with the sum of all pages (as returned by `findSum`).

3. **allocateBooks()**:
    - We iteratively calculate the mid of `low` and `high`, which gives the current guess for the `maxPages` a student can be allocated.
    - `findNumberOfStudents` determines how many students are required to allocate the books such that no student gets more than `maxPages`.
    - If the number of students required is less than or equal to `m`, it means our current `maxPages` guess is potentially too high. Hence, update `minPages` and move `high` to `mid - 1`.
    - If more students are required, it indicates our guess is too low, so move `low` to `mid + 1`.

4. **findNumberOfStudents()**:
    - This function goes through each book and tries to allocate it to the current student (without exceeding `maxPages`). If a book causes an overflow, allocate it to the next student.

5. **Returning the result**:
    - After the while loop in `allocateBooks`, the answer should be stored in `minPages`. However, the code mistakenly returns `-1` unconditionally. The last line should be changed to `return minPages;`.

### **Final Note**:

The code embodies the power of Binary Search on Answer Space by converting a seemingly complex allocation problem into a simple search problem. Instead of looking at students or books directly, it looks at the number of pages, which provides a continuous space to apply binary search, making the problem solvable in O(n log sum) time, where `sum` is the total number of pages in all books.
 */