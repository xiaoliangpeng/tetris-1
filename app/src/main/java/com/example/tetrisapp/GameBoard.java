package com.example.tetrisapp;

import android.graphics.Color;

public class GameBoard {

    int boardHeight = 20;
    int boardWidth = 10;

    private int gameBoard[][] = new int [boardHeight][boardWidth];

    public int codeToColor(int x, int y){

        switch(gameBoard[x][y]){

            case 0: // background, no piece
                return Color.BLACK;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            case 4:
                return Color.RED;
            case 5:
                return Color.RED;
            case 6:
                return Color.RED;
            case 7:
                return Color.RED;
            default:
                return -1;
        }
    }

    public
}
