package tictactoe;

interface PlayerInterface  {
    void Move(char[][] table);
}

public class Player implements PlayerInterface {
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

    public void Move(char[][] table) {
        System.out.println("Something went wrong!");
    }
}
