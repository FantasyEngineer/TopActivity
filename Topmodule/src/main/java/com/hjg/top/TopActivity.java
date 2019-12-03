package com.hjg.top;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;


/**
 * window管理类
 */

public enum TopActivity {
    INSTANCE;

    @TargetApi(Build.VERSION_CODES.M)
    public void show(Context context) {
        TopActivity.INSTANCE.ShowInApplication(context);
    }


    /**
     * 应用内---展示栈顶的activity
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void ShowInApplication(Context context) {
        if (Settings.canDrawOverlays(context)) {//有权限
            if (PermissionUtil.isServiceRunning(context, WatchingService.class.getName())) {
                Toast.makeText(context, "请勿重复运行服务", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "开启运行", Toast.LENGTH_SHORT).show();
                context.startService(new Intent(context, WatchingService.class));
            }
        } else {//无权限
            Toast.makeText(context, "需要开启权限", Toast.LENGTH_SHORT).show();
            PermissionUtil.startSetting(context);//跳转到设置界面
        }
    }

//    /**
//     * 应用外，应用内均展示栈顶的activity
//     */
//    public void ShowOutApplication(Context context) {
//
//
//    }

    /**
     * 普通的show（如果已经存在，则是更改显示的内容）
     *
     * @param context
     * @param content
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void show(Context context, String content) {
        if (Settings.canDrawOverlays(context)) {//有权限
            TasksWindow.show(context, content);
        } else {//无权限
            PermissionUtil.startSetting(context);//跳转到设置界面
        }
    }

    /**
     * 全局的消失
     */
    private void dismiss() {
        TasksWindow.dismiss();
    }

    /**
     * 全局的消失
     */
    public void dismiss(Context context) {
        if (PermissionUtil.isServiceRunning(context, WatchingService.class.getName())) {
            context.stopService(new Intent(context, WatchingService.class));
        }
        dismiss();
    }

}
