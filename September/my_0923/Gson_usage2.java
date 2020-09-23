package my_0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Gson_usage2 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.naver.com/");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tmp;
			int rank = 0;
			while ((tmp = br.readLine()) != null) {
				System.out.println(tmp);
				if (tmp.contains("class=\"ah_k\"") && rank < 20) {
					System.out.println(++rank + "위:"+tmp.split(">")[1].split("<")[0]);
				}
			}
			br.close();
			con.disconnect();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Post> list = new ArrayList<>();
		String jsonString = "{'page':1,'per_page':10,'total':2,'total_pages':1,'data':[{'title':'Google Is Eating Our Mail','url':'https://www.tablix.org/~avian/blog/archives/2019/04/google_is_eating_our_mail/','author':'saintamh','num_comments':685,'story_id':null,'story_title':null,'story_url':null,'parent_id':null,'created_at':1556274921},{'title':null,'url':'https://www.bunniestudios.com/blog/?p=4782','author':'saintamh','num_comments':305,'story_id':null,'story_title':'난 스토리 타이틀','story_url':null,'parent_id':null,'created_at':1469106658},{'title':null,'url':'https://www.bunniestudios.com/blog/?p=4782','author':'saintamh','num_comments':305,'story_id':null,'story_title':null,'story_url':null,'parent_id':null,'created_at':1469106658}]}";
//		String jsonString = "{'page':1,'per_page':10,'total':2,'total_pages':1,'data':[{'title':'Google Is Eating Our Mail','url':'https://www.tablix.org/~avian/blog/archives/2019/04/google_is_eating_our_mail/','author':'saintamh','num_comments':685,'story_id':null,'story_title':null,'story_url':null,'parent_id':null,'created_at':1556274921},{'title':'Why I’m Suing the US Government','url':'https://www.bunniestudios.com/blog/?p=4782','author':'saintamh','num_comments':305,'story_id':null,'story_title':null,'story_url':null,'parent_id':null,'created_at':1469106658}]}";

		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(jsonString, JsonObject.class);
		JsonArray jsonArray = obj.getAsJsonArray("data");
		L: for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObj = jsonArray.get(i).getAsJsonObject();
			Post p = null;
			if (jsonObj.get("title").isJsonNull()) {
				if (jsonObj.get("story_title").isJsonNull()) {
					continue L;
				} else {
					p = new Post(jsonObj.get("story_title").getAsString());
				}
			} else p = new Post(jsonObj.get("title").getAsString());
			list.add(p);
		}
		for (Post post : list) {
			System.out.println(post.title);
		}
	}
}