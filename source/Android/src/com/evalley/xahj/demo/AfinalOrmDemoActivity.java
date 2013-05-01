package com.evalley.xahj.demo;

import java.io.IOException;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.evalley.xahj.R;
import com.evalley.xahj.vo.Blog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AfinalOrmDemoActivity extends FinalActivity {

	@ViewInject(id = R.id.textView)
	TextView textView; // 这里使用了afinal的ioc功能，以后将会讲到

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_orm);
		
		

//		FinalDb db = FinalDb.create(this);
//
//		User user = new User();
//		user.setEmail("afinal@tsz.net");
//		user.setName("探索者");
//		user.setRegisterDate(new Date());
//
//		db.save(user);
//
//		List<User> userList = db.findAll(User.class);// 查询所有的用户
//
//		Log.e("AfinalOrmDemoActivity", "用户数量：" + (userList != null ? userList.size() : 0));
//
//		textView.setText(userList.get(0).getName() + ":" + user.getRegisterDate());

//		FinalHttp fh = new FinalHttp();
//
//		AjaxParams params = new AjaxParams();
//		params.put("action", "test");
//		params.put("username", "aaaaa");
//		try {
//			params.put("file", new File("/mnt/sdcard/1.jpg"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		//String serverUrl = "http://192.168.0.22:8080/XAHJServer/blog/test.do";
		String serverUrl = "http://192.168.0.105:8080/XAHJServer/blog/list.do";

//		fh.post(serverUrl, params, new AjaxCallBack<Object>() {
//
//			@Override
//			public void onLoading(long count, long current) {
//				textView.setText(current+"/"+count);
//				super.onLoading(count, current);
//			}
//
//			@Override
//			public void onSuccess(Object t) {
//				Log.i("AfinalOrmDemoActivity", "返回信息是+" + t.toString());
//				textView.setText(t.toString());
//				
//				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
//				try {
//					Blog blog = mapper.readValue(t.toString(), Blog.class);
//					blog.toString();
//				} catch (JsonParseException e) {
//					e.printStackTrace();
//				} catch (JsonMappingException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
}
