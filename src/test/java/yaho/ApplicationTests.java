package yaho;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import yaho.domain.Company;

import java.util.ArrayList;
import java.util.List;


class ApplicationTests {

	@Test
	void contextLoads() {

		Company company1 = new Company("kse", "123");
		Company company2 = new Company("lsn", "1234");
		List<Company> companyList = new ArrayList<>();
		companyList.add(company1);
		companyList.add(company2);
		Company findCompany = companyList.stream().filter(company -> company.getName()=="kse").findFirst().get();
		String name = findCompany.getBusinessNumber();
		System.out.println(name);
	}

}
