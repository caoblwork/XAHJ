package com.evalley.xahj.cases;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.evalley.xahj.R;

/**
 * @Description 环境保护案件调查报告
 * @author Evalley
 * @date 2011-10-20 下午06:15:19
 */
public class SurveyCaseActivity extends FinalActivity {
	
	@ViewInject(id=R.id.queryBtn,click="submit") Button queryBtn;
	@ViewInject(id=R.id.corpNameTxt) EditText corpNameTxt;
	@ViewInject(id=R.id.corporationTxt) EditText corporationTxt;
	@ViewInject(id=R.id.corpAreaSpinner) Spinner corpAreaSpinner;
	@ViewInject(id=R.id.corpTypeSpinner) Spinner corpTypeSpinner;
	//@ViewInject(id=R.id.progressBar) 
	ProgressBar progressBar;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.corp_search);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		findViews();
	}
	
	
	private void findViews(){
		progressBar = (ProgressBar)findViewById(R.id.progressBar);
		
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("案件调查报告");
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
		
		ArrayAdapter<?> areaAdapter = ArrayAdapter.createFromResource(this, R.array.corp_area, android.R.layout.simple_spinner_item);
		areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		corpAreaSpinner.setAdapter(areaAdapter);
		
		ArrayAdapter<?> typeAdapter = ArrayAdapter.createFromResource(this, R.array.corp_type, android.R.layout.simple_spinner_item);
		typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		corpTypeSpinner.setAdapter(typeAdapter);
	}
	
	public void submit(View v){
		progressBar.setVisibility(View.VISIBLE);
//		progressBar.setVisibility(View.GONE);
	}
	
	private void selectCorpArea(){
		int area = corpAreaSpinner.getSelectedItemPosition();
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
		super.onBackPressed();
	}
}
