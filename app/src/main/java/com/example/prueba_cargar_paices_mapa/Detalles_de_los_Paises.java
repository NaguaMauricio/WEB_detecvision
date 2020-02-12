package com.example.prueba_cargar_paices_mapa;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

public class Detalles_de_los_Paises extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap cargar_mapa;
    private Cargar_Paises carga_paises;
    private ImageView cargar_bandera;
    private TextView pais_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_del_pais);
        this.setTitle("Detalle País");
        Bundle bundle = this.getIntent().getExtras();
        int i = bundle.getInt("pais");
        carga_paises = MainActivity.lista_de_paises.get(i);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
        pais_nombre = (TextView) findViewById(R.id.nombre_pais);
        pais_nombre.setText(carga_paises.getPais());
        cargar_bandera = (ImageView)findViewById(R.id.cargar_bandera);
        Glide.with(this.getApplicationContext())
                .load(carga_paises.getUrl_imagen())
               .into(cargar_bandera);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        cargar_mapa = googleMap;
        cargar_mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        cargar_mapa.getUiSettings().setZoomControlsEnabled(true);

        PolygonOptions rectangulo = new PolygonOptions().
                add(new LatLng(carga_paises.getNorth(), carga_paises.getWest()),
                        new LatLng(carga_paises.getNorth(), carga_paises.getEast()),
                        new LatLng(carga_paises.getSouth(), carga_paises.getEast()),
                        new LatLng(carga_paises.getSouth(), carga_paises.getWest()),
                        new LatLng(carga_paises.getNorth(), carga_paises.getWest()));
        rectangulo.strokeWidth(5);
        rectangulo.strokeColor(Color.GREEN);
        cargar_mapa.addPolygon(rectangulo);

        LatLng latLng = new LatLng(carga_paises.getMove_Lat(), carga_paises.getMove_Lon());
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(latLng, 4);
        cargar_mapa.moveCamera(camUpd1);
    }


}
