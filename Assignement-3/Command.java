/**
* Commands supported by the CollegeTester to use the College which is
* a collection of Students.
*
* @author Gladys Monagan 
* @version September 21, 2017
*/
public enum Command {
   ADD,
   FIND,
   LOGIN,
   REMOVE,
   COURSE,
   HIGHEST,
   TOTAL,
   PRINTALL,
   COMMENT,
   QUIT,
   INVALID;

   /**
   * Explanations given to clarify the commands allowed.
   * The order of the explanations is significantas it should be the same
   * as the ordinal value of the commands.
   */
   public static final String[] EXPLANATION = {
      "add - add a new student",
      "find - find a specific student based on the student #",
      "login - get a specific student's 'login id' based on the student #",
      "remove - remove a specific student based on the student #",
      "course - add a course (grade and pts) for a specific student",
      "highest - find a student with the highest GPA in the college",
      "total - give the total number of students in the college",
      "printall - prints the whole college",
      "comment - echo the commented given",
      "quit - stop the program",
      "anything else is not a valid command"
   };

   /**
   * Determines if str corresponds to one of the "String values" of the 
   * commands of the enumerated type. If it does not match any, the 
   * enumerated type INVALID is returned otherwise the type corresponding
   * to the string is returned.
   * @param str which is going to be tested against the String Command types
   * @return an enumerated type that matches the str
   */
   public static Command type(String str)
   {
      Command cmd;
      str = str.trim().toUpperCase();
      if ((str.length() == 0 ) || (str.indexOf(' ') != -1) ) 
      {
         cmd = INVALID;
      }
      else 
      {
         try 
         {
            cmd = valueOf(str);
         }
         catch (IllegalArgumentException e) 
         {
            cmd = INVALID;
         }
      }
      return cmd;
   } 
}