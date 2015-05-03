package com.dni.rck.sidescrollcastledefense;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by rck on 5/3/2015.
 */
public class DrawableObject {
    Bitmap bitmap;
    RectF bounds;
    float xPos, yPos, xVelocity, yVelocity;
    public DrawableObject(Bitmap bitmap, RectF bounds,float xPos, float yPos){
        this.bitmap=bitmap;
        this.bounds=bounds;
        this.xPos=xPos;
        this.yPos=yPos;
        xVelocity=0;
        yVelocity=0;
    }
    public DrawableObject(Bitmap bitmap, RectF bounds,float xPos, float yPos, float xVelocity, float yVelocity){
        this.bitmap=bitmap;
        this.bounds=bounds;
        this.xPos=xPos;
        this.yPos=yPos;
        this.xVelocity=xVelocity;
        this.yVelocity=yVelocity;
    }
    private void move(){
        xPos+=xVelocity;
        yPos+=yVelocity;
    }

    
    private void drawSelf(Canvas canvas){
        canvas.drawBitmap(bitmap,null,bounds,null);
    }
    public void update(Canvas canvas){
        move();
        drawSelf(canvas);
    }
}
