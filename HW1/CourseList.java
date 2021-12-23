import java.util.Scanner;

public class CourseList  {
  
  //initialising the array to have ten variables
  private static Course[] listOfCourses= new Course[10];
  //size method to calculaute the number of courses in the array
  public int size() {
    if (listOfCourses[0]==null){
      return 0;
    }
    
    int counter = 0;
    for (int i = 0; i < listOfCourses.length; i ++){
      if (listOfCourses[i] != null)
        counter ++;
    }
    return counter;
  }
  //add course method to add to the courses
  public void addCourse(int i, Course course) {
    System.out.println("List before operation");
    printer();
    
    Course[] listCoursesNew = new Course[listOfCourses.length+1];
    
    
    
    for(int j=0;j<i;j++) {
      listCoursesNew[j]=listOfCourses[j];
    }
    listCoursesNew[i]=course;
    
    for(int j=i+1;j<listOfCourses.length+1;j++) {
      listCoursesNew[j]=listOfCourses[j-1];
    }
    
    listOfCourses=listCoursesNew;
    
    System.out.println("List after operation");
    printer();
  }
  //remove method to remove the courses
  public boolean remove(int i) {    
    System.out.println("List before operation");
    printer();
    for(int j = 0; j < size(); j++){
      if(j==i){
        // shifting elements
        for(int k = i; k < size() - 1; k++){
          listOfCourses[j] = listOfCourses[j+1];
        }
        listOfCourses[j+1]=null;
        System.out.println("List after operation");
        printer();
        return true;
      }
    }
    
    return false;
  }
  
  
  //method to change the capacity of the course provided with the course ID
  public boolean changeCapacity(String courseIDinput, int capacity) {
    System.out.println("List before operation");
    printer();
    
    for(int i=0;i<size();i++){
      if(listOfCourses[i].getCourseID().equalsIgnoreCase(courseIDinput)){
        listOfCourses[i].setCapacity(capacity);
        System.out.println("List after operation");
        printer();
        return true;
      }
    }
    
    return false;
  }
  //getting course with Index
  public Course getCourseWithIndex(int i){
    if(i<size()){
      return listOfCourses[i];
    }
    else {
      return null;
    }
  }
  //searching for course with ID
  public int SearchCourseID(String courseIDinput){
    for(int i=0;i<size();i++){
      if(listOfCourses[i].getCourseID().equalsIgnoreCase(courseIDinput)){
        return i;
      }
    }
    return -1;
  }
  //searching for course with course name
  public int SearchCourseName(String courseNameinput){
    for(int i=0;i<size();i++){
      if(listOfCourses[i].getCourseName().equalsIgnoreCase(courseNameinput)){
        return i;
      }
    }
    return -1;
  }
  //helper method to print the array
  public void printer() {
    for(int i=0;i<size();i++) {
      System.out.println(listOfCourses[i]);
    }
  }
  //main method to run the commands
  public static void main (String[] args)
  {
    CourseList user = new CourseList();
    String courseIDtemp ;
    String coursenametemp ;
    int capacity;
    Course temp;
    int index;
    //Declare input as scanner
    Scanner input = new Scanner(System.in);
    
    //Take inputs
    System.out.println("Welcome to Course List");
    int n=1;
    while(n!=0){
      System.out.println("Press 1 for the number of courses"+"\n"+"Press 2 to add a course"+"\n"+"Press 3 to remove a course"+"\n"+"Press 4 to change a course capacity"+"\n"+"Press 5 to search for a course with an index"+"\n"+"Press 6 to search for a course with a Course ID"+"\n"+"Press 7 to search for a course with the name");
      String s = input.next();
      char c = s.charAt(0);
      //siwtch case for a menu driven approach
      switch(c)
      {
        case '1': 
          System.out.println("Operation : Number of Courses");
          System.out.println(user.size());
          break;
          
          
        case '2':
          System.out.println("Operation : Add a Course");
          System.out.println("Input the Index");
          index = input.nextInt();
          System.out.println("Input the Course ID Without spaces");
          courseIDtemp = input.next();
          System.out.println("Input the Course Name Without spaces");
          coursenametemp = input.next();
          System.out.println("Input the Capacity");
          capacity = input.nextInt();
          temp = new Course(courseIDtemp,coursenametemp,capacity);
          user.addCourse(index, temp);
          
          break;
        case '3':
          System.out.println("Operation : Delete a Course");
          System.out.println("Input the Index");
          index = input.nextInt();
          user.remove(index);
          break;
        case '4':
          System.out.println("Operation : Change capacity");
          System.out.println("Input the Course ID (without spaces)and Capacity");
          courseIDtemp = input.next();
          capacity = input.nextInt();;
          user.changeCapacity(courseIDtemp, capacity);
          
          break;
        case '5':
          System.out.println("Operation : Find a Course");
          System.out.println("Input the Index");
          index = input.nextInt();
          System.out.println(user.getCourseWithIndex(index));
          break;
        case '6':
          System.out.println("Operation : Search for a Course with ID");
          System.out.println("Input the ID without spaces");
          courseIDtemp = input.next();
          System.out.println(user.SearchCourseID(courseIDtemp));
          break;
        case '7':
          System.out.println("Operation : Search for a Course with Course Name");
          System.out.println("Input the Name without spaces");
          coursenametemp = input.next();
          System.out.println(user.SearchCourseName(coursenametemp));
          break;
        default:
          System.out.println("wrong input, please try again, maybe without spaces?");
          break;
      }
      
    }
  }
}

