package com.evalley.common;

import java.util.Locale;

import android.app.Activity;
import android.widget.Toast;

public class BaseActivity extends Activity {
	
	/**
	 * 标签
	 */
	protected String TAG = this.getClass().getSimpleName().toUpperCase(Locale.CHINA);
	
	/**
	 * 显示信息 - 时间短
	 * @param msg
	 */
	protected void showMessage(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 显示信息 - 时间长
	 * @param msg
	 */
	protected void showMessageLongTime(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

}
