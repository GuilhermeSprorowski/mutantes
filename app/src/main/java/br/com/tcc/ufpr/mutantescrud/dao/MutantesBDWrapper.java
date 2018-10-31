package br.com.tcc.ufpr.mutantescrud.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MutantesBDWrapper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Mutantes.db";
    public static final String MUTANTES = "Mutantes";
    public static final String MUTANTES_ID = "_id";
    public static final String MUTANTES_NAME = "_name";
    public static final String MUTANTES_SKILLS = "_skills";


    public static final int DATABASE_VERSION = 3;

    public static final String DBASE_CREATE = "create table " +MUTANTES+ "("
            + MUTANTES_ID + " integer primary key autoincrement, "
            +MUTANTES_NAME+ " text not null unique,"
            +MUTANTES_SKILLS +" text);";

    public MutantesBDWrapper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(DBASE_CREATE);
        db.execSQL(DBASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ MUTANTES);
        onCreate(db);
    }

}
