package br.com.tcc.ufpr.mutantescrud;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.tcc.ufpr.mutantescrud.dao.MutantesDAO;
import br.com.tcc.ufpr.mutantescrud.models.Mutante;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    MutantesDAO mutantesDAO;
    ArrayList<Mutante> mutantes;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listView = (ListView) findViewById(R.id.listMutantes);
        listView.setOnItemClickListener(this);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Mutante mutanteClick = (Mutante) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, ViewMutanteActivity.class);
        intent.putExtra("mutante", mutanteClick);
        startActivity(intent);

    }

    @Override
    public void onResume(){
        loadMutante();
        super.onResume();

    }

}
