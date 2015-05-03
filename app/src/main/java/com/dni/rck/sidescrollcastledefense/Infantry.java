package com.dni.rck.sidescrollcastledefense;

import android.graphics.Bitmap;
import android.graphics.RectF;

/**
 * Created by rck on 5/3/2015.
 */
enum InfantryType{SWORDSMAN, SPEARMAN, MACEMAN, HEAVYARMOR }
public class Infantry extends DrawableObject {

    public Infantry(Bitmap bitmap, RectF bounds, float xPos, float yPos) {
        super(bitmap, bounds, xPos, yPos);
    }
}
