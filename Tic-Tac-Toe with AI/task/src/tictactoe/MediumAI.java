package tictactoe;

public class MediumAI extends EasyAI {
    public MediumAI(char x) {
        super(x);
    }

    private int[] Rule(char tic, char[][] table) {
        int[] coordinates = {-1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    if (table[1][1] == tic && table[i][j] == tic && table[2 - i][2 - j] == ' ') {
                        coordinates[0] = 2 - i;
                        coordinates[1] = 2 - j;
                        return coordinates;
                    }
                    if (table[i][j] == tic && table[i][2 - j] == tic && table[i][1] == ' ') {
                        coordinates[0] = i;
                        coordinates[1] = 1;
                        return coordinates;
                    }
                    if (table[i][j] == tic && table[2 - i][j] == tic && table[1][j] == ' ') {
                        coordinates[0] = 1;
                        coordinates[1] = j;
                        return coordinates;
                    }
                    if (j == 1) {
                        if (table[i][j] == tic && table[i][2] == tic && table[i][0] == ' ') {
                            coordinates[0] = i;
                            coordinates[1] = 0;
                            return coordinates;
                        }
                        if (table[i][j] == tic && table[i][0] == tic && table[i][2] == ' ') {
                            coordinates[0] = i;
                            coordinates[1] = 2;
                            return coordinates;
                        }
                    }
                    if (i == 1) {
                        if (table[i][j] == tic && table[2][j] == tic && table[0][j] == ' ') {
                            coordinates[0] = 0;
                            coordinates[1] = j;
                            return coordinates;
                        }
                        if (table[i][j] == tic && table[0][j] == tic && table[2][j] == ' ') {
                            coordinates[0] = 2;
                            coordinates[1] = j;
                            return coordinates;
                        }
                    }
                }

            }
        }

        return coordinates;
    }


    public void Move(char[][] table, User user) {
        char symbol = getSymbol();
        int[] place = Rule(symbol, table);
        if (place[0] == -1) {
            place = Rule(user.getSymbol(), table);
            if (place[0] == -1) {
                super.Move(table);
            }
        }
        else {
            table[place[0]][place[1]] = symbol;
            System.out.println("Making move level \"medium\"");
            Main.PrintTable(table);
        }
    }
}
