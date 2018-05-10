package ar.edu.utn.fra.lab5.a1erparcial;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by lkdml on 03/10/2017.
 */

public class ViewHolder  extends RecyclerView.ViewHolder implements  View.OnClickListener{

    TextView nombre;
    TextView apellido;
    TextView telefono;
    ImageView img;
    ItemClickListener listener;
    int posicion;

    public ViewHolder(View itemView, ItemClickListener listener) {
        super(itemView);
        this.nombre = (TextView) itemView.findViewById(R.id.vh_nombre);
        this.apellido = (TextView) itemView.findViewById(R.id.vh_apellido);
        this.telefono = (TextView) itemView.findViewById(R.id.vh_telefono);
        this.img = (ImageView) itemView.findViewById(R.id.vh_img);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.listener.onItemClick(v,getAdapterPosition());
    }

}
