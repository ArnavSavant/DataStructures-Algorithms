import java.util.Arrays;

public class FillingBookCaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] dp = new int[n][shelfWidth + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memorization(books, shelfWidth, 0, 0, 0, dp);
    }

    public int recursion(int[][] books, int shelfWidth, int index, int currWidth, int currHeight) {
        if (index == books.length) {
            return currHeight;
        }
        int booksWidth = books[index][0];
        int booksHeight = books[index][1];
        int place = Integer.MAX_VALUE;
        if (currWidth + booksWidth <= shelfWidth) {
            place = recursion(books, shelfWidth, index + 1, currWidth + booksWidth, Math.max(booksHeight, currHeight));
        }
        int newShelf = currHeight + recursion(books, shelfWidth, index + 1, booksWidth, booksHeight);

        return Math.min(place, newShelf);
    }

    public int memorization(int[][] books, int shelfWidth, int index, int currWidth, int currHeight, int[][] dp) {
        if (index == books.length) {
            return currHeight;
        }
        int booksWidth = books[index][0];
        int booksHeight = books[index][1];
        int place = Integer.MAX_VALUE;
        if (dp[index][currWidth] != -1) {
            return dp[index][currWidth];
        }
        if (currWidth + booksWidth <= shelfWidth) {
            place = recursion(books, shelfWidth, index + 1, currWidth + booksWidth, Math.max(booksHeight, currHeight));
        }
        int newShelf = currHeight + recursion(books, shelfWidth, index + 1, booksWidth, booksHeight);

        return dp[index][currWidth] = Math.min(place, newShelf);
    }

    public int tabulation(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth)
                    break;
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FillingBookCaseShelves obj = new FillingBookCaseShelves();
        int books[][] = { { 1, 3 }, { 2, 4 }, { 3, 2 } };
        int shelfWidth = 6;
        System.out.println(obj.tabulation(books, shelfWidth));
    }
}