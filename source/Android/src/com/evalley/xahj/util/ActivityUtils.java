package com.evalley.xahj.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * @Description Activity工具类
 * 
 * @author 麻胜海
 * @date 2012-7-5 下午5:30:58
 */
public class ActivityUtils {
	
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
