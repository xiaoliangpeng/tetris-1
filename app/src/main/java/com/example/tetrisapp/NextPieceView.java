package com.example.tetrisapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.example.tetrisapp.GameBoard;
import com.example.tetrisapp.Piece;
import com.example.tetrisapp.R;

import java.util.ArrayList;
import java.util.Random;

/*
paint next Piece on Screen
 */

public class NextPieceView extends View {

    private GameBoard gameBoard;
    private ArrayList<Piece> pieceList;

    private Bitmap oPiece = BitmapFactory.decodeResource(getResources(), R.drawable.opiece);
    private Bitmap tPiece = BitmapFactory.decodeResource(getResources(), R.drawable.tpiece);
    private Bitmap zPiece = BitmapFactory.decodeResource(getResources(), R.drawable.zpiece);
    private Bitmap sPiece = BitmapFactory.decodeResource(getResources(), R.drawable.spiece);
    private Bitmap jPiece = BitmapFactory.decodeResource(getResources(), R.drawable.jpiece);
    private Bitmap lPiece = BitmapFactory.decodeResource(getResources(), R.drawable.lpiece);
    private Bitmap iPiece = BitmapFactory.decodeResource(getResources(), R.drawable.ipiece);

    public NextPieceView(Context context, GameBoard gameBoard) {
        super(context);
        this.gameBoard = gameBoard;
        pieceList = gameBoard.getPieceList();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        if (pieceList.size() > 0) {
            Piece s = gameBoard.getNextPiece();

            if (s.colorCode == 1) {
               canvas.drawBitmap(oPiece, 0, 0, p);
            }

            if (s.colorCode == 2) {
                canvas.drawBitmap(zPiece, 0, 0, p);
            }

            if (s.colorCode == 3) {
                canvas.drawBitmap(iPiece, 0, 0, p);
            }

            if (s.colorCode == 4) {
               canvas.drawBitmap(tPiece, 0, 0, p);
            }

            if (s.colorCode == 5) {
                canvas.drawBitmap(sPiece, 0, 0, p);
            }

            if (s.colorCode == 6) {
                canvas.drawBitmap(jPiece, 0, 0, p);
            }

            if (s.colorCode == 7) {
                canvas.drawBitmap(lPiece, 0, 0, p);
            }

        }
    }
}
