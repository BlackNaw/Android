package com.nawtovi.simondice.Modelo;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import com.nawtovi.simondice.R;

/**
 * Created by jose on 15/11/2016.
 */


public class Touch {

    private float radius;
    private float centerX;
    private float centerY;
    private Activity activity;

    public Touch(Context c) {
        this.activity=(Activity)c;
        //Parametros necesarios para el circulo
        GridLayout gridLayout = (GridLayout) activity.findViewById(R.id.gridLayout);
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.relativeLayout);

        centerX = gridLayout.getLeft() + metrics.widthPixels - relativeLayout.getWidth() + (gridLayout.getWidth() / 2);
        centerY = gridLayout.getTop() + metrics.heightPixels - relativeLayout.getHeight() + (gridLayout.getHeight() / 2);
        radius = (gridLayout.getHeight() <= gridLayout.getWidth()) ? gridLayout.getHeight() / 2 : gridLayout.getWidth() / 2;
    }

    private double isTouching(float currentX, float currentY) {
        return Math.sqrt(Math.pow(currentX - centerX, 2.0)+Math.pow(currentY - centerY, 2.0));
    }

    public int wichIsTouching(MyButton boton, MotionEvent event,View v){
        double masterRadius;
        int elemento = 0;
        if ((masterRadius = isTouching(event.getRawX(), event.getRawY())) < radius) {
            if (masterRadius < boton.getImageView().getWidth() / 2&&boton.getImageView().isEnabled()) {
                elemento = 5;
            } else if (masterRadius > boton.getImageView().getWidth() / 2) {
                elemento = Integer.valueOf((v.getResources().getResourceEntryName(v.getId())).substring((v.getResources().getResourceEntryName(v.getId())).length() - 1));
            }
        }
        return (elemento-1);
    }


}
