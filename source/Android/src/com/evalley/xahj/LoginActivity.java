package com.evalley.xahj;

import android.accounts.Account;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.evalley.xahj.persistent.LoginSharedPreferencesHelper;
import com.evalley.xahj.util.StringUtils;
import com.evalley.xahj.vo.LoginInfo;

/**
 * @Description 登录
 * 
 * @author 麻胜海
 * @date 2013-2-18 下午2:36:30
 */
public class LoginActivity extends Activity {

	/**
	 * 登录
	 */
	private static final int LOGIN = 0;
	/**
	 * 账号
	 */
	private EditText mobilephoneExt;
	/**
	 * 密码
	 */
	private EditText passwdExt;
	/**
	 * 记住密码
	 */
	private CheckBox rememberPasswdChk;
	/**
	 * 登录
	 */
	private Button loginBtn;
	/**
	 * 等待对话框
	 */
	private ProgressDialog progressDialog;
	/**
	 * 处理器
	 */
	private Handler handler;

	/**
	 * 登录信息
	 */
	private Account account;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_login);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		init();
	}

	private void init() {
		TextView title = (TextView) findViewById(R.id.title_text);
		title.setText("用 户 登 录");
		title.getPaint().setFakeBoldText(true);

		mobilephoneExt = (EditText) findViewById(R.id.mobilephoneExt);
		// TODO 测试
		// mobilephoneExt.setText("13571826703");
		passwdExt = (EditText) findViewById(R.id.passwdExt);
		// TODO 测试
		// passwdExt.setText("123456");
		rememberPasswdChk = (CheckBox) findViewById(R.id.rememberPasswdChk);
		loginBtn = (Button) findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (prepare()) {
					progressDialog = ProgressDialog.show(LoginActivity.this, "", "登录中...", true, true);
					new Thread(new Runnable() {
						@Override
						public void run() {
							login();
							handler.sendEmptyMessage(LOGIN);
						}
					}).start();
				}
			}
		});

		handler = new Handler() {
			public void handleMessage(Message msg) {
				progressDialog.dismiss();
//				switch (msg.what) {
//					case LOGIN:
//						if (response != null) {
//							if (response.isSuccess()) {
//								LoginSharedPreferencesHelper.saveLoginInfo(getApplicationContext(), populateLoginInfo());
//								Toast.makeText(LoginActivity.this, "登录成功.", Toast.LENGTH_SHORT).show();
//								initUserInfo();
//								
//							} else {
//								//Toast.makeText(LoginActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
//							}
//						} else {
//							Toast.makeText(LoginActivity.this, "连接服务失败.", Toast.LENGTH_SHORT).show();
//						}
//						break;
//				}
				forward();
			}
		};
		// 初始化记住密码信息
		initLoginInfo();
	}
	
	/**
	 * 初始化用户信息
	 */
	private void initUserInfo() {
		// 将用户信息写入常量类，供其他功能使用
//		Account loginUser = response.getBean();
//		Constants.user.setLoginId(loginUser.getLoginId());
//		Constants.user.setPasswd(loginUser.getPasswd());
//		Constants.user.setAvatar(loginUser.getAvatar());
//		Constants.user.setEmail(loginUser.getEmail());
//		Constants.user.setHeadImg(loginUser.getHeadImg());
//		Constants.user.setMobilephone(loginUser.getMobilephone());
//		Constants.user.setName(loginUser.getName());
//		Constants.user.setId(loginUser.getId());
//		Constants.user.setGender(loginUser.getGender());
	}
	
	/**
	 * 进入主界面
	 */
	private void forward() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainTab.class);
		intent.putExtra("needUpdate", getIntent().getBooleanExtra("needUpdate", false));
		LoginActivity.this.startActivity(intent);
		overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
		finish();
	}

	/**
	 * 初始化登录信息
	 */
	private void initLoginInfo() {
		LoginInfo loginInfo = LoginSharedPreferencesHelper.getLoginInfo(getApplicationContext());
		if (loginInfo != null && loginInfo.isRememberPasswd()) {
			rememberPasswdChk.setChecked(true);
			String name = loginInfo.getLoginName();
			if (StringUtils.isNotBlank(name)) {
				mobilephoneExt.setText(name);
				mobilephoneExt.setSelection(name.length());
			}
			passwdExt.setText(loginInfo.getLoginPasswd());
		}
	}

	/**
	 * 准备登录
	 * 
	 * @return
	 */
	private boolean prepare() {
//		account = new Account();
//		String mobilephone = mobilephoneExt.getText().toString().trim();
//		if (StringUtils.isNotBlank(mobilephone)) {
//			account.setMobilephone(mobilephone);
//			account.setLoginId(mobilephone);
//		} else {
//			Toast.makeText(LoginActivity.this, "手机号不能为空.", Toast.LENGTH_SHORT).show();
//			return false;
//		}
//		String passwd = passwdExt.getText().toString().trim();
//		if (StringUtils.isNotBlank(passwd)) {
//			account.setPasswd(passwd);
//		} else {
//			Toast.makeText(LoginActivity.this, "密码不能为空.", Toast.LENGTH_SHORT).show();
//			return false;
//		}
		return true;
	}

	private void login() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 收集用户登录信息
	 * 
	 * @return
	 */
	private LoginInfo populateLoginInfo() {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoginName(mobilephoneExt.getText().toString().trim());
		loginInfo.setLoginPasswd(passwdExt.getText().toString());
		loginInfo.setRememberPasswd(rememberPasswdChk.isChecked());
		return loginInfo;
	}

	@Override
	protected void onPause() {
		if (progressDialog != null) {
			progressDialog.dismiss();
		}
		super.onPause();
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
		// .setTitle("提示")
				.setMessage("确定要退出吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						System.exit(0);
						// 或者下面这种方式
						// android.os.Process.killProcess(android.os.Process.myPid());
					}
				}).setNegativeButton("取消", null).show();
	}
}
