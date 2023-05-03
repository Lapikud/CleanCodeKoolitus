package cleancode.clean;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {
	@Test
	public void testEmployeeName() {
		Employee karin = new Employee("Karin", "Ärikonsultant");
		Assert.assertEquals(karin.getName(), "Karin");
	}

	@Test
	public void testEmployeeTitle() {
		Employee karin = new Employee("Karin", "Ärikonsultant");
		Assert.assertEquals(karin.getTitle(), "Ärikonsultant");
		karin.setTitle("Turundusjuht");
		Assert.assertEquals(karin.getTitle(), "Turundusjuht");
	}

	@Test
	public void testNetSalaryCalculator() {
		NetSalaryCalculator netSalaryCalculator = new NetSalaryCalculator(1000);
		Assert.assertEquals(netSalaryCalculator.getMonthlyGrossSalary(), 1000, 0);
		netSalaryCalculator.setMonthlyGrossSalary(1200);
		Assert.assertEquals(netSalaryCalculator.getMonthlyGrossSalary(), 1200, 0);
	}

	@Test
	public void testEmployeeSalaryConstantTaxFreeIncome() {
		Employee karl = new Employee("Karl", "Raamatupidaja");
		karl.setMonthlyGrossSalary(1000);
		NetSalaryCalculator netSalaryCalculator = new NetSalaryCalculator(karl.getMonthlyGrossSalary());
		Assert.assertEquals(netSalaryCalculator.calculateNetSalary(), 902, 0.01);
	}

	@Test
	public void testEmployeeSalary() {
		Employee juhan = new Employee("Juhan", "Elektriinsener");
		juhan.setMonthlyGrossSalary(1900);
		NetSalaryCalculator netSalaryCalculator = new NetSalaryCalculator(juhan.getMonthlyGrossSalary());
		Assert.assertEquals(netSalaryCalculator.calculateNetSalary(), 1494.35, 0.01);
	}

	@Test
	public void testEmployeeSalaryNoTaxFreeIncome() {
		Employee madis = new Employee("madis", "IT-arhitekt");
		madis.setMonthlyGrossSalary(2200);
		NetSalaryCalculator netSalaryCalculator = new NetSalaryCalculator(madis.getMonthlyGrossSalary());
		Assert.assertEquals(netSalaryCalculator.calculateNetSalary(), 1696.64, 0.01);
	}
}
