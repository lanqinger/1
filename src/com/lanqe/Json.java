package com.lanqe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	public static void main(String[] args) {
		String result = "{\"isSuccess\":\"true\",\"list\":[{\"name\":\"¡÷“∂\",\"age\":\"21\"},{\"name\":\"“∂√»\",\"age\":\"20\"}]}";
		Map<String,Object> map = getJson(result);
		System.out.println(map);
	}

}
