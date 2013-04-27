package com.evalley.xahj;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.evalley.xahj.util.ActivityUtils;

/**
 * @Description 主界面
 * 
 * @author 麻胜海
 * @date 2013-4-21 下午11:27:35
 */
public class NineCellActivity extends FinalActivity {
	
	/**
	 * 任务管理
	 */
	private final String[] task = {"例行监察","“三同时”监察","减排项目","信访处理","指派任务","专项行动","在线监控","断面监测异常"};
	/**
	 * 移动应急
	 */
	private final String[] emergency = {"人员定位", "即拍即传","应急手册","专家资料库","危险品属性库"};
	/**
	 * 信息查询
	 */
	private final String[] infoSearch = {"一厂一档查询", "环境质量查询"};
	/**
	 * 地图功能
	 */
	private final String[] map = {"信息查看", "GPS定位", "环保专题图查询"};
	/**
	 * 设置
	 */
	public static final String[] setting = {"帮    助", "检查更新", "关    于"};
	/**
	 * 窗口对话框
	 */
	private Window window;
	
	@ViewInject(id=R.id.nav1,click="forward") LinearLayout nav1Layout;
	@ViewInject(id=R.id.nav2,click="forward") LinearLayout nav2Layout;
	@ViewInject(id=R.id.nav3,click="forward") LinearLayout nav3Layout;
	@ViewInject(id=R.id.nav4,click="forward") LinearLayout nav4Layout;
	@ViewInject(id=R.id.nav5,click="forward") LinearLayout nav5Layout;
	@ViewInject(id=R.id.nav6,click="forward") LinearLayout nav6Layout;
	@ViewInject(id=R.id.nav7,click="forward") LinearLayout nav7Layout;
	@ViewInject(id=R.id.nav8,click="forward") LinearLayout nav8Layout;
	@ViewInject(id=R.id.nav9,click="forward") LinearLayout nav9Layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nine_cell);
	}

	/**
	 * 模块导航
	 */
	public void forward(View v){
		switch (v.getId()) {
			case R.id.nav1:
				taskDialog();
				break;
			case R.id.nav2:
				break;
			case R.id.nav3:
				emergencyDialog();
				break;
			case R.id.nav4:
				infoSearchDialog();
				break;
			case R.id.nav5:
				break;
			case R.id.nav6:
				break;
			case R.id.nav7:
				mapDialog();
				break;
			case R.id.nav8:
				break;
			case R.id.nav9:
				settingDialog();
				break;
		}
		//Toast.makeText(this, model + ",即将推出,敬请期待!", Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 任务管理
	 */
    protected void taskDialog() {
    	final AlertDialog dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
		window = dialog.getWindow();
		window.setContentView(R.layout.dialog);
		
		ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
		TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
		titleTxt.setText(getString(R.string.nav1));
		final TextView itemTxt1 = getTextView(R.id.itemTxt1, task[0]);
		final TextView itemTxt2 = getTextView(R.id.itemTxt2, task[1]);
		final TextView itemTxt3 = getTextView(R.id.itemTxt3, task[2]);
		final TextView itemTxt4 = getTextView(R.id.itemTxt4, task[3]);
		final TextView itemTxt5 = getTextView(R.id.itemTxt5, task[4]);
		final TextView itemTxt6 = getTextView(R.id.itemTxt6, task[5]);
		final TextView itemTxt7 = getTextView(R.id.itemTxt7, task[6]);
		final TextView itemTxt8 = getTextView(R.id.itemTxt8, task[7]);
		
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		itemTxt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt1.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt3.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt4.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt5.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt6.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt7.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt8.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		
		window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - getParent().findViewById(R.id.mainBtnLayout).getHeight());
		window.setBackgroundDrawableResource(android.R.color.transparent); 
		window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
		window.setWindowAnimations(R.style.dialogStyle); // 添加动画
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
     * 移动应急
     */
    protected void emergencyDialog() {
    	final AlertDialog dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
		window = dialog.getWindow();
		window.setContentView(R.layout.dialog);
		
		ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
		TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
		titleTxt.setText(getString(R.string.nav3));
		final TextView itemTxt1 = getTextView(R.id.itemTxt1, emergency[0]);
		final TextView itemTxt2 = getTextView(R.id.itemTxt2, emergency[1]);
		final TextView itemTxt3 = getTextView(R.id.itemTxt3, emergency[2]);
		final TextView itemTxt4 = getTextView(R.id.itemTxt4, emergency[3]);
		final TextView itemTxt5 = getTextView(R.id.itemTxt5, emergency[4]);
		
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		itemTxt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt1.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt3.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt4.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		itemTxt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(NineCellActivity.this, itemTxt5.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		
		window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - getParent().findViewById(R.id.mainBtnLayout).getHeight());
		window.setBackgroundDrawableResource(android.R.color.transparent); 
		window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
		window.setWindowAnimations(R.style.dialogStyle); // 添加动画
    }
    
    /**
     * 地图功能
     */
    protected void mapDialog() {
    	final AlertDialog dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
    	window = dialog.getWindow();
    	window.setContentView(R.layout.dialog);
    	
    	ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
    	TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
    	titleTxt.setText(getString(R.string.nav7));
    	final TextView itemTxt1 = getTextView(R.id.itemTxt1, map[0]);
    	final TextView itemTxt2 = getTextView(R.id.itemTxt2, map[1]);
    	final TextView itemTxt3 = getTextView(R.id.itemTxt3, map[2]);
    	
    	backBtn.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			dialog.dismiss();
    		}
    	});
    	itemTxt1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt1.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt3.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt3.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	
    	window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - getParent().findViewById(R.id.mainBtnLayout).getHeight());
    	window.setBackgroundDrawableResource(android.R.color.transparent); 
    	window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
    	window.setWindowAnimations(R.style.dialogStyle); // 添加动画
    }
    
    /**
     * 设置
     */
    protected void settingDialog() {
    	final AlertDialog dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
    	window = dialog.getWindow();
    	window.setContentView(R.layout.dialog);
    	
    	ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
    	TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
    	titleTxt.setText(getString(R.string.nav9));
    	final TextView itemTxt1 = getTextView(R.id.itemTxt1, setting[0]);
    	final TextView itemTxt2 = getTextView(R.id.itemTxt2, setting[1]);
    	final TextView itemTxt3 = getTextView(R.id.itemTxt3, setting[2]);
    	
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
    			Intent intent = new Intent(NineCellActivity.this, HelpActivity.class);
    			startActivity(intent);
    			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
    	itemTxt2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt3.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			/**
    			 * 关于
    			 */
    			Intent intent = new Intent(NineCellActivity.this, AboutActivity.class);
    			startActivity(intent);
    			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    		}
    	});
    	
    	window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - getParent().findViewById(R.id.mainBtnLayout).getHeight());
    	window.setBackgroundDrawableResource(android.R.color.transparent); 
    	window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
    	window.setWindowAnimations(R.style.dialogStyle); // 添加动画
    }
    
    /**
     * 信息查询
     */
    protected void infoSearchDialog() {
    	final AlertDialog dialog = new AlertDialog.Builder(this).create();
    	dialog.show();
    	window = dialog.getWindow();
    	window.setContentView(R.layout.dialog);
    	
    	ImageButton backBtn = (ImageButton)window.findViewById(R.id.backBtn);
    	TextView titleTxt = (TextView)window.findViewById(R.id.titleTxt);
    	titleTxt.setText(getString(R.string.nav4));
    	final TextView itemTxt1 = getTextView(R.id.itemTxt1, infoSearch[0]);
    	final TextView itemTxt2 = getTextView(R.id.itemTxt2, infoSearch[1]);
    	
    	backBtn.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			dialog.dismiss();
    		}
    	});
    	itemTxt1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt1.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	itemTxt2.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			Toast.makeText(NineCellActivity.this, itemTxt2.getText().toString(), Toast.LENGTH_SHORT).show();
    		}
    	});
    	
    	
    	window.setLayout(ActivityUtils.getScreenWidth(this), ActivityUtils.getScreenHeight(this) - getParent().findViewById(R.id.mainBtnLayout).getHeight());
    	window.setBackgroundDrawableResource(android.R.color.transparent); 
    	window.setGravity(Gravity.CENTER|Gravity.TOP); // 此处可以设置dialog显示的位置
    	window.setWindowAnimations(R.style.dialogStyle); // 添加动画
    }
    
	@Override
	public void onBackPressed() {
		ActivityUtils.quit(this);
	}
	
}
