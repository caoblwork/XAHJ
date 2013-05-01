package com.evalley.xahj.cases;

import android.util.Log;

import com.evalley.xahj.util.DateUtils;
import com.evalley.xahj.util.FileUtils;
import com.evalley.xahj.util.StringUtils;

public class CaseHelper {

	/**
	 * 创建一个临时的图片文件
	 * @param path
	 * @return
	 */
	public static String createTempImageFile(String caseId) {
		String file = null;
		if (StringUtils.isNotBlank(caseId)) {
			String path = getImagePath(caseId);
			String imageName = DateUtils.getCurrentTimeString() + CaseBaseActivity.IMAGE_POSTFIX;
			file = path + imageName;
		}
		return file;
	}
	
	/**
	 * 创建一个临时的视频文件
	 * @param path
	 * @return
	 */
	public static String createTempVideoFile(String caseId) {
		String file = null;
		if (StringUtils.isNotBlank(caseId)) {
			String path = getVideoPath(caseId);
			String videoName = DateUtils.getCurrentTimeString() + CaseBaseActivity.VIDEO_POSTFIX;
			file = path + videoName;
		}
		return file;
	}
	
	/**
	 * 创建一个临时的音频文件
	 * @param path
	 * @return
	 */
	public static String createTempSoundFile(String caseId) {
		String file = null;
		if (StringUtils.isNotBlank(caseId)) {
			String path = getSoundPath(caseId);
			String soundName = DateUtils.getCurrentTimeString() + CaseBaseActivity.SOUND_POSTFIX;
			file = path + soundName;
		}
		return file;
	}

	/**
	 * 获取案件的照片保存路径
	 * @param caseId 案件Id
	 * @return
	 */
	private static String getImagePath(String caseId) {
		String imagePath = FileUtils.getImageBasePath() + "/" + caseId + "/";
		FileUtils.createPath(imagePath);
		Log.i("图片保存路径", imagePath);
		return imagePath;
	}
	
	/**
	 * 获取案件的视频保存路径
	 * @param caseId 案件Id
	 * @return
	 */
	private static String getVideoPath(String caseId) {
		String videoPath = FileUtils.getVideoBasePath() + "/" + caseId + "/";
		FileUtils.createPath(videoPath);
		Log.i("视频保存路径", videoPath);
		return videoPath;
	}
	
	/**
	 * 获取案件的录音保存路径
	 * @param caseId 案件Id
	 * @return
	 */
	private static String getSoundPath(String caseId) {
		String soundPath = FileUtils.getAudioBasePath() + "/" + caseId + "/";
		FileUtils.createPath(soundPath);
		Log.i("录音保存路径:", soundPath);
		return soundPath;
	}
}
