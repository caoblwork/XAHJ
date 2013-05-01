package com.evalley.xahj;

import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.widget.TextView;

import com.evalley.xahj.util.JsonUtils;
import com.evalley.xahj.vo.Blog;
import com.fasterxml.jackson.core.type.TypeReference;

public class JSONDemoActivity extends FinalActivity {

	@ViewInject(id = R.id.text) TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jsondemo);
		
		//String src = "{\"id\":100,\"content\":\"This is a very cool article\",\"title\":\"Oh My God!\",\"author\":\"Yidao\"}";
//		Blog blog = (Blog)JsonUtils.json2Object(src, Blog.class);
//		blog.toString();
		String src = "[{\"id\":100,\"content\":\"This is a very cool article\",\"title\":\"Oh My God!\",\"author\":\"Yidao\"},{\"id\":100,\"content\":\"This is a very cool article\",\"title\":\"Oh My God!\",\"author\":\"Yidao\"}]";
		List<Blog> blogs = JsonUtils.json2GenericObject(src, new TypeReference<List<Blog>>(){});
		blogs.toString();
//		String src = "{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"}";
//		textView.setText(src);
//		
//		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
//		try {
//			UserVo user = mapper.readValue(src, UserVo.class);
//			user.toString();
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}
