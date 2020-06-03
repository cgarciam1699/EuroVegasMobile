package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class mostrar_pronosticos_registrados extends AppCompatActivity {

    Button bt_consultar_pronostico;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pronosticos_registrados);


        bt_consultar_pronostico = findViewById(R.id.btnLoad);
        listview = findViewById(R.id.lvLista);

        bt_consultar_pronostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

    }
    public void ir_menu (View v){
        Intent recuperarCorreo = getIntent();
        String string_usuario_recibido = recuperarCorreo.getStringExtra("str_correo");
        Intent intent_menu = new Intent(this, pantalla_inicio.class);
        intent_menu.putExtra("str_correo", string_usuario_recibido);
        startActivity(intent_menu);
    }
    private void getData() {

        Intent intent = getIntent();

        String str_usuario_a_recibir = intent.getStringExtra("str_correo");

        String url = recuperar_pronosticos_deportivos.DATA_URL + str_usuario_a_recibir;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mostrar_pronosticos_registrados.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(recuperar_pronosticos_deportivos.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {

                JSONObject jo = result.getJSONObject(i);

                String muestra_ganador_premier = jo.getString(recuperar_pronosticos_deportivos.KEY_PREMIER);
                String muestra_ganador_liga_santander = jo.getString(recuperar_pronosticos_deportivos.KEY_lIGA_SANTANDER);
                String muestra_ganador_bundesliga = jo.getString(recuperar_pronosticos_deportivos.KEY_BUNDESLIGA);
                String muestra_ganador_ligue_one = jo.getString(recuperar_pronosticos_deportivos.KEY_LIGUE1);
                String muestra_ganador_serieA = jo.getString(recuperar_pronosticos_deportivos.KEY_SERIEA);

                final HashMap<String, String> employees = new HashMap<>();

                employees.put(recuperar_pronosticos_deportivos.KEY_PREMIER, muestra_ganador_premier);
                employees.put(recuperar_pronosticos_deportivos.KEY_lIGA_SANTANDER, muestra_ganador_liga_santander);
                employees.put(recuperar_pronosticos_deportivos.KEY_BUNDESLIGA, muestra_ganador_bundesliga);
                employees.put(recuperar_pronosticos_deportivos.KEY_LIGUE1, muestra_ganador_ligue_one);
                employees.put(recuperar_pronosticos_deportivos.KEY_SERIEA, muestra_ganador_serieA);
               
                list.add(employees);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }
        ListAdapter adapter = new SimpleAdapter(

                mostrar_pronosticos_registrados.this, list, R.layout.activity_my_list_pronostico,

                new String[]{recuperar_pronosticos_deportivos.KEY_PREMIER, recuperar_pronosticos_deportivos.KEY_lIGA_SANTANDER, recuperar_pronosticos_deportivos.KEY_BUNDESLIGA, recuperar_pronosticos_deportivos.KEY_LIGUE1, recuperar_pronosticos_deportivos.KEY_SERIEA},

                new int[]{R.id.muestra_ganador_premier, R.id.muestra_ganador_liga_santander, R.id.muestra_ganador_bundesliga, R.id.muestra_ganador_ligue_one, R.id.muestra_ganador_serieA});

        listview.setAdapter(adapter);

    }
}
