package project.basic.brandonzhu.tictactoe.game.modelgamelogic;

/**
 * Created by ezzhubr on 12/18/2017.
 */

public class TicTacToe {

    private Player[][] board = new Player[3][3];
    private Player user;
    private int turnCounter = 0;
    private String turn;
    private int rowX, rowO, columnX, columnO;


    private enum Player{
        X,O,NA

    }

    private TicTacToe(){

        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                board[i][j] = Player.NA;
            }
        }
        rowX = 0;
        rowO = 0;
        columnX = 0;
        columnO = 0;
    }

    public Player getBoardPoint(int i, int j){
        return board[i][j];
    }

    public void setMove(int i, int j) {
        playerTurn();
        if (turn.equals("X")){
            board[i][j] = Player.X;
        }
        else{
            board[i][j] = Player.O;
        }
        turnCounter++;

    }

    public void playerTurn(){
        turn = (turnCounter%2 == 0)?"X":"O";
    }


    public boolean check_winner(){
        boolean winner = false;


        for (int x = 0; x <board.length; x++){
        //Check column and row
            for (int i = 0; i < board.length; i++) {
                if (board[x][i].equals(Player.X.toString())){
                    rowX++;
                }
                else if(board[x][i].equals(Player.O.toString())){
                    rowO++;
                }
                else if (board[i][x].equals(Player.X.toString())){
                    columnX++;
                }
                else if (board[i][x].equals(Player.O.toString())){
                    columnO++;
                }
            }
        }

        if (rowX == 3 || columnX == 3 || rowO == 3 || columnO == 3){
            winner = true;
        }
        //Check diagonal
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            winner = true;
        }
        else if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])){
            winner = true;
        }

    return winner;
    }














}
