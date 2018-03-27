package chap06_01;

import org.aspectj.lang.annotation.AfterReturning;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(MemberRegRequest memberRegReq) {
		System.out.println("MemberServiceImpl.regist() 호출됨");
		System.out.println("MemberServiceImpl.regist() 호출하고 난 다음에, UpdateMemberInfoTraceAspect의  ");
		
	}

	@Override
	public boolean update(String id, UpdateInfo updateInfo) {
		System.out.println("MemberServiceImpl.update() 호출됨");
		System.out.println("MemberServiceImpl.update() 호출하고 난 다음에, UpdateMemberInfoTraceAspect의 @AfterReturning");
		return true;
	}

	
	
	
}
