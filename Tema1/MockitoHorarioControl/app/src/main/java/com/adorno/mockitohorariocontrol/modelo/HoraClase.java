package com.adorno.mockitohorariocontrol.modelo;

/**
 * Created by jose on 22/10/15.
 */
public class HoraClase {
    private final int idDia;
    private final int idHora;
    private final String abbr;

    public HoraClase(int idDia, int idHora, String abbr) {
        this.idDia = idDia;
        this.idHora = idHora;
        this.abbr = abbr;
    }

    public int getIdDia() {
        return idDia;
    }

    public int getIdHora() {
        return idHora;
    }

    public String getAbbr() {
        return abbr;
    }
}
