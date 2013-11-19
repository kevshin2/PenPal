package edu.berkeley.cs160.off_by_1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
    public void goToFriendList(View v) {
    	Intent i = new Intent(this, FriendList.class);
    	startActivity(i);
    }
    
    
    public void goToReceiveMessage(View v) {
    	Intent i = new Intent(this, ReceiveMessage.class);
    	//this intent will hopefully be dynamically loaded in the future
    	startActivity(i);
    	
    }
}