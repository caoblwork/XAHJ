package com.evalley.xahj.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/**
 * @Description Activity工具类
 * 
 * @author 麻胜海
 * @date 2012-7-5 下午5:30:58
 */
public class ActivityUtils {
	
	/**
	 * 将Drawable转化为Bitmap
	 * 
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;

	}
	
	/**
	 * 获取当前程序版本号
	 * 
	 * @param ctx
	 * @return
	 */
	public static String getVersion(Context ctx) {
		PackageManager pm = ctx.getPackageManager();
		try {
			PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
			if (pi != null) {
				return pi.versionName;
			}
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "1.0";
	}
	
	/**
	 * 获取屏幕宽度
	 * 
	 * @return
	 */
	public static int getScreenWidth(Activity activity) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels;
	}
	
	/**
	 * 获取屏幕高度
	 * 
	 * @return
	 */
	public static int getScreenHeight(Activity activity) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.heightPixels;
	}
	
	/**
	 * 退出
	 */
	public static void quit(final Activity activity) {
		new AlertDialog.Builder(activity)
		//.setTitle("提示")
		.setMessage("确定要退出吗?")
		.setPositiveButton("确定", 
				new DialogInterface.OnClickListener() {
			
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//System.exit(0);
						//或者下面这种方式
						android.os.Process.killProcess(android.os.Process.myPid()); 
					}
				}	
		)
		.setNegativeButton("取消", null).show();
	}

}
