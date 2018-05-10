package ar.edu.utn.fra.lab5.a1erparcial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener, View.OnClickListener{

    /*TODO:
    * 1.- Completar lo necesario para que compile
    *   a.- Strings.xml
    *   b.- Crear menu.xml
    *   c.- crear Interface
    * 2.- Adaptar codigo usando MVC (mover lo que no debe estar en MainActivity)
    * 3.- Completar metodos OnCreate y OnBind del Adapter
    * 4.- Menu
    *   a.- Completar opciones del menu "opcion a" y "salir"
    *   b.- Dar funcionalidad a los botones
    * 5.- Usar Intent para llamar por telefono.
    * 6.- Uso de GIT:
    *   a.- Bajar y subir cambios de/a github
    *   b.- realizar al menos 1 commit con la leyenda "entrega 1er Parcial, Alumno: Nombre y Apellido
    */


    //TODO: Limpiar MainActivity, pasando lo necesario a las clases Controlador y VistaControlador para usar MVC
    Adapter adaptador;
    List<Modelo> contactos;
    Button btn_llamar;
    Controlador c;
    VistaControlador v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_llamar = (Button) this.findViewById(R.id.btn_llamar);
        btn_llamar.setOnClickListener(this);

        contactos = new ArrayList<Modelo>();
        contactos.add(new Modelo("Juan", "Garcia", "4444-4444"));
        contactos.add(new Modelo("Pablo", "Lopez", "5555-45554"));
        contactos.add(new Modelo("Ricardo", "Perez", "4124-1234"));
        contactos.add(new Modelo("Raul", "Garnica", "4123-43244"));
        contactos.add(new Modelo("Roberto", "Rossi", "1251-5123"));
        contactos.add(new Modelo("Julieta", "H.", "5324-1252"));
        contactos.add(new Modelo("Gabriel", "Veracruz", "1225-5423"));
        contactos.add(new Modelo("Martin", "Paez", "4444-4124"));
        contactos.add(new Modelo("Adrian", "Stocombo", "4444-1251"));
        contactos.add(new Modelo("Walter", "Lilope", "4444-1524"));
        contactos.add(new Modelo("Teodoro", "Tarcuro", "4444-1252"));
        contactos.add(new Modelo("Celia", "Curro", "2314-1521"));
        contactos.add(new Modelo("Belen", "Paz", "1523-4444"));
        contactos.add(new Modelo("Tomas", "Tarifa", "3125-6234"));
        contactos.add(new Modelo("Jazmin", "Solano", "1252-6234"));
        contactos.add(new Modelo("Nicolas", "trejo", "2634-2346"));
        contactos.add(new Modelo("Osvaldo", "Ramallo", "7345-4444"));
        contactos.add(new Modelo("Alfredo", "Garcia", "2364-2346"));

        RecyclerView rv = (RecyclerView) this.findViewById(R.id.rv1);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        adaptador = new Adapter(this, contactos, this);
        rv.setAdapter(adaptador);

        this.v = new VistaControlador(this);
        this.c = new Controlador(contactos, v);

    }

    @Override
    public void onItemClick(View view, int position) {
        c.seleccion(position);
    }

    @Override
    public void onClick(View v) {
        TextView tvTelefono = (TextView) this.findViewById(R.id.main_telefono);
        Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+tvTelefono.getText().toString()));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
        }else{
            startActivity(callIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.salir:
                finish();
                break;
            case R.id.nuevo:
                Log.d("Boton nuevo","Presione el boton nuevo");
                break;
        }
        return true;
    }
}
