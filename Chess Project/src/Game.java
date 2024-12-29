import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        //Initializing the board, Scanner, and setting the board to its default stat
        Board myBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",myBoard);
        Scanner input = new Scanner(System.in);

        int turn = 0;//Keeping track of whether it is white or black's turn

        while(!myBoard.isGameOver()){
            //Printing out the current state of the board
            System.out.println(myBoard);
            if(turn % 2 == 0){
                System.out.println("It is black's turn. Enter starting row, starting column, ending row, ending column. No spaces.");

            }
            else{
                System.out.println("It is white's turn. Enter starting row, starting column, ending row, ending column. No spaces.");


            }
            //Letting the user input their move
            String theMove = input.nextLine();
            int startRow = Integer.parseInt(theMove.substring(0,1));

            int startCol = Integer.parseInt(theMove.substring(1,2));

            int endRow = Integer.parseInt(theMove.substring(2,3));

            int endCol = Integer.parseInt(theMove.substring(3));

            //Checking to see if the move is legal, and then moving it if it is
            if(((turn % 2 == 0) && !myBoard.getPiece(startRow, startCol).getIsBlack()) || ((turn % 2 == 1) && myBoard.getPiece(startRow, startCol).getIsBlack())){
                if(myBoard.getPiece(startRow,startCol).isMoveLegal(myBoard, endRow, endCol)){

                    myBoard.movePiece(startRow, startCol, endRow, endCol);
                    //Checking to see if a pawn can be promoted
                    if(myBoard.getPiece(endRow,endCol).getCharacter() == '\u2659' || myBoard.getPiece(endRow,endCol).getCharacter() == '\u265f'){

                        myBoard.getPiece(endRow,endCol).promotePawn(endRow, myBoard.getPiece(endRow,endCol).getIsBlack());

                    }


                }
                else{
                    System.out.println("That move is not legal. Try again");
                    continue;

                }
            }
            else{
                System.out.println("That move is not legal. Try again");
                continue;

            }


           turn++;
        }

         System.out.println("The game is over!");
        //Figuring out which king remains and printing out the winner
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++){
                if(myBoard.getPiece(i,j) == null){
                    continue;
                }
                else if(myBoard.getPiece(i,j).getCharacter() == '♔'){
                    System.out.println("White has won!");
                    break;
                }
                else if(myBoard.getPiece(i,j).getCharacter() == '♚'){
                    System.out.println("Black has won!");
                }

            }
        }


    }
}