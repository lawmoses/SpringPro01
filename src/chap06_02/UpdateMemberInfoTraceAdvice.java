package chap06_02;

import chap06_01.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {
	
	public void traceReturn(String memberId, UpdateInfo info) {
		System.out.printf("[TA] ���� ����: ���ȸ��=%s, ��������=%s\n",
				memberId, info);
	}

}