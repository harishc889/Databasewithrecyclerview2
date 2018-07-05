package com.example.harish.databasewithrecyclerview;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    /*
     * Database details*/
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";
    List<Student> studentsList = new ArrayList<>();
    /*
     * Student_Record table details*/
    private static final String TABLE_NAME = "student_record";
    private static final String STUDENT_NAME = "student_name";
    private static final String STUDENT_ID = "student_id";
    private static final String STUDENT_COLLEGE = "student_college";
    private static final String STUDENT_FEES = "student_fees";
    private static final String STUDENT_PHONE_NUMBER = "student_phone";

    /*
     * Table structure*/
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
            STUDENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT, " +
            STUDENT_COLLEGE + " TEXT, " + STUDENT_FEES
            + " TEXT, " + STUDENT_PHONE_NUMBER + " INTEGER ); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }


    public long addNewStudent(Student studentModel) {
        /*using this.getWritableDatabase() we are actually taking permission to write in database */
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        /*contentvalues is like a dictionary of in which we have key and its values */
        contentValues.put(STUDENT_NAME, studentModel.name);
        contentValues.put(STUDENT_COLLEGE, studentModel.collegeName);
        contentValues.put(STUDENT_FEES, studentModel.fees);
        contentValues.put(STUDENT_PHONE_NUMBER, studentModel.phoneNumber);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

        return id;
    }

    public Student getSingleStudentDetails(long id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{STUDENT_ID, STUDENT_NAME, STUDENT_COLLEGE, STUDENT_FEES,
                        STUDENT_PHONE_NUMBER}, STUDENT_ID + "=?", new String[]{String.valueOf(id)}, null, null,
                null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Student studentModel = new Student(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)),
                cursor.getString(cursor.getColumnIndex(STUDENT_NAME)),
                cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE)),
                cursor.getInt(cursor.getColumnIndex(STUDENT_FEES)),
                cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)));

        cursor.close();

        return studentModel;
    }

    public List<Student> allStudentsDetails() {


        String selectQuery = " SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student studentModel = new Student();
                studentModel.setId(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)));
                studentModel.setName(cursor.getString(cursor.getColumnIndex(STUDENT_NAME)));
                studentModel.setCollegeName(cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE)));
                studentModel.setFees(cursor.getInt(cursor.getColumnIndex(STUDENT_FEES)));
                studentModel.setPhoneNumber(cursor.getLong(cursor.getColumnIndex(STUDENT_PHONE_NUMBER)));

                studentsList.add(studentModel);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();

        return studentsList;
    }

    public int getStudentsCount() {

        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        int totalStudentsCount = cursor.getCount();
        cursor.close();

        return totalStudentsCount;
    }

    public int updateIndividualStudentDetails(Student studentModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME, studentModel.getName());
        values.put(STUDENT_COLLEGE, studentModel.getCollegeName());
        values.put(STUDENT_FEES, studentModel.getFees());
        values.put(STUDENT_PHONE_NUMBER, studentModel.getPhoneNumber());

        // updating row
        return sqLiteDatabase.update(TABLE_NAME, values, STUDENT_ID + " = ?",
                new String[]{String.valueOf(studentModel.getId())});
    }

    public List<Student> allStudentsDetail() {
        return studentsList;
    }
}
