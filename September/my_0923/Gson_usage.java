package my_0922;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Gson_usage {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> dataList = new ArrayList<>();
		String jsonString = "";
		Map<String, String> map = new HashMap<String, String>();
		Gson gson = new Gson();
//		map = gson.fromJson(jsonString, Map.class);
//		System.out.println(map.toString());
		Data data = gson.fromJson(jsonString, Data.class);
		System.out.println(data);
//		System.out.println(data.list.toString());
		
//		String dString = map.get("data");
//		System.out.println("+++++++++++++++++++++++++++");
//		dataList = (ArrayList<String>) gson.fromJson(dString, List.class);
//		System.out.println(dataList.toString());
//		gson.fromJson(jsonString, typeOfT)
	}
}