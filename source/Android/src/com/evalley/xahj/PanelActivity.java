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
 * @author 麻胜海
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
				model = getString(R.string.panel_imgNav1);
				break;
			case R.id.imgNav2:
				model = getString(R.string.panel_imgNav2);
				break;
			case R.id.imgNav3:
				model = getString(R.string.panel_imgNav3);
				break;
			case R.id.imgNav4:
				model = getString(R.string.panel_imgNav4);
				break;
			case R.id.imgNav5:
				model = getString(R.string.panel_imgNav5);
				break;
			case R.id.imgNav6:
				model = getString(R.string.panel_imgNav6);
				break;
			case R.id.imgNav7:
				model = getString(R.string.panel_imgNav7);
				break;
			case R.id.imgNav8:
				model = getString(R.string.panel_imgNav8);
				break;
			case R.id.imgNav9:
				model = getString(R.string.panel_imgNav9);
				break;
		}
		Toast.makeText(this, model + ",即将推出,敬请期待!", Toast.LENGTH_SHORT).show();
	}
	
}
