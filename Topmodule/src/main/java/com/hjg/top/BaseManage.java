package com.hjg.top;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.view.menu.ShowableListMenu;

/**
 * Created by Administrator on 2017/12/21.
 */
interface BaseManage {
    void ShowInApplication(Context context);

    void show(Context context, String content);

    void dismiss();

    void dismiss(Context context);
}
