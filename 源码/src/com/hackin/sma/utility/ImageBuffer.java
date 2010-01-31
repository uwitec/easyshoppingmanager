package com.hackin.sma.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ImageBuffer {

	private final Map<String, Image> imageMap = new HashMap<String, Image>();
	
	private static ImageBuffer imageBuffer = new ImageBuffer();
	
	// 阻止外部创建对象
	private ImageBuffer() {
		
	}
	
	// 获得唯一对象
	public static ImageBuffer getInstance() {
		return imageBuffer;
	}
	
	// 获得图像
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
	
	
	// 释放图像资源
	public void dispose() {
		
		// 将Map对象转化成Iterator对象
		Iterator<Image> iterator = imageMap.values().iterator();
		while(iterator.hasNext()) {
			((Image)iterator.next()).dispose();
		}
		imageMap.clear();
	}
	
	
	
	
}

