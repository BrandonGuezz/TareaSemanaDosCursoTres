package com.example.tareasemanados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaDos extends AppCompatActivity {

    TextView Nombre;
    TextView Fecha;
    TextView Correo;
    TextView Telefono;
    TextView InfoContacto;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        Bundle parametros = getIntent().getExtras();

        final String extraNombre = parametros.getString("Nombre");
        final String extraFecha = parametros.getString("Fecha");
        final String extraCorreo = parametros.getString("Correo");
        final String extraTelefono = parametros.getString("Telefono");
        final String extraInfoContacto= parametros.getString("InfoContacto");

        TextView Nombre = (TextView) findViewById(R.id.txtFieldNombre);
        TextView Fecha = (TextView) findViewById(R.id.txtFieldFecha);
        TextView Correo = (TextView) findViewById(R.id.txtFieldCorreo);
        TextView Telefono = (TextView) findViewById(R.id.txtFieldTelefono);
        TextView InfoContacto = (TextView) findViewById(R.id.txtFieldInfoContacto);
        Button btnEditar = (Button) findViewById(R.id.btnEditarInfo);

        Nombre.setText(extraNombre);
        Fecha.setText(extraFecha);
        Correo.setText(extraCorreo);
        Telefono.setText(extraTelefono);
        InfoContacto.setText(extraInfoContacto);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editInfo = new Intent(PantallaDos.this ,MainActivity.class );
                editInfo.putExtra("NombreE",extraNombre);
                editInfo.putExtra("FechaE",extraFecha);
                editInfo.putExtra("TelefonoE",extraTelefono);
                editInfo.putExtra("CorreoE",extraCorreo);
                editInfo.putExtra("InfoContactoE",extraInfoContacto);

                startActivity(editInfo);
            }
        });

    }
}
