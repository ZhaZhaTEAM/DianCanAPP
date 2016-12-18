package com.example.jc.store.com.team.helper;


import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImportDB {
    private final int BUFFER_SIZE = 10000;
    public static final String DB_NAME = "store.db"; // 保存的数据库文件名
    public static final String PACKAGE_NAME = "com.example.jc.store";// 工程包名
    public static final String DB_PATH = "/data/data/com.example.jc.store/files/";
           /* + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME + "/databases"; // 在手机里存放数据库的位置*/
    public Context context;

    public ImportDB(Context context) {
        this.context = context;
    }

    public void copyDatabase(Context context) {
        String dbfile = DB_PATH +  DB_NAME;
        File path = context.getDatabasePath(DB_NAME);
        System.out.println(path);
        if (path.exists()) {
            System.out.println(path);
            return;
        }
        File f=new File(dbfile);
        if (!f.exists()){
            if (f.getParentFile().mkdirs()){}
        }
        try {
            // 执行数据库导入
            InputStream is = this.context.getResources().getAssets().open("store.db"); // 欲导入的数据库

            FileOutputStream fos = new FileOutputStream(f.getPath());
            byte[] buffer = new byte[BUFFER_SIZE];
            int count = 0;
            while ((count = is.read(buffer)) > 0) {
                fos.write(buffer, 0, count);
            }
            fos.close();// 关闭输出流
            is.close();// 关闭输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
