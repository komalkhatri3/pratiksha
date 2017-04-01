package com.harsh.nandy.cancerantidote;

/*
 * Created by Shree on 3/26/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

@SuppressWarnings({"WeakerAccess", "FieldCanBeLocal", "unused"})
public class DatabaseHolder {
    private static final String database_name = "CancerAntidote";
    private static final int database_version = 1;

    private static final String patient_aadhar = "aadharNumber";
    private static final String patient_name = "Name";
    private static final String patient_contact = "contact";
    private static final String patient_email = "email";
    private static final String patient_gender = "gender";
    private static final String patient_age = "age";
    private static final String patient_disease = "disease";
    private static final String patient_doctorID = "doctorID";
    private static final String patient_nextAppointment = "nextAppointment";
    private static final String patient_hospitalID = "hospitalID";
    private static final String patient_address = "address";

    private static final String doctor_tableName = "Doctor";
    private static final String nurse_tableName = "Nurse";
    public static final String hospital_tableName = "Hospital";
    public static final String ambulance_tableName = "Ambulance";
    private static final String patient_tableName = "Patient";

    private static final String create_table_doctor = "create table if not exists Doctor (id text not null primary key, Name text not null, SpecialisedField text not null, contact int not null);";

    private static final String create_table_hospital = "create table if not exists Hospital (id integer not null primary key , Name text not null, address text not null, ambulanceCount int not null, userRating int not null);";

    private static final String create_table_ambulance = "create table if not exists Ambulance (id text not null primary key , stateIn text not null, hospital text not null, availability int not null, FOREIGN KEY (hospital) REFERENCES Hospital(id));";

    private static final String create_table_nurse = "create table if not exists Nurse (id text not null primary key, Name text not null, contact int not null, available int not null, hospitalID text not null, FOREIGN KEY (hospitalID) REFERENCES Hospital(id));";

    private static final String create_table_patient = "create table if not exists Patient (aadharNumber bigint not null primary key, Name text not null, contact bigint not null, email text not null, gender text not null, age int not null, disease text not null, doctorID text not null, nextAppointment blob not null, hospitalID text not null, address blob not null, FOREIGN KEY (doctorID) REFERENCES Doctor(id), FOREIGN KEY (hospitalID) REFERENCES Hospital(id));";

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    public DatabaseHolder(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    public DatabaseHolder open() {
        db  = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public long insertPatientData(String aadhar, String name, String contact, String email,
                                  String gender, String age, String disease, String doctorID,
                                  String nextAppointment, String hospitalID, String address) {
        ContentValues content = new ContentValues();
        content.put(patient_aadhar, aadhar);
        content.put(patient_name, name);
        content.put(patient_contact, contact);
        content.put(patient_email, email);
        content.put(patient_gender, gender);
        content.put(patient_age, age);
        content.put(patient_disease, disease);
        content.put(patient_doctorID, doctorID);
        content.put(patient_nextAppointment, nextAppointment);
        content.put(patient_hospitalID, hospitalID);
        content.put(patient_address, address);
        return db.insertOrThrow(patient_tableName, null, content);
    }

    public long insertHospitalData(String id, String name, String address, String ambulanceCount, String userRating){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("Name", name);
        contentValues.put("address", address);
        contentValues.put("ambulanceCount", ambulanceCount);
        contentValues.put("userRating", userRating);
        return db.insertOrThrow(hospital_tableName, null, contentValues);
    }

    public long insertAmbulanceData(String state, String hospital){
        ContentValues contentValues = new ContentValues();
        contentValues.put("stateIn", state);
        contentValues.put("hospital", hospital);
        contentValues.put("availability", "1");
        return db.insertOrThrow(ambulance_tableName, null, contentValues);
    }

    public long deletePatientData(String aadhar) {
        return db.delete(patient_tableName, "aadharNumber = '"+aadhar+"'", null);
    }

    public long deleteAllPatientData(){
        return db.delete(patient_tableName, "1", null);
    }

    public Cursor returnPatientData() {
        Cursor cursor = null;
        try{
            cursor = db.query(patient_tableName, new String[] {
                    patient_aadhar, patient_name, patient_contact,
                    patient_email, patient_gender, patient_age, patient_disease,
                    patient_doctorID, patient_nextAppointment, patient_hospitalID, patient_address
            }, null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }

    public Cursor returnDoctorData(){
        Cursor cursor = null;
        try{
            cursor = db.query(doctor_tableName, new String[]{"Name", "SpecialisedField", "contact"}, null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }

    public Cursor returnNurseData() {
        Cursor cursor = null;
        try{
            cursor = db.query(nurse_tableName, new String[]{"Name", "available", "contact"}, null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }

    public Cursor returnHospitalData() {
        Cursor cursor = null;
        try{
            cursor = db.query(hospital_tableName, new String[]{"Name", "address", "ambulanceCount", "userRating"}, null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }

    public Cursor returnAmbulanceData() {
        Cursor cursor = null;
        try{
            cursor = db.query(ambulance_tableName, new String[]{"id", "stateIn", "hospital", "availability"}, null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }

    public Cursor returnSelectedStateAmbulanceAvailability(String state){
        Cursor cursor = null;
        try{
            cursor = db.query(true, ambulance_tableName, new String[]{"id", "hospital", "availability"}, "stateIn = '"+ state +"'", null, null, null, null, null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }
    public Cursor getListuser()
    {
        Cursor cursor=null;
        try{
            cursor=db.query(true, hospital_tableName,new String[]{"hospital"},null,null,null,null,"userRating",null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }
    public Cursor getListarea(String state)
    {
        Cursor cursor=null;
        try {
            cursor=db.query(true,hospital_tableName,new String[]{"hospital"},"state='"+ state +"'",null,null,null,null,null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }
    public Cursor getListspecialization(String specialization)
    {
        Cursor cursor=null;
        try {
            cursor=db.query(true,hospital_tableName,new String[]{"hospital"},"specialization='"+ specialization +"'",null,null,null,null,null);
        }
        catch (SQLiteException e){
            if (e.getMessage().contains("no such table")){
                Toast.makeText(context, "ERROR: Table doesn't exist!", Toast.LENGTH_SHORT).show();
                // create table
                // re-run query, etc.
            } else e.printStackTrace();
        }
        return cursor;
    }


    public void resetTables(){
        db.execSQL("DROP TABLE IF EXISTS Doctor");
        db.execSQL("DROP TABLE IF EXISTS Nurse");
        db.execSQL("DROP TABLE IF EXISTS Hospital");
        db.execSQL("DROP TABLE IF EXISTS Patient");
        db.execSQL("DROP TABLE IF EXISTS Ambulance");
        try{
            db.execSQL(create_table_doctor);
            db.execSQL(create_table_hospital);
            db.execSQL(create_table_ambulance);
            db.execSQL(create_table_nurse);
            db.execSQL(create_table_patient);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, database_name, null, database_version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(create_table_doctor);
                db.execSQL(create_table_hospital);
                db.execSQL(create_table_ambulance);
                db.execSQL(create_table_nurse);
                db.execSQL(create_table_patient);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Doctor");
            db.execSQL("DROP TABLE IF EXISTS Hospital");
            db.execSQL("DROP TABLE IF EXISTS Ambulance");
            db.execSQL("DROP TABLE IF EXISTS Nurse");
            db.execSQL("DROP TABLE IF EXISTS Patient");
            onCreate(db);
            if(newVersion>oldVersion)
            {
                db.execSQL("ALTER TABLE Hospital ADD COLUMN state TEXT");
                db.execSQL("ALTER TABLE Hospital ADD COLUMN specialization TEXT");
            }
        }
    }
}