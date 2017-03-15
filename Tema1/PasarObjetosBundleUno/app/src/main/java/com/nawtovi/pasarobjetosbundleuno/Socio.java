package com.nawtovi.pasarobjetosbundleuno;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yo on 07/10/2016.
 */

public class Socio implements Parcelable {
    private int numero;
    private String nombre;

    public Socio(int numeor, String nombre) {
        this.numero = numeor;
        this.nombre = nombre;
    }

    //----------------------------------------------------------------------------------------------

    /* Esta parte es de implementacion obligatoria para un objeto parcelable */
    protected Socio(Parcel in) {
        numero = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<Socio> CREATOR = new Creator<Socio>() {
        @Override
        public Socio createFromParcel(Parcel in) {
            return new Socio(in);
        }

        @Override
        public Socio[] newArray(int size) {
            return new Socio[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /* Tenemos que explicar a Parcelable como
     se escribe los campos del objeto en un Parcel*/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numero);
        dest.writeString(nombre);
    }
//--------------------------------------------------------------------------------------------------
    public int getNumeor() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumeor(int numeor) {
        this.numero = numeor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
