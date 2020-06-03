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

public class encuesta_clientes extends AppCompatActivity {
    EditText respuesta1, respuesta2, respuesta3, respuesta4;
    Button bt_registrar_respuestas;
    String str_respuesta1, str_respuesta2, str_respuesta3, str_respuesta4;
    String url = "https://rogdomain.ddns.net:8860/eurovegasmobile/insertar_encuestas.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_clientes);

        respuesta1 = findViewById(R.id.et_respuesta1);
        respuesta2 = findViewById(R.id.et_respuesta2);
        respuesta3 = findViewById(R.id.et_respuesta3);
        respuesta4 = findViewById(R.id.et_respuesta4);
        bt_registrar_respuestas = findViewById(R.id.bt_registrar_pronostico);
    }
    public void guardar_respuestas(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Espere ...");

        String comprobar_respuesta_1 = respuesta1.getText().toString();
        String comprobar_respuesta_2 = respuesta2.getText().toString();
        String comprobar_respuesta_3 = respuesta3.getText().toString();
        String comprobar_respuesta_4 = respuesta4.getText().toString();

        if (comprobar_respuesta_1.isEmpty()) {
            respuesta1.setError("Ingresa una respuesta");
        } else if (comprobar_respuesta_2.isEmpty()) {
            respuesta2.setError("Ingrese una respuesta");
        } else if (comprobar_respuesta_3.isEmpty()) {
            respuesta3.setError("Ingrese una respuesta");
        } else if (comprobar_respuesta_4.isEmpty()) {
            respuesta4.setError("Ingrese una respuesta");

        } else{

            progressDialog.show();
            str_respuesta1 = respuesta1.getText().toString().trim();
            str_respuesta2 = respuesta2.getText().toString().trim();
            str_respuesta3 = respuesta3.getText().toString().trim();
            str_respuesta4 = respuesta4.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    respuesta1.setText("");
                    respuesta2.setText("");
                    respuesta3.setText("");
                    respuesta4.setText("");
                    //Toast.makeText(VentanaRegistro.this, response, Toast.LENGTH_SHORT).show();
                    if(response.equalsIgnoreCase("Encuesta registrada")){

                        //startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        Intent intent = getIntent();

                        String str_escribe_correo = intent.getStringExtra("str_correo");

                        Intent intent2 = new Intent(getApplicationContext(), pantalla_inicio.class);

                        intent2.putExtra("str_correo", str_escribe_correo);

                        startActivity(intent2);

                        Toast.makeText(encuesta_clientes.this, response, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(encuesta_clientes.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(encuesta_clientes.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();

                    Intent intent = getIntent();

                    String str_escribe_correo = intent.getStringExtra("str_correo");

                    params.put("respuesta1",str_respuesta1);
                    params.put("respuesta2",str_respuesta2);
                    params.put("respuesta3",str_respuesta3);
                    params.put("respuesta4",str_respuesta4);
                    params.put("correo",str_escribe_correo);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(encuesta_clientes.this);
            requestQueue.add(request);


        }
    }
}
