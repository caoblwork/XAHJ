package com.evalley.xahj;

import java.util.ArrayList;
import java.util.List;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.evalley.xahj.util.ActivityUtils;

/**
 * @Description 主界面
 * 
 * @author 麻胜海
 * @date 2012-7-3 上午11:27:22
 */
public class MainTab extends TabActivity {
	
	private TabHost tabHost;
	private LinearLayout linearLayout1;
	private LinearLayout linearLayout2;
	private LinearLayout linearLayout3;
	private LinearLayout linearLayout4;
	
	public static final String TAB_HOME = "tabHome";
	public static final String TAB_SETTINGS = "tabSettings";
	public static final String TAB_HELP = "tabHelp";
	public static final String TAB_CANCLE = "tabCancle";
	
	// 当前是否处于二级菜单
	public Boolean isSecondLevel = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main_tab);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
        init();
    }
    
	/**
	 * 初始化工作
	 */
	private void init() {
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText(getString(R.string.app_name));
		findViews();
        addListener();
        initTab();
	}

	/**
     * 查找控件
     */
    private void findViews() {
    	linearLayout1 = (LinearLayout)this.findViewById(R.id.main_layout1);
    	linearLayout2 = (LinearLayout)this.findViewById(R.id.main_layout2);
    	linearLayout3 = (LinearLayout)this.findViewById(R.id.main_layout3);
    	linearLayout4 = (LinearLayout)this.findViewById(R.id.main_layout4);
    	
    }
    
    /**
     * 添加监听器
     */
    private void addListener() {
    	linearLayout1.setOnClickListener(labelClickListener);
    	linearLayout2.setOnClickListener(labelClickListener);
    	linearLayout3.setOnClickListener(labelClickListener);
    	linearLayout4.setOnClickListener(labelClickListener);
    } 
    
    /**
     * 点击Tab事件
     */
    OnClickListener labelClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			setLinearLayoutBackground(v.getId());
			switch (v.getId()) {
				case R.id.main_layout1:
					tabHost.setCurrentTabByTag(TAB_HOME);
					break;
				case R.id.main_layout2:
					tabHost.setCurrentTabByTag(TAB_SETTINGS);
					break;
				case R.id.main_layout3:
					tabHost.setCurrentTabByTag(TAB_HELP);
					break;
				case R.id.main_layout4:
					ActivityUtils.quit(MainTab.this);
					break;
			}
		}
	};
	
	/**
	 * 设置TextView的背景
	 * @param id
	 */
	private void setLinearLayoutBackground(int id) {
		List<LinearLayout> linearLayoutList = new ArrayList<LinearLayout>();
		linearLayoutList.add(linearLayout1);
		linearLayoutList.add(linearLayout2);
		linearLayoutList.add(linearLayout3);
		linearLayoutList.add(linearLayout4);
		for (LinearLayout linearLayout : linearLayoutList) {
			if (linearLayout.getId() == id) {
				linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_selected));
			} else {
				linearLayout.setBackgroundDrawable(null);
			}
		}
	}
	
	/**
	 * 初始化标签页
	 */
	private void initTab() {
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec(TAB_HOME).setIndicator(TAB_HOME)
				.setContent(new Intent(this, NineCellActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_SETTINGS)
				.setIndicator(TAB_SETTINGS)
				.setContent(new Intent(this, NineCellActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_HELP).setIndicator(TAB_HELP).setContent(new Intent(this, NineCellActivity.class)));
		tabHost.setCurrentTabByTag(TAB_HOME);
	}

}