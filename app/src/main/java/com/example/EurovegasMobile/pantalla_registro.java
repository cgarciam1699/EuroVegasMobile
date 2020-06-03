package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class pantalla_registro extends AppCompatActivity {
    EditText nombre, edad, telefono, correo, contrasena;
    Button bt_crear_cuenta;
    String str_escribe_nombre, str_escribe_edad, str_escribe_telefono, str_escribe_correo, str_escribe_contrasena;
    //Escribimos la url donde tenemos el php del registro
    String url = "https://rogdomain.ddns.net:8860/eurovegasmobile/register.php";
    Button btn_ir_inicioSesion,crear_cuenta;
    RadioButton rb_aceptar_terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        btn_ir_inicioSesion = findViewById(R.id.btn_volver_inicioSesion);
        nombre = findViewById(R.id.et_nombre);
        edad = findViewById(R.id.et_edad);
        telefono = findViewById(R.id.et_telefono);
        correo = findViewById(R.id.et_verifica_correo);
        contrasena = findViewById(R.id.et_contrasena);
        bt_crear_cuenta = findViewById(R.id.bt_crear_cuenta);
        rb_aceptar_terminos = findViewById(R.id.aceptar_condiciones);

    }
    public void guardar_registro(View view){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Espere ...");

        //Pasamos a string los datos que recogemos de los editText
        String comprobar_nombre = nombre.getText().toString();
        String comprobar_correo = correo.getText().toString();
        String comprobar_contrasena = contrasena.getText().toString();
        String comprobar_edad = edad.getText().toString();
        String comprobar_telefono = telefono.getText().toString();

        //Parseamos a entero para filtrar por edades
        int filtrado_edad = Integer.parseInt(comprobar_edad);

        // Hacemos las condiciones para que sea obligatorio rellenar todos los campos sin que se quede
        // ninguno vacío
        if(comprobar_nombre.isEmpty()){
            nombre.setError("Ingresa un nombre de usuario");
        }
        else if (comprobar_correo.isEmpty()){
            correo.setError("Ingrese un correo electronico");
        }
        else if (comprobar_contrasena.isEmpty()){
            contrasena.setError("Ingrese una contrasena");
        }
        else if (comprobar_edad.isEmpty()){
            edad.setError("Ingrese su edad");
        }
        else if (filtrado_edad<18){
            edad.setError("Debes de ser mayor de edad para poder registrarte");
        }
        else if (comprobar_telefono.isEmpty()){
            telefono.setError("Ingrese su telefono");
        }
        else if (rb_aceptar_terminos.isChecked()){

            progressDialog.show();
            str_escribe_nombre = nombre.getText().toString().trim();
            str_escribe_correo = correo.getText().toString().trim();
            str_escribe_contrasena = contrasena.getText().toString().trim();
            str_escribe_edad = edad.getText().toString().trim();
            str_escribe_telefono = telefono.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Aquí programamos lo que deseamos hacer en caso de no haber ningún error,
                    progressDialog.dismiss();
                    nombre.setText("");
                    correo.setText("");
                    contrasena.setText("");
                    edad.setText("");
                    telefono.setText("");
                    //Toast.makeText(VentanaRegistro.this, response, Toast.LENGTH_SHORT).show();
                    if(response.equalsIgnoreCase("Registro completado")){

                        startActivity(new Intent(getApplicationContext(), Ruleta.class));
                        Toast.makeText(pantalla_registro.this, response, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(pantalla_registro.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    // En caso de tener algún error al obtener los datos ponemos que nos salte un mensaje de error
                    progressDialog.dismiss();
                    Toast.makeText(pantalla_registro.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    // En este método hacemos el envio de valores de la aplicación al servidor
                    Map<String,String> params = new HashMap<String, String>();

                    params.put("nombre",str_escribe_nombre);
                    params.put("correo",str_escribe_correo);
                    params.put("contrasena",str_escribe_contrasena);
                    params.put("edad",str_escribe_edad);
                    params.put("telefono",str_escribe_telefono);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(pantalla_registro.this);
            requestQueue.add(request);


        }
        else {
            Toast.makeText(this, "Debes aceptar las condiciones y politcas de privacidad", Toast.LENGTH_SHORT).show();
        }

    }

    public void volverIniciarSesion(View view){
        Intent intent1 = new Intent(this, Pantalla_Inicio_Sesion.class);
        startActivity(intent1);
    }
}