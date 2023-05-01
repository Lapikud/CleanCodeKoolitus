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

	public double calculateNetSalary() {
		int grossSalary = getMonthlyGrossSalary();

		// arvuta kogumispension (2%)
		double fundedPension = (double) grossSalary / 100 * 2;

		// arvuta töötuskindlustusmakse (1,6%)
		double unemploymentEnsurance = (double) grossSalary / 1000 * 16;

		// arvuta maksuvabatulu
		double taxFreeSalary;
		if (grossSalary <= 1200) {
			taxFreeSalary = 654;
		} else if (grossSalary > 1200 && grossSalary <= 2100) {
			taxFreeSalary = 654 - (double) 654 / 900 * (grossSalary - 1200);
		} else {
			taxFreeSalary = 0;
		}

		// arvuta ja võta maha tulumaks
		double salaryToTakeTaxFrom = grossSalary - fundedPension - unemploymentEnsurance - taxFreeSalary;
		double incomeTax = salaryToTakeTaxFrom / 5;

		double netSalary = grossSalary - fundedPension - unemploymentEnsurance - incomeTax;

		return netSalary;
	}
}
