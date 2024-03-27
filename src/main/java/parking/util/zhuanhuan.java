package parking.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;


public class zhuanhuan {
	public static void main(String[] args) {
		shiyou say = new shiyou(1, "张三");
		shiyou say1 = new shiyou(2, "李四");
		System.out.println(JSONObject.toJSONString(say));
		List<shiyou> list = new ArrayList<shiyou>();
		list.add(say);
		list.add(say1);
		System.out.println(JSONArray.toJSONString(list));
	}
}
