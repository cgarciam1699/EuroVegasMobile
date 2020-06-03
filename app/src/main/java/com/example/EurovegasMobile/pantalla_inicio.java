package com.example.EurovegasMobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class pantalla_inicio extends AppCompatActivity {
    Button acceder_ruleta, acceder_carreras_caballos;
    ImageButton acceder_blackjack, acceder_maquina_tragamonedas, acceder_pronostico_deportivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        acceder_ruleta = findViewById(R.id.bt_acceder_ruleta);
        acceder_blackjack = findViewById(R.id.bt_acceder_blackjack);
        acceder_maquina_tragamonedas = findViewById(R.id.bt_acceder_maquina_tragamonedas);
        acceder_pronostico_deportivo = findViewById(R.id.bt_acceder_pronostico_deportivo);
        acceder_carreras_caballos = findViewById(R.id.button4);


        /*Bundle b = this.getIntent().getExtras();
        String nom_jugador = b.getString("Jugador");
        nombre_jugador.setText(""+nom_jugador);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bt_encuesta:
                Intent intent = getIntent();
                String str_usuario_a_recibir1 = intent.getStringExtra("str_correo");
                Intent intent8 = new Intent(this, encuesta_clientes.class);
                intent8.putExtra("str_correo", str_usuario_a_recibir1);
                startActivity(intent8);
                break;
            case R.id.bt_cerrar_sesion:
                Intent intent_cerrar_sesion = new Intent(this, Pantalla_Inicio_Sesion.class);
                startActivity(intent_cerrar_sesion);
                break;
            case R.id.bt_compartir:
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("geo:40.517160, -3.489110"));
                if(intent2.resolveActivity(getPackageManager())!=null){
                    startActivity(intent2);
                }

                break;
            case R.id.bt_ver_pronostico:
                Intent intent3 = getIntent();
                String str_usuario_a_recibir = intent3.getStringExtra("str_correo");
                Intent intent4 = new Intent(this, mostrar_pronosticos_registrados.class);
                intent4.putExtra("str_correo", str_usuario_a_recibir);
                startActivity(intent4);
                break;

            case R.id.bt_politicas:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Términos y Condiciones de privacidad");
                builder.setMessage("Estos Términos y condiciones regulan el acceso y uso del sitio web www.edp.com, bajo la responsabilidad de EDP S.A., con sede en la Avenida 24 de julio, 12, en Lisboa (en lo sucesivo, «EDP S.A.»). Cualquier cuestión legal relacionada con el sitio web se podrá consultar en las secciones Política de privacidad y Política de cookies, que forman parte integral de estos Términos y condiciones.\n" +
                        "\n" +
                        "El uso de este sitio web por parte de cualquier usuario se regirá por los siguientes Términos y condiciones, y su uso implica una aceptación de los mismos por el usuario. Si el usuario rechaza estos Términos y condiciones, debe cesar el uso del mismo.\n" +
                        "\n" +
                        "EurovegasMobile podrá modificar o actualizar, de manera total o parcial, estos Términos y condiciones, así como la Política de privacidad y la Política de cookies. Cualquier cambio o actualización de estos Términos y condiciones, así como los de la Política de privacidad y Política de cookies, entrarán en vigor tan pronto como se publiquen en la sección correspondiente del sitio web. Se aconseja a los usuarios consultar regularmente las secciones de los Términos y condiciones, la Política de privacidad y la Política de cookies para comprobar las versiones más actualizadas.\n" +
                        "\n" +
                        "El acceso y uso del sitio web están disponibles exclusivamente para uso personal y promoción de la actividad de EDP S.A.\n" +
                        "\n" +
                        "EDP S.A. se reserva el derecho de evaluar, a su entera discreción, el cumplimiento de estos Términos y condiciones por parte de cualquier usuario. La violación de los Términos y condiciones podrá implicar la retirada de la licencia de uso concedida por EDP S.A., en virtud de esta cláusula n.º 1 y, así, ejercer sus derechos en la máxima extensión posible permitida por la ley.\n" +
                        "\n" +
                        "Los usuarios se comprometen a indemnizar y exonerar a EDP S.A., así como a los representantes legales, socios y trabajadores, de cualquier daño, responsabilidades, reclamaciones o solicitudes de compensación, incluidos los gastos y costes de representación, solicitados por terceros como consecuencia del uso del sitio web en disconformidad con estos Términos y condiciones o en virtud de la violación de las condiciones previstas en los mismos o que resulten del incumplimiento de las representaciones y garantías contenidas en estos Términos y condiciones.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public void click_acceder_ruleta (View v){
        if(acceder_ruleta.isClickable()){
            Intent intent = new Intent(this, Tabla_Ruleta.class);
            startActivity(intent);

        }
    }

    public void click_acceder_blackjack (View v){
        if (acceder_blackjack.isClickable()){
            Intent intent = new Intent(this, principal_blackjack.class);
            startActivity(intent);
        }
    }

    public void click_acceder_maquina_tragamonedas (View v){
        if (acceder_maquina_tragamonedas.isClickable()){
            Intent intent = new Intent(this, maquina_tragamonedas.class);
            startActivity(intent);
        }
    }

    public void click_acceder_pronostico_deportivo (View v){
        if (acceder_pronostico_deportivo.isClickable()){
            Intent intent = getIntent();
            String str_usuario_a_recibir1 = intent.getStringExtra("str_correo");
            Intent intent8 = new Intent(this, pronostico_deportivo.class);
            intent8.putExtra("str_correo", str_usuario_a_recibir1);
            startActivity(intent8);
        }
    }
    public void salir_app (View v){
            Intent intent = new Intent(this, Pantalla_Inicio_Sesion.class);
            startActivity(intent);

    }
    public void click_acceder_carreras_caballos (View v){
        if (acceder_carreras_caballos.isClickable()){
            Intent intent = new Intent(this, Principal_carrera_caballos.class);
            startActivity(intent);
        }
    }



}
