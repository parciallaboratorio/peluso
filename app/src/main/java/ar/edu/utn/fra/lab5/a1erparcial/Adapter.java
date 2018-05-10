package ar.edu.utn.fra.lab5.a1erparcial;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lkdml on 03/10/2017.
 */


public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    LayoutInflater mLInflater;
    List<Modelo> contactos;ItemClickListener listener;

    public Adapter(Context context, List<Modelo> modelo, ItemClickListener listener) {
        this.mLInflater = LayoutInflater.from(context);
        this.contactos = modelo;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO: completar lo que falta
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder,parent,false);
        ViewHolder vh = new ViewHolder(v,this.listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO: completar lo que falta
        TextView telefono = holder.telefono;
        TextView nombre = holder.nombre;
        TextView apellido = holder.apellido;
        Modelo contacto = this.contactos.get(position);
        telefono.setText(contacto.getTelefono());
        nombre.setText(contacto.getNombre());
        apellido.setText(contacto.getApellido());
    }

    @Override
    public int getItemCount() {
        return this.contactos.size();
    }


}
