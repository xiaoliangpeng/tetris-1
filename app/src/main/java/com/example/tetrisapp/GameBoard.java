package com.example.tetrisapp;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class GameBoard implements GameBoardMethod {

    // Declare game board
    int boardHeight = 20;
    int boardWidth = 10;
    private int gameBoard[][] = new int [boardHeight][boardWidth];


	private ArrayList<Piece> pieceList = new ArrayList<Piece>();
    private  final int numOfPieces = 7;
    Random random = new Random();

    public GameBoard() {
        pieceList.add(new Piece(random.nextInt(numOfPieces)+1));
        pieceList.add(new Piece(random.nextInt(numOfPieces)+1));
     }

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


    public  ArrayList<Piece> getPieceList(){
        return pieceList;
    }

    public Piece getCurrentPiece()  {
              return pieceList.get(pieceList.size() - 2);
     }

    public Piece getNextPiece() {
         return pieceList.get(pieceList.size()-1);
    }
	
    // Sets all board elements to BLACK
    public void clearBoardGame(){
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                gameBoard[row][col] = 0;
            }
        }
    }

    // Set all row elements to BLACK
    public void deleteRow(int rowNumber){
        for(int col = 0; col < 10; col++){
            gameBoard[rowNumber][col] = 0;
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

    // Clear and shift completed rows
    public int clearAndShiftRows(){
        int rowsDeleted = 0;
        int deletedRowIndex;
        ArrayList<Integer> arrayList = new ArrayList<>(); // Keep track of deletedRowIndex history

        for(int row = 0; row < boardHeight; row++){
            for(int col = boardWidth-1; col >= 0; col--){

                // If board element is BLACK, exit row
                if(gameBoard[row][col] == 0){
                    break;
                }

                // If we're at the left-most column, delete row, add that row to arrayList
                if(col == 0){
                    deletedRowIndex = row;
                    arrayList.add(row);
                    rowsDeleted++;
                    deleteRow(row);
                }
            }
        }

        // Save copy of rows that were not deleted
        if(rowsDeleted > 0){
            int highestRow = Collections.min(arrayList);
            int gameBoardCopy[][] = new int [highestRow][boardWidth];

            // Create board copy to preserve untouched rows
            for(int row = 0; row < gameBoardCopy.length; row++){
                for(int col = 0; col < gameBoardCopy[1].length; col++){
                    gameBoardCopy[row][col] = gameBoard[row][col];
                }
            }

            // Put unaffected rows from board copy back into original board
            for(int row = 0; row < gameBoardCopy.length; row++){
                for(int col = 0; col < gameBoardCopy[1].length; col++){
                    gameBoard[row+rowsDeleted][col] = gameBoardCopy[row][col];
                }
            }
        }

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
         int tmp =0;
        /*
        copy piece coordinates
         */
        Point p1 = new Point(currentPiece.x1, currentPiece.y1);
        Point p2 = new Point(currentPiece.x2, currentPiece.y2);
        Point p3 = new Point(currentPiece.x3, currentPiece.y3);
        Point p4 = new Point(currentPiece.x4, currentPiece.y4);

        Point tmp1 = new Point(currentPiece.x1+x, currentPiece.y1+y);
        Point tmp2 = new Point(currentPiece.x2+x, currentPiece.y2+y);
        Point tmp3 = new Point(currentPiece.x3+x, currentPiece.y3+y);
        Point tmp4 = new Point(currentPiece.x4+x, currentPiece.y4+y);

        ArrayList<Point> tmpPieceCoordinates = new ArrayList<Point>();

        tmpPieceCoordinates.addAll(Arrays.asList(tmp1, tmp2, tmp3, tmp4));


        for(Point p : tmpPieceCoordinates ) {

            if(p.x< boardHeight && p.y>=0 && p.y< boardWidth && gameBoard[p.x][p.y]==0) {
                tmp++;
            }

            else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4)) {
                tmp++;
            }
        }

        return tmp == 4; 
    }
	
	private boolean canMoveLeft(Piece currentPiece) {
        if(pieceCanMove(currentPiece, 0, -1)==true) {
            return true;
        }
        return false;
    }

    private boolean canMoveRight(Piece currentPiece){
        if(pieceCanMove(currentPiece, 0,1) == true) {
            return true;
        }
        return false;
    }

    public boolean canMoveDown(Piece currentPiece) {
        if(pieceCanMove(currentPiece, 1,0)==true) {
            return true;
        }
        return false;
    }

	public void fastDrop(Piece currentPiece) {
        deletePiece(currentPiece);

        while(canMoveDown(currentPiece)==true) {
            moveDown(currentPiece);
         }
        placePiece(currentPiece);
    }
	
    // Check if the current piece can rotate
    public boolean pieceCanRotate(Piece currentPiece){

        try {
            ArrayList<Point> tmpPieceCoord = new ArrayList<>();
            Piece tmpPiece = (Piece) currentPiece.clone();

            int tmpCount = 0;

            Point p1 = new Point(currentPiece.x1, currentPiece.y1);
            Point p2 = new Point(currentPiece.x2, currentPiece.y2);
            Point p3 = new Point(currentPiece.x3, currentPiece.y3);
            Point p4 = new Point(currentPiece.x4, currentPiece.y4);

            tmpPiece.turnPiece();

            Point tmpp1 = new Point(tmpPiece.x1, tmpPiece.y1);
            Point tmpp2 = new Point(tmpPiece.x2, tmpPiece.y2);
            Point tmpp3 = new Point(tmpPiece.x3, tmpPiece.y3);
            Point tmpp4 = new Point(tmpPiece.x4, tmpPiece.y4);

            tmpPieceCoord.addAll(Arrays.asList(tmpp1, tmpp2, tmpp3, tmpp4));

            for(Point p:tmpPieceCoord){

                if(p.x < boardHeight && p.x >= 0 && p.y >= 0 && p.y < boardWidth && gameBoard[p.x][p.y] == 0){
                    tmpCount++;
                }

                else if(p.equals(p1) || p.equals(p2) || p.equals(p3) || p.equals(p4)){
                    tmpCount++;
                }
            }

            return (tmpCount == 4);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Makes current piece's squares BLACK
    public void deletePiece(Piece currentPiece){
        gameBoard[currentPiece.x1][currentPiece.y1] = 0;
        gameBoard[currentPiece.x2][currentPiece.y2] = 0;
        gameBoard[currentPiece.x3][currentPiece.y3] = 0;
        gameBoard[currentPiece.x4][currentPiece.y4] = 0;
    }

    // Rotate all squares of a piece
    public void rotatePiece(Piece currentPiece){

        if((pieceCanRotate(currentPiece)) && (currentPiece.colorCode != 1)){
            deletePiece(currentPiece);
            currentPiece.turnPiece();
        }

        placePiece(currentPiece);
    }

}
