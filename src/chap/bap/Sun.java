package chap.bap;


public class Sun implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("���̹� �Ⱦ� �Ⱦ�===> �� ���� ����");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("�Ƶ��� ģ��"+friend+"�Դϴ�");
	}
}
