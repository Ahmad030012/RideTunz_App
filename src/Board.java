import java.util.Random;

public class Board {
    // 0 means empty
                         // 1 means X
                                           // 2 means O
    private int[][] board= new int[3][3];
    // prints the instruction Board
    public void instructionBoard(){
        System.out.println("| - | - | - |");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| - | - | - |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| - | - | - |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| - | - | - |");
    }

    public void displayBoard(){
        System.out.println("| - | - | - |");
        System.out.println(printRow(0));
        System.out.println("| - | - | - |");
        System.out.println(printRow(1));
        System.out.println("| - | - | - |");
        System.out.println(printRow(2));
        System.out.println("| - | - | - |");

    }
          // it places the user's piece  on the Board
    public boolean placePiece(int position, String pieceType){
        int row = (position-1)/3;
        int col = (position - (row*3))-1;
        if(board[row][col] == 0) {
            if (pieceType.equals("X")) board[row][col] = 1;
            if (pieceType.equals("O")) board[row][col] = 2;
            return true;
        } 
        return false;

    }
        // it places the pieces of the Computer on the Board Randomly
    public boolean placePieceRandomly(String pieceType){
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        boolean wasPiecePlace = false;
        while(!wasPiecePlace && !isFull()){
            if(board[row][col]==0){
                wasPiecePlace=true;
                if (pieceType.equals("X")) board[row][col] = 1;
                if (pieceType.equals("O")) board[row][col] = 2;
            }else{
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
        }
        return wasPiecePlace;
    }
     // it checks if the table is full or not
    public boolean isFull(){

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==0) return false;
            }
        }
        return true;
    }

      // it prints the rows of the Board
    private String printRow(int row){
        StringBuilder rowBuilder = new StringBuilder("| ");
        for(int i=0;i<board[0].length;i++){
            if(board[row][i] == 0) rowBuilder.append(" ");
            if(board[row][i] == 1) rowBuilder.append("X");
            if(board[row][i] == 2) rowBuilder.append("O");
            rowBuilder.append(" | ");
        }
        rowBuilder.deleteCharAt(rowBuilder.lastIndexOf(" "));
        return rowBuilder.toString();
    }

    public int[][] getBoard(){
        return board;
    }

    public static class Cell{
        public int row;
        public int col;

        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

}