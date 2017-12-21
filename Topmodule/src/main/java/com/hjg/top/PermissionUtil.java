package com.hjg.top;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Administrator on 2017/12/21.
 */

public class PermissionUtil {

    /**
     * 检查权限
     *
     * @param context
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static boolean checkSystemAlertPermission(Context context) {
        if (Settings.canDrawOverlays(context)) {
        } else {

        }
//        requestFloatWindowPermissionIfNeeded();
        return EasyPermissions.hasPermissions(context, Manifest.permission.SYSTEM_ALERT_WINDOW);
    }

    /**
     * 调换到悬浮窗权限设置界面
     *
     * @param context
     */
    public static void startSetting(Context context) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + context.getApplicationContext().getPackageName()));
        context.startActivity(intent);
    }

    /**
     * 判断一个服务是否正在运行
     *
     * @param context
     * @param serviceName
     * @return
     */
    public static boolean isServiceRunning(Context context, String serviceName) {
        boolean isRunning = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> lists = am.getRunningServices(200);

        for (ActivityManager.RunningServiceInfo info : lists) {//判断服务
            if (info.service.getClassName().equals(serviceName)) {
                isRunning = true;
            }
        }
        return isRunning;
    }

}
