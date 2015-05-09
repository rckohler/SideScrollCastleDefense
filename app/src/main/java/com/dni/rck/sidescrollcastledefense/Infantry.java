package com.dni.rck.sidescrollcastledefense;

import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.Random;
/**I made a note in order to push data, KK
/**
 * Created by rck on 5/3/2015.
 */
enum BattleState{COMBAT,UNDERORDERS,PLIABLE}
enum InfantryType{SWORDSMAN, SPEARMAN, MACEMAN, HEAVYARMOR }
public class Infantry extends DrawableObject {
    InfantryType infantryType;
    boolean attackedThisTurn;
    boolean pliable;
    boolean dead;
    int hp, range, armor, speed, damage, attack;
    Random rand;
    Infantry enemy;
    BattleState battleState;
    public Infantry(RectF bounds, float xPos, float yPos, InfantryType infantryType, GameView gameView) {
        super(bounds, xPos, yPos);
        battleState = BattleState.PLIABLE;
        this.rand = gameView.rand;
        this.infantryType = infantryType;
        switch(infantryType){

            case SWORDSMAN:
                bitmap = gameView.bSword;
                hp = gameView.rand.nextInt(8)+10;
                damage =3+rand.nextInt(4);
                range = 1;
                armor = 3+rand.nextInt(2);
                speed = 6+rand.nextInt(3);
                break;
            case SPEARMAN:

                break;
            case MACEMAN:
                break;
            case HEAVYARMOR:
                break;
        }
        range = (int)(bounds.width()*.1*range);

    }
    public void combatOther(){
        if (enemy.range>range){
            if (distanceFrom(enemy)<enemy.range){
                swing();
            }
            else
                intercept(enemy);
        }
        else // other's range is less than or equal to my own
                swing();
    }
    private void intercept(Infantry target){
            float a,c,d,e,g,h,i,j,t=-1,t1,t2;

            float A,B,C; //quadratic
            //givens
            a = xPos;
            c = target.xPos;
            d = target.xVelocity;
            e = yPos;
            g = target.yPos;
            h = target.yVelocity;
            //calculated
            i = c-a;
            j = g-e;

            A = d*d+h*h-speed*speed;
            B = 2*i*d+2*j*h;
            C = i*i + j*j;

            float u = B*B-4*A*C;
            if (u < 0)
                ;//setDestination((int)player.rx, (int)player.ry);
                // no intercept move toward;
            else{
                u = (float) Math.pow(u, .5);
                t1 = (-B+u)/(2*A);
                t2 = (-B-u)/(2*A);
                if (t1>0 && t2>0)//2 valid answers
                {
                    if (t1<t2)t = t1; else t = t2;
                }
                if (t1<0 && t2 >0)
                    t = t2;
                if (t1>0 && t2<0)
                    t = t1;

                if (t == t1 || t == t2){
                    xVelocity = (i+d*t)/t;
                    yVelocity = (j + h*t)/t;
                }


            }

    }
    private void swing(){
        int attackValue = rand.nextInt(attack);
        int defend = rand.nextInt(enemy.armor);
        int attackDamage = rand.nextInt(damage);

        if(attackValue>defend)
        {
            enemy.hp-=attackDamage;
            if (enemy.hp < 1)
                enemy.die();
        }
    }
    public void die(){
       // some code that enters a death animation and fun stuff like that.
    }

    public void slaughter(Archer other){

    }

}
