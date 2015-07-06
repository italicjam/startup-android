package com.startup.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Tools {

    @SuppressWarnings("rawtypes")
    public static void changeActivity( Context context, Class clazz, Bundle bundle ){
	
	Intent intent = new Intent( context, clazz );
	intent.putExtras(bundle);
	
        context.startActivity( intent );
    }
    
    @SuppressWarnings("rawtypes")
    public static void changeActivity( Context context, Class clazz ){
	
	Intent intent = new Intent( context, clazz );
        context.startActivity( intent );
    }
    
}
