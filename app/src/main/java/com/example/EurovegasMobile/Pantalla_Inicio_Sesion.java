package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Pantalla_Inicio_Sesion extends AppCompatActivity {
    EditText et_correo, et_contrasena;
    Button btn_ir_crearCuenta,iniciar_sesion;
    String str_correo, str_contrasena;
    String url = "https://rogdomain.ddns.net:8860/eurovegasmobile/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__inicio__sesion);
        et_contrasena = findViewById(R.id.et_contrasena);
        et_correo = findViewById(R.id.et_verifica_correo);
        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);

    }

    public void inicioSesion (View view){
        String comprobar_correo = et_correo.getText().toString();
        String comprobar_contrasena = et_contrasena.getText().toString();

        if(comprobar_correo.isEmpty()){
            et_correo.setError("Ingrese un correo electronico valido");
        }
        else if(comprobar_contrasena.isEmpty()){
            et_contrasena.setError("Ingrese una contrasena valida");
        }
        else{
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Espere ...");

            progressDialog.show();

            str_correo = et_correo.getText().toString().trim();
            str_contrasena = et_contrasena.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if(response.equalsIgnoreCase("Iniciando sesion")){

                        et_correo.setText("");
                        et_contrasena.setText("");
                        //startActivity(new Intent(getApplicationContext(),pantalla_inicio.class));
                        Intent intent = new Intent(getApplicationContext(), pantalla_inicio.class);
                        intent.putExtra("str_correo", str_correo);
                        startActivity(intent);
                        Toast.makeText(Pantalla_Inicio_Sesion.this, response, Toast.LENGTH_SHORT).show();
                        
                    }
                    else{
                        et_correo.setError("correo no valido");
                    }
                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Pantalla_Inicio_Sesion.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("correo",str_correo);
                    params.put("contrasena",str_contrasena);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Pantalla_Inicio_Sesion.this);
            requestQueue.add(request);

        }


    }


    public void Registrarse (View v){

            Intent intent = new Intent(this, pantalla_registro.class);
            startActivity(intent);

    }

    public void olvido_contraseña(View v){
        Intent intent = new Intent(this, pronostico_deportivo.class);
        startActivity(intent);
    }
}
