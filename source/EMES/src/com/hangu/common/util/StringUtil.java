package com.hangu.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * @author 李显锋
 * @version 1.0
 */
public class StringUtil {

	/**
	 * 判断一个字符串是否为有效字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidString(String str) {
		return (str != null && StringUtils.isNotBlank(str) && StringUtils.isNotEmpty(str));
	}

	/**
	 * 重置StringBuilder
	 * 
	 * @param sbf
	 */
	public static void resetStrBuf(StringBuilder sbf) {
		sbf.delete(0, sbf.length());
	}

	/**
	 * 字符串左侧补0。
	 * 
	 * @param str
	 *            待补足字符串
	 * @param length
	 *            总长度
	 */
	public static String leftAppendZero(String str, int length) {
		return StringUtils.leftPad(str, length, '0');
	}

	/**
	 * 半角转全角
	 * 
	 * @param input
	 * @return
	 */
	public static String DBCToSBC(String input) {
		// 半角转全角：
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 * @return
	 */
	public static String SBCToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 根据浏览器信息编码文件名称
	 * 
	 * @param fileName
	 * @param agent
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeFileName(String fileName, String agent) {
		String encodedFileName = "";
		try {
			if (null != agent && -1 != agent.indexOf("MSIE")) {
				encodedFileName = URLEncoder.encode(fileName, "UTF-8");
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
				encodedFileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
			} else {
				encodedFileName = fileName;
			}
		} catch (UnsupportedEncodingException e) {
			// do noting!
		}
		return encodedFileName;
	}

	/**
	 * 获得文件类型
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName) {
		String postfix = getFilePostfix(fileName);
		if ("jpg".equals(postfix) || "jpeg".equals(postfix) || "png".equals(postfix) || "gif".equals(postfix) || "bmp".equals(postfix)) {
			return "IMG";
		} else if ("wav".equals(postfix) || "mp3".equals(postfix) || "mid".equals(postfix)) {
			return "AUDIO";
		}
		return "";
	}

	/**
	 * 将文件名称转换为UUID
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getNameUUID(String fileType) {
		return UUID.randomUUID().toString().replace("-", "") + "." + getFilePostfix(fileType);
	}

	/**
	 * 获得文件后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePostfix(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	}

	public static String getAvailablePath(String path) {
		if (StringUtil.isValidString(path)) {
			return path.replace("/", "\\");
		}
		return path;
	}

	/**
	 * 判断IP是否在指定范围；
	 * 
	 * @param ipSection
	 *            ip地址区段（如：192.168.1.1-192.168.1.100）
	 * @param ip
	 *            要验证的ip地址（192.168.1.5）
	 * @return 在区段内返回true,否则返回false
	 */
	public static boolean ipIsValid(String ipSection, String ip) {
		if (ipSection == null) {
			throw new NullPointerException("IP段不能为空！");
		}
		if (ip == null) {
			throw new NullPointerException("IP不能为空！");
		}
		ipSection = ipSection.trim();
		ip = ip.trim();
		final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
		if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;
		int idx = ipSection.indexOf('-');
		String[] sips = ipSection.substring(0, idx).split("\\.");
		String[] sipe = ipSection.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		return ips <= ipt && ipt <= ipe;
	}

	/**
	 * 生成uuid字符串
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
