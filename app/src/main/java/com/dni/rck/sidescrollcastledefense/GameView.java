package com.dni.rck.sidescrollcastledefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.Vector;

/**
 * Created by rck on 5/3/2015.
 */
public class GameView extends View {
    float initialX, initialY;
    Bitmap bArcher, bSiege, bBall, bSword, bMace, bHeavy, bSpear ;
    MainActivity main;
    DrawableObject archer;
    SiegeEngine siege;
    Projectile ball;
    Random rand = new Random();
    Vector<DrawableObject> drawableObjects  = new Vector<>();
    public GameView(Context context) {
        super(context);
        main=(MainActivity)context;
        loadBitmaps();
        archer=new DrawableObject(bArcher,new RectF(0,0,50,50),0,0,1,1);
        ball = new Projectile(bBall,new RectF(0,0,main.screenWidth*.025f,main.screenWidth*.025f),0,0,0,0);
        siege = new SiegeEngine(bSiege,new RectF(0,0,50,50),100,300,ball);
        drawableObjects.add(archer);
        drawableObjects.add(siege);
    }
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        float finishX=-1, finishY=-1;
        switch (eventaction) {

            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                initialY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                finishX = event.getX();
                finishY = event.getY();
                handleSiegeLaunch(finishX,finishY);
                // finger touches the screen
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.print(event.getX());

                finishX = event.getX();
                finishY = event.getY();
                handleSiegeLaunch(finishX,finishY);
                // finger touches the screen

                break;


        }



        return true;
    }

    private void handleSiegeLaunch(float endX, float endY){
            drawableObjects.add(siege.launch(endX-initialX,endY-initialY));
            System.out.println("launch");
    }

    private void loadBitmaps(){
        bArcher= BitmapFactory.decodeResource(main.getResources(),R.drawable.elfsprite);
        bBall= BitmapFactory.decodeResource(main.getResources(),R.drawable.ball);
        bSiege= BitmapFactory.decodeResource(main.getResources(),R.drawable.siege);

    }
    private void drawDrawableObjects(Canvas canvas){
        for (int i = 0; i < drawableObjects.size(); i++){
            drawableObjects.elementAt(i).update(canvas);
        }
    }
    public void onDraw(Canvas canvas){
        drawDrawableObjects(canvas);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
        invalidate();
    }

}
