package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PhoneUserDAO {

    @Query("SELECT * FROM phoneUsers WHERE name = :name or number = :number LIMIT 1;")
    PhoneUser getUserByNameOrPhone(String name,String number);

    @Query("SELECT * FROM phoneUsers;")
    List<PhoneUser> getAllPhoneUsers();

    @Insert
    void insertPhoneUser(PhoneUser phoneUser);

    @Delete
    void deletePhoneUser(PhoneUser phoneUser);

    @Update
    void updatePhoneUser(PhoneUser phoneUser);
}
