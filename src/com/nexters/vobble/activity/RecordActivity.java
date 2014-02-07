package com.nexters.vobble.activity;

import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.nexters.vobble.R;
import com.nexters.vobble.record.*;
import com.nexters.vobble.util.FileIOUtils;

public class RecordActivity extends BaseActivity implements View.OnClickListener {
	public static final int RECORD_MODE = 1;
	public static final int STOP_MODE = 2;
	public static final int PLAY_MODE = 3;	
	
	private ImageView ivCameraBtn;
	private ImageView ivRecordBtn;
	private ImageView ivResetBtn;
	private Button btnConfirm;
	private RecordManager recordManager;
	private int recordMode = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_record);

        recordManager = new RecordManager();

        initResources();
		initEvents();
		FileIOUtils.deleteSoundFile();
	}
	
	private void initResources() {
		ivCameraBtn = (ImageView)findViewById(R.id.iv_record_camera);
		ivRecordBtn = (ImageView)findViewById(R.id.iv_record_record_btn);
		ivResetBtn = (ImageView)findViewById(R.id.iv_record_re_btn);
		btnConfirm = (Button) findViewById(R.id.btn_record_confirm);
	}
	
	private void initEvents() {
		ivCameraBtn.setOnClickListener(this);
		ivRecordBtn.setOnClickListener(this);
		ivResetBtn.setOnClickListener(this);
		btnConfirm.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.iv_record_camera:
			break;
		case R.id.iv_record_record_btn:
			recordStatusPattern();
			break;
		case R.id.iv_record_re_btn:
			break;
		case R.id.btn_record_confirm:
			confirm();
			break;
		}
	}

	private void recordStatusPattern() {
		switch (recordMode) {
		case RECORD_MODE:
			ivRecordBtn.setImageResource(R.drawable.record_stop_btn);
			recordManager.startRecord(FileIOUtils.getVoiceFilePath());
			recordMode = STOP_MODE;
			break;
		case STOP_MODE:
			ivRecordBtn.setImageResource(R.drawable.play_btn); // 회색
			recordManager.stopRecord();
			recordMode = PLAY_MODE;
			break;
		case PLAY_MODE:
			ivCameraBtn.setImageResource(R.drawable.record_camera_icon);
			ivRecordBtn.setImageResource(R.drawable.play2_btn);
			recordManager.playRecord(FileIOUtils.getVoiceFilePath());
			break;
		default :
			break;
		}
	}

	private void confirm() {
		if (FileIOUtils.isExistSoundFile()) {
			Intent intent = new Intent(RecordActivity.this, MapActivity.class);
			startActivity(intent);
		} else {
			alert(R.string.error_not_record);
		}
	}
}