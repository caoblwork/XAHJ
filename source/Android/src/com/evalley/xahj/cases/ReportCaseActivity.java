package com.evalley.xahj.cases;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.evalley.xahj.R;

/**
 * @Description 环境违法行为立案登记
 * @author 麻胜海
 * @date 2011-10-20 下午06:15:19
 */
public class ReportCaseActivity extends FinalActivity {
	
	/**
	 * 导航栏
	 */
	@ViewInject(id=R.id.caseNav1,click="navigate") private TextView caseNav1;
	@ViewInject(id=R.id.caseNav2,click="navigate") private TextView caseNav2;
	@ViewInject(id=R.id.caseNav3,click="navigate") private TextView caseNav3;
	@ViewInject(id=R.id.caseNav4,click="navigate") private TextView caseNav4;
	
	/**
	 * 基本信息
	 */
	//@ViewInject(id=R.id.queryBtn,click="submit") 
	private Button queryBtn;
	//@ViewInject(id=R.id.partyExt) 
	private EditText partyExt;
	//@ViewInject(id=R.id.corporationExt) 
	private EditText corporationExt;
	//@ViewInject(id=R.id.corporationDutyExt) 
	private EditText corporationDutyExt;
	//@ViewInject(id=R.id.corporationPhoneExt) 
	private EditText corporationPhoneExt;
	//@ViewInject(id=R.id.caseDescExt) 
	private EditText caseDescExt;
	//@ViewInject(id=R.id.ownerOpinionExt) 
	private EditText ownerOpinionExt;
	//@ViewInject(id=R.id.deptOpinionExt) 
	private EditText deptOpinionExt;
	//@ViewInject(id=R.id.remarkExt) 
	private EditText remarkExt;
	private ProgressBar progressBar;
	private View baseInfoView;
	private View picView;
	
	/**
	 * 页面切换器
	 */
	private ViewPager mPager;
	/**
	 * 页面切换器包含的View
	 */
	private List<TextView> navList;
	/**
	 * 页面切换器包含的View
	 */
	private List<View> listViews;
	/**
	 * 当前页面的索引号
	 */
	private int lastNav = 0;
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.case_report);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		init();
	}
	
	/**
	 * 初始化
	 */
	private void init() {
		initNavigate();
		findViews();
	}


	private void findViews(){
		progressBar = (ProgressBar)findViewById(R.id.progressBar);
		
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("违法行为立案登记");
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
		
		initPagerView();
		
		queryBtn = (Button)baseInfoView.findViewById(R.id.queryBtn);
		queryBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				submit();
			}
		});
		partyExt = (EditText)baseInfoView.findViewById(R.id.partyExt);
		corporationExt = (EditText)baseInfoView.findViewById(R.id.corporationExt);
		corporationDutyExt = (EditText)baseInfoView.findViewById(R.id.corporationDutyExt);
		corporationPhoneExt = (EditText)baseInfoView.findViewById(R.id.corporationPhoneExt);
		caseDescExt = (EditText)baseInfoView.findViewById(R.id.caseDescExt);
		ownerOpinionExt = (EditText)baseInfoView.findViewById(R.id.ownerOpinionExt);
		deptOpinionExt = (EditText)baseInfoView.findViewById(R.id.deptOpinionExt);
		remarkExt = (EditText)baseInfoView.findViewById(R.id.remarkExt);
		
		mPager = (ViewPager) findViewById(R.id.viewPager);
		mPager.setAdapter(new MyPagerAdapter(listViews));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 初始化导航
	 */
	private void initNavigate() {
		navList = new ArrayList<TextView>();
		navList.add(caseNav1);
		navList.add(caseNav2);
		navList.add(caseNav3);
		navList.add(caseNav4);
	}

	/**
	 * 初始化切换页
	 */
	private void initPagerView() {
		listViews = new ArrayList<View>();
		baseInfoView = getLayoutInflater().inflate(R.layout.case_report_info, null);
		picView = getLayoutInflater().inflate(R.layout.case_report_pic, null);
		listViews.add(baseInfoView);
		listViews.add(picView);
	}
	
	/**
	 * 提交
	 * 
	 */
	public void submit(){
		progressBar.setVisibility(View.VISIBLE);
//		progressBar.setVisibility(View.GONE);
	}
	
	/**
	 * 导航
	 */
	//@SuppressWarnings("unused")
	public void navigate(View v){
		int position = 0;
		switch (v.getId()) {
			case R.id.caseNav1:
				break;
			case R.id.caseNav2:
				position = 1;
				break;
			case R.id.caseNav3:
				position = 2;
				break;
			case R.id.caseNav4:
				position = 3;
				break;
		}
		mPager.setCurrentItem(position);
	}
	
	/**
	 * 导航
	 */
	private void changePage(int position){
		// 两次导航是同一个栏目，则不处理
		if (lastNav != position) {
			int size = navList.size();
			for (int i = 0; i < size; i++) {
				TextView nav = navList.get(i);
				if (i == position) {
					nav.setBackgroundResource(R.drawable.label_p_bg);
					nav.setTextColor(getResources().getColor(android.R.color.white));
				} else if (i == lastNav) {
					nav.setBackgroundResource(R.drawable.label_bg);
					nav.setTextColor(getResources().getColor(R.color.text_color5));
				}
			}
			lastNav = position;
		}
	}
	
	
	
	/**
	 * ViewPager适配器
	 */
	public class MyPagerAdapter extends PagerAdapter {
		public List<View> mListViews;

		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}
	
	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			changePage(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
		super.onBackPressed();
	}
}
