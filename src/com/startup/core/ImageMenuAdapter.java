package com.startup.core;

import com.startup.main.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageMenuAdapter extends BaseAdapter{

    private Context m_context;
    private final String[] m_mobileValues;
    
    public ImageMenuAdapter( Context context, String[] mobileValues ) {
	m_context = context;
	m_mobileValues = mobileValues;
    }
    
    @Override
    public int getCount() {
	// TODO Auto-generated method stub
	return m_mobileValues.length;
    }

    @Override
    public Object getItem(int iIndex ) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public long getItemId(int iIndex) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public View getView(int iPosition, View convertView, ViewGroup parent) {
	
	LayoutInflater inflater = (LayoutInflater) m_context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	View gridView;

	if (convertView == null) {

		gridView = new View(m_context);

		// get layout from mobile.xml
		gridView = inflater.inflate(R.layout.menu, null);

		// set value into textview
		TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
		textView.setText(m_mobileValues[iPosition]);

		// set image based on selected text
		ImageView imageView = (ImageView) gridView
				.findViewById(R.id.grid_item_image);

		String mobile = m_mobileValues[iPosition];

		if (mobile.equals("Entradas")) {
			imageView.setImageResource(R.drawable.entradas);
		} else if (mobile.equals("Fuentes")) {
			imageView.setImageResource(R.drawable.fuentes);
		} else if (mobile.equals("Bebidas")) {
			imageView.setImageResource(R.drawable.bebidas);
		} else {
			imageView.setImageResource(R.drawable.carta);
		}

	} else {
		gridView = (View) convertView;
	}

	return gridView;
    }

}
