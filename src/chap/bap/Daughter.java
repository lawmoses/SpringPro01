package chap.bap;


public class Daughter implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("����� �Ⱦ� �Ǿ�===> �� �ҹ��� ���� ");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("���� ģ��"+friend+"�Դϴ�");
	}
}
