
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Person> person = Arrays.asList( new Person("Lawrance", "Jeyapaul", 20),
											new Person("Rubesh", "Prakash", 23),
											new Person("John", "Commedy", 12),
											new Person("Vin", "Diesel", 32),
											new Person("Van", "Carmon", 22),
											new Person("Loop", "Carathy", 26));
		person.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		
		System.out.println("Print All the Names");
		printIt(person, p -> true);
		System.out.println();
		System.out.println("Print All the lastName starts with C");
		printIt(person, p -> p.getLastName().startsWith("C"));
		System.out.println();
		System.out.println("Print All the person Whos age is below 23");
		printIt(person, p -> p.getAge() <= 23);
		
	}
	
	public static void printIt(List<Person> person, Predicate<Person> predicate) {
		for(Person i : person) {
			if(predicate.test(i)) {
				System.out.println(i);
			}
		}
	}

}

