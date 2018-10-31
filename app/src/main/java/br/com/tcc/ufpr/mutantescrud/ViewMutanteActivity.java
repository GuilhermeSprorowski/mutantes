package br.com.tcc.ufpr.mutantescrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.tcc.ufpr.mutantescrud.dao.MutantesDAO;
import br.com.tcc.ufpr.mutantescrud.models.Mutante;

public class ViewMutanteActivity extends AppCompatActivity {

    private Mutante mutante;
    private MutantesDAO mutantesDAO;
    EditText name;
    EditText hab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mutante);
        name = (EditText) findViewById(R.id.txtName);
        hab = (EditText) findViewById(R.id.txtHabilidade);

        mutantesDAO = new MutantesDAO(this);

        Intent intent = getIntent();
        if (intent != null) {
            mutante = (Mutante) intent.getSerializableExtra("mutante");
            if (mutante != null) {
                name.setText(mutante.getName());
                hab.setText(mutante.getSkills());
            }
        }
    }

    public void onSalvar(View view) {
        mutante.setName(name.getText().toString().trim());
        mutante.setSkills(hab.getText().toString().trim());
        if(mutantesDAO.updateMutante(mutante)) {
            Toast.makeText(this, "Mutante Salvo", Toast.LENGTH_LONG);
            finish();
        }else
            Toast.makeText(getApplicationContext(), "Nome duplicado", Toast.LENGTH_LONG).show();
        mutantesDAO.close();

    }

    public void onDeletar(View view) {
        mutantesDAO.deleteMutante(mutante);
        System.out.println("ID: " + mutante.getId());
        mutantesDAO.close();
        Toast.makeText(this, "Deletado com Sucesso", Toast.LENGTH_LONG);
        finish();
    }
}
