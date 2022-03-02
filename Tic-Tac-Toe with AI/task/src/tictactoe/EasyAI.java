package tictactoe;

import java.util.Random;

public class EasyAI extends Player {
    public EasyAI(char x) {
        super(x);
    }

    public void Move(char[][] table) {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (table[x][y] != ' ') {
            Move(table);
        } else {
            table[x][y] = getSymbol();
            System.out.println("Making move level \"easy\"");
            Main.PrintTable(table);
        }
    }

}
