package com.startup.ui;

import com.startup.main.Main;
import com.startup.utils.Tools;

import android.os.Bundle;
import android.view.View;

public class DailyDealsActivity extends ProductListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	m_btnHome.setOnClickListener(this);
    }

    
    @Override
    public void onClick(View v) {
        
	Tools.changeActivity( this, Main.class );
    }

}
