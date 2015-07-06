package com.startup.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.startup.core.ImageMenuAdapter;
import com.startup.ui.DailyDealsActivity;
import com.startup.ui.ProductListActivity;
import com.startup.utils.Tools;

public class Main extends Activity implements OnClickListener{

   private Button m_btnDailyDeals  = null;
    
   private GridView m_gvMenu = null;
   
   static final String[] MENU = new String[] { 
	"Entradas", "Fuentes","Platos a la Carta", "Bebidas" };
   
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	m_gvMenu = (GridView) findViewById(R.id.gvMenu);
	m_gvMenu.setAdapter(new ImageMenuAdapter(this, MENU) );
	
	m_gvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
		 
		    
	        String sTitle = MENU[position];	
		    
		changeActivity(ProductListActivity.class,sTitle);

		}
	});
	
	m_btnDailyDeals=(Button)findViewById( R.id.btnOfertas );
	m_btnDailyDeals.setOnClickListener(this);
	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }

    @Override
    public void onClick(View v) {
	
	int iId = v.getId();
	
	if( iId == m_btnDailyDeals.getId() ){
	    changeActivity( DailyDealsActivity.class,getResources().getString(R.string.footer_title) );
	}
	
    }
    
    @SuppressWarnings("rawtypes")
    private void changeActivity( Class clazz, String title ){
	
	Bundle bundle = new Bundle(1);
	bundle.putString("title", title);
	
	Tools.changeActivity( this, clazz, bundle );
	
    }

}


