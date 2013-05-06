package com.evalley.xahj.corp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.evalley.xahj.Constants;
import com.evalley.xahj.R;
import com.evalley.xahj.util.JsonUtils;
import com.evalley.xahj.util.RemoteUtils;
import com.evalley.xahj.vo.CorpInfo;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @Description 企业列表
 * @author Evalley
 * @date 2011-10-20 下午06:15:19
 */
public class CorpListActivity extends FinalActivity {
	
	// @ViewInject(id=R.id.queryBtn,click="submit") Button queryBtn;
//	@ViewInject(id=R.id.corpNameTxt) EditText corpNameTxt;
//	@ViewInject(id=R.id.corporationTxt) EditText corporationTxt;
//	@ViewInject(id=R.id.corpAreaSpinner) Spinner corpAreaSpinner;
	@ViewInject(id=R.id.corpListView) ListView corpListView;
	private ProgressBar progressBar;
	private List<CorpInfo> corpList = new ArrayList<CorpInfo>();
	/**
	 * 处理器
	 */
	private Handler handler;
	private FinalHttp fh = new FinalHttp();
	/**
	 * 查询地址
	 */
	private String searchUrl = Constants.SERVER_URL + "corp/list.do";
	/**
	 * 查询开始下标
	 */
	private int startIndex;
	/**
	 * 查询参数
	 */
	private AjaxParams params;
	/**
	 * 查询参数
	 */
	private HashMap<String, Object> paramMap;
	
	private final static int ACTION_SEARCH = 0;
	
	
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_corp_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
		findViews();
		initSearchParams();
		search();
	}
	
	
	private void findViews(){
		progressBar = (ProgressBar)findViewById(R.id.progressBar);
		
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("企业列表");
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
	}
	
	private void search() {
		progressBar.setVisibility(View.VISIBLE);
		new Thread(new Runnable() {
			public void run() {
				doSearch();
				handler.sendEmptyMessage(ACTION_SEARCH);
			}
		}).start();
	}
	
	/**
	 * 查询
	 */
	protected void doSearch() {
		
		fh.post(searchUrl, params, new AjaxCallBack<Object>() {

			@Override
			public void onStart() {
				progressBar.setVisibility(View.VISIBLE);
				super.onStart();
			}

			@Override
			public void onSuccess(Object t) {
				Log.i(TAG, "返回信息是+" + t.toString());
				progressBar.setVisibility(View.GONE);
				List<CorpInfo> corps = JsonUtils.json2GenericObject(t.toString(), new TypeReference<List<CorpInfo>>(){});
				for (CorpInfo corpInfo : corps) {
					corpList.add(corpInfo);
				}
			}

			@Override
			public void onFailure(Throwable t, String strMsg) {
				progressBar.setVisibility(View.GONE);
				showMessage("查询失败,请重试.");
				super.onFailure(t, strMsg);
			}
		});
	}


	/**
	 * 准备查询参数
	 * @return
	 */
	private void prepareSearchParams() {
		params.put("startIndex", "" + startIndex);
	}
	
	
	/**
	 * 初始化查询参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void initSearchParams() {
		paramMap = (HashMap<String, Object>)getIntent().getSerializableExtra("paramMap");
		params = RemoteUtils.getAjaxParams();
		Iterator<String> iterator = paramMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			params.put(key, String.valueOf(paramMap.get(key)));
		}
	}
	

	/**
	 * 行程安排适配器
	 */
	class NewsAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			if (corpList != null) {
				return corpList.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			if (getCount() > 0) {
				CorpInfo corp = corpList.get(position);
				
				View myview = CorpListActivity.this.getLayoutInflater().inflate(R.layout.corp_item, null);
				TextView corpNameTxt = (TextView) myview.findViewById(R.id.corpName);
				corpNameTxt.setText(corp.getName());
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
