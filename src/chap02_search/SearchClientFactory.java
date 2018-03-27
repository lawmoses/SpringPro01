package chap02_search;

public interface SearchClientFactory {
	
	public void init();

	public SearchClient create();
	
}
