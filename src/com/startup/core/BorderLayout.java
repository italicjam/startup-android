/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 *
 * @author flimaylla
 */
public class BorderLayout extends LinearLayout{
    
    private final int    DEFAULT_MARGIN    = 5;
    private final int    PADDING           = 4;
    private final int    STROKE_WIDTH      = 2;
    private final int    RADIUS            = 6;
    
    private       int    m_iBorderColor;
    private       int    m_iWidth;
    private       int    m_iHeight;
    
    private boolean      m_blRoundBorder    = true;
    private boolean      m_blHasBorder      = true;
    
    private ViewGroup    m_layout;
    private Context      m_context;
    private Paint        m_paint;
   
    public BorderLayout( Context context ){
        this( context ,  true );
    }

    public BorderLayout( Context context , boolean blHasBorder ){
        super( context );
        
        m_blHasBorder = blHasBorder;
        
        init ( context );
    }

    private void init( Context context ){
      m_context         = context;
      
      m_iBorderColor    = 0xFF006A8F;
              
      createPaint();
    }

    
    private void createPaint(){
        m_paint = new Paint();
        m_paint.setStyle      ( Paint.Style.STROKE );
        m_paint.setColor      ( m_iBorderColor );
        m_paint.setStrokeWidth( STROKE_WIDTH );
    }
    
    /**
     *
     * @param iBorderColor   color de border del canvas
     */
    public void setBorderColor(int iBorderColor){
        m_iBorderColor=iBorderColor;
    }

    public void setRoundBorder( boolean bRoundBorder ){
        m_blRoundBorder=bRoundBorder;
    }

    public void setPaintBorder( boolean blHasBorder ){
        m_blHasBorder = blHasBorder;
    }
    
    
    @Override
    protected void onDraw( Canvas canvas ) {

        super.onDraw( canvas );

        m_iWidth =  this.getWidth();
        m_iHeight = this.getHeight();

        if( m_blHasBorder ){
        
            RectF drawArea=new RectF( );
            drawArea.set( DEFAULT_MARGIN,DEFAULT_MARGIN,m_iWidth-DEFAULT_MARGIN, m_iHeight-DEFAULT_MARGIN );

            if( m_blRoundBorder ) {
                canvas.drawRoundRect( drawArea,RADIUS,RADIUS,m_paint );
            } else {
               canvas.drawRect( drawArea, m_paint );
            }
            setPadding( DEFAULT_MARGIN+PADDING, DEFAULT_MARGIN+PADDING, DEFAULT_MARGIN+PADDING, DEFAULT_MARGIN+PADDING );
        }
        
    }

    public ViewGroup getContainer()
    {
        return m_layout;
    }


    public int getMargin() {
        return DEFAULT_MARGIN;
    }

    
    
}
