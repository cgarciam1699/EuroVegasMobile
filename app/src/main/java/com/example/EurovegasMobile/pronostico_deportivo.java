package com.example.EurovegasMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class pronostico_deportivo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Opciones array list
    String [] opciones_premier_league = {"-- Equipos --","Liverpool","M.United","Arsenal","Chelsea","M.City","Tottenham","Newcastle","Leicester","Everton","West Ham","Aston Villa","Wolverhampton","Watford","Sunderland","Crystal Palace","Southampton","Sheffield","Norwich","Burnley","Brighton","Bournemouth","Fulham","Stoke City","Swansea","Cardiff","Hull City"};
    String [] opciones_liga_santander = {"-- Equipos --","Real Madird","At.Madird","Sevilla","Betis","Valencia","Real Sociedad","Atc.Bilbao","Espanyol","Getafe","Levante","Valladolid","Celta de Vigo","Osasuna","Eibar","Leganés","Mallorca","Alavés","Granada","Rayo Vallecano","Huesca"};
    String [] ociones_bundesliga = {"-- Equipos --","Dortmund","Bayern Múnich","Schalke 04","Leipzig","Werder Bremen","Monchengladbach","Leverkusen","Eintracht","Hertha","Colonia","U.Berlin","Wolfsburgo","Hoffenheim","Friburgo","Stuttgart","Mainz","Dusseldorf","Augsburgo","Hannover 96","Paderborn 07","Nuremberg"};
    String [] opciones_ligue1 = {"-- Equipos --","PSG","O.Marsella","O.Lyon","Saint-Étienne","Stade Rennais","Monaco","Lille","Lens","Nantes","Burdeos","Niza","Nimes","Toulouse","Reims","Metz","Angers","Brestois","Montpelliere","Estraburgo","Dijon","Lorient","Guigamp","Caen"};
    String [] opciones_serieA = {"-- Equipos --","Juventus","Inter de Milan","Lazio","Roma","Napoles","Atalanta","Fiorentina","Sampdoria","Parma","Genoa","Torino","Cagliari","Udinese","S.P.A.L","Bologna","Verona","Lecce","Empoli","Catania"};
    //--------------------------------------------------------------
    String str_ganador1, str_ganador2, str_ganador3, str_ganador4, str_ganador5;
    String url = "https://rogdomain.ddns.net:8860/eurovegasmobile/insertar_pronostico.php";
    //--------------------------------------------------------------
    EditText  et_ganador_premier, et_ganador_liga_santander, et_ganador_bundesliga, et_ganador_ligue1, et_ganador_serieA;
    Spinner sp_premier, sp_liga_santander, sp_bundesliga, sp_ligue1, sp_serieA;
    Button bt_registrar_pronostico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronostico_deportivo);
        et_ganador_premier = findViewById(R.id.et_ganador_premier);
        et_ganador_liga_santander = findViewById(R.id.et_ganador_liga_santander);
        et_ganador_bundesliga = findViewById(R.id.et_ganador_bundesliga);
        et_ganador_ligue1 = findViewById(R.id.et_ganador_ligue1);
        et_ganador_serieA = findViewById(R.id.et_ganador_serieA);
        sp_premier = findViewById(R.id.spinner_premier_league);
        sp_liga_santander = findViewById(R.id.spinner_liga_santander);
        sp_bundesliga = findViewById(R.id.spinner_bundesliga);
        sp_ligue1 = findViewById(R.id.spinner_ligue1);
        sp_serieA = findViewById(R.id.spinner_serieA);
        bt_registrar_pronostico = findViewById(R.id.bt_registrar_pronostico);
        // ------------------------------------------------------------------------
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_premier_league);
        sp_premier.setAdapter(adapter);
        sp_premier.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter <String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_liga_santander);
        sp_liga_santander.setAdapter(adapter1);
        sp_liga_santander.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter <String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ociones_bundesliga);
        sp_bundesliga.setAdapter(adapter2);
        sp_bundesliga.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter <String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_ligue1);
        sp_ligue1.setAdapter(adapter3);
        sp_ligue1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        ArrayAdapter <String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_serieA);
        sp_serieA.setAdapter(adapter4);
        sp_serieA.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        et_ganador_premier.setText(sp_premier.getSelectedItem().toString());
        et_ganador_liga_santander.setText(sp_liga_santander.getSelectedItem().toString());
        et_ganador_bundesliga.setText(sp_bundesliga.getSelectedItem().toString());
        et_ganador_ligue1.setText(sp_ligue1.getSelectedItem().toString());
        et_ganador_serieA.setText(sp_serieA.getSelectedItem().toString());

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        et_ganador_premier.setText("Selecciona alguna opción");
        et_ganador_liga_santander.setText("Selecciona alguna opción");
        et_ganador_bundesliga.setText("Selecciona alguna opción");
        et_ganador_ligue1.setText("Selecciona alguna opción");
        et_ganador_serieA.setText("Selecciona alguna opción");

    }
    //Guardar datos de los pronosticos en bbdd
    public void guardar_pronostico(View view){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Espere ...");

        String comprobar_ganador1 = et_ganador_premier.getText().toString();
        String comprobar_ganador2 = et_ganador_liga_santander.getText().toString();
        String comprobar_ganador3 = et_ganador_bundesliga.getText().toString();
        String comprobar_ganador4 = et_ganador_ligue1.getText().toString();
        String comprobar_ganador5 = et_ganador_serieA.getText().toString();

        if(comprobar_ganador1.isEmpty()){
            et_ganador_premier.setError("Ingrese un ganador");
        }else if(comprobar_ganador2.isEmpty()){
            et_ganador_liga_santander.setError("Ingrese un ganador");
        }else if(comprobar_ganador3.isEmpty()){
            et_ganador_bundesliga.setError("Ingrese un ganador");
        }else if(comprobar_ganador4.isEmpty()){
            et_ganador_ligue1.setError("Ingrese un ganador");
        }else if(comprobar_ganador5.isEmpty()){
            et_ganador_serieA.setError("Ingrese un ganador");
        }else{
            progressDialog.show();
            str_ganador1 = et_ganador_premier.getText().toString().trim();
            str_ganador2 = et_ganador_liga_santander.getText().toString().trim();
            str_ganador3 = et_ganador_bundesliga.getText().toString().trim();
            str_ganador4 = et_ganador_ligue1.getText().toString().trim();
            str_ganador5 = et_ganador_serieA.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    et_ganador_premier.setText("");
                    et_ganador_liga_santander.setText("");
                    et_ganador_bundesliga.setText("");
                    et_ganador_ligue1.setText("");
                    et_ganador_serieA.setText("");
                    //------
                    if(response.equalsIgnoreCase("Pronostico registrado")){
                        //startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        Intent intent = getIntent();

                        String str_escribe_correo = intent.getStringExtra("str_correo");

                        Intent intent2 = new Intent(getApplicationContext(), pantalla_inicio.class);

                        intent2.putExtra("str_correo", str_escribe_correo);
                        startActivity(new Intent(getApplicationContext(), Ruleta.class));
                        Toast.makeText(pronostico_deportivo.this, response, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(pronostico_deportivo.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(pronostico_deportivo.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    Intent intent = getIntent();

                    String str_escribe_correo = intent.getStringExtra("str_correo");
                    params.put("ganador_premier",str_ganador1);
                    params.put("ganador_liga_santander",str_ganador2);
                    params.put("ganador_bundesliga",str_ganador3);
                    params.put("ganador_ligue_one",str_ganador4);
                    params.put("ganador_serieA",str_ganador5);
                    params.put("correo",str_escribe_correo);

                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(pronostico_deportivo.this);
            requestQueue.add(request);


        }
    }
}

