package com.hiramine.aboutdialogtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
	}

	// オプションメニュー作成時の処理
	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.activity_main, menu );
		return true;
	}

	// オプションメニューのアイテム選択時の処理
	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		switch( item.getItemId() )
		{
			case R.id.menuitem_aboutdialog:
				AboutDialog dlg = new AboutDialog( this );
				dlg.show();
				return true;
			case R.id.menuitem_aboutactivity:
				Intent devicelistactivityIntent = new Intent( this, AboutActivity.class );
				startActivity( devicelistactivityIntent );
				return true;
		}
		return false;
	}

}
