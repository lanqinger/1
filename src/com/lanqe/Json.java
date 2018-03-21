
package com.lanqe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Json {
	
	public static Map<String, Object> getJson(String result) {
		JSONObject jsonObject = JSONObject.fromObject(result);
		Map<String, Object> map = new HashMap<String, Object>();
		List jsonList = jsonObject.getJSONArray("list");
		Iterator it = jsonList.iterator();
		while(it.hasNext()) {
			JSONObject object = (JSONObject) it.next();
			String name = object.getString("name");
			String age = object.getString("age");
			map.put(name, age);
		}
		return map;
	}
	
	public static JSONObject transformJson(Map<String, Object> map) {
		return JSONObject.fromObject(map);
	}
	
	public static JSONArray transformJsonArray(List<String> list) {
		return JSONArray.fromObject(list);
	}
	
	public static void main(String[] args) {
		String result = "{\"isSuccess\":\"true\",\"list\":[{\"name\":\"ÁÖÒ¶\",\"age\":\"21\"},{\"name\":\"Ò¶ÃÈ\",\"age\":\"20\"}]}";
		Map<String,Object> map = getJson(result);
		System.out.println(map);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("success","1");
		map2.put("message", "ִ�гɹ���");
		JSONObject json = transformJson(map2);
		System.out.println(json);
		
		List<String> list = new ArrayList<String>();
		list.add("������");
		list.add("������");
		list.add("��ˮ��");
		JSONArray array = transformJsonArray(list);
		System.out.println(array);
	}

}
