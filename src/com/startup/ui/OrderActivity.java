package com.startup.ui;

import com.startup.main.R;
import com.startup.main.R.layout;
import com.startup.main.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.act_order);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.act_order, menu);
	return true;
    }

}
