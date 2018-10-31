package br.com.tcc.ufpr.mutantescrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

import br.com.tcc.ufpr.mutantescrud.dao.MutantesDAO;
import br.com.tcc.ufpr.mutantescrud.models.Mutante;

public class MutanteCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutante_cadastro);


    }

    public void onCadastrar(View view) {
        MutantesDAO mutantesDAO = new MutantesDAO(this);
        EditText name = (EditText) findViewById(R.id.txtName);
        EditText hab =(EditText) findViewById(R.id.txtHabilidade);
        Mutante mutante = new Mutante(name.getText().toString().trim(), hab.getText().toString().trim());

        if(mutantesDAO.addMutante(mutante)){
            Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
            finish();
        }else
            Toast.makeText(getApplicationContext(), "Nome duplicado", Toast.LENGTH_LONG).show();

    }
}
