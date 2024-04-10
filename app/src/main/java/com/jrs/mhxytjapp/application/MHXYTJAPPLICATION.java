package com.jrs.mhxytjapp.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jrs.mhxytjapp.database.DataBaseHelper;

public class MHXYTJAPPLICATION extends Application {

    // 定义一个静态变量来持有全局Context引用
    private static MHXYTJAPPLICATION sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化全局Context引用
        sInstance = this;

        // 在这里进行应用程序启动时的全局初始化工作

        // 1. 初始化第三方库
        // 示例：初始化日志库、网络库、数据库、缓存库等
        // YourThirdPartyLibrary.initialize(this);

        // 2. 注册全局异常处理
        // 示例：使用第三方库或自定义实现捕获未处理的异常
        // registerUncaughtExceptionHandler();

        // 3. 初始化全局配置信息
        // 示例：读取并设置主题、字体、API密钥等
        // setupGlobalConfigurations();

        // 4. 初始化数据持久化组件（如Room数据库、SharedPreferences）
        // 初始化数据库、缓存或其他需要在应用启动时初始化的数据存储组件
        // initializeDataStorage();

        // 5. 注册全局事件总线（如EventBus、LiveDataBus）
        // 示例：如果您的项目使用了事件总线，可以在这里注册
        // EventBus.getDefault().register(this);

        // 6. 初始化全局服务（如后台任务、定时任务）
        // 示例：启动后台服务、JobScheduler等
        // startBackgroundServices();

        // ... 其他需要在应用启动时执行的初始化操作

        //创建数据库
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // 可以选择关闭数据库连接，通常情况下数据库对象会在不使用时自动关闭
        // db.close();
    }

    /**
     * 获取全局Context实例
     */
    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    /**
     * 示例方法：注册全局未捕获异常处理器
     */
    private void registerUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // 处理异常逻辑，如记录日志、发送错误报告等
                // Log.e("MyApplication", "Uncaught Exception:", e);
                // sendCrashReport(e);

                // 如果需要保留系统默认的异常处理行为，可以调用父类方法
                // 默认情况下，这将导致应用崩溃并显示异常堆栈信息
                // DefaultExceptionHandler.handleException(t, e);
            }
        });
    }

    /**
     * 示例方法：设置全局配置信息
     */
    private void setupGlobalConfigurations() {
        // 从资源配置文件或远程服务器获取并设置全局配置
        // 示例：设置全局主题、字体、API密钥等
    }

    /**
     * 示例方法：初始化数据持久化组件
     */
    private void initializeDataStorage() {
        // 初始化数据库、缓存或其他需要在应用启动时初始化的数据存储组件
    }

    /**
     * 示例方法：启动全局服务
     */
    private void startBackgroundServices() {
        // 启动后台服务、JobScheduler等
    }
}
