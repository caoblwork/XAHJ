package com.evalley.xahj;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @Description 主界面
 * 
 * @author 麻胜海
 * @date 2013-4-21 下午11:27:35
 */
public class NineCellActivity extends FinalActivity {
	
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
		String model = null;
		switch (v.getId()) {
			case R.id.nav1:
				model = getString(R.string.nav1);
				break;
			case R.id.nav2:
				model = getString(R.string.nav2);
				break;
			case R.id.nav3:
				model = getString(R.string.nav3);
				break;
			case R.id.nav4:
				model = getString(R.string.nav4);
				break;
			case R.id.nav5:
				model = getString(R.string.nav5);
				break;
			case R.id.nav6:
				model = getString(R.string.nav6);
				break;
			case R.id.nav7:
				model = getString(R.string.nav7);
				break;
			case R.id.nav8:
				model = getString(R.string.nav8);
				break;
			case R.id.nav9:
				model = getString(R.string.nav9);
				break;
		}
		Toast.makeText(this, model + ",即将推出,敬请期待!", Toast.LENGTH_SHORT).show();
	}
	
}
