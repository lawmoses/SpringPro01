package chap02_search;

public class HttpSearchClientFactory implements SearchClientFactory {

	private String server;
	private String contentType;
	private String encoding;
	
	
	//생성자 만드는 것 없나?
	public HttpSearchClientFactory(String server, String contentType, String encoding) {
		this.server = server;
		this.contentType = contentType;
		this.encoding = encoding;
	}

	
	@Override
	public void init() {
		System.out.printf("HttpSearchClientFactory: 초기화 함 - %s, %s, %s\n", server, contentType, encoding);
	}

	@Override
	public String toString() {
		return "HttpSearchClientFactory [server=" + server + ", contentType=" + contentType + ", encoding=" + encoding + "]";
	}

	@Override
	public SearchClient create() {
		return new HttpSearchClient();
	}
	
	
}
