package com.evalley.xahj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.evalley.xahj.util.ActivityUtils;

/**
 * @Description 关于类
 * @author 麻胜海
 * @date 2011-10-20 下午06:15:19
 */
public class AboutActivity extends Activity {
	
    private TextView mTextView;
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.about);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		findViews();
	}
	
	
	private void findViews(){
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("关    于");
		title.getPaint().setFakeBoldText(true);
		
		/**
		 * 返回按钮
		 */
		ImageButton gobackBtn = (ImageButton) findViewById(R.id.gobackBtn);
		gobackBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		
		mTextView = (TextView)findViewById(R.id.system_about_id);
		mTextView.setText("版本号：" + ActivityUtils.getVersion(this));
		mTextView.getPaint().setFakeBoldText(true);
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
		super.onBackPressed();
	}
}
