package com.hjg.top;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.hjg.topactivity.topmodule.R;

public class TasksWindow {

    private static WindowManager.LayoutParams sWindowParams;
    private static WindowManager sWindowManager;
    private static View infoView;
    private static TextView tv_name;
    public static boolean isShow = false;

    private static void init(Context context) {
        if (infoView == null) {
            if (context == null) {
                return;
            }
            sWindowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            sWindowParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    Build.VERSION.SDK_INT <= Build.VERSION_CODES.N ? WindowManager.LayoutParams.TYPE_SYSTEM_ALERT : WindowManager.LayoutParams.TYPE_PHONE, 0x18,
                    PixelFormat.TRANSLUCENT);
            //部分机器可以使用TYPE_TOAST
            sWindowParams.gravity = Gravity.START | Gravity.TOP;
        }
    }

    //展示windowAlert
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void show(Context context, String text) {
        if (sWindowManager == null) {
            init(context);
            initView(context, text);
        } else {
            if (infoView == null) {
                initView(context, text);
            } else {
                tv_name.setText(text);
            }
        }
    }

    //消失
    public static void dismiss() {
        if (infoView == null) {
            Log.d("TasksWindow", "window already dismiss!!");
            return;
        }
        try {
            sWindowManager.removeView(infoView);
            infoView = null;
            isShow = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initView(Context context, String text) {
        infoView = LayoutInflater.from(context).inflate(R.layout.window_activity_info, null);
        tv_name = (TextView) infoView.findViewById(R.id.tv_name);
        tv_name.setText(text);
        try {
            sWindowManager.addView(infoView, sWindowParams);
            isShow = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //展示状态
    public static boolean isShow() {
        return isShow;
    }

}
