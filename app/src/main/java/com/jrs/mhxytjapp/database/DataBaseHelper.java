package com.jrs.mhxytjapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jrs.mhxytjapp.R;
import com.jrs.mhxytjapp.Utils.XMLPullUtils;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    // 数据库名
    private static final String DATABASE_NAME = "MHXYTJ.db";
    // 数据库版本号，每次升级时增加
    private static final int DATABASE_VERSION = 1;
    Context mContext;
    private List<String> tableList;

    // 构造函数
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
        tableList = XMLPullUtils.getAllTable(context.getResources().openRawResource(R.xml.tablelist));
    }

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    // 当数据库首次创建时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String tableSql : tableList){
            db.execSQL(tableSql);
        }
    }

    // 当数据库版本需要升级时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 根据版本号差异执行相应的升级逻辑，例如添加新表、删除旧表、修改列等
        // 示例：删除旧表并重新创建新表（仅作演示，实际操作需谨慎）
        db.execSQL("DROP TABLE IF EXISTS your_table_name");
        onCreate(db);
    }
}
