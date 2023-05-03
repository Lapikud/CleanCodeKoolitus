package cleancode.clean;

public class NetSalaryCalculator {
    private float monthlyGrossSalary;

    public NetSalaryCalculator(float monthlyGrossSalary) {
        this.monthlyGrossSalary = monthlyGrossSalary;
    }

	public float getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}

	public void setMonthlyGrossSalary(int monthlyGrossSalary) {
		this.monthlyGrossSalary = monthlyGrossSalary;
	}

	public double calculateNetSalary() {
		double fundedPension = calculateFundedPension();
		double unemploymentInsurance = calculateUnemploymentInsurance();
		double taxFreeSalary = calculateTaxFreeSalary();

		return calculateNetSalaryFromTaxes(fundedPension, unemploymentInsurance, taxFreeSalary);
	}

    public double calculateFundedPension() {
        return getMonthlyGrossSalary() / 100 * 2;
    }

    public double calculateUnemploymentInsurance() {
        return getMonthlyGrossSalary() / 100 * 1.6;
    }

    public double calculateTaxFreeSalary() {
        float grossSalary = getMonthlyGrossSalary();
		if (grossSalary <= 1200) {
			return 654;
		} else if (grossSalary <= 2100) {
			return calculateTaxFreeSalaryNonConstant(grossSalary);
		} else {
			return 0;
		}
    }

    public double calculateTaxFreeSalaryNonConstant(double grossSalary) {
        return 654 - (double) 654 / 900 * (grossSalary - 1200);
    }

    public double calculateNetSalaryFromTaxes(double fundedPension, double unemploymentInsurance, double taxFreeSalary) {
        float grossSalary = getMonthlyGrossSalary();

		double salaryToTakeTaxFrom = grossSalary - fundedPension - unemploymentInsurance - taxFreeSalary;
		double incomeTax = salaryToTakeTaxFrom / 5;

		return grossSalary - fundedPension - unemploymentInsurance - incomeTax;
    }
}
