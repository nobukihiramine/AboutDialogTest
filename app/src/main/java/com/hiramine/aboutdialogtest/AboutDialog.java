package com.hiramine.aboutdialogtest;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutDialog
{
	private Activity m_activityParent;    // 呼び出し元

	// コンストラクタ
	public AboutDialog( Activity activity )
	{
		m_activityParent = activity;
	}

	// ダイアログの作成と表示
	public void show()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder( m_activityParent );

		// タイトル
		builder.setTitle( "About" );

		// ダイアログにカスタムレイアウトのビューの設置
		LayoutInflater inflater   = m_activityParent.getLayoutInflater();
		View           dialogView = inflater.inflate( R.layout.dialog_about, null );
		builder.setView( dialogView );

		TextView textView;

		// バージョン
		textView = (TextView)dialogView.findViewById( R.id.textview_version );
		textView.setText( m_activityParent.getString( R.string.about_version ) + " " + BuildConfig.VERSION_NAME );

		// コピーライト（URLリンク）
		textView = (TextView)dialogView.findViewById( R.id.textview_copyright );
		textView.setMovementMethod( LinkMovementMethod.getInstance() );

		// ボタン
		builder.setPositiveButton( "OK", null );

		builder.show();
	}
}
