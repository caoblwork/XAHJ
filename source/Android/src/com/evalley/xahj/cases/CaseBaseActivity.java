package com.evalley.xahj.cases;

import net.tsz.afinal.FinalActivity;
import android.os.Bundle;
import android.util.Log;

import com.evalley.xahj.util.FileUtils;
import com.evalley.xahj.util.StringUtils;
import com.evalley.xahj.util.UUIDGenerator;

/**
 * @Description 案件基类
 * @author Evalley
 * @date 2011-10-11 上午11:11:00
 */
public class CaseBaseActivity extends FinalActivity {
	
	// 案件Id
	public static final String CASE_ID_KEY = "caseId";
	// 照片文件后缀
	public static final String IMAGE_POSTFIX = ".jpg";
	// 视频文件后缀
	public static final String VIDEO_POSTFIX = ".mp4";
	// 录音文件后缀
	public static final String SOUND_POSTFIX = ".mar";
	
	private String TAG;
		
	// 案件临时Id
	private String caseUUId;
	// 照片存放路径
	private String imagePath;
	// 视频存放路径
	private String videoPath;
	// 录音存放路径
	private String soundPath;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TAG = getClass().getSimpleName();
		initialize();
	}
	
	/**
	 * 初始化工作
	 */
	private void initialize() {
		initCaseId();
	}
	
	/**
	 * 初始化案件Id
	 */
	private void initCaseId() {
//		if (StringUtils.isBlank(this.caseUUId)) {
//			this.caseUUId = getIntent().getStringExtra(CASE_ID_KEY);
//			Log.i(TAG, "案件编号:" + caseUUId);
//		}
		caseUUId = UUIDGenerator.getUUID();
		Log.i(TAG, "案件编号:" + caseUUId);
	}
	
    /**
     * 判断是否存在附件
     * @return
     */
    protected boolean existEvidence() {
    	if(FileUtils.hasFile(this.getImagePath(), new MediaFilter(IMAGE_POSTFIX))) {
    		return true;
    	}
    	if(FileUtils.hasFile(this.getVideoPath(), new MediaFilter(VIDEO_POSTFIX))) {
    		return true;
    	}
	    if(FileUtils.hasFile(this.getSoundPath(), new MediaFilter(SOUND_POSTFIX))) {
	    	return true;
	    }
	    return false;
    }
	
    /**
     * 获取案件Id
     * @return
     */
	public String getCaseUUId() {
		if (StringUtils.isBlank(caseUUId)) {
			caseUUId = UUIDGenerator.getUUID();
		}
		return caseUUId;
	}

	/**
	 * 获取图片保存路径
	 * @return
	 */
	public String getImagePath() {
		if (StringUtils.isBlank(imagePath)) {
			imagePath= FileUtils.getImageBasePath() + this.getCaseUUId() + "/";
			FileUtils.createPath(imagePath);
		}
		Log.i("MSH", "图片保存路径: " + imagePath);
		return imagePath;
	}

	/**
	 * 获取视频保存路径
	 * @return
	 */
	public String getVideoPath() {
		if (StringUtils.isBlank(videoPath)) {
			videoPath = FileUtils.getVideoBasePath() + this.getCaseUUId() + "/";
			FileUtils.createPath(videoPath);
		}
		Log.i("MSH", "视频保存路径: " + videoPath);
		return videoPath;
	}

	/**
	 * 获取录音保存路径
	 * @return
	 */
	public String getSoundPath() {
		if (StringUtils.isBlank(soundPath)) {
			soundPath = FileUtils.getAudioBasePath() + this.getCaseUUId() + "/";
			FileUtils.createPath(soundPath);
		}
		Log.i("MSH", "录音保存路径: " + soundPath);
		return soundPath;
	}

}
