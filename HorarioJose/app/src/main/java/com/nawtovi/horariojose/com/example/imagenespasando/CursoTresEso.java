package com.nawtovi.horariojose.com.example.imagenespasando;

import android.app.Activity;
import android.os.Bundle;

import com.example.imagenespasando.R;
import com.nawtovi.horariojose.Asociadores.AsociadorCursos;

public class CursoTresEso extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.curso3eso);
		AsociadorCursos asociadorCursos=new AsociadorCursos();
		asociadorCursos.asociadorCursos(this, 3);
	}
	
}
