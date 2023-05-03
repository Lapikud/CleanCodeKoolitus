package cleancode.clean;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {
	@Test
	public void testEmployeeNameAndTitle() {
		Employee karin = new Employee("Karin", "Ärikonsultant");
		Assert.assertEquals(karin.getName(), "Karin");
		Assert.assertEquals(karin.getTitle(), "Ärikonsultant");
		karin.setTitle("Turundusjuht");
		Assert.assertEquals(karin.getTitle(), "Turundusjuht");
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
