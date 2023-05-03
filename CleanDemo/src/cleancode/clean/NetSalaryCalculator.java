package cleancode.clean;

public class NetSalaryCalculator {
    private int monthlyGrossSalary;

    public NetSalaryCalculator(int monthlyGrossSalary) {
        this.monthlyGrossSalary = monthlyGrossSalary;
    }

	public int getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}

	public void setMonthlyGrossSalary(int monthlyGrossSalary) {
		this.monthlyGrossSalary = monthlyGrossSalary;
	}

	public double calculateNetSalary() {
		double fundedPension = calculateFundedPension();
		double unemploymentEnsurance = calculateUnemploymentEnsurance();
		double taxFreeSalary = calculateTaxFreeSalary();

		return calculateNetSalaryFromTaxes(fundedPension, unemploymentEnsurance, taxFreeSalary);
	}

    public double calculateFundedPension() {
        return (double) getMonthlyGrossSalary() / 100 * 2;
    }

    public double calculateUnemploymentEnsurance() {
        return (double) getMonthlyGrossSalary() / 100 * 1.6;
    }

    public double calculateTaxFreeSalary() {
        double grossSalary = getMonthlyGrossSalary();
		if (grossSalary <= 1200) {
			return 654;
		} else if (grossSalary > 1200 && grossSalary <= 2100) {
			return calculateTaxFreeSalaryGrossSalaryBetween1200And2100(grossSalary);
		} else {
			return 0;
		}
    }

    public double calculateTaxFreeSalaryGrossSalaryBetween1200And2100(double grossSalary) {
        return 654 - (double) 654 / 900 * (grossSalary - 1200);
    }

    public double calculateNetSalaryFromTaxes(double fundedPension, double unemploymentEnsurance, double taxFreeSalary) {
        int grossSalary = getMonthlyGrossSalary();

		double salaryToTakeTaxFrom = grossSalary - fundedPension - unemploymentEnsurance - taxFreeSalary;
		double incomeTax = salaryToTakeTaxFrom / 5;

		return grossSalary - fundedPension - unemploymentEnsurance - incomeTax;
    }
}
