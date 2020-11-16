package com.example.projectmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;

public class DB_sqlite extends SQLiteOpenHelper {
    public static final String Db_name = "MbrankingV1";

    public DB_sqlite( Context context) {
        super(context, Db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user_ (id int primary key autoincrement ,username text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user_");
        onCreate(sqLiteDatabase);
    }
    //create Method Add new User
    public String InsertUser(String username,String password){
        Integer s = SearchUserId(username);
        String msg ;
        if(s == -1){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues v = new ContentValues();
            v.put("username",username);
            v.put("password",password);
            long a = db.insert("user_",null,v);
            if(a == -1){
                msg = "false";
            }
            else{
                msg = "true";
            }
        }else{
            msg = "exists";
        }
        return msg;
    }
    //Search User in Database
    public Integer SearchUserId(String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor crs = db.rawQuery("select * from user_ where username = ?",new String[]{username});
        if(crs.getCount() > 0){
            return Integer.parseInt(String.valueOf(crs.getColumnIndex("id")));
        }else{
            return -1;
        }
    }
    //Search User with id in database
    public String SearchUser(String id){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from user_ where id = "+id;
        Cursor crs = db.rawQuery(sql,null);
        if(crs != null){
            return String.valueOf(crs.getColumnIndex("username"));
        }else{
            return "Error";
        }
    }
    //Method for Login
    public String LoginUser(String username,String pass){
        String msg = "false";
        SQLiteDatabase db = getReadableDatabase();
        Cursor crs = db.query("user_",new String []{"id"},"username = ? and password = ?",new String[]{username,pass},null,null,null);
        int count = crs.getCount();
        crs.close();
        db.close();
        if(count > 0){
            msg = "true";
        }
        return msg;
    }
}
