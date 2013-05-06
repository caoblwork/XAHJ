package com.evalley.xahj;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * @Description 主界面
 * 
 * @author Evalley
 * @date 2013-4-21 下午11:27:35
 */
public class PanelActivity extends FinalActivity {
	
	@ViewInject(id=R.id.imgNav1,click="forward") ImageButton imgNav1;
	@ViewInject(id=R.id.imgNav2,click="forward") ImageButton imgNav2;
	@ViewInject(id=R.id.imgNav3,click="forward") ImageButton imgNav3;
	@ViewInject(id=R.id.imgNav4,click="forward") ImageButton imgNav4;
	@ViewInject(id=R.id.imgNav5,click="forward") ImageButton imgNav5;
	@ViewInject(id=R.id.imgNav6,click="forward") ImageButton imgNav6;
	@ViewInject(id=R.id.imgNav7,click="forward") ImageButton imgNav7;
	@ViewInject(id=R.id.imgNav8,click="forward") ImageButton imgNav8;
	@ViewInject(id=R.id.imgNav9,click="forward") ImageButton imgNav9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panel);
	}

	/**
	 * 模块导航
	 */
	public void forward(View v){
		String model = null;
		switch (v.getId()) {
			case R.id.imgNav1:
				model = getString(R.string.nav1);
				break;
			case R.id.imgNav2:
				model = getString(R.string.nav2);
				break;
			case R.id.imgNav3:
				model = getString(R.string.nav3);
				break;
			case R.id.imgNav4:
				model = getString(R.string.nav4);
				break;
			case R.id.imgNav5:
				model = getString(R.string.nav5);
				break;
			case R.id.imgNav6:
				model = getString(R.string.nav6);
				break;
			case R.id.imgNav7:
				model = getString(R.string.nav7);
				break;
			case R.id.imgNav8:
				model = getString(R.string.nav8);
				break;
			case R.id.imgNav9:
				model = getString(R.string.nav9);
				break;
		}
		Toast.makeText(this, model + ",即将推出,敬请期待!", Toast.LENGTH_SHORT).show();
	}
	
}
