package com.nawtovi.horariojose.Comportamientos;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nawtovi.horariojose.com.example.imagenespasando.CursoCuatroEso;
import com.nawtovi.horariojose.com.example.imagenespasando.CursoDosEso;
import com.nawtovi.horariojose.com.example.imagenespasando.CursoTresEso;
import com.nawtovi.horariojose.com.example.imagenespasando.CursoUnoEso;

import java.util.Vector;

public class ComportamientoEstudios {
	Vector<ImageView> imagenes;
	
	public ComportamientoEstudios(Vector<ImageView> imagenes) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		this.imagenes=imagenes;
	}

	public void conductaEstudios(Vector<ImageView> imagenes) {		
		for (int i = 0; i < imagenes.size(); i++) {
			imagenes.get(i).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Ap�ndice de m�todo generado autom�ticamente
					procesaToqueEstudio(v);
				}
			});
		}
	}
	
	public void procesaToqueEstudio(View v) {
		Log.d("imagen", "la imagen " + v.getId());
		//Compruebo que estudio y lanzo la activity correpondiente
		//Esto seria un hallazgo si el contexto es la activity main
		int valor=seleccionaEstudio(v);
		Class lanzar=obtenerClase(valor);		
		Intent i=new Intent(v.getContext(),lanzar);				
		v.getContext().startActivity(i);

	}
	private Class obtenerClase(int valor) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		switch (valor) {
		case 1:	return CursoUnoEso.class;
		case 2:	return CursoDosEso.class;
		case 3:	return CursoTresEso.class;
		case 4:	return CursoCuatroEso.class;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		}
		return null;
	}

	private int seleccionaEstudio(View v) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		for (int i = 0; i < imagenes.size(); i++) {
			if (v == imagenes.get(i))
				return i+1;
		}
		return (Integer) null;
	}
}
