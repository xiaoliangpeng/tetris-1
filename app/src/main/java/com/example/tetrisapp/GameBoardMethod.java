package com.example.admin.tetris;

public interface GameBoardMethod {
    /**
     * Clears the entire gameBoardArray with values of 0
     */
    void clearBoardGame();

    /**
     * accepts rowNumber and deletes it by setting all values to 0
     * @param rowNumber
     */
    void deleteRow(int rowNumber);

    /**
     * Returns board width
     * @return
     */
    int getBoardWidth();

    /**
     *
     * @return
     */
    int getBoardHeight();

    /**
     * Very complex method
     * Clears alls rows and returns how many rows were deleted
     * @return
     */
    int clearAndShiftRows();

    /**
     * It takes a current piece's colorCode and assigns it to each of
     * the x y coordinates for that current piece. E.g. gameBoard[currentPiece.x1][currentPiece.y1] = currentPiece.colorCode;
     * @param currentPiece
     */
    void placePiece(Piece currentPiece);

    /**
     * Looks at a potential xy coordinate for a current piece.
     * IF such a step is acceptable, we return true.
     * @param currentPiece
     * @param x
     * @param y
     * @return
     */
    boolean pieceCanMove(Piece currentPiece, int x, int y);


    /**
     * Very complex
     *  Depends on {@link #canMoveLeft()}{@link #canMoveRight()} {@link #canMoveDown()}
     * IF such a step is acceptable, we return true. Else false.
     * @param currentPiece
     * @return
     */
    boolean pieceCanRotate(Piece currentPiece);
    /**
     * Makes that current peices color code 0 for the 4 xy cooridnates.
     * @param currentPiece
     */
    void deletePiece(Piece currentPiece);
    /**
     * Depends on {@link #placePiece()}
     * checks to see if a piece can rotate and then rotates it.
     * @param currentPiece
     */
    void rotatePiece(Piece currentPiece);
	
	
	boolean canMoveLeft(Piece currentPiece, int x, int y); 
	boolean canMoveRight(Piece currentPiece, int x, int y); 
	boolean canMoveDown(Piece currentPiece, int x, int y);

    /**
     * if {@link #canMoveLeft(Piece currentPiece, int x, int y)}then {@link #movePiece(Piece currentPiece, int x, int y}
     * where x = 0 and y = -1
     * @param currentPiece
     */
    void moveLeft(Piece currentPiece);

    /**
     * if {@link #canMoveRight(Piece currentPiece, int x, int y)}then {@link #movePiece(Piece currentPiece, int x, int y}
     * where x = 0 and y = 1
     * @param currentPiece
     */
    void moveRight(Piece currentPiece);

    /**
     * if {@link #canMoveDown(Piece currentPiece, int x, int y)}then {@link #movePiece(Piece currentPiece, int x, int y}
     * where x = 1 and y = 0
     * @param currentPiece
     */
    void moveDown(Piece currentPiece);

    /**
     * deletePiece, then currentPiece.move(x,y), then placePiece(currentPiece)
     * @param currentPiece
     * @param x
     * @param y
     */
    void movePiece(Piece currentPiece, int x, int y);

}
