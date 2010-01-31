package com.hackin.sma.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ImageBuffer {

	private final Map<String, Image> imageMap = new HashMap<String, Image>();
	
	private static ImageBuffer imageBuffer = new ImageBuffer();
	
	// ��ֹ�ⲿ��������
	private ImageBuffer() {
		
	}
	
	// ���Ψһ����
	public static ImageBuffer getInstance() {
		return imageBuffer;
	}
	
	// ���ͼ��
	public Image getImage(String applicationID, String imageName) {
		
		if(imageName == null) {
			return null;
		}
		
		Image image = (Image)imageMap.get(imageName);
		
		if(image == null) {
			image = AbstractUIPlugin.imageDescriptorFromPlugin(applicationID, imageName).createImage();
			imageMap.put(imageName, image);
		}
		
		return image;
	}
	
	
	// �ͷ�ͼ����Դ
	public void dispose() {
		
		// ��Map����ת����Iterator����
		Iterator<Image> iterator = imageMap.values().iterator();
		while(iterator.hasNext()) {
			((Image)iterator.next()).dispose();
		}
		imageMap.clear();
	}
	
	
	
	
}

