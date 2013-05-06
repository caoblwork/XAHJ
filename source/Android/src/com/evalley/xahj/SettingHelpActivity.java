package com.evalley.xahj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @Description 设置-帮助
 * @author Evalley
 * @date 2011-10-20 下午06:15:19
 */
public class SettingHelpActivity extends Activity {
	
    private static final String[] titles = {
    	"怎么管理我的任务?",
    	"怎么进行现场执法?",
    	"怎么查询污染源企业信息?",
    	"怎么通过地图进行定位?",
    	"怎么修改密码?",
    	"忘记密码怎么办?",
    	"怎么修改个人信息?",
    	"怎么修改头像?"};

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.help);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		findViews();
	}
	
	
	private void findViews(){
		
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("帮    助");
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
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new HelpItemAdapter());
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				Intent intent = new Intent(HelpActivity.this, ViewPagerActivity.class);
//				switch (arg2) {
//					case 0:
//						break;
//				}
//				
//				intent.putExtra("title", titles[arg2]);
//				startActivity(intent);
//				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		});
	}
	
	/**
	 * 适配器
	 */
	class HelpItemAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			if (getCount() > 0) {
				View myview = SettingHelpActivity.this.getLayoutInflater().inflate(R.layout.help_item, null);
				TextView title = (TextView) myview.findViewById(R.id.title);
				title.setText(titles[position]);
				return myview;
			}
			return null;
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
		super.onBackPressed();
	}
}
