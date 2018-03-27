package chap06_02;

import chap06_01.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {
	
	public void traceReturn(String memberId, UpdateInfo info) {
		System.out.printf("[TA] 정보 수정: 대상회원=%s, 수정정보=%s\n",
				memberId, info);
	}

}