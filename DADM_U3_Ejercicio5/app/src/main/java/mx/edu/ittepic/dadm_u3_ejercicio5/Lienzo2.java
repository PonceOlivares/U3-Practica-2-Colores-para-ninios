package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    String mensaje, mensaje2;
    int cont=0;
    Imagen2 morado;
    Imagen2 letrasMoradas;
    Imagen2 azul;
    Imagen2 letrasAzul;
    Imagen2 amarillo;
    Imagen2 letrasAmarillas;
    Imagen2 puntero;



    public Lienzo2(Context context) {
        super(context);
        mensaje = "Arrastre el texto al color que corresponde";
        mensaje2= "";


        morado = new Imagen2(R.drawable.morado, 100, 100, this);
        letrasMoradas = new Imagen2(R.drawable.purpura, 500, 900, this);

        amarillo = new Imagen2(R.drawable.amarrillo, 100, 500, this);
        letrasAmarillas = new Imagen2(R.drawable.yellow, 500, 200, this);

        azul = new Imagen2(R.drawable.azul, 100, 900, this);
        letrasAzul = new Imagen2(R.drawable.blue, 500, 600, this);


        puntero = null;

    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        p.setTextSize(30);
        p.setColor(Color.GRAY);
        canvas.drawText(mensaje, 50, 50, p);
        //canvas.drawColor(Color.CYAN);
        //canvas.draw
        amarillo.pintar(canvas, p);
        letrasAmarillas.pintar(canvas, p);

        morado.pintar(canvas, p);
        letrasMoradas.pintar(canvas, p);

        azul.pintar(canvas, p);
        letrasAzul.pintar(canvas, p);

        p.setTextSize(150);
        p.setColor(Color.RED);
        canvas.drawText(mensaje2, 50, 800, p);


    }


    public boolean onTouchEvent(MotionEvent e) {

        float xp = e.getX(), yp = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Entra si e.getAction esta presionado


                if (letrasMoradas.estEnArea(xp, yp)) {
                    puntero = letrasMoradas;
                }
                if (letrasAzul.estEnArea(xp, yp)) {
                    puntero = letrasAzul;
                }


                if (letrasAmarillas.estEnArea(xp, yp)) {
                    puntero = letrasAmarillas;
                }


                break;

            case MotionEvent.ACTION_MOVE: //no es eficiente el if en mover
                if (puntero != null) {
                    puntero.mover(xp, yp);


                    if (puntero.colision(morado) && puntero == letrasMoradas) {
                        mensaje = "Purple ---  Morado ";
                        morado.hacerVisible(false);
                        letrasMoradas.hacerVisible(false);
                        cont ++;
                    }
                }
                if (puntero != null) {
                    puntero.mover(xp, yp);
                    if (puntero.colision(amarillo) && puntero == letrasAmarillas) {

                        mensaje = "Yellow ---  Amarillo";
                        amarillo.hacerVisible(false);
                        letrasAmarillas.hacerVisible(false);
                        cont ++;
                    }
                }
                if (puntero != null) {
                    puntero.mover(xp, yp);
                    if (puntero.colision(azul) && puntero == letrasAzul) {
                        mensaje = "Blue ---  Azul";
                        azul.hacerVisible(false);
                        letrasAzul.hacerVisible(false);
                        cont ++;
                    }
                }
                if (cont==3){
                    mensaje2 ="CORRECTO!!";
                }


                break;


            case MotionEvent.ACTION_UP:
                puntero = null;
                break;

        }
        invalidate();//manda llamar a onDraw
        return true;
    }


}