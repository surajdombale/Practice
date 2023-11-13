package practice.list;

public class Variable {
public String get(String x,String y) {
	return (x+" "+y+"");
}
	public static void main(String[] args) {
		Variable var=new Variable();
	
	String just=var.get("Suraj", "Dombale");
	
	System.out.println(just.toLowerCase());
	
	
	}

}
