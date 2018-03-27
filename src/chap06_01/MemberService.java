package chap06_01;

public interface MemberService {

	void regist(MemberRegRequest memberRegReq);

	boolean update(String id, UpdateInfo updateInfo);
	
}
