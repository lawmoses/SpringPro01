package chap02_search;

import org.springframework.beans.factory.FactoryBean;

public class SearchClientFactoryBean implements FactoryBean<SearchClientFactory>{
	private String server;
	private int port;
	private String contentType;
	private String encoding = "utf8";
	private SearchClientFactory searchClientFactory;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getEncofing() {
		return encoding;
	}
	public void setEncofing(String encoding) {
		this.encoding = encoding;
	}
	
	public SearchClientFactory getSearchClientFactory() {
		return searchClientFactory;
	}
	
	public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}
	
	@Override
	public SearchClientFactory getObject() throws Exception {
		if (this.searchClientFactory != null)
			return this.searchClientFactory;
		SearchClientFactoryBuilder builder = new SearchClientFactoryBuilder();
		builder.server(server)
				.port(port)
				.contentType(contentType == null ? "json" : contentType)
				.encoding(encoding);
		SearchClientFactory searchClientFactory = builder.build();
		searchClientFactory.init();
		this.searchClientFactory = searchClientFactory;
		return this.searchClientFactory;
	}
	
	@Override
	public Class<?> getObjectType() {
		return SearchClientFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	
	
	
}
