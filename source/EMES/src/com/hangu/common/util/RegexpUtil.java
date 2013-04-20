package com.hangu.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * 正则表达式验证数据或提取数据工具类
 * 
 * @author 徐浩
 * 
 */
public final class RegexpUtil {

    private static final Logger LOGGER = Logger.getLogger(RegexpUtil.class);

    private static PatternCompiler compiler = new Perl5Compiler();

    private static PatternMatcher matcher = new Perl5Matcher();

    /**
     * 保放有四组对应分隔符
     */
    static final Set<String> SEPARATOR_SET = new TreeSet<String>();
    {
        SEPARATOR_SET.add("(");
        SEPARATOR_SET.add(")");
        SEPARATOR_SET.add("[");
        SEPARATOR_SET.add("]");
        SEPARATOR_SET.add("{");
        SEPARATOR_SET.add("}");
        SEPARATOR_SET.add("<");
        SEPARATOR_SET.add(">");
    }

    /**
     * 存放各种正规表达式(以key->value的形式)
     */
    public static HashMap<String, String> regexpHash = new HashMap<String, String>();

    /**
     * 存放各种正规表达式(以key->value的形式)
     */
    public static List<Object> matchingResultList = new ArrayList<Object>();

    /**
     * 匹配图象 <br>
     * 
     * 格式: /相对路径/文件名.后缀 (后缀为gif,dmp,png)
     * 
     * 匹配 : /forum/head_icon/admini2005111_ff.gif 或 admini2005111.dmp<br>
     * 
     * 不匹配: c:/admins4512.gif
     * 
     */
    public static final String icon_regexp = "^(/{0,1}\\w){1,}\\.(gif|dmp|png|jpg)$|^\\w{1,}\\.(gif|dmp|png|jpg)$";

    /**
     * 匹配email地址 <br>
     * 
     * 格式: XXX@XXX.XXX.XX
     * 
     * 匹配 : foo@bar.com 或 foobar@foobar.com.au <br>
     * 
     * 不匹配: foo@bar 或 $$$@bar.com
     * 
     */
    public static final String email_regexp = "(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)";

    /**
     * 匹配匹配并提取url <br>
     * 
     * 格式: XXXX://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX
     * 
     * 匹配 : http://www.suncer.com 或news://www<br>
     * 
     * 提取(MatchResult matchResult=matcher.getMatch()): matchResult.group(0)=
     * http://www.suncer.com:8080/index.html?login=true matchResult.group(1) =
     * http matchResult.group(2) = www.suncer.com matchResult.group(3) = :8080
     * matchResult.group(4) = /index.html?login=true
     * 
     * 不匹配: c:\window
     * 
     */
    public static final String url_regexp = "(\\w+)://([^/:]+)(:\\d*)?([^#\\s]*)";

    /**
     * 匹配并提取http <br>
     * 
     * 格式: http://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX 或 ftp://XXX.XXX.XXX 或
     * https://XXX
     * 
     * 匹配 : http://www.suncer.com:8080/index.html?login=true<br>
     * 
     * 提取(MatchResult matchResult=matcher.getMatch()): matchResult.group(0)=
     * http://www.suncer.com:8080/index.html?login=true matchResult.group(1) =
     * http matchResult.group(2) = www.suncer.com matchResult.group(3) = :8080
     * matchResult.group(4) = /index.html?login=true
     * 
     * 不匹配: news://www
     * 
     */
    public static final String http_regexp = "(http|https|ftp)://([^/:]+)(:\\d*)?([^#\\s]*)";

    /**
     * 匹配日期 <br>
     * 
     * 格式(首位不为0): XXXX-XX-XX 或 XXXX XX XX 或 XXXX-X-X <br>
     * 
     * 范围:1900--2099 <br>
     * 
     * 匹配 : 2005-04-04 <br>
     * 
     * 不匹配: 01-01-01
     * 
     */
    public static final String date_regexp = "^((((19){1}|(20){1})d{2})|d{2})[-\\s]{1}[01]{1}d{1}[-\\s]{1}[0-3]{1}d{1}$";

    /**
     * 匹配身份证 （15位或18位）
     */
    public static final String ID_card_regexp = "^([1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3})|([1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X))$";

    /**
     * 匹配邮编代码
     */
    public static final String ZIP_regexp = "^[0-9]{6}$";

    /**
     * 不包括特殊字符的匹配 (字符串中不包括符号 数学次方号^ 单引号' 双引号" 分号; 逗号, 帽号: 数学减号- 右尖括号> 左尖括号< 反斜杠\ 空格,制表符,回车符等 )
     */
    public static final String non_special_char_regexp = "^[^'\"\\;,:-<>\\s].+$";

    /**
     * 匹配非负整数（正整数 + 0)
     */
    public static final String non_negative_integers_regexp = "^\\d+$";

    /**
     * 匹配不包括零的非负整数（正整数 > 0)
     */
    public static final String non_zero_negative_integers_regexp = "^[1-9]+\\d*$";

    /**
     * 匹配正整数
     */
    public static final String positive_integer_regexp = "^[0-9]*[1-9][0-9]*$";

    /**
     * 匹配非正整数（负整数 + 0）
     */
    public static final String non_positive_integers_regexp = "^((-\\d+)|(0+))$";

    /**
     * 匹配负整数
     */
    public static final String negative_integers_regexp = "^-[0-9]*[1-9][0-9]*$";

    /**
     * 匹配整数
     */
    public static final String integer_regexp = "^-?\\d+$";

    /**
     * 匹配非负浮点数（正浮点数 + 0）
     */
    public static final String non_negative_rational_numbers_regexp = "^\\d+(\\.\\d+)?$";

    /**
     * 匹配正浮点数
     */
    public static final String positive_rational_numbers_regexp = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";

    /**
     * 匹配非正浮点数（负浮点数 + 0）
     */
    public static final String non_positive_rational_numbers_regexp = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";

    /**
     * 匹配负浮点数
     */
    public static final String negative_rational_numbers_regexp = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";

    /**
     * 匹配浮点数
     */
    public static final String rational_numbers_regexp = "^(-?\\d+)(\\.\\d+)?$";

    /**
     * 匹配由26个英文字母组成的字符串
     */
    public static final String letter_regexp = "^[A-Za-z]+$";

    /**
     * 匹配由26个英文字母的大写组成的字符串
     */
    public static final String upward_letter_regexp = "^[A-Z]+$";

    /**
     * 匹配由26个英文字母的小写组成的字符串
     */
    public static final String lower_letter_regexp = "^[a-z]+$";

    /**
     * 匹配由数字和26个英文字母组成的字符串
     */
    public static final String letter_number_regexp = "^[A-Za-z0-9]+$";

    /**
     * 匹配由数字、26个英文字母或者下划线组成的字符串
     */
    public static final String letter_number_underline_regexp = "^\\w+$";

    /**
     * 电话号码(含手机、固话、分机)
     */
    public static final String phone_regexp = "^(1[3-9]\\d{9})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$";

    /**
     * 固定电话号 
     */
    public static final String telephone_regexp = "^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$";

    /**
     * 手机号码 
     */
    public static final String mobile_regexp = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$";

    /**
     * 采集批次
     * 格式：共6位数字，前4位是年，后两位是顺序号
     */
    public static final String batchCode_regexp = "^(20\\d{4})$";

    /**
     * 添加正规表达式 (以key->value的形式存储)
     * 
     * @param regexpName 该正规表达式名称 
     * @param regexp 该正规表达式内容
     */
    public void putRegexpHash(String regexpName, String regexp) {
        regexpHash.put(regexpName, regexp);
    }

    /**
     * 得到正规表达式内容 (通过key名提取出value[正规表达式内容])
     * 
     * @param regexpName 正规表达式名称
     * 
     * @return 正规表达式内容
     */
    public String getRegexpHash(String regexpName) {
        if (regexpHash.get(regexpName) != null) {
            return regexpHash.get(regexpName);
        } else {
            System.out.println("在regexpHash中没有此正规表达式");
            return "";
        }
    }

    /**
     * 清除正规表达式存放单元
     */
    public void clearRegexpHash() {
        regexpHash.clear();
        return;
    }

    /**
     * 大小写敏感的正规表达式批配
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回真,否则返回假
     */
    public static boolean isHardRegexpValidate(String source, String regexp) {
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 实例大小大小写敏感的正规表达式模板
            Pattern hardPattern = compiler.compile(regexp);
            // 返回批配结果
            return matcher.contains(source, hardPattern);
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 不区分大小写的正规表达式批配
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回真,否则返回假
     */
    public static boolean isSoftRegexpValidate(String source, String regexp) {
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 实例不区分大小写的正规表达式模板
            Pattern softPattern = compiler.compile(regexp, Perl5Compiler.CASE_INSENSITIVE_MASK);
            // 返回批配验证值
            return matcher.contains(source, softPattern);
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 返回许要的批配结果集(大小写敏感的正规表达式批配)
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回许要的批配结果集,否则返回 "null"关键字 <br>
     *         如 : MatchResult matchResult = getHardRegexpMatchResult(
     *         "http://www.suncer.com:8080/index.html?login=true"
     *         ,Regexp.url_regexp) 得到取出的匹配值为 matchResult.group(0)=
     *         http://www.suncer.com:8080/index.html?login=true
     *         matchResult.group(1) = http matchResult.group(2) = www.suncer.com
     *         matchResult.group(3) = :8080 matchResult.group(4) =
     *         /index.html?login=true
     * 
     */
    public static MatchResult getHardRegexpMatchResult(String source, String regexp) {
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 实例大小大小写敏感的正规表达式模板
            Pattern hardPattern = compiler.compile(regexp);
            // 如果批配结果正确,返回取出的批配结果
            if (matcher.contains(source, hardPattern)) {
                return matcher.getMatch();
            }
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回许要的批配结果集(不区分大小写的正规表达式批配)
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回许要的批配结果集,否则返回 "null"关键字 
     *         如 : MatchResult matchResult = getHardRegexpMatchResult
     *         ("http://www.suncer.com:8080/index.html?login=true"
     *         ,Regexp.url_regexp) 得到取出的匹配值为 matchResult.group(0)=
     *         http://www.suncer.com:8080/index.html?login=true
     *         matchResult.group(1) = http matchResult.group(2) = www.suncer.com
     *         matchResult.group(3) = :8080 matchResult.group(4) =
     *         /index.html?login=true
     */
    public static MatchResult getSoftRegexpMatchResult(String source, String regexp) {
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 实例不区分大小写的正规表达式模板
            Pattern softPattern = compiler.compile(regexp, Perl5Compiler.CASE_INSENSITIVE_MASK);
            // 如果批配结果正确,返回取出的批配结果
            if (matcher.contains(source, softPattern)) {
                return matcher.getMatch();
            }
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回许要的批配结果集(大小写敏感的正规表达式批配)
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回许要的批配结果集,
     *         {@link #getHardRegexpMatchResult(String, String)
     *         使用方法参见getHardRegexpMatchResult(String, String)}
     */
    public static ArrayList<String> getHardRegexpArray(String source, String regexp) {
        List<String> tempList = new ArrayList<String>();
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 实例大小大小写敏感的正规表达式模板
            Pattern hardPattern = compiler.compile(regexp);
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 如果批配结果正确,返回取出的批配结果
            if (matcher.contains(source, hardPattern)) {
                // 存放取出值的正规表达式比较批配结果对象
                MatchResult matchResult = matcher.getMatch();
                for (int i = 0; i < matchResult.length()
                        && matchResult.group(i) != null; i++) {
                    tempList.add(i, matchResult.group(i));
                }
            }
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) tempList;
    }

    /**
     * 返回许要的批配结果集(不区分大小写的正规表达式批配)
     * 
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回许要的批配结果集
     *         {@link #getHardRegexpMatchResult(String, String)
     *         使用方法参见getHardRegexpMatchResult(String, String)}
     */
    public static ArrayList<String> getSoftRegexpArray(String source, String regexp) {
        List<String> tempList = new ArrayList<String>();
        try {
            // 用于定义正规表达式对象模板类型
            PatternCompiler compiler = new Perl5Compiler();
            // 正规表达式比较批配对象
            PatternMatcher matcher = new Perl5Matcher();
            // 实例不区分大小写的正规表达式模板
            Pattern softPattern = compiler.compile(regexp, Perl5Compiler.CASE_INSENSITIVE_MASK);
            if (matcher.contains(source, softPattern)) {
                // 如果批配结果正确,返回取出的批配结果
                MatchResult matchResult = matcher.getMatch();
                for (int i = 0; i < matchResult.length() && matchResult.group(i) != null; i++) {
                    tempList.add(i, matchResult.group(i));
                }
            }
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) tempList;
    }

    /**
     * <pre>
     * 得到指定分隔符中间的字符串的集合,
     *              说明: 1.分隔符为 ()，[]，{}，<> 中的一组
     *                        2.得到的集合以 ASCII 的升序排列
     *              如       String originStr="((([a]+[b])/[c])-24)+[d]";
     *              则          getStrBetweenSeparator(originStr,"[","]"));
     *                           返回结果集合有四个元素  [a, b, c, d],
     *                          以 ASCII 的升序排列
     * </pre>
     * 
     * @param originStr
     *            要提取的源字符串
     * @param leftSeparator
     *            左边的分隔符
     * @param rightSeparator
     *            右边的分隔符
     * @return 指定分隔符中间的字符串的集合
     */
    public static Set<String> getBetweenSeparatorStr(final String originStr,
            final char leftSeparator, final char rightSeparator) {
        Set<String> variableSet = new TreeSet<String>();
        if (StringUtils.isEmpty(originStr)) {
            return variableSet;
        }
        String sTempArray[] = originStr.split("(\\" + leftSeparator + ")");
        for (int i = 1; i < sTempArray.length; i++) {
            int endPosition = sTempArray[i].indexOf(rightSeparator);
            String sTempVariable = sTempArray[i].substring(0, endPosition);
            variableSet.add(sTempVariable);
        }
        return variableSet;
    }

    /**
     * 判断正则表达式和文字列是否 匹配
     * 
     * @param text 文字列
     * @param regxp 正则表达式
     * @return
     * @throws MalformedPatternException
     */
    public static boolean isEquals(String text, String regxp) {
        if (text == null) {
            return false;
        }
        try {
            Pattern pattern = compiler.compile(regxp, Perl5Compiler.SINGLELINE_MASK);
            return matcher.matches(text, pattern);
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据正则表达式从文字列中提取匹配内容
     * 
     * @param text 文字列
     * @param regxp 正则表达式
     * @return
     * @throws MalformedPatternException
     */
    public static String extractRegText(String text, String regxp)
            throws MalformedPatternException {
        if (text == null) {
            return "";
        }
        Pattern pattern = compiler.compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        if (matcher.contains(text, pattern)) {
            return matcher.getMatch().toString();
        }
        return "";
    }

    /**
     * @param text
     * @param regxp
     * @return
     * @throws MalformedPatternException
     */
    public static List<String> extractRegxpContains(String text, String regxp)
            throws MalformedPatternException {
        List<String> results = new ArrayList<String>();
        Pattern pattern = compiler
                .compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        PatternMatcherInput input = new PatternMatcherInput(text);
        while (matcher.contains(input, pattern)) {
            String string = matcher.getMatch().toString();
            results.add(string);
        }
        return results;
    }

    /**
     * 按照正则表达式分拆文字列
     * 
     * @param text 文字列
     * @param regxp 正则表达式
     * @return
     * @throws MalformedPatternException
     */
    public static List<String> splitRegxpGroups(String text, String regxp)
            throws MalformedPatternException {
        List<String> results = new ArrayList<String>();
        Pattern pattern = new Perl5Compiler().compile(regxp,
                Perl5Compiler.SINGLELINE_MASK);
        PatternMatcherInput matcherInput = new PatternMatcherInput(text);
        while (matcher.contains(matcherInput, pattern)) {
            for (int i = 0; i < matcher.getMatch().groups(); i++) {
                String info = matcher.getMatch().group(i);
                LOGGER.info(info);
                results.add(info);
            }
        }
        return results;
    }
}