package chap02_search;

public class HttpSearchClient implements SearchClient {

	@Override
	public void addDcoument(SearchDocument searchDocument) {
		System.out.println("���� �߰���");
		
	}

	@Override
	public void checkLive() {
		System.out.println("���� Ȯ��");
		
	}

}
