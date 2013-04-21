package com.evalley.xahj;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * @Description 启动画面
 * @author 麻胜海
 * @date 2012-7-3 上午10:12:24
 */
public class SplashActivity extends FinalActivity {
	
	@ViewInject(id=R.id.title1) TextView txtTitle1;
	@ViewInject(id=R.id.title2) TextView txtTitle2;
	
	/**
	 * 启动画面停留的时间
	 */
	private final int SPLASH_DISPLAY_LENGHT = 5000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		txtTitle1.getPaint().setFakeBoldText(true);
		txtTitle2.getPaint().setFakeBoldText(true);
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, MainTab.class);
				SplashActivity.this.startActivity(intent);
				overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
				SplashActivity.this.finish();
			}

		}, SPLASH_DISPLAY_LENGHT);
	}

}
