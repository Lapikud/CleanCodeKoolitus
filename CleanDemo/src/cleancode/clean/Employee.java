package cleancode.clean;

public class Employee {
	private String name;
	private String title;
	private int monthlyGrossSalary;

	public Employee(String name, String title) {
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}

	public void setMonthlyGrossSalary(int monthlyGrossSalary) {
		this.monthlyGrossSalary = monthlyGrossSalary;
	}
}
