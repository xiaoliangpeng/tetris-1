package com.example.tetrisapp;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

public class GameBoard implements com.example.admin.tetris.GameBoardMethod {

    int boardHeight = 20;
    int boardWidth = 10;

    private int gameBoard[][] = new int [boardHeight][boardWidth];

    // Get color from coordinate
    public int codeToColor(int x, int y){

        switch(gameBoard[x][y]){

            case 0: // background, no piece
                return Color.BLACK;
            case 1: // blue
                return 0x0000F0;
            case 2: // turquoise
                return 0x00F0F0;
            case 3: // orange
                return 0xF0A000;
            case 4: // purple
                return 0xA000F0;
            case 5: // red
                return 0xF00000;
            case 6: // green
                return 0x00F000;
            case 7: // yellow
                return 0xFFFF00;
            default:
                return -1;
        }
    }

    // Sets all board elements to BLACK
    public void clearBoardGame(){
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                gameBoard[row][col] = Color.BLACK;
            }
        }
    }

    // Set all row elements to BLACK
    public void deleteRow(int rowNumber){
        for(int col = 0; col < 10; col++){
            gameBoard[rowNumber][col] = Color.BLACK;
        }
    }

    // Returns board height
    public int getBoardHeight(){
        return boardHeight;
    }

    // Returns board width
    public int getBoardWidth(){
        return boardWidth;
    }

    // ?????
    public int clearRows(){
        int rowsDeleted = 0;

        // do stuff

        return rowsDeleted;
    }

    // Change color of every square of a piece
    public void placePiece(Piece currentPiece){
        gameBoard[currentPiece.x1][currentPiece.y1] = currentPiece.colorCode;
        gameBoard[currentPiece.x2][currentPiece.y2] = currentPiece.colorCode;
        gameBoard[currentPiece.x3][currentPiece.y3] = currentPiece.colorCode;
        gameBoard[currentPiece.x4][currentPiece.y4] = currentPiece.colorCode;
    }

    // Check if the current piece can move to the desired coordinates (x,y)
    public boolean pieceCanMove(Piece currentPiece, int x, int y){
        if(gameBoard[x][y] != Color.BLACK){
            return false;
        }
        else{
            return true;
        }
    }

    // Check if the current piece can rotate
    public boolean pieceCanRotate(Piece currentPiece){

        int tempX1, tempY1;
        int tempX2, tempY2;
        int tempX3, tempY3;

        // Get desired (x,y) coordinates
        tempX1 = currentPiece.turnAroundX1(currentPiece.y2);
        tempY1 = currentPiece.turnAroundY1(currentPiece.x2);
        tempX2 = currentPiece.turnAroundX1(currentPiece.y3);
        tempY2 = currentPiece.turnAroundY1(currentPiece.x3);
        tempX3 = currentPiece.turnAroundX1(currentPiece.y4);
        tempY3 = currentPiece.turnAroundY1(currentPiece.x4);

        // If desired coordinates have an existing square or are out-of-bounds, return FALSE ...
        if((pieceCanMove(currentPiece, tempX1, tempY1) == false)
           || (tempX1 > 10) || (tempY1 > 20)|| (tempX1 < 0) || (tempY1 < 0)){
            return false;
        }

        else if((pieceCanMove(currentPiece, tempX2, tempY2) == false)
                || (tempX2 > 10) || (tempY2 > 20)|| (tempX2 < 0) || (tempY2 < 0)){
            return false;
        }

        else if((pieceCanMove(currentPiece, tempX3, tempY3) == false)
                || (tempX3 > 10) || (tempY3 > 20)|| (tempX3 < 0) || (tempY3 < 0)){
            return false;
        }

        // ... otherwise, return TRUE
        else{
            return true;
        }
    }

    // Makes current piece's squares BLACK
    public void deletePiece(Piece currentPiece){
        gameBoard[currentPiece.x1][currentPiece.y1] = Color.BLACK;
        gameBoard[currentPiece.x2][currentPiece.y2] = Color.BLACK;
        gameBoard[currentPiece.x3][currentPiece.y3] = Color.BLACK;
        gameBoard[currentPiece.x4][currentPiece.y4] = Color.BLACK;
    }

    // Rotate all squares of a piece
    void rotatePiece(Piece currentPiece){

    }

}
