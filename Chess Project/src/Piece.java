import java.util.Scanner;

public class Piece {
    // Create Instance Variables
   private char character;
   private int row;
   private int col;
   private boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {

        return isBlack;

    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {

        if(isBlack && row == 0){

            Scanner input = new Scanner(System.in);
            System.out.println("Your pawn can be promoted! What would you like to change it to? ");
            String newPiece = input.nextLine();

            if(newPiece.toLowerCase().equals("queen")){
                this.character = '♛';

            }
            else if(newPiece.toLowerCase().equals("bishop")){
                this.character = '♝';
            }
            else if(newPiece.toLowerCase().equals("rook")){

                this.character = '♜';
            }
            else if(newPiece.toLowerCase().equals("knight")){
                this.character = '♞';
            }



        }
        else if(!isBlack && row == 7){
            Scanner input = new Scanner(System.in);
            System.out.println("Your pawn can be promoted! What would you like to change it to? ");
            String newPiece = input.nextLine();

            if(newPiece.toLowerCase().equals("queen")){
                this.character = '♕';

            }
            else if(newPiece.toLowerCase().equals("bishop")){
                this.character = '♗';
            }
            else if(newPiece.toLowerCase().equals("rook")){

                this.character = '♖';
            }
            else if(newPiece.toLowerCase().equals("knight")){
                this.character = '♘';
            }


        }


    }

    //Returns the character of the piece
    public char getCharacter(){

        return character;
    }


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {

        return "This piece is a " + character + " it is at row " + row + " and column " + col + " and it is " + isBlack;

    }


}
