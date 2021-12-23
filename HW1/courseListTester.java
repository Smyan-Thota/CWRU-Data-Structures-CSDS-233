import junit.framework.TestCase;
//testing class
public class courseListTester extends TestCase {
  
  
  public void test() {
    //creating a list and filling it
    CourseList list = new CourseList();
    Course course1 = new Course("CSDS233", "DataStructures", 100);  
    Course course2 = new Course("MATH223", "Calculus 3", 40); 
    Course course3 = new Course("CSDS310", "Algorithms", 80);
    Course course4 = new Course("CSDS302", "Discrete", 250); 
    list.addCourse(0, course1);
    list.addCourse(1, course2);
    list.addCourse(1, course3);
    list.addCourse(3, course4);
    
    //checking to see both get course with index and if the add course method works
    assertEquals(list.getCourseWithIndex(0),course1);
    assertEquals(list.getCourseWithIndex(1), course3);
    assertEquals(list.getCourseWithIndex(2), course2);
    assertEquals(list.getCourseWithIndex(3), course4);
    
    //removing the second element and also checking what happens if you remove a non existing element
    list.remove(2);
    assertEquals(list.getCourseWithIndex(2), course4);
    assertEquals(list.remove(5), false);
    
    //changing capacity for a course and checking what happens if you change for a non existing course
    list.changeCapacity("CSDS233",200);
    assertEquals(list.getCourseWithIndex(0).getCapacity(),200);
    assertEquals(list.changeCapacity("CSDS100",200),false);
    
    //testing the search function using the ID
    assertEquals(list.SearchCourseID("CSDS233"),0);
    assertEquals(list.SearchCourseID("CSDS100"),-1);
    //testing the search function using the name
    assertEquals(list.SearchCourseName("DataStructures"),0);
    assertEquals(list.SearchCourseName("ABCDE"),-1);
    
    
    
  }
  
}
