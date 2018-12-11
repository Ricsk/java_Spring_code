package chapter5;
public class Manager extends EmployeeBasic{
	private double bonus;

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getSalary() {
		return this.bonus+super.getSalary();
	}
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		this.bonus = 0;
	}
	
	public Manager() {
		super();
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) 
			return false;
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}
/*	public Manager(int x) {
		super();
		System.out.println(x);
	}
	public Manager(double x) {
		System.out.println(x);
	}*/
/*	public void test() {
		System.out.println("test for subclass function");
	}*/
	public static void main(String[] args) {
		/*Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		//System.out.println(boss.getSalary());//error
		EmployeeBasic[] staff = new EmployeeBasic[3];
		staff[0] = boss;
		staff[1] = new EmployeeBasic("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new EmployeeBasic("Tony Tester", 40000, 1990, 3, 15);
		//System.out.println(staff[0].test());
		for (EmployeeBasic e : staff) {
			System.out.println(e.getName()+ " " + e.getSalary());
		}*/
		
/*		Manager[] managers = new Manager[10];
		EmployeeBasic[] staff = managers;
		staff[0] = new EmployeeBasic("Harray Hacker", 50000, 1980, 10, 1);//error but not visable
		staff[0].setBonus(110);//error
		manager[0] = new EmployeeBasic("Harray Hacker", 50000, 1980, 10, 1);//error but visable
*/	
	
	//force transition//cast
		EmployeeBasic staff [] = new EmployeeBasic[3];
		for(EmployeeBasic e:staff)
			e = new EmployeeBasic();
		System.out.println(staff[0] instanceof Manager);
		Manager boss = (Manager)staff[0];//can run but error
		//boss.setBonus(1000);
		//System.out.println(boss.getSalary());
		
		Manager boss2 = new Manager("xxx", 200, 1990, 8, 1);
		boss2.setBonus(1000);
		//boss2.raiseSalary(1000);
		staff[0] = boss2;
		System.out.println(staff[0].getSalary());
		//Manager boss3 = staff[0];//error but has meaning
		if(staff[0] instanceof Manager)
		{
			Manager boss4 = (Manager)staff[0];
			boss4.setBonus(1000);
			System.out.println(boss4.getSalary());
		}
	}
}