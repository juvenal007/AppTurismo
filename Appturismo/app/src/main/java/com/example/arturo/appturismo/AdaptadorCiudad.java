package com.example.arturo.appturismo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.arturo.appturismo.basededatos.Ciudad;
import java.util.List;

public class AdaptadorCiudad extends RecyclerView.Adapter<AdaptadorCiudad.CiudadHolder>{

    List<Ciudad> list;
    Activity activity;
    int resource;

    public AdaptadorCiudad(List<Ciudad> list, Activity activity, int resource) {
        this.list = list;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public CiudadHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,
                parent, false);
        return new CiudadHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadHolder holder, int i) {
        Ciudad c = list.get(i);
        holder.nombre.setText(c.nombre);
        holder.foto.setImageResource(c.foto1);
        holder.id.setText(String.valueOf(c.id));

    }

    @Override
    public int getItemCount() {return list.size(); }

    public class CiudadHolder extends RecyclerView.ViewHolder{

        TextView nombre,id;
        ImageView foto;
        RelativeLayout container;

        public CiudadHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.item_nombre);
            foto = itemView.findViewById(R.id.item_foto);
            id = itemView.findViewById(R.id.item_id);
            container = itemView.findViewById(R.id.item_container);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(activity, Detalle.class);
                    i.putExtra("id", id.getText().toString());
                    activity.startActivity(i);
                }
            });


        }
    }

}
