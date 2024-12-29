public class Bishop {
    //Instance Variables
    private int row;
    private int col;
    private boolean isBlack;


    //Constructor for creating the Bishop pieces
    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;

    }

    //This method verifies whether the intended movement of the Rook pieces is legal
    //Given the current state of the board
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //This first if statement verifies that the space is free and there is nothing in the path of the Bishop
        if(board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow,endCol) == null){


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

            //These are the same if statements from the first half of the method
            //They each verify movement in a different diagonal direction
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
