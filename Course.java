public class Course{
 //creating private fields 
 private String courseID;
 private String courseName;
 private int capacity;
 //utilsiing constructor to store the input while creating an object
 public Course(String courseID, String courseName,int capacity) {
  this.courseID=courseID;
  this.courseName=courseName;
  this.capacity=capacity;
 }
//getter for course ID
 public String getCourseID() { 
   return courseID;
 }
//setter for course ID 
 public void setCourseID(String courseID) {
  this.courseID = courseID;
 }
//getter for CourseName
 public String getCourseName() {
  return courseName;
 }
//setter for CourseName 
 public void setCourseName(String courseName) {
  this.courseName = courseName;
 }
//getter for Capacity
 public int getCapacity() {
  return capacity;
 }
//setter for Capacity
 public void setCapacity(int capacity) {
  this.capacity = capacity;
 }
 //to string method to display the information
 @Override
 public String toString() {
  return "Course ID: "+this.courseID+", "+"Course Name: "+this.courseName+", "+"Capacity:"+this.capacity;
 }
 
 
}
