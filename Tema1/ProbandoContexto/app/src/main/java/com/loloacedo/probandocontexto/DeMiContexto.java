package com.loloacedo.probandocontexto;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import java.io.File;

/**
 * Created by manue on 30/09/2016.
 */

public class DeMiContexto extends MiContexto {
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public File getDataDir(){
        Log.d("Hasta aqui hemos llegao");
        return super.getDataDir();
    }
}
