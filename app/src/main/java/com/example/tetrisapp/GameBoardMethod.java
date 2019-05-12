package com.example.tetrisapp;

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
     *  Depends on {@link this.canMoveLeft(), this.canMoveRight(), this.canMoveDown()}
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
     * Depends on {@link this.placePiece()}
     * checks to see if a piece can rotate and then rotates it.
     * @param currentPiece
     */
    void rotatePiece(Piece currentPiece);

}
