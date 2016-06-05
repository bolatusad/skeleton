package com.dreamchain.skeleton.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonTest {
	public static void main(String[] args) {
		Map<String, List<ImageTagInfoTest>> maps = new HashMap<String, List<ImageTagInfoTest>>();
		List<ImageTagInfoTest> lists = new ArrayList<ImageTagInfoTest>();
		ImageTagInfoTest img1 = new ImageTagInfoTest();
		ImageTagInfoTest img2 = new ImageTagInfoTest();
		ImageTagInfoTest img3 = new ImageTagInfoTest();

//		img1.setImageid("1");
//		img1.setImageurl("aaa");
//		img1.setName("zhangsan");
//		img1.setType("aa");
//		img1.setRound("1");
//		img1.setAcc("t");
//		img1.setCount("4");
//		
//		img2.setImageid("2");
//		img2.setImageurl("bbb");
//		img2.setName("zhangsan");
//		img2.setType("b");
//		img2.setRound("3");
//		img2.setAcc("t");
//		img2.setCount("4");
//		
//		img3.setImageid("3");
//		img3.setImageurl("ccc");
//		img3.setName("zhangsan");
//		img3.setType("b");
//		img3.setRound("3");
//		img3.setAcc("t");
//		img3.setCount("4");
		
		lists.add(img1);
		lists.add(img2);
		lists.add(img3);
		
		maps.put("images", lists);
		System.out.println(JSON.toJSONString(maps));
	}
}