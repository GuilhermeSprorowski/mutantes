package br.com.tcc.ufpr.mutantescrud.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.tcc.ufpr.mutantescrud.models.Mutante;

public class MutantesDAO {
    private MutantesBDWrapper dbHelper;
    private String[] MUTANTES_TABLE_COLUMNS = {MutantesBDWrapper.MUTANTES_ID, MutantesBDWrapper.MUTANTES_NAME, MutantesBDWrapper.MUTANTES_SKILLS};
    private SQLiteDatabase database;

    public MutantesDAO(Context context){
        dbHelper = new MutantesBDWrapper(context);
    }
    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
    public boolean addMutante(Mutante mutante){
        ContentValues newMutante = new ContentValues();
        newMutante.put(MutantesBDWrapper.MUTANTES_NAME, mutante.getName());
        newMutante.put(MutantesBDWrapper.MUTANTES_SKILLS, mutante.getSkills());
        open();
        long id = database.insert(MutantesBDWrapper.MUTANTES, null, newMutante);
        close();
        if(id > 0) return true;
        return false;
    }
    public boolean updateMutante(Mutante mutante){
        long id = mutante.getId();
        open();
        ContentValues editMutante = new ContentValues();
        editMutante.put(MutantesBDWrapper.MUTANTES_ID, mutante.getId());
        editMutante.put(MutantesBDWrapper.MUTANTES_NAME, mutante.getName());
        editMutante.put(MutantesBDWrapper.MUTANTES_SKILLS, mutante.getSkills());
        String[] whereArgs = {Long.toString(mutante.getId())};
        try{
        database.update(MutantesBDWrapper.MUTANTES, editMutante,  MutantesBDWrapper.MUTANTES_ID + " = ?", whereArgs);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean deleteMutante(Mutante mutante){
        long id = mutante.getId();
        open();
        return database.delete(MutantesBDWrapper.MUTANTES, MutantesBDWrapper.MUTANTES_ID + " = " + id, null) > 0;
    }
    public ArrayList<Mutante> getAllMutantes(){
        ArrayList<Mutante>  mutantes = new ArrayList();
        open();
        Cursor cursor = database.query(MutantesBDWrapper.MUTANTES, MUTANTES_TABLE_COLUMNS, null, null, null, null, MutantesBDWrapper.MUTANTES_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            mutantes.add(parseMutante(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return mutantes;
    }

    private Mutante parseMutante(Cursor cursor){
        Mutante mutante = new Mutante();
        mutante.setId(cursor.getInt(0));
        mutante.setName(cursor.getString(1));
        mutante.setSkills(cursor.getString(2));
        return mutante;
    }


}
