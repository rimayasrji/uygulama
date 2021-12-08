package student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class Test2 {
	
	StudenTest StudenTest;
	@Before
	public void student_info() {
		StudenTest =new StudenTest("rima","yasrji","web","Html");
		System.out.println("student information created");
	}
	@Test
	public void  newTest() {
		
	Assert.assertTrue(50<StudenTest.studentPass(89));
	}
	@After
	public void closeTest() {
		System.out.println("Tested sucessfully");
	}
	

}
//@Afterclass & @Beforeclass ---->  bir metot sadece bir kere calistirmak icin kullanilir
//@ingore ---> bir metotunun calistirilmamasinin istenmesi durumunda kullanilir 




