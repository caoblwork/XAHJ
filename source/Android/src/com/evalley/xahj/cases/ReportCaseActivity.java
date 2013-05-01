package com.evalley.xahj.cases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.annotation.view.ViewInject;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.evalley.xahj.R;
import com.evalley.xahj.util.FileUtils;

/**
 * @Description 环境违法行为立案登记
 * @author 麻胜海
 * @date 2011-10-20 下午06:15:19
 */
public class ReportCaseActivity extends CaseBaseActivity {
	
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
	
	/**
	 * 拍照
	 */
	private View picView;
	private Button capturePhotoBtn;
	private ImageAdapter photoAdapter;
	// 画廊
	private Gallery gallery;
	// 分页信息
	private TextView pageInfo;
	// 图片所在的文件夹
	private String path;
	// 文件集合
	private List<File> pictures;
	// 缩略图
	private List<Bitmap> thumbnails = new ArrayList<Bitmap>();
	
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
	 * 切换前
	 */
	private int currentNav = 0;
	/**
	 * 切换后
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
	
	@Override
	protected void onResume() {
		if(currentNav==1) {
			initPictures();
		}
		super.onResume();
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
		initBaseInfo();
		initCapture();
		
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
		picView = getLayoutInflater().inflate(R.layout.capture_photo, null);
		listViews.add(baseInfoView);
		listViews.add(picView);
	}
	
	/**
	 * 基本信息
	 */
	private void initBaseInfo() {
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
	}
	
	/**
	 * 拍照
	 */
	private void initCapture() {
		gallery = (Gallery) picView.findViewById(R.id.gallery);
		pageInfo = (TextView) picView.findViewById(R.id.pageInfo);
		registerForContextMenu(gallery);
		
		// 更新分页信息
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				if (pictures != null && pictures.size() > 0) {
					pageInfo.setText((arg2 + 1) + "/" + pictures.size());
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
		capturePhotoBtn = (Button)picView.findViewById(R.id.capturePhotoBtn);
		capturePhotoBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String file = CaseHelper.createTempImageFile(getCaseUUId());
				Intent captureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File picFile = new File(file);
				Uri uri = Uri.fromFile(picFile);
				captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				if (android.os.Build.VERSION.RELEASE.compareTo("2.2") <= 0) {
					captureIntent.setClassName("com.sec.android.app.camera","com.sec.android.app.camera.Camera");
				}
				startActivity(captureIntent);				
			}
		});
	}
	
	/**
	 * 初始化照片信息
	 */
	private void initPictures() {
		File[] files = FileUtils.getAllFiles(getImagePath(), new MediaFilter(IMAGE_POSTFIX));
		int length = files.length;
		if (files == null || length < 1) {
			Toast.makeText(this, "没有照片", Toast.LENGTH_SHORT).show();
		} else {
			pictures = new ArrayList<File>();
			thumbnails.clear();
			for (int i = 0; i < length; i++) {
				pictures.add(files[i]);
				thumbnails.add(FileUtils.optimizeBitmap(pictures.get(i)));
			}
			photoAdapter = new ImageAdapter(this);
			gallery.setAdapter(photoAdapter);
		}
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.add("删除");
	}

	@Override
	public boolean onContextItemSelected(final MenuItem item) {
		deleteImage(item);
		
		return true;
	}
	
	/**
	 * 删除图片
	 * 
	 * @param item
	 */
	public void deleteImage(MenuItem item) {
		AdapterContextMenuInfo itemInfo = (AdapterContextMenuInfo) item.getMenuInfo();
		deleteImage(itemInfo.position);
	}
	
	/**
	 * 删除图片
	 * 
	 * @param item
	 */
	public void deleteImage(final int position) {
		new AlertDialog.Builder(this).setTitle("提示").setMessage("确定要删除该图片?").setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				FileUtils.deleteFile(pictures.get(position).getAbsolutePath());
				pictures.remove(position);
				thumbnails.remove(position);
//				photoAdapter.notifyDataSetChanged();
				ImageAdapter adapter = new ImageAdapter(ReportCaseActivity.this);
				if (adapter != null && adapter.getCount() > 0) {
					gallery.setAdapter(adapter);
				}
			}
		}).setNegativeButton("取消", null).show();
		
	}
	
	/**
	 * 图片适配器
	 * 
	 */
	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		public ImageAdapter(Context context) {
			mContext = context;
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			mGalleryItemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount() {
			if (null != thumbnails) {
				return thumbnails.size();
			} else {
				return 0;
			}
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView image = new ImageView(mContext);
			image.setImageBitmap(thumbnails.get(position));
			image.setScaleType(ImageView.ScaleType.FIT_XY);
			image.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			image.setBackgroundResource(mGalleryItemBackground);
			
			return image;
		}
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
		currentNav = position;
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
