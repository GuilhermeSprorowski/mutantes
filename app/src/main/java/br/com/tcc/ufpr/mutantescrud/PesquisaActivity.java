package br.com.tcc.ufpr.mutantescrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.tcc.ufpr.mutantescrud.dao.MutantesDAO;
import br.com.tcc.ufpr.mutantescrud.models.Mutante;

public class PesquisaActivity extends AppCompatActivity implements TextWatcher {


    EditText txtSearch;
    ListView listView;
    MutantesDAO mutantesDAO;
    ArrayList<Mutante> mutantes;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        listView = (ListView) findViewById(R.id.listMutantes);
        txtSearch = (EditText)findViewById(R.id.txtSearch);
        txtSearch.addTextChangedListener(this);
        loadMutante();
    }

    public void loadMutante(){
        mutantesDAO = new MutantesDAO(this);
        mutantes = mutantesDAO.getAllMutantes();
        mutantesDAO.close();

        if(mutantes != null){
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mutantes);
            listView.setAdapter(adapter);

        }else{
            Toast.makeText(this, "Nenhum Mutante cadastrado", Toast.LENGTH_LONG);
        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String searchText = txtSearch.getText().toString().trim().toLowerCase();
        if( searchText!= null && !searchText.isEmpty()){
            ArrayList<Mutante> mutantesFound = new ArrayList<>();
            for (Mutante mutante: mutantes){
                if(mutante.getSkills().toLowerCase().contains(searchText) || mutante.getName().toLowerCase().contains(searchText)){
                    mutantesFound.add(mutante);
                    findViewById(R.id.txtNotFound).setVisibility(View.INVISIBLE);
                }
            }
            ArrayAdapter foundAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mutantesFound);
            listView.setAdapter(foundAdapter);
            if(mutantesFound.size() < 1){
                findViewById(R.id.txtNotFound).setVisibility(View.VISIBLE);
            }
        }else {
            findViewById(R.id.txtNotFound).setVisibility(View.INVISIBLE);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
