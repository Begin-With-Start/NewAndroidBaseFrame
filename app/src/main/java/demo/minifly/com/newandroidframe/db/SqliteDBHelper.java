package demo.minifly.com.newandroidframe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDBHelper extends SQLiteOpenHelper {

    public SqliteDBHelper(Context context) {
        /**
         * 第二个参数：数据库名字
         * 第三个参数：数据库版本
         */
        super(context, "minifly.db", null, 1);
    }

    // 主要创建表用
    public void onCreate(SQLiteDatabase db) {
        // 所有城市列表   操作数据库的时候_id不用管他，他会自动加1
        String sql = "create table citys (_id integer primary key not null,"
                + " id text,"
                + " country text,"
                + " province text,"
                + " city text,"
                + " district text)";
        db.execSQL(sql);

        String sqlPosition = "create table position (_id integer primary key not null,"
                + " serialNumber text,"
                + " position text)";
        db.execSQL(sqlPosition);

        String sqlContainers = "create table containers (_id integer primary key not null,"
                + " containerCode text,"
                + " containerUkid text,"
                + " proxyId text)";
        db.execSQL(sqlContainers);

    }

    // 数据库升级用， 当数据库版本加1的时候onUpgrade()就会走一遍
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
