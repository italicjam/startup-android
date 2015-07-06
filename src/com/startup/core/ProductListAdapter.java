package com.startup.core;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.startup.beans.Product;
import com.startup.main.R;
import com.startup.ui.OrderActivity;
import com.startup.ui.ProductDetailActivity;
import com.startup.utils.Tools;

public class ProductListAdapter extends BaseAdapter {

    private Context m_context;
    private List<Product> m_lstProducts;
    
    public ProductListAdapter( Context context, List<Product> lstProducts ){
	m_context = context;
	m_lstProducts = lstProducts;
    }
    
    
    @Override
    public int getCount() {
	// TODO Auto-generated method stub
	return m_lstProducts.size();
    }

    @Override
    public Object getItem(int position) {
	// TODO Auto-generated method stub
	return m_lstProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
	// TODO Auto-generated method stub
	Product product = m_lstProducts.get(position);
	return product.getId();
    }

    @Override
    public View getView( int position, View viewer, ViewGroup parent) {
	// TODO Auto-generated method stub
	LayoutInflater inflater = (LayoutInflater) m_context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	View lstView = null;
	
	Product product = (Product)getItem(position);
    	
	final Bundle bundle = new Bundle();
	bundle.putInt("productId", product.getId());
	bundle.putString("productName",product.getName());
	bundle.putString("productDesc",product.getDesc());
	bundle.putDouble("productPrice", product.getPrice()	);
	
	
	if ( viewer == null ) {

	    	lstView = new View( m_context );

		// get layout from mobile.xml
	    	lstView = inflater.inflate( R.layout.product_item, null );
	    	
		// set value into textview
		TextView txtProductName = (TextView) lstView.findViewById(R.id.txtProductName);
		TextView txtProductPrice= (TextView) lstView.findViewById(R.id.txtProductPrice);
		TextView txtProductDesc= (TextView) lstView.findViewById(R.id.txtProductDesc);
		Button   btnOrder = (Button)lstView.findViewById(R.id.btnOrder);
		btnOrder.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
			
			Tools.changeActivity( m_context, OrderActivity.class, bundle );
			
		    }
		});
		
		txtProductName.setText( product.getName() );
		String priceFormat = String.format("%.2f", product.getPrice());
		txtProductPrice.setText( "S/." + priceFormat );
		txtProductDesc.setText( product.getDesc() );
		
	} else {
	    	lstView = (View) viewer;
	}
	
	lstView.setOnClickListener( new OnClickListener() {
	    
	    @Override
	    public void onClick( View v ) {
		Tools.changeActivity( m_context, ProductDetailActivity.class, bundle );
	    }
	} );
	
	return lstView;
    }

}
