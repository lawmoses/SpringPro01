package chap03_c02;

import org.springframework.beans.factory.BeanNameAware;

public class Work implements BeanNameAware {
	
	public static enum WorkType  {
		SINGLE, DOUBLE;

	}
	
	private long timeout;
	private WorkType type;
	private long order;
	
	public void setOrder(long order) {
		this.order = order;
	}
	
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	public void setType(WorkType type) {
		this.type = type;
	}
	
	public long getOrder() {
		return order;
	}
	
	public void run() {
		//hashCodes는 config-for-scope.xml에서 scope="prototype" 하면 다른게 나오고, 없애면 같은 hashcode가 나온다.
		System.out.println("hashcode" + hashCode());
		System.out.printf("Work[timeout=%d, type=%s, order=%d]" + "execute\n", timeout, type, order);
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName : " + arg0);
	}
	
	
	
}









