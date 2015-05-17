package com.dni.rck.sidescrollcastledefense;

import android.graphics.Bitmap;
import android.graphics.RectF;

/**
 * Created by rck on 5/3/2015.
 */
public class SiegeEngine extends DrawableObject {
    float maxAngle, minAngle, maxPull, minPull, velocityToPull=.05f;
    float launchFromX, launchFromY;
    Projectile prototypeProjectile;

    public SiegeEngine(Bitmap bitmap, RectF bounds, float xPos, float yPos, Projectile projectile) {
        super(bitmap, bounds, xPos, yPos);
        prototypeProjectile = projectile;
    }
    private float distance(float x, float y){
        return (float)(Math.pow((x*x+y*y),.5));
    }
    public Projectile launch(float dx, float dy){

        Projectile projectile = null;
        float d = distance(dx,dy); //pull
        float v = velocityToPull*d;
        float xComponent = dx/d;
        float yComponent = dy/d;
        float xVelocity = xComponent*v;
        float yVelocity = yComponent*v;
        float localLaunchFromX = launchFromX;
        if (xVelocity<0) localLaunchFromX= launchFromX*-1;
        projectile = new Projectile(prototypeProjectile.bitmap,prototypeProjectile.bounds,xPos+localLaunchFromX,yPos+launchFromY,xVelocity,yVelocity);
        return projectile;
    }
}
