package com.evalley.xahj.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.evalley.xahj.Constants;

public class FileUtils {
	
	/**
	 * 删除文件
	 * @param filePath
	 */
	public static void deleteFile(String filePath) {
		try {
			if (StringUtils.isNotBlank(filePath)) {
				File file = new File(filePath);
				if (file.exists()) {
					file.delete();
				}
			}
		} catch (Exception e) {
			System.out.println("删除文件出错: " + filePath);
			e.printStackTrace();
		}
	}
	
	/**
	 * 图片显示内存优化
	 * @param resource
	 * @param maxWidth
	 * @param maxHeight
	 * @return
	 */
	public static Bitmap optimizeBitmap(File file) {  
		Bitmap result = null;
		FileInputStream inputStream = null;
		try {
			if (file != null && file.exists()) {
				inputStream = new FileInputStream(file);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 4;
				result = BitmapFactory.decodeStream(inputStream, null, options);  
			}				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(inputStream);
		}
		return result;  
	}
	
	/**
	 * 关闭文件流
	 * @param stream
	 */
	public static void close(Closeable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取文件夹下的所有文件
	 * @param path
	 * @param filter
	 * @return
	 */
	public static File[] getAllFiles(String path, FilenameFilter filter) {
		File[] files = null;
		if (StringUtils.isNotBlank(path)) {
			files = new File(path).listFiles(filter);
		}
		
		return files;
	}
	
	/**
	 * 判断文件夹下是否有指定的文件
	 * @param path
	 * @param filter
	 * @return
	 */
	public static boolean hasFile(String path, FilenameFilter filter) {
		File[] files = new File(path).listFiles(filter);
		if (files != null && files.length > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获得SD卡根目录路径
	 * 
	 * @return String类型 SD卡根目录路径
	 */
	public static String getSdCardAbsolutePath() {
		return Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
	}

	/**
	 * 获取项目文件夹在SD卡中的路径
	 * 
	 * @return
	 */
	public static String getProjectPath() {
		String projectPath = getSdCardAbsolutePath() + Constants.PROJECT_CODE;
		createPath(projectPath);
		return projectPath;
	}
	
	/**
	 * 获取图片文件路径
	 * 
	 * @return
	 */
	public static String getImageBasePath() {
		String imagePath = getProjectPath() + "/image/";
		createPath(imagePath);
		return imagePath;
	}
	
	/**
	 * 获取视频文件路径
	 * 
	 * @return
	 */
	public static String getVideoBasePath() {
		String imagePath = getProjectPath() + "/video";
		createPath(imagePath);
		return imagePath;
	}
	
	/**
	 * 获取音频文件路径
	 * 
	 * @return
	 */
	public static String getAudioBasePath() {
		String imagePath = getProjectPath() + "/audio";
		createPath(imagePath);
		return imagePath;
	}
	
	/**
	 * 创建目录
	 */
	public static void createPath(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
}
