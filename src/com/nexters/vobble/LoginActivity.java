package com.nexters.vobble;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class LoginActivity extends Activity {
	private ImageView loginImageView = null;
	private Intent intent = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		loginImageView = (ImageView) findViewById(R.id.login_check);
		
		loginImageView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
