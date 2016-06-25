package com.alan.android.diccionario_juridico;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Bienvenida extends AppCompatActivity {

    final int Bienvenida		= 25;

    TextView linea_ayuda;
    ProgressBar mProgressBar;
    int progreso=0;
    int paso = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);
        mProgressBar=(ProgressBar) findViewById(R.id.progressbar);
        linea_ayuda = (TextView) findViewById(R.id.linea_ayuda);
    }
    @Override
    protected void onResume() {
        super.onResume();

        linea_ayuda.setText("");
        cuentaAtras(3000);


    }

    private void cuentaAtras(long milisegundos){
        CountDownTimer mCountDownTimer;

        mProgressBar.setMax((int)milisegundos);

        mProgressBar.setProgress(paso);

        mCountDownTimer=new CountDownTimer(milisegundos, paso) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ progreso+ millisUntilFinished);
                progreso+=paso;
                mProgressBar.setProgress(progreso);

            }

            @Override
            public void onFinish() {

                progreso+=	paso;
                mProgressBar.setProgress(progreso);
                mProgressBar.setVisibility(View.INVISIBLE);
                Intent i = new Intent ("android.intent.diccionario_juridico.ACTIVITY_MAIN");
                startActivityForResult(i, Bienvenida);

            }
        };

        mCountDownTimer.start();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==Bienvenida)
            finish();
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}
