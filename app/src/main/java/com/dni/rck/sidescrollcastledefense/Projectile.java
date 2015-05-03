package com.dni.rck.sidescrollcastledefense;

import android.graphics.Bitmap;
import android.graphics.RectF;

/**
 * Created by rck on 5/3/2015.
 */
public class Projectile  extends DrawableObject {
    public Projectile(Bitmap bitmap, RectF bounds, float xPos, float yPos, float xVelocity, float yVelocity) {
        super(bitmap, bounds, xPos, yPos, xVelocity, yVelocity);
    }
}
