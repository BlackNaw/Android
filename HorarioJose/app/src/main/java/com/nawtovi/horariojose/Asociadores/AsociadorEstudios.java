package com.nawtovi.horariojose.Asociadores;

import android.app.Activity;
import android.widget.ImageView;

import com.example.imagenespasando.R;

import java.util.Vector;

public class AsociadorEstudios {
	Vector<ImageView> imagenes = new Vector<ImageView>();

	public Vector<ImageView> asociaEstudios(Activity actividad) {
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView1));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView2));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView3));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView4));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView5));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView6));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView7));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView8));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView9));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView10));
		imagenes.add((ImageView) actividad.findViewById(R.id.imageView11));
		return imagenes;
	}

 }

