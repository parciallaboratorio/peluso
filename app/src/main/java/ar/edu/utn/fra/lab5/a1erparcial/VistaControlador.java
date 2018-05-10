package ar.edu.utn.fra.lab5.a1erparcial;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lkdml on 03/10/2017.
 */

public class VistaControlador {

    private Activity a;
    ImageView imgContacto;
    TextView main_nombre;
    TextView main_telefono;
    List<Modelo> contactos;
    Button btn_llamar;

    public VistaControlador(Activity a){
        this.a = a;
        this.imgContacto = (ImageView) a.findViewById(R.id.vh_img);
        this.main_nombre = (TextView) a.findViewById(R.id.main_nombre);
        this.main_telefono = (TextView) a.findViewById(R.id.main_telefono);
        this.btn_llamar = (Button) a.findViewById(R.id.btn_llamar);
    }

    public void modificarVista(Modelo contacto){
        this.main_nombre.setText(contacto.getNombre());
        this.main_telefono.setText(contacto.getTelefono());
    }

}
