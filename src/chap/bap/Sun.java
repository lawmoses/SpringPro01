package chap.bap;


public class Sun implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("현미밥 싫어 싫어===> 난 빵이 좋아");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("아들의 친구"+friend+"입니다");
	}
}
