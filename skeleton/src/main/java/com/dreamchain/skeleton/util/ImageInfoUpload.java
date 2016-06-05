package com.dreamchain.skeleton.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dreamchain.skeleton.model.ImageInfo;

public class ImageInfoUpload {

	public static List<ImageInfo>  readFile(String path) throws IOException{
		
		List<ImageInfo> imageInfos = new ArrayList<ImageInfo>();
		File file = new File(path);
		FileInputStream fis = null;
		try {
			int a = 0;
			fis = new FileInputStream(file);
			StringBuffer temp = new StringBuffer();
			int flag = 1;
			ImageInfo image = new ImageInfo();
			while((a = fis.read()) != -1){
				if(a != 10){
					if(a == 32){
						switch (flag) {
						case 1:
							image.setG(temp.toString().trim());
							flag++;
							break;
						case 2:
							image.setR(temp.toString().trim());
							flag++;
							break;
						case 3:
							image.setV(temp.toString().trim());
							flag++;
							break;
						case 4:
							image.setImage_type(Integer.parseInt(temp.toString().trim()));
							flag++;
							break;
						case 5:
							image.setHard(Integer.parseInt(temp.toString().trim()));
							flag++;
							break;

						default:
							image.setTag_times(0);
							imageInfos.add(image);
							System.out.println(image.toString().trim());
							image = new ImageInfo();
							image.setG(temp.toString().trim());
							flag = 2;
							break;
						}
						temp.delete(0, temp.length());
					}else{
						temp.append((char)a);
					}
					

					
				}
				
				
			}
			System.out.println(image.toString().trim());
			image.setTag_times(0);
			imageInfos.add(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}finally {
			fis.close();
		}
		
		
		
		
		return imageInfos;
	}
}
