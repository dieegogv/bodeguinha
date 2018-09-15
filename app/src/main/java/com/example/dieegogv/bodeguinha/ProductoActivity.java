package com.example.dieegogv.bodeguinha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class ProductoActivity extends  MainActivity {
    private EditText etNombre;
    private EditText etCantidad;
    private Button btGuardad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        etCantidad = (EditText) findViewById(R.id.etCantidad);
    }
}
