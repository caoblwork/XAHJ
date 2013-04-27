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
					//View view = tabHost.getTabWidget().getChildAt(0);
					settingDialog();
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
     * 设置
     */
    protected void settingDialog() {
    	if (dialog != null) {
    		Toast.makeText(MainTab.this, "重用Dialog", Toast.LENGTH_SHORT).show(); 
    		dialog.show();
    		return;
		}
    	dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
    	window = dialog.getWindow();
    	window.setContentView(R.layout.dialog);
    	
    	ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
    	TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
    	titleTxt.setText(getString(R.string.nav9));
    	final TextView itemTxt1 = getTextView(R.id.itemTxt1, NineCellActivity.setting[0]);
    	final TextView itemTxt2 = getTextView(R.id.itemTxt2, NineCellActivity.setting[1]);
    	final TextView itemTxt3 = getTextView(R.id.itemTxt3, NineCellActivity.setting[2]);
    	
    	backBtn.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			dialog.dismiss();
    		}
    	});
    	itemTxt1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			/**
    			 * 帮助
    			 */
    			Intent intent = new Intent(MainTab.this, HelpActivity.class);
    			startActivity(intent);
    			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
    	itemTxt2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(MainTab.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt3.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			/**
    			 * 关于
    			 */
    			Intent intent = new Intent(MainTab.this, AboutActivity.class);
    			startActivity(intent);
    			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
    	
    	window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - findViewById(R.id.mainBtnLayout).getHeight());
    	window.setBackgroundDrawableResource(android.R.color.transparent); 
    	window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
    	//window.setWindowAnimations(R.style.dialogStyle); // 添加动画
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
//		tabHost.addTab(tabHost.newTabSpec(TAB_SETTINGS)
//				.setIndicator(TAB_SETTINGS)
//				.setContent(new Intent(this, NineCellActivity.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_HELP).setIndicator(TAB_HELP)
				.setContent(new Intent(this, NineCellActivity.class)));
		tabHost.setCurrentTabByTag(TAB_HOME);
	}

}