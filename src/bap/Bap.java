package bap;

public class Bap {
	
	private String meal;
	private String kind;

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void eat() {
		
		System.out.println("A조는 "+meal+"를(을)"+kind+"에 먹습니다");
		
	}

}



