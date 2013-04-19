package com.evalley.xahj.demo;

import java.util.Date;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.evalley.xahj.R;
import com.evalley.xahj.vo.User;

public class AfinalOrmDemoActivity extends FinalActivity {
	
	
	@ViewInject(id=R.id.textView) TextView textView; //这里使用了afinal的ioc功能，以后将会讲到
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_orm);
        
        FinalDb db = FinalDb.create(this);
        
        User user = new User();
        user.setEmail("afinal@tsz.net");
        user.setName("探索者");
        user.setRegisterDate(new Date());
        
        db.save(user);
        
        List<User> userList = db.findAll(User.class);//查询所有的用户
        
        Log.e("AfinalOrmDemoActivity", "用户数量："+ (userList!=null?userList.size():0));
        
        textView.setText(userList.get(0).getName()+":"+user.getRegisterDate());
    }
}
