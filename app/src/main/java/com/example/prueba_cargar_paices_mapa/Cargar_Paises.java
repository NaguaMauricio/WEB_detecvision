package com.example.prueba_cargar_paices_mapa;

public class Cargar_Paises {
    private String pais;
    private String imagen;
    private Double GeoPt_Lat;
    private Double GeoPt_Lon;
    private Double Move_Lat;
    private Double Move_Lon;

    private Double West;
    private Double East;
    private Double North;
    private Double South;

    private String capital;
    private String cord_capital;


    public Cargar_Paises() {

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrl_imagen() {
        return imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.imagen =imagen+".png";
    }

    public Double getGeoPt_Lat() {
        return GeoPt_Lat;
    }

    public void setGeoPt_Lat(Double geoPt_Lat) {
        GeoPt_Lat = geoPt_Lat;
    }

    public Double getGeoPt_Lon() {
        return GeoPt_Lon;
    }

    public void setGeoPt_Lon(Double geoPt_Lon) {
        GeoPt_Lon = geoPt_Lon;
    }

    public Double getWest() {
        return West;
    }

    public void setWest(Double west) {
        West = west;
    }

    public Double getEast() {
        return East;
    }

    public void setEast(Double east) {
        East = east;
    }

    public Double getNorth() {
        return North;
    }

    public void setNorth(Double north) {
        North = north;
    }

    public Double getSouth() {
        return South;
    }

    public void setSouth(Double south) {
        South = south;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCord_capital() {
        return cord_capital;
    }

    public void setCord_capital(String cord_capital) {
        this.cord_capital = cord_capital;
    }

    public Double getMove_Lat() {
        return Move_Lat;
    }

    public void setMove_Lat(Double move_Lat) {
        Move_Lat = move_Lat;
    }

    public Double getMove_Lon() {
        return Move_Lon;
    }

    public void setMove_Lon(Double move_Lon) {
        Move_Lon = move_Lon;
    }
}
