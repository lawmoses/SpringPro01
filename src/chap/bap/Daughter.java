package chap.bap;


public class Daughter implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("Çöºñ¹ä ½È¾î ½Ç¾î===> ³­ ½Ò¹äÀÌ ÁÁ¾Æ ");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("µşÀÇ Ä£±¸"+friend+"ÀÔ´Ï´Ù");
	}
}
