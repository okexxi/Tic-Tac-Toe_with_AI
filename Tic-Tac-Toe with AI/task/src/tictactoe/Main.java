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
        if ((para[1].equals("easy") || para[1].equals("user") || para[1].equals("medium")) &&
                (para[2].equals("easy") || para[2].equals("user") || para[2].equals("medium"))) {
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
            }
            n = 0;
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
            Player player1;
            Player player2;
            switch (parameters[1]){
                case "easy":
                    player1 = new EasyAI('X');
                    break;
                case "medium":
                    player1 = new MediumAI('X');
                    break;
                case "user":
                    player1 = new User('X');
                    break;
                default:
                    player1 = new Player();
            }

            switch (parameters[2]){
                case "easy":
                    player2 = new EasyAI('O');
                    break;
                case "medium":
                    player2 = new MediumAI('O');
                    break;
                case "user":
                    player2 = new User('O');
                    break;
                default:
                    player2 = new Player();
            }
            do {
                player1.Move();
                n++;
                if (!WhoWins(tabl, n)) break;
                player2.Move();
                n++;
            } while (WhoWins(tabl, n));
        }while (true);
    }
}
