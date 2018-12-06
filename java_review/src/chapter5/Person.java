package chapter5;
public abstract class Person{
	public abstract String getDescription();
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	String text() {
		return "text";
	}
	
	public Person() {}
	
	public static void main(String[] args) {
		Person[] people = new Person[2];
		people[0] = new EmployeeBasic("Harry Hacker", 5000, 1989, 10, 1);
		people[1] = new Student("Maria Morris", "computer science");
		Student s = new Student("Maria Morris", "computer science");
		System.out.println(s.text());
		for(Person p:people) {
			System.out.println(p.text());
			System.out.println(p.getDescription());
		}
	}
}