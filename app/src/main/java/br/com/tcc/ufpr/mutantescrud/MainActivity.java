package br.com.tcc.ufpr.mutantescrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callScreen(Class<?> activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public void onCadastroClick(View view){
        callScreen(MutanteCadastroActivity.class);
    }

    public void onListarClick(View view) {
        callScreen(ListaActivity.class);
    }

    public void onPesquisarClick(View view) {
        callScreen(PesquisaActivity.class);
    }

    public void onSair(View view) {
        finish();
    }
}
