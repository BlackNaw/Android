package com.example.mary.bolitaenmovimiento;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

/**
 * Surface que pinta el fondo y la bola moviéndose.
 */
public class BallPainter extends SurfaceView {
    Bitmap bola;
    float x = 0;
    float y = 0;

    public BallPainter(Context context) {
        super(context);
        //Fondo
        setBackgroundResource(R.drawable.sakuratree);
        bola = BitmapFactory.decodeResource(getResources(), R.drawable.sakura);
    }

    /**
     * Asigna el nuevo valor de coordenadas para mover la bola.
     * @param x nueva
     * @param y nueva
     */
    public void moverCoordenadas(float x, float y) {
        this.x -= x;
        this.y += y;

        if (this.x +bola.getWidth()> getWidth()) {
            this.x = getWidth()-bola.getWidth();
        } else if (this.x < 0) {
            this.x = 0;
        }
        if (this.y +bola.getHeight()> getHeight()) {
            this.y = getHeight()-bola.getHeight();
        } else if (this.y < 0) {
            this.y = 0;
        }
    }

    @Override
    protected void onDraw(Canvas lienzo) {
        super.onDraw(lienzo);
        //Pinta la bola en las coordenadas indicadas
        lienzo.drawBitmap(bola, x, y, null);
    }

}
