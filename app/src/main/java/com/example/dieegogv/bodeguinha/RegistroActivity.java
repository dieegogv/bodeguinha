package com.example.dieegogv.bodeguinha;
import android.app.DialogFragment;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class RegistroActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler, MessageDialogFragment.MessageDialogListener{
    private final static String TAG = "ScannerLog";
    private ZBarScannerView mScannerView;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Inicializs el escáner
        setContentView(mScannerView);                // Convierte el escaner en una vista
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Se le muestran los resultados al admin de la aplicación
        mScannerView.startCamera();          // Inicia la cámara cuando vuelve de segundo plano
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Detiene la cámara cuando pasa a segundo plano
    }

    @Override
    public void handleResult(Result rawResult) {

        final String codigo = rawResult.getContents();
        final String formato = rawResult.getContents();
        final String mensaje ="Codigo:"+codigo+" formato:"+formato;
        try {
            Uri notificacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notificacion);
        }catch (Exception e){
            Log.e(TAG,e.getLocalizedMessage());
        }
        showMessage(mensaje);
        // Logear el resultado
        Log.v(TAG, rawResult.getContents()); // Resultado del escaneo
        Log.v(TAG, rawResult.getBarcodeFormat().getName()); // Imprime lo escaneado

        // Éste método es para volver a usar la cámara
        mScannerView.resumeCameraPreview(this);
    }

    public void showMessage(String mensaje){
        MessageDialogFragment fragment = MessageDialogFragment.newInstance("Escaneo",mensaje,this);
        fragment.show(getSupportFragmentManager(),"");

    }

    @Override
    public void onDialogPositiveClick(android.support.v4.app.DialogFragment dialog) {
        mScannerView.resumeCameraPreview(this);
    }

}