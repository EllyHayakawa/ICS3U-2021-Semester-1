package week2;


/**
 * A class is a bue print for something that we can model and create variables to use in our code.
 * 
 * This code (class) defines what a Student is
 */
public class Student {

/**
 * Attributes that define a student
 * The state of a specific student is what is in the attrbutes at a specific point
 */
  private String name;
  private String studentNumber;
  private int grade;

  /**
   * 
   * The method with the same name as the class is used to instantiate (create) a Student Object
   * 
   * 
   * Constructor - same name as the class and its purpose is to instantiate an instance of the class (creates a student and places it in its initial state)
   */
  public Student(String name, String studentNumber, int grade) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = grade;
  }


  /**
   * displayName, displayStudentNumber, increaseGrade, display Grade
   * The methods (actions) in a class define the behaviour for the class
   */
  public void displayName() {
    System.out.println(name);
  }

  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }

  public void increaseGrade() {
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }

}