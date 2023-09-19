package ignacio.campillos.androidstudio_recogerinformacion_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import ignacio.campillos.androidstudio_recogerinformacion_02.Modelos.Usuario;

public class MainActivity extends AppCompatActivity {
//Variables de vista
    private EditText textMailMain;
    private EditText textPasswordMain;

    private Button buttonRegister;

    //variables de logica

    ArrayList<Usuario> listaUsuarios; //No inicializar la lista, solo al inicio de actividades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaUsuarios = new ArrayList<>();

        inicializarVista(); //Inicializar variables con botones y EditTexts

        buttonRegister.setOnClickListener(new View.OnClickListener() { //Al pulsar el boton se ejecuta
            @Override
            public void onClick(View view) {
                //Recuperar los datos de las cajas de texto

                String email = textMailMain.getText().toString();
                String password = textPasswordMain.getText().toString();


                if(email.isEmpty() || password.isEmpty()){
                    //Si no hay datos
                    //Mensaje
                    Toast.makeText(MainActivity.this, "MISSING DATA", Toast.LENGTH_SHORT).show(); //Aviso al usuario. Actividad donde se muestra / Texto / Duracion
                    }else {
                    //Si hay datos se guardan
                    // Guardar esos datos en un objeto usuario
                    Usuario miUsuario = new Usuario(email,password);
                    //Añadir ese usuario en la lista
                    listaUsuarios.add(miUsuario);
                    //Mensaje Resumen
                    Toast.makeText(MainActivity.this, "USER SAVED: " + miUsuario.toString(), Toast.LENGTH_SHORT).show();


                }

            }
        });

    }

    private void inicializarVista() {
        textMailMain = findViewById(R.id.TextEmailMain);
        textPasswordMain = findViewById(R.id.TextPasswordMain);
        buttonRegister = findViewById(R.id.buttonRegister);
    }


}