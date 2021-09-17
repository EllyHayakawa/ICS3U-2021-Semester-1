package week2;

public class StudentExample {
    public static void main(String[] args) {
        Student shohei;

        shohei = new Student("Shohei", "123456", 11);
        //shohei is a student (object variable)

        Student samantha = new Student("Samantha", "654321", 11);

        Student alan = shohei;

        /**called (activated) the method increaseGrade
        * because alan and shohei reference the same Student Object both of their grades increase (there is only one object)
        */
        alan.increaseGrade();

        //we activate methods (functions) through the object (variable) name
        samantha.displayName();
        samantha.displayStudentNumber();
        samantha.increaseGrade();

        samantha = null;
        alan = new Student("Alan", "555555", 11);

        //samantha.displayGrade(); //null pointer exception canont call a method from a null reference

        alan.addTest(87);
        alan.displayAverage();
        alan.addTest(92);
        alan.displayAverage();
        alan.addTest(96);
        alan.displayAverage();
        alan.addTest(67);
        alan.displayAverage();
        //double avg = alan.getAverage(); //not used (called getAverage inline on next line)
        System.out.println(alan.getName() + " has an average of " + alan.getAverage());

        // alan.numMarks = 7; //don't have access to private members (not visible)

        alan.displayName();
        alan.displayName("Hello");

        Student stefano = new Student("Stefano", "876234");
        stefano.displayName();
        stefano.displayGrade();

        
    }
}
