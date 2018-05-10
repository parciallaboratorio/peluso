package ar.edu.utn.fra.lab5.a1erparcial;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lkdml on 03/10/2017.
 */

public class Controlador {

    private VistaControlador v;
    List<Modelo> contactos;

    public Controlador(List<Modelo> contactos, VistaControlador v){
        this.contactos = contactos;
        this.v = v;
    }

    public void seleccion (int posicion){
        v.modificarVista(contactos.get(posicion));
    }
}
