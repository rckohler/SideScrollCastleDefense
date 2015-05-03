package com.dni.rck.sidescrollcastledefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by rck on 5/3/2015.
 */
public class GameView extends View {
    Bitmap bArcher;
    MainActivity main;
    DrawableObject archer;
    public GameView(Context context) {
        super(context);
        main=(MainActivity)context;
        loadBitmaps();
        archer=new DrawableObject(bArcher,new RectF(0,0,50,50),0,0);
    }

    private void loadBitmaps(){
        bArcher= BitmapFactory.decodeResource(main.getResources(),R.drawable.elfsprite);
    }
    public void onDraw(Canvas canvas){


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
        invalidate();
    }

}
