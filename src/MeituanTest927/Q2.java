package MeituanTest927;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long row = scanner.nextLong(), col = scanner.nextLong(), actions = scanner.nextLong();
        boolean[] closed = new boolean[(int) (row + 1)];
        HashMap<Integer, Integer> bookMap = new HashMap<>();
        Set<Integer> borrowedBooks = new HashSet<>();
        int bookId, rowId;
        for (int i = 0; i < actions; i++) {
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    bookId = scanner.nextInt();
                    rowId = scanner.nextInt();
                    if (bookMap.containsKey(bookId)) {
                        if (closed[bookMap.get(bookId)]) break;
                    }
                    if (!closed[rowId] && !borrowedBooks.contains(bookId)) {
                        bookMap.remove(bookId);
                        bookMap.put(bookId, rowId);
                    }
                    break;
                case 2:
                    rowId = scanner.nextInt();
                    closed[rowId] = true;
                    break;
                case 3:
                    rowId = scanner.nextInt();
                    closed[rowId] = false;
                    break;
                case 4:
                    bookId = scanner.nextInt();
                    if (borrowedBooks.contains(bookId) || !bookMap.containsKey(bookId)) {
                        System.out.println(-1);
                        break;
                    }
                    int tempRow = bookMap.get(bookId);
                    if (closed[tempRow]) {
                        System.out.println(-1);
                        break;
                    }
                    borrowedBooks.add(bookId);
                    bookMap.remove(bookId);
                    System.out.println(tempRow);
                    break;
                case 5:
                    bookId = scanner.nextInt();
                    borrowedBooks.remove(bookId);
                    break;
            }
        }
    }
}
