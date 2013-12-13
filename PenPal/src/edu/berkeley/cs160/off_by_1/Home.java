package edu.berkeley.cs160.off_by_1;

import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_home);

		//R.id.unreadText
		int unreadMessages = 2;
		String unreadMsgString = getResources().getQuantityString(R.plurals.unread_messages, unreadMessages, unreadMessages);
		TextView unreadMessagesText = (TextView) findViewById(R.id.unreadText);
		unreadMessagesText.setText(unreadMsgString);
	}

	@Override
	public void onActivityResult(int req, int result, Intent i) {
		Log.d("debug", "Got here" );
		try {
			String name = i.getStringExtra("name");
			Button openedMsg = null;
			Drawable stamp;
			Log.d("debug", "received name" + name);
			if (name.equals("Timmy")) {
				openedMsg = (Button) findViewById(R.id.timmy);
			} else if (name.equals("Annie")) {
				openedMsg = (Button) findViewById(R.id.annie);
			} 
			stamp = openedMsg.getCompoundDrawables()[2];
			Drawable openedImage = getResources().getDrawable(R.drawable.opened_message);
			Log.d("debug", "opened image" + openedImage);
			
			openedMsg.setCompoundDrawablesWithIntrinsicBounds(openedImage, null, stamp, null);
		} catch (Exception e) {

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Log.d("debug", "inflating menu");
		getMenuInflater().inflate(R.menu.home, menu);
		//MenuItem backItem = menu.findItem(R.id.actionBack);
		//MenuItem homeItem = menu.findItem(R.id.actionHome);
		// To retrieve the Action Provider
		//ShareActionProvider provider = (ShareActionProvider) MenuItemCompat.getActionProvider(backItem);
		return super.onCreateOptionsMenu(menu);
	}
	/**
    public boolean onOptionsItemSelected(MenuItem menuItem) {

    }
	 */
	public void goToFriendList(View v) {
		goToFriendList();	
	}

	public void goToFriendList() {
		Intent i = new Intent(this, FriendList.class);    	
		startActivity(i);
	}

	public void goToReceiveMessage(View v) {
		String name = ((TextView) v).getText().toString(); 
		goToReceiveMessage(name);	
	}

	public void goToReceiveMessage(String name) {
		Intent i = new Intent(this, ReceiveMessage.class);
		i.putExtra("name", name);
		startActivityForResult(i, 0);

	}

	public static String getUserMsgType(String name) {
		if (name.equals("Timmy")) {
			return "text";
		} else if (name.equals("Annie")) {
			return "voice";
		} else {
			return "text";
		}
	}

	public static String[] getUserData(String name) {
		String[] data = new String[3];

		if (name.equals("Timmy")){
			data[0] = "Timmy";
			data[1] = "Spain";
			data[2] = "English, Spanish";
		} else if (name.equals("Annie")) {
			data[0] = "Annie";
			data[1] = "France";
			data[2] = "English, French";
		} else if (name.equals("Angus")) {
			data[0] = "Angus";

			data[1] = "CA, United States";
			data[2] = "English, Vietnamese";
		} else if (name.equals("Mike")) {
			data[0] = "Mike";
			data[1] = "New York, United States";
			data[2] = "English";

		} else if (name.equals("Natalie")) {
			data[0] = "Natalie";
			data[1] = "Germany";
			data[2] = "German";

		} else {
			data[0] = "A random alien";
			data[1] = "Unknown";
			data[2] = "Unknown";
		}
		return data;


	}

	public static Bitmap getStamp(Activity act, String name) {
		Drawable stamp = null;
		if (name.equals("Timmy")) {
			stamp = act.getResources().getDrawable(R.drawable.stamp1);
		} else if (name.equals("Annie")) {
			stamp = act.getResources().getDrawable(R.drawable.stamp2);
		}
		else {
			stamp = act.getResources().getDrawable(R.drawable.stamp5);
		}
		return ((BitmapDrawable) stamp).getBitmap();
		//return stamp;
	}
}
