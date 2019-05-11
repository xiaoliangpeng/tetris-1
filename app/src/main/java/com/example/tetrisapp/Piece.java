package com.example.tetrisapp;

/**
 * 4 points make up a piece
 */
public class Piece implements Cloneable {

    public int x1, y1;
    public int x2, y2;
    public int x3, y3;
    public int x4, y4;
    public int colorCode;
    public Piece piece;

    public Piece(Piece piece){
        this.piece = piece;

        this.x1 = piece.x1;
        this.x2 = piece.x2;
        this.x3 = piece.x3;
        this.x4 = piece.x4;

        this.y1 = piece.y1;
        this.y2 = piece.y2;
        this.y3 = piece.y3;
        this.y4 = piece.y4;
    }

    public Piece(int colorCode){

        switch(colorCode){
            case 1: // square
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 7;
                x4 = 1; y4 = 8;
                this.colorCode = colorCode;
                break;
            case 2: // Z-piece
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 8;
                x4 = 1; y4 = 9;
                this.colorCode = colorCode;
                break;
            case 3: // I-piece
                x1 = 0; y1 = 6;
                x2 = 0; y2 = 7;
                x3 = 0; y3 = 8;
                x4 = 0; y4 = 9;
                this.colorCode = colorCode;
                break;
            case 4: // T-piece
                x1 = 0; y1 = 8;
                x2 = 1; y2 = 7;
                x3 = 1; y3 = 8;
                x4 = 2; y4 = 8;
                this.colorCode = colorCode;
                break;
            case 5: // S-piece
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 6;
                x4 = 1; y4 = 7;
                this.colorCode = colorCode;
                break;
            case 6: // J-piece
                x1 = 2; y1 = 7;
                x2 = 2; y2 = 8;
                x3 = 1; y3 = 8;
                x4 = 0; y4 = 8;
                this.colorCode = colorCode;
                break;
            case 7: // L-piece
                x1 = 0; y1 = 7;
                x2 = 0; y2 = 8;
                x3 = 1; y3 = 8;
                x4 = 2; y4 = 8;
                this.colorCode = colorCode;
                break;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void move(int x, int y){
        x1 = x1 + x;
        y1 = y1 + y;

        x2 = x2 + x;
        y2 = y2 + y;

        x3 = x3 + x;
        y3 = y3 + y;

        x4 = x4 + x;
        y4 = y4 + y;
    }

    public int turnAroundX1(int y){
        return x1 + y - y1;
    }

    public int turnAroundY1(int x){
        return y1 + x - x1;
    }

    public void turnPiece(){
        int tempX1, tempY1;
        int tempX2, tempY2;
        int tempX3, tempY3;

        tempX1 = turnAroundX1(y2);
        tempY1 = turnAroundY1(x2);
        x2 = tempX1;
        y2 = tempY1;
        tempX2 = turnAroundX1(y3);
        tempY2 = turnAroundY1(x3);
        x3 = tempX2;
        y3 = tempY2;
        tempX3 = turnAroundX1(y4);
        tempY3 = turnAroundY1(x4);
        x4 = tempX3;
        y4 = tempY3;

    }

    public int getMinXCoord(int x1, int x2, int x3, int x4){
        return Math.min(Math.min(x1,x2), Math.min(x3, x4));
    }
}
