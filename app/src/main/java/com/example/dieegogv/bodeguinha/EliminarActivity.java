package com.example.dieegogv.bodeguinha;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
class EliminarActivity extends StockActivity implements Destroyable{
    public void onCreate (Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_eliminar);
    }
}
