package com.startup.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.startup.beans.Product;
import com.startup.core.ProductListAdapter;
import com.startup.main.R;
import com.startup.utils.Tools;

public class ProductListActivity extends Activity implements OnClickListener{

    private ListView m_lstView = null;
    public  Button m_btnHome;
    private Button m_btnDetailOrder;
    private Button m_btnDailyDeals;
    private ProductListAdapter m_productListAdapter;
    private List<Product> m_lstProducts;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	String sTitle = "";
	
	setContentView(R.layout.act_product_list);
	
	Bundle bundle = this.getIntent().getExtras();
	sTitle = bundle.getString("title");
	
	m_lstView = (ListView) findViewById( R.id.lstProducts );
	
	m_btnHome = (Button)findViewById(R.id.btnHome);
	m_btnHome.setOnClickListener(this);
	m_btnDetailOrder = (Button)findViewById(R.id.btnOrderDetail);
	m_btnDetailOrder.setOnClickListener(this);
	m_btnDailyDeals=(Button)findViewById( R.id.btnOfertas );
	m_btnDailyDeals.setOnClickListener(this);
	
	TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
	txtTitle.setText(sTitle);
	createAnimation();
	
	m_lstProducts = new ArrayList<Product>();
	
	String name=" Couche de Queso ";
	String desc="Aji colorado,queso,leche,cebolla,pap huayro,huacatay,bla bla bla bla bla bla bla bla bla bla bla bla bla";
	
	for (int i = 0; i < 20; i++) {
	    
	    Product product = new Product();
	    product.setId(i+1);
	    product.setName(name);
	    product.setDesc(desc);
	    product.setPrice(10.0);
	    m_lstProducts.add( product );
	}
	
	m_productListAdapter = new ProductListAdapter( this, m_lstProducts );
	
	m_lstView.setAdapter( m_productListAdapter );
    }
    
    /*
     * Create a animation for listview listproducts
     */
    private void createAnimation(){
        
        AnimationSet set = new AnimationSet( true );

        Animation animation = new AlphaAnimation( 0.0f, 1.0f );
        animation.setDuration( 50 );
        set.addAnimation     ( animation );

        animation = new TranslateAnimation(  Animation.RELATIVE_TO_SELF,
                                             0.0f,
                                             Animation.RELATIVE_TO_SELF,
                                             0.0f,
                                             Animation.RELATIVE_TO_SELF,
                                             -1.0f,
                                             Animation.RELATIVE_TO_SELF,
                                             0.0f );
        animation.setDuration( 100 );
        set.addAnimation     ( animation );

        LayoutAnimationController controller = new LayoutAnimationController( set, 0.5f );
        
        m_lstView.setLayoutAnimation( controller );
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.act_product_list, menu);
	return true;
    }

    @Override
    public void onClick(View v) {
	
	int iBtnId = v.getId();
	
	if( iBtnId == m_btnHome.getId() ){
	    super.onBackPressed();
	}
	else if( iBtnId == m_btnDetailOrder.getId() ){
	    Tools.changeActivity( this, OrderActivity.class );
	}
	else if( iBtnId == m_btnDailyDeals.getId() ){
	    Bundle bundle = new Bundle();
	    bundle.putString("title", getResources().getString( R.string.footer_title ) );
	    Tools.changeActivity( this, DailyDealsActivity.class, bundle );
	}
    }  

}
