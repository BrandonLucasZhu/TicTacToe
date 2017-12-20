package project.basic.brandonzhu.tictactoe.game.modelgamelogic;

/**
 * Created by ezzhubr on 12/18/2017.
 */

public class TicTacToe {

    private Player[][] board = new Player[3][3];
    private Player user;
    public int turnCounter = 0;
    public String turn;



    private enum Player {
        X, O, NA


    }

    public TicTacToe(){

        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                board[i][j] = Player.NA;
            }
        }

    }

    public Player getBoardPoint(int i, int j){
        return board[i][j];
    }

    public void setMove(int i, int j) {

        if (getPlayerTurn().equals("X")){
            board[i][j] = Player.X;
        }
        else{
            board[i][j] = Player.O;
        }
        turnCounter++;

    }

    public String getPlayerTurn(){
        return turn = (turnCounter%2 == 0)?"X":"O";
    }


    public boolean check_winner(){
        boolean winner = false;
        int rowX = 0, rowO = 0, columnX = 0, columnO = 0;

        for (int x = 0; x <board.length; x++){
        //Check column and row
            for (int i = 0; i < board.length; i++) {
                if (board[x][i] == Player.X){
                    rowX++;
                }
                else if(board[x][i] == Player.O){
                    rowO++;
                }
                if (board[i][x] == Player.X){
                    columnX++;
                }
                else if (board[i][x] == Player.O){
                    columnO++;
                }
            }

            if (rowX == 3 || columnX == 3 || rowO == 3 || columnO == 3){
                winner = true;

            }

            rowX = 0;
            rowO = 0;
            columnO = 0;
            columnX = 0;

        }



        //Check diagonal
        if (board[0][0] == Player.X  && board[1][1] == Player.X && board[2][2] == Player.X){
            winner = true;
        }
        else if (board[0][0] == Player.O  && board[1][1] == Player.O && board[2][2] == Player.O){
            winner = true;
        }
        else if (board[0][2] == Player.X && board[1][1] == Player.X && board[2][0] == Player.X){
            winner = true;
        }
        else if (board[0][2] == Player.O  && board[1][1] == Player.O && board[2][0] == Player.O){
            winner = true;
        }

    return winner;
    }














}
