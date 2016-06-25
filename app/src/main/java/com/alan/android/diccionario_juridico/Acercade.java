package com.alan.android.diccionario_juridico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Alan on 11/05/2016.
 */
public class Acercade extends Activity{
    private String x;
    private TextView TxtAcercade;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);
        x = ("Esta aplicacion fue desarrollada \n por Richard Alan Brañez Paredes \n");
        TxtAcercade = (TextView) findViewById(R.id.txtacercade);
        TxtAcercade.setText(x);

    }
}
