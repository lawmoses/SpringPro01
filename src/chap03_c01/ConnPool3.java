package chap03_c01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool3 {

	public void init() {
		System.out.println("ConnPool3.init()");
	}
	
	public void destroy() {
		System.out.println("ConnPool3.destroy()");
	}
	
}
