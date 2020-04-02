package com.example.tareasemanados;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView edTextNombre;
    TextView edTextTelefono;
    TextView edTextCorreo;
    TextView edTextInfoContacto;
    Button   btnGuadar;
    CalendarView PickerCalendario;
    String FechaIntroducido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView edTextNombre         = (TextView) findViewById(R.id.edTextNombre);
        final TextView edTextTelefono       = (TextView) findViewById(R.id.edTextTelefono);
        final TextView edTextCorreo         = (TextView) findViewById(R.id.edTextCorreo);
        final TextView edTextInfoContacto   = (TextView) findViewById(R.id.edTextInfoContacto);
        Button   btnGuardar           = (Button) findViewById(R.id.btnGuardar);
        CalendarView PickerCalendario  = (CalendarView) findViewById(R.id.pickerCalendario);


        Bundle originales = getIntent().getExtras();
        if(originales != null) {
        final String eNombre = originales.getString("NombreE");
        final String eFecha = originales.getString("FechaE");
        final String eCorreo = originales.getString("CorreoE");
        final String eTelefono = originales.getString("TelefonoE");
        final String eContacto= originales.getString("InfoContactoE");


            final String parts[] = eFecha.split("/");
            int day = Integer.parseInt(parts[1]);
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[2]);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            long miliTime = calendar.getTimeInMillis();

           // PickerCalendario.setDate(Long.parseLong(eFecha)); //Corregir fecha

            PickerCalendario.setDate(miliTime,true,true);
            edTextNombre.setText(eNombre);
            edTextCorreo.setText(eCorreo);
            edTextTelefono.setText(eTelefono);
            edTextInfoContacto.setText(eContacto);
        }


        PickerCalendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                FechaIntroducido = month + "/" + dayOfMonth + "/" + year;
                                                                                                              }
                                                                                         });//Fin llaves para obetenr datos del calendario
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PantallaDos.class);

                intent.putExtra("Nombre",edTextNombre.getText().toString());
                intent.putExtra("Fecha",FechaIntroducido);
                intent.putExtra("Telefono",edTextTelefono.getText().toString());
                intent.putExtra("InfoContacto",edTextInfoContacto.getText().toString());
                intent.putExtra("Correo",edTextCorreo.getText().toString());
                startActivity(intent);
                                        }
                                                                         }); //Fin on click

    }  //Llave onCreate final
} // llave final
