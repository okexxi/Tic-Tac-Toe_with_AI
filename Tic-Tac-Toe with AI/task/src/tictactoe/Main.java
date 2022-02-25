package tictactoe;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static String[] Start(String start) {
        if (!start.contains("start") || !start.contains(" ")) {
            System.out.println("Bad parameters!");
            return null;
        }
        String[] para = start.split(" ");
        if (para.length != 3){
            System.out.println("Bad parameters!");
            return null;
        }
        if ((para[1].equals("easy") || para[1].equals("user")) &&
                (para[2].equals("easy") || para[2].equals("user"))) {
            return para;
        }
        System.out.println("Bad parameters!");
        return null;
    }

    public static void PrintTable(char[][] table) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


    public static int[] Coordinates(String str) {
        int[] cord = new int[2];
        for (int i = 0; i < 2; i++) {
            switch (str.charAt(i + i)) {
                case '1':
                    cord[i] = 1;
                    break;
                case '2':
                    cord[i] = 2;
                    break;
                case '3':
                    cord[i] = 3;
                    break;
                default:
                    return cord;
            }
        }
        return cord;
    }


    public static void NextMoveUser(char[][] table, char XOR) {
        int[] cord;
        boolean ex;
        do {
            ex = false;
            System.out.print("Enter the coordinates: ");
            String coord = in.nextLine();
            coord = coord.trim();
            cord = Coordinates(coord);
            if (cord[0] == 0 || cord[1] == 0) {         //00 значит неправильность, метод Coordinates
                ex = true;
            }
            if (table[cord[0] - 1][cord[1] - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                ex = true;
            }
        } while (ex);
        table[cord[0] - 1][cord[1] - 1] = XOR;
        PrintTable(table);
    }


    public static char[][] NextMoveAI(char[][] table, char XOR) {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (table[x][y] != ' ') {
            table =NextMoveAI(table, XOR);
        } else {
            table[x][y] = XOR;
            System.out.println("Making move level \"easy\"");
            PrintTable(table);
        }
        return table;
    }

    public static boolean WhoWins(char[][] table, int count) {
        int n, m;
        for (int i = 0; i < 3; i++) {
            n = 0;
            m = 0;
            for (int j = 1; j < 3; j++) {
                if (table[i][j - 1] == table[i][j] && table[i][j] != ' ') n++;
                else n = 0;
                if (n == 2) {
                    System.out.println(table[i][j] + " wins");
                    return false;
                }

                if (table[j - 1][i] == table[j][i] && table[j][i] != ' ') m++;
                else m = 0;
                if (m == 2) {
                    System.out.println(table[j][i] + " wins");
                    return false;
                }
            }
        }
        if (table[1][1] != ' ' && (table[0][0] == table[1][1] && table[1][1] == table[2][2] || table[0][2] == table[1][1] && table[2][0] == table[1][1])) {
            System.out.println(table[1][1] + " wins");
            return false;
        }
        if (count == 9) {
            System.out.println("Draw");
            return false;
        } else return true;
    }

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] tabl = new char[3][3];
        int n;

        do {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tabl[i][j] = ' ';
                }
            } n = 0;
            System.out.print("Input command: ");
            String command = in.nextLine();
            if (command.equals("exit")) {
                break;
            }
            String[] parameters = Start(command);
            if (parameters == null) {
                continue;
            }
            PrintTable(tabl);
            do {
                switch (parameters[1]){
                    case "easy":
                        NextMoveAI(tabl, 'X');
                        n++;
                        break;
                    case "user":
                        NextMoveUser(tabl, 'X');
                        n++; break;
                }

                if (!WhoWins(tabl, n)) break;
                switch (parameters[2]){
                    case "easy":
                        NextMoveAI(tabl, 'O');
                        n++;
                        break;
                    case "user":
                        NextMoveUser(tabl, 'O');
                        n++; break;
                }
            } while (WhoWins(tabl, n));
        }while (true);
    }
}
