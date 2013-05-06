package com.evalley.xahj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @Description 设置
 * @author Evalley
 * @date 2011-10-20 下午06:15:19
 */
public class SettingActivity extends Activity {
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		findViews();
	}
    
	private void findViews(){
		final TextView itemTxt1 = getTextView(R.id.itemTxt1, NineCellActivity.setting[0]);
		final TextView itemTxt2 = getTextView(R.id.itemTxt2, NineCellActivity.setting[1]);
		final TextView itemTxt3 = getTextView(R.id.itemTxt3, NineCellActivity.setting[2]);
    	
    	itemTxt1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(SettingActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			/**
    			 * 帮助
    			 */
    			Intent intent = new Intent(SettingActivity.this, SettingHelpActivity.class);
    			startActivity(intent);
    			//overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
    	itemTxt3.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			/**
    			 * 关于
    			 */
    			Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
    			startActivity(intent);
    			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
	}
	
    /**
     * 获取TextView
     * 
     * @param window
     * @param id
     * @param content
     * @return
     */
    private TextView getTextView(int id, String content) {
    	TextView itemTxt = (TextView)findViewById(id);
    	itemTxt.setVisibility(View.VISIBLE);
    	itemTxt.setText(content);
    	return itemTxt;
    }
	
	@Override
	public void onBackPressed() {
		((MainTab) getParent()).getTabHost().setCurrentTab(0);
	}
}
