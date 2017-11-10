class Person extends Object
{
   public String toString()
   {
      return "Person";
   }
}
class StudentLab10 extends Person
{
   public String toString()
   {
      return "Student";
   }
}
class GraduateStudent extends Student
{
}
public class PolymorphismDemo
{
   public static void main(String[] args)
   {
      m(new GraduateStudent());
      m(new Student());
      m(new Person());
      m(new Object());
   }
   public static void m(Object x)
   {
      System.out.println(x.toString());
   }
}
