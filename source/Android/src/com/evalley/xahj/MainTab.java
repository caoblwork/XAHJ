package com.evalley.xahj;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

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
	
	private Window window;
	private AlertDialog dialog;
	
	// 当前是否处于二级菜单
	public Boolean isSecondLevel = false;
	
	private TextView titleTxt;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main_tab);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);
        init();
    }
    
	/**
	 * 初始化工作
	 */
	private void init() {
		resetTitle();
		findViews();
        addListener();
        initTab();
	}

	@Override
	protected void onResume() {
		
		super.onResume();
	}

	/**
	 * 重置标题
	 */
	private void resetTitle() {
		setTitle(getString(R.string.app_name));
	}
	
	/**
	 * 设置标题
	 */
	private void setTitle(String title) {
		if (titleTxt == null) {
			titleTxt = (TextView)findViewById(R.id.title_text);
		}
		titleTxt.setText(title);
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
					resetTitle();
					break;
				case R.id.main_layout2:
					tabHost.setCurrentTabByTag(TAB_SETTINGS);
					setTitle(getString(R.string.main_settings));
					break;
				case R.id.main_layout3:
					tabHost.setCurrentTabByTag(TAB_HELP);
					setTitle(getString(R.string.help_label));
					break;
				case R.id.main_layout4:
					resetTitle();
					ActivityUtils.quit(MainTab.this);
					break;
			}
		}
	};
	
    /**
     * 获取TextView
     * 
     * @param window
     * @param id
     * @param content
     * @return
     */
    private TextView getTextView(int id, String content) {
    	TextView itemTxt = (TextView)window.findViewById(id);
    	itemTxt.setVisibility(View.VISIBLE);
    	itemTxt.setText(content);
    	return itemTxt;
    }
	
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
				.setContent(new Intent(this, SettingActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_HELP).setIndicator(TAB_HELP)
				.setContent(new Intent(this, HelpActivity.class)));
		tabHost.setCurrentTabByTag(TAB_HOME);
	}

}