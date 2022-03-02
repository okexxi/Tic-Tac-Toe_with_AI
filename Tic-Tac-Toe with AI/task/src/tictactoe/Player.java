package tictactoe;

public class Player {
    private char symbol;
    private int ID;

    public Player() {
        this.symbol = 'Z';
    }

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void Move() {
        System.out.println("Something went wrong!");
    }
}
