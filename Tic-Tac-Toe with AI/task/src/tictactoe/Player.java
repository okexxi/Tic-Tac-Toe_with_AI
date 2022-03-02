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

    public void setID(String  level) {
        switch (level){
            case "easy":
                this.ID = 1;
                break;
            case "medium":
                this.ID = 2;
                break;
            case "user":
                this.ID = 0;
                break;
            default:
                this.ID = -1;
        }
    }

    public void Move() {
        switch (ID){
            case 0:
                this.ID = 1;
                break;
            case 1:
                this.ID = 2;
                break;
            case 2:
                this.ID = 0;
                break;
            default:
                this.ID = -1;
        }
}
