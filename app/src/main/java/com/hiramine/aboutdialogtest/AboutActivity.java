package com.hiramine.aboutdialogtest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_about );

		// タイトル
		setTitle( R.string.about_title );

		TextView textView;

		// バージョン
		textView = (TextView)findViewById( R.id.textview_version );
		textView.setText( getString( R.string.about_version ) + " " + BuildConfig.VERSION_NAME );

		// コピーライト（URLリンク）
		textView = (TextView)findViewById( R.id.textview_copyright );
		textView.setMovementMethod( LinkMovementMethod.getInstance() );

		// アクションバーに前画面に戻る機能をつける
		ActionBar actionBar = getSupportActionBar();
		if( null != actionBar )
		{
			actionBar.setDisplayHomeAsUpEnabled( true );
		}
	}

	// オプションメニューのアイテム選択時の処理
	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		switch( item.getItemId() )
		{
			case android.R.id.home:    // 戻る
				finish();
				return true;
		}
		return true;
	}
}
