package chap06_01;

import org.aspectj.lang.annotation.AfterReturning;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(MemberRegRequest memberRegReq) {
		System.out.println("MemberServiceImpl.regist() ȣ���");
		System.out.println("MemberServiceImpl.regist() ȣ���ϰ� �� ������, UpdateMemberInfoTraceAspect��  ");
		
	}

	@Override
	public boolean update(String id, UpdateInfo updateInfo) {
		System.out.println("MemberServiceImpl.update() ȣ���");
		System.out.println("MemberServiceImpl.update() ȣ���ϰ� �� ������, UpdateMemberInfoTraceAspect�� @AfterReturning");
		return true;
	}

	
	
	
}
