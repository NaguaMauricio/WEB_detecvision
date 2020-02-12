package com.example.prueba_cargar_paices_mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterViewAnimator.OnItemClickListener{
    private ListView listado_paises;
    public static ArrayList<Cargar_Paises> lista_de_paises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Lista de Países");

        listado_paises = (ListView)findViewById(R.id.id_listView);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",datos,MainActivity.this, MainActivity.this);
        ws.execute("");
    }

    public void processFinish(String result) throws JSONException {
        if (result.equals("")){
            Toast.makeText(this, "Error de Conexión", Toast.LENGTH_SHORT).show();
        }else{
            lista_de_paises = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject results = jsonObject.getJSONObject("Results");

            Iterator<?> iterator = results.keys();
            while (iterator.hasNext()){
                String key =(String)iterator.next();
                JSONObject json_pais = results.getJSONObject(key);

                Cargar_Paises pais = new Cargar_Paises();
                pais.setPais(json_pais.getString("Name"));

                JSONObject rect_pais = json_pais.getJSONObject("GeoRectangle");
                pais.setWest(rect_pais.getDouble("West"));
                pais.setEast(rect_pais.getDouble("East"));
                pais.setNorth(rect_pais.getDouble("North"));
                pais.setSouth(rect_pais.getDouble("South"));

                JSONObject img_pais = json_pais.getJSONObject("CountryCodes");
                pais.setUrl_imagen(img_pais.getString("iso2"));

                JSONArray coord =  json_pais.getJSONArray("GeoPt");
                pais.setMove_Lat(coord.getDouble(0));
                pais.setMove_Lon(coord.getDouble(1));

                lista_de_paises.add(pais);
            }
        }
        Paices_Adaptados adaptador_paises = new Paices_Adaptados(this, lista_de_paises);
        listado_paises.setAdapter(adaptador_paises);
        listado_paises.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, Detalles_de_los_Paises.class);
        Bundle b = new Bundle();
        b.putInt("pais",position);
        intent.putExtras(b);
        startActivity(intent);
    }
}
