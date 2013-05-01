package com.evalley.xahj.cases;


import java.io.File;
import java.io.FilenameFilter;

/**
 * @Description 多媒体文件过滤器类
 * @author 麻胜海
 * @date 2011-10-17 下午05:31:40
 */
public class MediaFilter implements FilenameFilter {

	// 文件后缀 
	private String postFIx;
	
	public MediaFilter(String postFIx) {
		super();
		this.postFIx = postFIx;
	}

	public boolean accept(File dir, String filename) {
		return (filename.endsWith(postFIx));
	}
}

