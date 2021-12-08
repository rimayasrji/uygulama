package student;

public class StudenTest {
	
	public String name,surname, department, course;
	
    public StudenTest(String name, String surname, String department, String course) {
		super();
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.course = course;
		
	}
    
  public float studentPass(float degree) {
	if(degree>50 ){
		System.out.println("student with this degree "+degree+" is passed ");
		return degree;
}
	System.out.println("student failed");
	return 0;
}

}