package com.example.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.Setter;

@Setter
@Entity(indices = {@Index(value = {"name","number"},unique = true)},tableName = "phoneUsers")
public class PhoneUser {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String name;
    @ColumnInfo
    public String number;

    public PhoneUser(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
