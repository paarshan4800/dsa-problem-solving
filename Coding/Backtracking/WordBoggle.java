// Given a dictionary of distinct words and an M x N board where every cell has
// one character. Find all possible words from the dictionary that can be formed
// by a sequence of adjacent characters on the board. We can move to any of 8
// adjacent characters, but a word should not have multiple instances of the
// same cell.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/word-boggle4143/1#

// Input:
// N = 1
// dictionary = {"CAT"}
// R = 3, C = 3
// board = {{C,A,P},{A,N,D},{T,I,E}}
// Output:
// CAT
// Explanation:
// C A P
// A N D
// T I E
// Words we got is denoted using same color.

// Input:
// N = 4
// dictionary = {"GEEKS","FOR","QUIZ","GO"}
// R = 3, C = 3
// board = {{G,I,Z},{U,E,K},{Q,S,E}}
// Output:
// GEEKS QUIZ
// Explanation:
// G I Z
// U E K
// Q S E
// Words we got is denoted using same color.

class Solution {
    public boolean isValidCell(int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n)
            return true;

        return false;
    }

    public boolean findWord(char board[][], String target, int i, int j, int index, boolean[][] visited) {
        if (target.charAt(index) == board[i][j]) {
            index++;
            if (target.length() == index)
                return true;

            visited[i][j] = true;

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && y == 0)
                        continue;

                    int nextI = i + x;
                    int nextJ = j + y;
                    if (isValidCell(nextI, nextJ, board.length, board[0].length) && !visited[nextI][nextJ]) {
                        if (findWord(board, target, nextI, nextJ, index, visited))
                            return true;
                    }
                }
            }

            visited[i][j] = false;
        }

        return false;
    }

    public boolean findWord(char board[][], String target) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == target.charAt(0)) {
                    if (findWord(board, target, i, j, 0, visited))
                        return true;
                }
            }
        }

        return false;
    }

    public String[] wordBoggle(char board[][], String[] dictionary) {
        ArrayList<String> res = new ArrayList<>();

        for (String target : dictionary) {
            if (findWord(board, target))
                res.add(target);
        }

        String[] finRes = new String[res.size()];
        for (int i = 0; i < res.size(); i++)
            finRes[i] = res.get(i);

        return finRes;
    }
}