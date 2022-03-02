package tictactoe;

import java.util.Scanner;

public class User extends Player {

    public User(char x) {
        super(x);
    }

    public void Move(char[][] table) {
        Scanner in = new Scanner(System.in);
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
        table[cord[0] - 1][cord[1] - 1] = getSymbol();
        Main.PrintTable(table);
    }


    private int[] Coordinates(String str) {
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

}
