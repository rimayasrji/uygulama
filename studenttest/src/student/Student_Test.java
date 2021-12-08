package student;

import static org.junit.Assert.*;

import org.junit.Test;

public class Student_Test {
    @Test
	public void student_Test() {
		student student =new student();
		
		student.setName("rima");
		student.setSurname("yasrji");
		student.setDepartment("web degsiner");
		student.setCourse("html");
		student.setDegree(78);
		assertEquals("rima",student.getName());
		assertEquals("yasrji",student.getSurname());
		assertEquals("web degsiner",student.getDepartment());
		assertEquals("html",student.getCourse());
		assertEquals(78,student.getDegree());
		
	}
	
		
	}
	

