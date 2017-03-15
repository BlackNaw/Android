package com.nawtovi.horariojose.Asociadores;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.example.imagenespasando.R;

import java.util.Vector;


public class AsociadorCursos {
	public Vector<ImageView> asociadorCursos(Activity activity, int estudio) {
		Vector<ImageView> cursos = enlazarImagenes(activity, estudio);
		for (int i = 0; i < cursos.size(); i++) {
			cursos.get(i).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Ap�ndice de m�todo generado autom�ticamente
					procesaToqueCursos(v);
				}

			});
		}
		return cursos;
	}

	private void procesaToqueCursos(View v) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	// Aqu� debe llamar la activity que ya tiene asociado el layuout
	// correspondiente
	private Vector<ImageView> enlazarImagenes(Activity activity, int estudios) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		Vector<ImageView> cursos = new Vector<ImageView>();
		switch (estudios) {
		case 1:
			cursos.add((ImageView) activity.findViewById(R.id.imagece1a));
			cursos.add((ImageView) activity.findViewById(R.id.imagece1b));
			cursos.add((ImageView) activity.findViewById(R.id.imagece1d));
			cursos.add((ImageView) activity.findViewById(R.id.imagece1d));
			break;
		case 2:
			cursos.add((ImageView) activity.findViewById(R.id.imagece2a));
			cursos.add((ImageView) activity.findViewById(R.id.imagece2b));
			cursos.add((ImageView) activity.findViewById(R.id.imagece2d));
			cursos.add((ImageView) activity.findViewById(R.id.imagece2d));
			break;

		case 3:
			cursos.add((ImageView) activity.findViewById(R.id.imagece3a));
			cursos.add((ImageView) activity.findViewById(R.id.imagece3b));
			cursos.add((ImageView) activity.findViewById(R.id.imagece3d));
			cursos.add((ImageView) activity.findViewById(R.id.imagece3d));
			break;

		case 4:
			cursos.add((ImageView) activity.findViewById(R.id.imagece4a));
			cursos.add((ImageView) activity.findViewById(R.id.imagece4b));
			cursos.add((ImageView) activity.findViewById(R.id.imagece4c));			
			break;
		}
		return cursos;
	}

}
