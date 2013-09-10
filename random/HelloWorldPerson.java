
/**
 * This class uses Person class to create 5 objects and stores them in an array
 * Prints the names of all the Persons in that array after insertion
 * Sorts the array in increasing order of the ages of Persons
 * @author Sudhanshu Mishra
 *
 */
public class HelloWorldPerson {
	public static void main(String[] args){ 
		Person [] persons = new Person[5];  
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
		person1.name = "Sudhanshu Mishra";
		person1.age = 19;
		person2.name = "Tyler Durden";
		person2.age = 33;
		person3.name = "Sirius Black";
		person3.age = 45; 
		person4.name = "Peter Patigrue";
		person4.age = 52;
		person5.name = "Harry Potter";
		person5.age = 23;
		persons[0] = person1;
		persons[1] = person2;
		persons[2] = person3;
		persons[3] = person4;
		persons[4] = person5;
		
		for(int i=0;i<5;i++)
			System.out.println(persons[i].name); //Printing the names of all the elements in persons array
		
		Person swapVar = new Person();
		for(int i=0;i<persons.length;i++){
			for(int j=1;j<persons.length-i;j++){
				if (persons[j-1].age > persons[j].age){
					swapVar = persons[j-1];
					persons[j-1] = persons[j];
					persons[j] = swapVar;
				}
			}
		}
		
		System.out.println("\nPersons sorted according to their age in increasing order.\n");
		
		for(int i=0;i<5;i++)
			System.out.println("*"+persons[i].name+"*"); //Printing the names of all the elements in persons array
		
	}
}


/**
 * This class has a method birthday which takes no parameters and
 * returns nothing. It prints the name and age of the object.
 * @author Sudhanshu Mishra
 *
 */
class Person {
	   String name;
	   int age;
	   void birthday ( ) {
	      age++;
	      System.out.println(name+ " is now "+age);
	   }
}