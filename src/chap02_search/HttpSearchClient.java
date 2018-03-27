package chap02_search;

public class HttpSearchClient implements SearchClient {

	@Override
	public void addDcoument(SearchDocument searchDocument) {
		System.out.println("문서 추가함");
		
	}

	@Override
	public void checkLive() {
		System.out.println("상태 확인");
		
	}

}
