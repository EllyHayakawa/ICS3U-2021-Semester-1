package week2;


/**
 * A class is a blue print for something that we can model and create variables to use in our code.
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
  private int totalMarks;
  private int numMarks;
  private double average;

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
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
  }

  public Student(String name, String studentNumber){
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = 9;
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
  }


  /**
   * displayName, displayStudentNumber, increaseGrade, display Grade
   * The methods (actions) in a class define the behaviour for the class
   */
  public void displayName() {
    System.out.println(name);
  }

  /**
   * Method overloading - methods with the same name but different arguments (parameters)
   * @param greeting
   */
  public void displayName(String greeting){
    System.out.println(greeting + " " + name);
  }

  public String getName(){
    return name;
  }
  /**
   * A void method performs a task and does NOT return a value
   */
  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }

  /**
   * non-static methods do not have the word static (modifier static before the retur type (void))
   * non-static methods/attributes mean the method/attribute belongs to the OBJECT not the class
   * every instance gets its own version
   */
  public void increaseGrade() {
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }

  //naming convention for variable and methods are the same (camelCase)
  public void displayAverage() {
    System.out.println(average);
  }

  public double getAverage(){
    return average;
  }

  public void addTest(int mark) {
    totalMarks+= mark;
    numMarks++;
    calculateAverage();
  }

  private void calculateAverage() {
    average = ((double)totalMarks / numMarks);
  }

}