package com.dni.rck.sidescrollcastledefense;

import android.graphics.RectF;

/**
 * Created by rck on 5/9/2015.
 */
public class Archer extends DrawableObject {
    enum ArcherType {longBow, shortBow, lightCrossbow, heavyCrossBow}
    int reloadRate, velocity, damage;
    boolean loaded;
    ArcherType archerType;
    public Archer(RectF bounds, float xPos, float yPos, ArcherType archerType, GameView gameView) {
        super(bounds, xPos, yPos);
        this.archerType = archerType;
        switch(archerType){
            case longBow:
                break;
            case shortBow:
                break;
            case lightCrossbow:
                break;
            case heavyCrossBow:
                break;
        }
    }
    public void fire(float pull, float radians){

    }
}
