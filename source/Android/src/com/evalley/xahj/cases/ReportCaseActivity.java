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
import android.database.Cursor;
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
import android.view.LayoutInflater;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.evalley.xahj.R;
import com.evalley.xahj.util.ActivityUtils;
import com.evalley.xahj.util.FileUtils;

/**
 * @Description 环境违法行为立案登记
 * @author 麻胜海
 * @date 2011-10-20 下午06:15:19
 */
public class ReportCaseActivity extends CaseBaseActivity {
	
	// 拍照请求码
	private static final int PICTURE_REQUEST_CODE = 1;
	// 录像请求码
	private static final int VIDEO_REQUEST_CODE = 2;
	// 录音请求码
	private static final int RECORD_REQUEST_CODE = 3;
	
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
	private Button titleBtn;
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
	private Bitmap defaultPhoto;
	private boolean photoCountChanged;
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
	 * 录像
	 */
	private View videoView;
	private ListView videoListView;
	private Button captureVideoBtn;
	private String videoFile;
	private List<File> videoFileList;
	private List<PlayListItem> videoItemList;
	private VideoListItemAdapter videoListItemAdapter;
	
	/**
	 * 录音
	 */
	private View audioView;
	private ListView audioListView;
	private Button captureAudioBtn;
	private AlertDialog audioDialog;
	private String audioFile;
	private List<File> audioFileList;
	private List<PlayListItem> audioItemList;
	private AudioListItemAdapter audioListItemAdapter;
	// 选中的项
	private int selectedIndex;
	
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
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.case_title);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		init();
	}
	
	@Override
	protected void onResume() {
		
//		if(currentNav==1) {
//			initPictures();
//		}
		initPictures();
		initVideoFiles();
		initAudioFiles();
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
		
		titleBtn = (Button)findViewById(R.id.titleBtn);
		titleBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				submit();
			}
		});
		
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
		initCapturePhoto();
		initCaptureVideo();
		initCaptureAudio();
		
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
		videoView = getLayoutInflater().inflate(R.layout.capture_video, null);
		audioView = getLayoutInflater().inflate(R.layout.capture_audio, null);
		listViews.add(baseInfoView);
		listViews.add(picView);
		listViews.add(videoView);
		listViews.add(audioView);
	}
	
	/**
	 * 基本信息
	 */
	private void initBaseInfo() {
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
	 * 录像
	 */
	private void initCaptureVideo() {
		videoListView = (ListView)videoView.findViewById(R.id.videoListView);
		videoListItemAdapter = new VideoListItemAdapter();
		videoListView.setAdapter(videoListItemAdapter);
		
		captureVideoBtn = (Button)videoView.findViewById(R.id.captureVideoBtn);
		captureVideoBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				videoFile = CaseHelper.createTempVideoFile(getCaseUUId());
				Intent videoIntent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
				videoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
				startActivityForResult(videoIntent, VIDEO_REQUEST_CODE);
			}
		});
	}
	
	/**
	 * 录音
	 */
	private void initCaptureAudio() {
		audioListView = (ListView)audioView.findViewById(R.id.audioListView);
		audioListItemAdapter = new AudioListItemAdapter();
		audioListView.setAdapter(audioListItemAdapter);
		captureAudioBtn = (Button)audioView.findViewById(R.id.captureAudioBtn);
		captureAudioBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				if (audioDialog == null) {
//					audioDialog = new AlertDialog.Builder(ReportCaseActivity.this).create();
//					audioDialog.show();
//					Window window = audioDialog.getWindow();
//					window.setContentView(R.layout.capture_audio_dialog);
//					LinearLayout audioCancelLayout = (LinearLayout)window.findViewById(R.id.audioCancelLayout);
//					audioCancelLayout.setOnClickListener(new OnClickListener() {
//						
//						@Override
//						public void onClick(View v) {
//							if (audioDialog != null) {
//								audioDialog.cancel();
//							}
//						}
//					});
//					window.setLayout(ActivityUtils.getScreenWidth(ReportCaseActivity.this), ActivityUtils.getScreenHeight(ReportCaseActivity.this));
//					window.setBackgroundDrawableResource(android.R.color.transparent); 
//					window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
//					window.setWindowAnimations(R.style.dialogStyle); // 添加动画
//				} else {
//					audioDialog.show();
//				}
				audioFile = CaseHelper.createTempSoundFile(getCaseUUId());
				Intent recordIntent=new Intent(Intent.ACTION_GET_CONTENT);
				recordIntent.setType("audio/amr");
				recordIntent.setClassName("com.android.soundrecorder","com.android.soundrecorder.SoundRecorder");
				startActivityForResult(recordIntent, RECORD_REQUEST_CODE);
			}
		});
	}
	
	/**
	 * 获取文件信息
	 */
	private void initAudioFiles() {
		File[] files = FileUtils.getAllFiles(getSoundPath(), new MediaFilter(SOUND_POSTFIX));
		int length = files.length;
		if (files != null && length > 0) {
			audioFileList = new ArrayList<File>();
			audioItemList = new ArrayList<PlayListItem>();
			for (int i = 0; i < length; i++) {
				File file = files[i];
				audioFileList.add(file);
				PlayListItem item = new PlayListItem();
				item.setSn(i);
				// item.setName(file.getName());
				item.setName("录音文件" + (i+1));
				setFileSize(item, file);
				item.setPath(file.getAbsolutePath());
				audioItemList.add(item);
			}
			audioListItemAdapter.notifyDataSetChanged();
		}
	}
	
	/**
	 * 获取文件信息
	 */
	private void initVideoFiles() {
		File[] files = FileUtils.getAllFiles(getVideoPath(), new MediaFilter(VIDEO_POSTFIX));
		int length = files.length;
		if (files != null && length > 0) {
			videoFileList = new ArrayList<File>();
			videoItemList = new ArrayList<PlayListItem>();
			for (int i = 0; i < length; i++) {
				File file = files[i];
				videoFileList.add(file);
				PlayListItem item = new PlayListItem();
				item.setSn(i);
				// item.setName(file.getName());
				item.setName("视频文件" + (i+1));
				setFileSize(item, file);
				item.setPath(file.getAbsolutePath());
				videoItemList.add(item);
			}
			videoListItemAdapter.notifyDataSetChanged();
		}
	}
	
	/**
     * 播放列表项适配器
     */
    class AudioListItemAdapter extends ArrayAdapter<PlayListItem> {
    	
    	// 播放按钮
    	private ImageButton btnPlay;
    	// 删除按钮
    	private ImageButton btnDelete;

		public AudioListItemAdapter() {
			super(ReportCaseActivity.this, 0);
		}
    	
		@Override
		public int getCount() {
			if (audioItemList != null) {
				return audioItemList.size();
			}
			return 0;
		}

		@Override
		public PlayListItem getItem(int position) {
			if (audioItemList != null) {
				return audioItemList.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View itemView = null;
			if (getCount() > 0) {
				PlayListItem item = audioItemList.get(position);
				LayoutInflater inflater = ReportCaseActivity.this.getLayoutInflater();
				itemView = inflater.inflate(R.layout.playlist_item, null);
				TextView textView1 = (TextView) itemView.findViewById(R.id.playlist_item_column1);
				textView1.setText(item.getName());
				TextView textView2 = (TextView) itemView.findViewById(R.id.playlist_item_column2);
				textView2.setText(item.getSize());
				btnPlay = (ImageButton) itemView.findViewById(R.id.playlist_item_play);
				btnDelete = (ImageButton) itemView.findViewById(R.id.playlist_item_delete);
				
				// LinearLayout operatorLayout = (LinearLayout) itemView.findViewById(R.id.operator_layout);
				
				// 播放
				btnPlay.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						selectedIndex = position;
						play();
					}
				});
				
				// 删除
				btnDelete.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						deleteSelectedItem(position);
					}
				});
			}

			return itemView;
		}
    }
    
    /**
     * 播放列表项适配器
     */
    class VideoListItemAdapter extends ArrayAdapter<PlayListItem> {
    	
    	// 播放按钮
    	private ImageButton btnPlay;
    	// 删除按钮
    	private ImageButton btnDelete;
    	
    	public VideoListItemAdapter() {
    		super(ReportCaseActivity.this, 0);
    	}
    	
    	@Override
    	public int getCount() {
    		if (videoItemList != null) {
    			return videoItemList.size();
    		}
    		return 0;
    	}
    	
    	@Override
    	public PlayListItem getItem(int position) {
    		if (videoItemList != null) {
    			return videoItemList.get(position);
    		}
    		return null;
    	}
    	
    	@Override
    	public long getItemId(int position) {
    		return position;
    	}
    	
    	@Override
    	public View getView(final int position, View convertView, ViewGroup parent) {
    		View itemView = null;
    		if (getCount() > 0) {
    			PlayListItem item = videoItemList.get(position);
    			LayoutInflater inflater = ReportCaseActivity.this.getLayoutInflater();
    			itemView = inflater.inflate(R.layout.playlist_item, null);
    			TextView textView1 = (TextView) itemView.findViewById(R.id.playlist_item_column1);
    			textView1.setText(item.getName());
    			TextView textView2 = (TextView) itemView.findViewById(R.id.playlist_item_column2);
    			textView2.setText(item.getSize());
    			btnPlay = (ImageButton) itemView.findViewById(R.id.playlist_item_play);
    			btnDelete = (ImageButton) itemView.findViewById(R.id.playlist_item_delete);
    			
    			// LinearLayout operatorLayout = (LinearLayout) itemView.findViewById(R.id.operator_layout);
    			
    			// 播放
    			btnPlay.setOnClickListener(new OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    					selectedIndex = position;
    					play();
    				}
    			});
    			
    			// 删除
    			btnDelete.setOnClickListener(new OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    					deleteSelectedItem(position);
    				}
    			});
    		}
    		
    		return itemView;
    	}
    }
    
    /**
     * 播放
     */
    private void play() {
    	
    }
    
	/**
     * 删除选择的某一项
     */
	private void deleteSelectedItem(final int position) {
		new AlertDialog.Builder(ReportCaseActivity.this)
		.setTitle("提示")
		.setMessage("确定要删除吗?")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				PlayListItem item = audioItemList.get(position);
		    	FileUtils.deleteFile(item.getPath());
		    	audioItemList.remove(item);
		    	audioListItemAdapter.notifyDataSetChanged();
			}
		})
		.setNegativeButton("取消", null).show();
	}
	
	/**
	 * 获取文件大小
	 * @param item
	 * @param file
	 * @return
	 */
	private PlayListItem setFileSize(PlayListItem item, File file) {
		try {
			item.setSize(FileUtils.getSizeString(file));
		} catch (Exception e) {
			e.printStackTrace();
			item.setSize("未知");
		}
		return item;
	}
	
	/**
	 * 拍照
	 */
	private void initCapturePhoto() {
		defaultPhoto = ActivityUtils.drawableToBitmap(getResources().getDrawable(R.drawable.default_photo));
		gallery = (Gallery) picView.findViewById(R.id.gallery);
		pageInfo = (TextView) picView.findViewById(R.id.pageInfo);
		registerForContextMenu(gallery);
		
		// 更新分页信息
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				updatePhotoPageInfo(arg2);
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
		
		photoAdapter = new ImageAdapter(this);
		gallery.setAdapter(photoAdapter);
	}
	
	/**
	 * 证据采集的回调函数
	 * 拍照调用的是startActivity，没有调用回调函数
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			// 录像
			case VIDEO_REQUEST_CODE:
				save(resultCode, data, videoFile);
				break;
			// 录音
			case RECORD_REQUEST_CODE:
				save(resultCode, data, audioFile);
				break;
		}
	}
	
	/**
	 * 保存文件
	 * @param resultCode
	 */
	private void save(int resultCode, Intent data, String file) {
		if (resultCode == RESULT_OK) {
			String filePath = null;
			Uri uriRecorder = data.getData();
			if ("file".equals(uriRecorder.getScheme())) {
				filePath = uriRecorder.getPath().replace("file:", "");
			} else {
				Cursor cursor = this.getContentResolver().query(uriRecorder, null, null, null, null);
				if (cursor.moveToNext()) {
					// _data：文件的绝对路径 
					// _display_name：文件名
					filePath = cursor.getString(cursor.getColumnIndex("_data"));
				}
			}
			FileUtils.copyAndDelete(filePath, file);
		}
	}
	
	/**
	 * 更新照片标识信息
	 */
	private void updatePhotoPageInfo(int arg2) {
		if (pictures != null && pictures.size() > 0) {
			photoCountChanged = false;
			pageInfo.setText((arg2 + 1) + "/" + pictures.size());
		}
	}
	
	/**
	 * 初始化照片信息
	 */
	private void initPictures() {
		int photoCount1 = 0;
		int photoCount2 = 0;
		File[] files = FileUtils.getAllFiles(getImagePath(), new MediaFilter(IMAGE_POSTFIX));
		int length = files.length;
		if (files != null && length > 0) {
			if (pictures != null) {
				photoCount1 = pictures.size();
			}
			pictures = new ArrayList<File>();
			thumbnails.clear();
			for (int i = 0; i < length; i++) {
				pictures.add(files[i]);
				thumbnails.add(FileUtils.optimizeBitmap(pictures.get(i)));
			}
			photoCount2 = pictures.size();
		}
		if (photoCount1 != photoCount2) {
			photoCountChanged = true;
		}
		updatePhoto();
	}

	/**
	 * 加载默认图片
	 */
	private void updatePhoto() {
		if (thumbnails.size() < 1) {
			pageInfo.setText("");
			thumbnails.add(defaultPhoto);
		}
		photoAdapter.notifyDataSetChanged();
		if (photoCountChanged || (thumbnails.get(0) != defaultPhoto && pageInfo.getText().toString().equals(""))) {
			updatePhotoPageInfo(0);
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
				photoCountChanged = true;
				updatePhoto();
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
