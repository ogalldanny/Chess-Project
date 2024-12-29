public class Knight {

    //Instance Variables
    private int row;
    private int col;
    private boolean isBlack;

    //Constructor for creating the Knight pieces
    public Knight(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    //This method verifies whether the intended movement of the Rook pieces is legal
    //Given the current state of the board
    public boolean isMoveLegal(Board board, int endRow, int endCol){


        if(board.getPiece(endRow, endCol) == null){
            //These two if statements are for verifying movement to an empty space
            if(endCol < this.col){
                return((endCol == this.col - 2) && (endRow == this.row - 1)) || ((endCol == this.col - 1) && (endRow == this.row - 2)) || ((endCol == this.col - 1) && (endRow == this.row + 2)) || ((endCol == this.col - 2) && (endRow == this.row + 1));

            }
            else if(endCol > this.col){
                return((endCol == this.col + 1) && (endRow == this.row + 2)) || ((endCol == this.col + 1) &&(endRow == this.row - 2)) || ((endCol == this.col + 2) && (endRow == this.row + 1)) || ((endCol == this.col + 2) && (endRow == this.row - 1));
            }


        }

        else if(board.getPiece(endRow, endCol) != null && board.getPiece(endRow,endCol).getIsBlack() != this.isBlack){
            //These two if statements are for capturing an opposing piece
            if(endCol < this.col){
                return((endCol == this.col - 2) && (endRow == this.row - 1)) || ((endCol == this.col - 1) && (endRow == this.row - 2)) || ((endCol == this.col - 1) && (endRow == this.row + 2)) || ((endCol == this.col - 2) && (endRow == this.row + 1));

            }
            else if(endCol > this.col){
                return((endCol == this.col + 1) && (endRow == this.row + 2)) || ((endCol == this.col + 1) &&(endRow == this.row - 2)) || ((endCol == this.col + 2) && (endRow == this.row + 1)) || ((endCol == this.col + 2) && (endRow == this.row - 1));
            }

        }

        

        return false;
    }


}
