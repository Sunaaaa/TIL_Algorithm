package my_0922;

import java.util.ArrayList;
import java.util.List;

public class Data {
	int page;
	int per_page;
	int total;
	int total_pages;
	String datas;
	List<Post> list = new ArrayList<Post>();
	
	@Override
	public String toString() {
		return this.page + "/" + this.per_page + "/" + this.total + "/" + this.total_pages + "/" + this.datas;
	}
}
