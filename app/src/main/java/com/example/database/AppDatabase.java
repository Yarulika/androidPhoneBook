package com.example.database;

import android.content.Context;
import android.content.Entity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Applying singleton design pattern for database (we working in main thread)
 * Because using Room DB it is not recommended to use in the main thread
 * but we can do it for training  purpose, and we must use singleton because
 * the instantiating the object is expensive...
 *
 * */

@Database(entities = {User.class,PhoneUser.class},version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    //DAO to manipulate the databases
    public abstract PhoneUserDAO phoneUserDAO();
    public abstract UserDAO userDAO();

    private static final String db_name ="phoneBook.db";
    private static AppDatabase instanceDB;

    public static AppDatabase getInstance(final Context context){

        if (instanceDB == null)
        synchronized (AppDatabase.class){
            instanceDB = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, db_name).addMigrations(MIGRATION_1_2).allowMainThreadQueries().build();
        }
        return instanceDB;
    }

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //we need to override this method just in case we made changes inside entities and here we have to write
            //queries with the update we made, for example in case we added one more column or changed name.
        }
    };
}