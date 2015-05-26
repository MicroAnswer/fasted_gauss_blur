package com.example.gaussblurtest;

import android.graphics.Bitmap;

public class GaussBlur 
{
	//�ֱ���x�� �� y�᷽���Ͻ��и�˹ģ��
	public Bitmap gaussBlur1(Bitmap bitmap, int radius)
	{
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		
		//����һ���µ�ͼƬ
		Bitmap outBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		
		//����һ����ʱ����洢ԭʼͼƬ������ ֵ
		int[] pix = new int[w * h];
		
		//��ͼƬ����ֵд������
		bitmap.getPixels(pix, 0, w, 0, 0, w, h);
		
		//����ģ��
		initCBlur1(pix, w, h, radius);
		
		//������д�뵽 ͼƬ
		outBitmap.setPixels(pix, 0, w, 0, 0, w, h);
		
		//���ؽ��
		return outBitmap;
	}
	
	//���þ�ֵģ�� �ƽ� ��˹ģ��
	public Bitmap gaussBlur2(Bitmap bitmap, int radius)
	{
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		
		//����һ���µ�ͼƬ
		Bitmap outBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		
		//����һ����ʱ����洢ԭʼͼƬ������ ֵ
		int[] pix = new int[w * h];
		
		//��ͼƬ����ֵд������
		bitmap.getPixels(pix, 0, w, 0, 0, w, h);
		
		//����ģ��
		initCBlur2(pix, w, h, radius);
		
		//������д�뵽 ͼƬ
		outBitmap.setPixels(pix, 0, w, 0, 0, w, h);
		
		//���ؽ��
		return outBitmap;
	}
	
	//ԭʼ�ĸ�˹ģ�� ����
	private native void initCBlur1(int[] pix, int w ,int h, int r);
	
	//���þ�ֵģ��������� ��˹ģ��
	private native void initCBlur2(int[] pix, int w ,int h, int r);
	
	//����nativeģ��
	static
	{
		System.loadLibrary("blur"); 
	};
}
