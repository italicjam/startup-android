package com.startup.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.startup.beans.Product;
import com.startup.main.R;

public class ProductDetailActivity extends Activity implements OnClickListener{

    
    private Button m_btnHome;
    private Product m_product;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.act_product_detail);
	
	loadProduct();
	
	m_btnHome = (Button)findViewById(R.id.btnHome);
	m_btnHome.setOnClickListener(this);
	
	TextView txtProductName = (TextView) findViewById( R.id.txtProductDetailName );
	TextView txtProductDesc = (TextView) findViewById( R.id.txtProductDetailDesc );
	TextView txtProductPrice = (TextView) findViewById( R.id.txtProductDetailPrice );
	
	txtProductName.setText( m_product.getName() );
	txtProductDesc.setText( m_product.getDesc() );
	txtProductPrice.setText( "S/." + String.format( "%.2f", m_product.getPrice() ) );
	
	
    }

    private void loadProduct(){
	
	m_product = new Product();
	
	Bundle bundle = getIntent().getExtras();
	m_product.setId(bundle.getInt("productId") );
	m_product.setName( bundle.getString( "productName" ));
	m_product.setDesc(bundle.getString( "productDesc" ));
	m_product.setPrice(bundle.getDouble("productPrice"));
	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.act_product_detail, menu);
	return true;
    }

    @Override
    public void onClick(View v) {
	
	super.onBackPressed();
	
    }

}
