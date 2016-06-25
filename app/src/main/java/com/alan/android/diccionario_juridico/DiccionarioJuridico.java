package com.alan.android.diccionario_juridico;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

/**
 * Created by Alan on 11/05/2016.
 */
public class DiccionarioJuridico extends AppCompatActivity {
    SqlLiteDbHelper dbHelper;
    Diccionario diccionario ;

    private EditText etnombre;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diccionario_juridico);
        dbHelper = new SqlLiteDbHelper(this);
        dbHelper.openDataBase();
        diccionario = new Diccionario();
        diccionario = dbHelper.Get_Diccionario();

        etnombre=(EditText)findViewById(R.id.txtnombre);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);

        tv2.setText(diccionario.getNombre());
        tv1.setText(diccionario.getSignificado());
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void Buscar(View v) {

        SqlLiteDbHelper nomb=new SqlLiteDbHelper (this);

        SQLiteDatabase db = nomb.getWritableDatabase();

        String nom = etnombre.getText().toString();


        Cursor fila = db.rawQuery("SELECT * FROM diccionario where nombre ='"+nom+"'", null);
        if (fila.moveToFirst()){
            tv2.setText(fila.getString(0));
            tv1.setText(fila.getString(1));

        } else
            makeText(this,"No existe la Palabra vuelva a buscar :-)", LENGTH_LONG).show();
        db.close();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.acercade:
                Intent intenta = new Intent(DiccionarioJuridico.this, Acercade.class);
                startActivity(intenta);
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
