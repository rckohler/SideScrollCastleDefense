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
    public DrawableObject(RectF bounds,float xPos, float yPos){
        this.bounds=bounds;
        this.xPos=xPos;
        this.yPos=yPos;
        xVelocity=0;
        yVelocity=0;
    }
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
    public float distanceFrom(DrawableObject other){
        return (float) Math.hypot(other.xPos-xPos,other.yPos-yPos);
    }

    private void setBounds(){
       float width=bounds.width();
       float height=bounds.height();
       bounds.set(xPos-width*.5f, yPos-height*.5f, xPos+width*.5f,yPos+height*.5f);
    }
    public boolean collidedWith(DrawableObject other){
        boolean ret = false;
            float leftWall = other.xPos-other.bounds.width()*.5f;
            float rightWall = other.xPos+other.bounds.width()*.5f;
            float topWall = other.yPos-other.bounds.height()*.5f;
            float bottomWall = other.yPos+other.bounds.height()*.5f;
            if (bounds.contains(leftWall,topWall)||bounds.contains(leftWall,bottomWall)||bounds.contains(rightWall,topWall)||bounds.contains(rightWall,bottomWall))
                ret = true;

        return ret;
    }

    private void drawSelf(Canvas canvas){
        canvas.drawBitmap(bitmap,null,bounds,null);
    }
    public void update(Canvas canvas){
        move();
        setBounds();
        drawSelf(canvas);
    }
}
