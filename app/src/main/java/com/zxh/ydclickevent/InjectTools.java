package com.zxh.ydclickevent;

import android.app.Activity;
import android.view.View;

import com.zxh.annotation.ClickView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InjectTools {
    public static void inject(final Activity activity){
        Class<? extends Activity> clazz = activity.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            method.setAccessible(true);
            ClickView clickView = method.getAnnotation(ClickView.class);
            if(clickView==null){
                continue;
            }
            int[] values = clickView.value();
            for (int value : values) {
                activity.findViewById(value).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            method.invoke(activity,v);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
