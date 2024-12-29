public class King {
    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifyAdjacent(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            return((endRow == this.row + 1 || endRow == this.row - 1)) || (endCol == this.row + 1 || endCol == this.row - 1) || (endRow == this.row + 1 && endCol == this.col+ 1) || (endRow == this.row - 1 && endCol == this.row - 1) || (endRow == this.row - 1 && endCol == this.row + 1) || (endRow == this.row + 1 && endCol == this.col - 1);


        }
        else if(board.verifyAdjacent(this.row,this.col, endRow, endCol) && ((board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack))){
            return((endRow == this.row + 1 || endRow == this.row - 1)) || (endCol == this.row + 1 || endCol == this.row - 1) || (endRow == this.row + 1 && endCol == this.col+ 1) || (endRow == this.row - 1 && endCol == this.row - 1) || (endRow == this.row - 1 && endCol == this.row + 1) || (endRow == this.row + 1 && endCol == this.col - 1);

        }

        return false;
    }
}
