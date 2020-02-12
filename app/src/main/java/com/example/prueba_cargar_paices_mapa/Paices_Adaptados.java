package com.example.prueba_cargar_paices_mapa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Paices_Adaptados extends ArrayAdapter<Cargar_Paises> {
    public Paices_Adaptados(@NonNull Context context, ArrayList<Cargar_Paises> datos) {
        super(context, R.layout.lista_de_los_paises, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_de_los_paises, null);
        TextView lblpais = (TextView)item.findViewById(R.id.LblPais);
        lblpais.setText(getItem(position).getPais());

        ImageView imageView = (ImageView)item.findViewById(R.id.id_imagen);
        Glide.with(this.getContext())
                .load(getItem(position).getUrl_imagen())
                .into(imageView);

        return(item);
    }
}
