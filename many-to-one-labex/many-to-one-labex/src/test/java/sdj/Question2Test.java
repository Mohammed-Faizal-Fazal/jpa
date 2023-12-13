package sdj;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sdj.entity.Guide;
import sdj.entity.Student;
import sdj.repository.StudentRepository;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Question2Test {	

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testLazyLoadingUsingAnIdentifierAttribute() {		
		Student student = studentRepository.findById(1L).get();
		Guide guide = student.getGuide();
		
		System.out.println( guide.getId() );
	}
	
	@BeforeAll
	public void populateDb() {
		Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);		
		Student student = new Student("2014JT50123", "John Smith", guide);
		
		studentRepository.save(student);		
	}
	
}
