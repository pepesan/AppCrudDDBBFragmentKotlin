package com.example.appcrudddbbfragmentkotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ClientSqliteHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        Log.d("app","Creating Database")
        dropAndCreate(db)

    }

    override fun onUpgrade(db: SQLiteDatabase,
                           oldVersion:Int,
                           newVersion:Int) {
        Log.d("app","Updating Database from $oldVersion to $newVersion")
        /*
        if (oldVersion == 1 && newVersion == 2)
        {

            db.execSQL("alter table " + PERSON_TABLE
                    + " add column "
                    + PERSON_PHOTOPATH + " text")
            db.execSQL("alter table " + PERSON_TABLE +
                    " add column " + PERSON_THUMBPHOTOPATH
                    + " text")
            db.execSQL("alter table " + PERSON_TABLE + " add column "
                    + PERSON_LOCATION + " text")
            db.execSQL("alter table " + PERSON_TABLE + " add column "
                    + PERSON_LATITUDE + " real")
            db.execSQL("alter table " + PERSON_TABLE + " add column "
                    + PERSON_LONGITUDE + " real")



        }
        */
        Log.d("app", "database actualizada")
    }
    protected fun dropAndCreate(db: SQLiteDatabase) {
        db.execSQL("drop table if exists $CLIENT_TABLE;")

        /*

        db.execSQL("drop table if exists $VALORATION_TABLE;")
        */
        createTables(db)
    }

    protected fun createTables(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + CLIENT_TABLE + " (" +
                    CLIENT_ID + " integer primary key autoincrement " +
                    "not null," +
                    CLIENT_NAME + " text not null" + ");")
        Log.d("app", "$CLIENT_TABLE created")
        /*
        db.execSQL(
            "create table " + PERSON_TABLE + " (" +
                    PERSON_ID + " integer primary key autoincrement " +
                    "not null," +
                    PERSON_NAME + " text not null," +
                    PERSON_TLF + " text," +
                    PERSON_GLOBAL + " text," +
                    PERSON_PHOTOPATH + " text, " +
                    PERSON_THUMBPHOTOPATH + " text, " +
                    PERSON_LOCATION + " text, " +
                    PERSON_LATITUDE + " real, " +
                    PERSON_LONGITUDE + " real " +
                    ");"
        )
        db.execSQL(
            ("create table " + VALORATION_TABLE + " (" +
                    VALORATION_ID + " integer primary key " +
                    "autoincrement not null," +
                    PERSON_ID + " integer," +
                    VALORATION_FACE + " float," +
                    VALORATION_BOOBS + " float," +
                    VALORATION_BUTT + " float," +
                    VALORATION_NOTE + " text " +
                    PERSON_ID + " REFERENCES " + PERSON_TABLE + "("
                    + PERSON_ID + ") "
                    + "ON DELETE CASCADE);")
        )

         */
        Log.d("app", "Database Schema created")
    }

    companion object {

        val VERSION = 1
        val DB_NAME = "client_db.sqlite"
        val CLIENT_TABLE = "client"
        val CLIENT_ID = "client_id"
        val CLIENT_NAME = "client_name"
    }

}
