public class Queen {
    //Instance Variables
    private int row;
    private int col;
    private boolean isBlack;

    //Constructor for creating the Queen objects
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }

    //This method verifies whether the intended movement of the Rook pieces is legal
    //Given the current state of the board

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //While this method looks like a bit of a mess, it is the same code from my Rook and Bishop methods combined
        //These first 2 if statements are for basic vertical and horizontal movement
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
        //The rest of this method is the exact same code from my Bishop method
        //This first if statement verifies that the space is free and there is nothing in the path of the Bishop
        else if(board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow,endCol) == null){

            //Each of these 4 if statements are for verifying movement in a different diagonal direction
            if(endRow < this.row && endCol > this.col){
                return(endRow == this.row - Math.abs(endRow - this.row) && (endCol == this.col + Math.abs(endCol - this.col)));

            }
            else if(endRow < this.row && endCol < this.col){

                return(endRow == this.row - Math.abs(endRow - this.row) && (endCol == this.col - Math.abs(endCol - this.col)));

            }
            else if(endRow > this.row && endCol > this.col){

                return(endRow == this.row + Math.abs(endRow - this.row) && (endCol == this.col + Math.abs(endCol - this.col)));

            }
            else if(endRow > this.row && endCol < this.col){

                return(endRow == this.row + Math.abs(endRow - this.row) && (endCol == this.col - Math.abs(endCol - this.col)));
            }


        }
        //This else if is in case there is an opposing piece on the end space
        else if(!board.verifyDiagonal(this.row, this.col, endRow, endCol) && ((board.getPiece(endRow,endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack))){

            //These are the same if statements that verify diagonal movement
            if(endRow < this.row && endCol > this.col){
                return(endRow == this.row - Math.abs(endRow - this.row) && (endCol == this.col + Math.abs(endCol - this.col)));

            }
            else if(endRow < this.row && endCol < this.col){

                return(endRow == this.row - Math.abs(endRow - this.row) && (endCol == this.col - Math.abs(endCol - this.col)));

            }
            else if(endRow > this.row && endCol > this.col){

                return(endRow == this.row + Math.abs(endRow - this.row) && (endCol == this.col + Math.abs(endCol - this.col)));

            }
            else if(endRow > this.row && endCol < this.col){

                return(endRow == this.row + Math.abs(endRow - this.row) && (endCol == this.col - Math.abs(endCol - this.col)));
            }


        }

       return false;


    }
}
