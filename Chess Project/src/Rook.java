public class Rook {
    //Instance Variables
    private int row;
    private int col;
    private boolean isBlack;

    //Constructor for creating the Rook Pieces
    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack  = isBlack;


    }

    //This method verifies whether the intended movement of the Rook pieces is legal
    //Given the current state of the board

    public boolean isMoveLegal(Board board, int endRow, int endCol){
         //These first two if statements are for verifying vertical and horizontal movements to empty spaces
        if(board.verifyVertical(this.row,this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){


                return (endRow == this.row + (Math.abs(endRow - this.row))) || (endRow == this.row - (Math.abs(endRow - this.row)));


        }
        else if(board.verifyHorizontal(this.row, this.col, endRow, endCol) && (board.getPiece(endRow,endCol) == null) ){

           return(endCol == this.col + (Math.abs(endCol - this.col))) || (endCol == this.col - (Math.abs(endCol - this.col)));

        }
        //These if statements verify movement to spaces with opposing pieces on them
        else if(!board.verifyVertical(this.row ,this.col,endRow,endCol) && ((board.getPiece(endRow,endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack))){

            return (endRow == this.row + (Math.abs(endRow - this.row))) || (endRow == this.row - (Math.abs(endRow - this.row)));
        }
        else if(!board.verifyHorizontal(this.row,this.col, endRow, endCol) && ((board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack))){

            return(endCol == this.col + (Math.abs(endCol - this.col))) || (endCol == this.col - (Math.abs(endCol - this.col)));
        }



        return false;
    }

}
