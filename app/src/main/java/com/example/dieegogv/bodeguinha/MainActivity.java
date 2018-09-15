package com.example.dieegogv.bodeguinha;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btRegistro;
    TextView btPedido;
    TextView btStock;
    TextView btEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btRegistro = (Button) findViewById(R.id.btRegisto);
        btRegistro.setOnClickListener(this);


        btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(MainActivity.this, PedidoActivity.class);
                startActivity(p);
            }
        });
        btStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(MainActivity.this, StockActivity.class);
                startActivity(s);
            }
        });
        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this, EliminarActivity.class);
                startActivity(e);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btRegisto:
                Intent r = new Intent(this, RegistroActivity.class);
                startActivity(r);
                break;
        }

    }
}
