package com.example.gaussblurtest;

import com.example.gaussblur_test.R;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
{
	ImageView imageView1 = null;
	ImageView imageView2 = null;
	
	TextView textView1 = null;
	TextView textView2 = null;
	
	Button button = null;
	
	GaussBlur gaussBlur = null;
	
	Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        
        button = (Button)findViewById(R.id.button1);
        
        gaussBlur = new GaussBlur();
        
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        
        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(bitmap);
        
        button.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				int radius = 30;
				
				//-------------------------------------------------------
				//��˹ģ��
				//textView1.setText("��˹ģ����....��ģ���뾶��10");
				
				//��¼ʱ��
				long time1 = System.currentTimeMillis();
				
				Bitmap out1 = gaussBlur.gaussBlur1(bitmap, radius);
				
				long time = System.currentTimeMillis() - time1;
				
				textView1.setText("��˹ģ�����뾶" + radius + "����ʱ��" + time + "ms");
				imageView1.setImageBitmap(out1);
				
				
				//--------------------------------------------
				//���þ�ֵģ���ƽ���˹ģ��
				//textView2.setText("3�ξ�ֵģ����....��ģ���뾶��10");
				
				time1 = System.currentTimeMillis();
				
				Bitmap out2 = gaussBlur.gaussBlur2(bitmap, radius);
				
				time = System.currentTimeMillis() - time1;
				
				textView2.setText("3�ξ�ֵģ�����뾶" + radius + "����ʱ��" + time + "ms");
				imageView2.setImageBitmap(out2);
			}
		});
    }
}




























