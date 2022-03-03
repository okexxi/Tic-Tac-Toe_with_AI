package tictactoe;

public class MediumAI extends EasyAI implements PlayerInterface {
    public MediumAI(char x) {
        super(x);
    }

    private int[] Rule(char tic, char[][] table) {
        int[] coordinates = {-1, -1};
        int icount, jcount, d1count = 0, d2count = 0;
        for (int i = 0; i < 3; i++) {
            icount = 0;
            jcount = 0;
            for (int j = 0; j < 3; j++) {
                /*if (!(i == 1 && j == 1)) {
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
                }*/
                if (table[i][j] == tic) icount++;
                if (table[j][i] == tic) jcount++;
                if (i == 0){
                    if (table[j][j] == tic) d1count++;
                    if (table[j][2 - j] == tic) d2count++;
                }

            }
            if (icount == 2){
                for (int j = 0; j < 3; j++)  {
                    if (table[i][j] == ' ') {
                        coordinates[0] = i;
                        coordinates[1] = j;
                        return coordinates;
                    }
                }
            }
            if (jcount == 2){
                for (int j = 0; j < 3; j++)  {
                    if (table[j][i] == ' ') {
                        coordinates[0] = j;
                        coordinates[1] = i;
                        return coordinates;
                    }
                }
            }
        }
        if (d1count == 2){
            for (int j = 0; j < 3; j++)  {
                if (table[j][j] == ' ') {
                    coordinates[0] = j;
                    coordinates[1] = j;
                    return coordinates;
                }
            }
        }
        if (d2count == 2){
            for (int j = 0; j < 3; j++)  {
                if (table[j][2 - j] == ' ') {
                    coordinates[0] = j;
                    coordinates[1] = 2 - j;
                    return coordinates;
                }
            }
        }

        return coordinates;
    }


    public void Move(char[][] table) {
        char symbol = getSymbol();
        char userSymbol;
        if (symbol == 'X') userSymbol = 'O';
        else userSymbol = 'X';
        int[] place = Rule(symbol, table);
        if (place[0] == -1) {
            place = Rule(userSymbol, table);
            if (place[0] == -1) {
                super.Move(table);
            }
            else {
                table[place[0]][place[1]] = symbol;
                Main.PrintTable(table);
            }
        }
        else {
            table[place[0]][place[1]] = symbol;
            Main.PrintTable(table);
        }
    }
}
