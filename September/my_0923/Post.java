package my_0922;
//{
//'title':'Google Is Eating Our Mail',
//'url':'https://www.tablix.org/~avian/blog/archives/2019/04/google_is_eating_our_mail/',
//'author':'saintamh',
//'num_comments':685,
//'story_id':null,
//'story_title':null,
//'story_url':null,
//'parent_id':null,
//'created_at':1556274921
//}
public class Post {
	String title;
//	String story_title;
	
	public Post(String title) {
		this.title = title;
//		this.story_title = story_title;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.title+" - »Æ¿Œ"; 
	}
	
}
