package yaho.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Company;
import yaho.repository.CompanyRepository;
import yaho.repository.CompanyRepositoryByMemory;
import yaho.service.CompanyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {
    CompanyRepository repo = new CompanyRepositoryByMemory();
    CompanyService companyService = new CompanyService(repo);

    Company company = new Company("kse", "123123");


    @BeforeEach
    void add() {
        companyService.add(company);
    }

    @Test
    void findByName() {
        Company find = companyService.findByName("kse");
        assertEquals(company.getName(),find.getName());
    }

    @Test
    void list() {
        Company company1 = new Company("kse1", "1231231");
        Company company2 = new Company("kse2", "1231232");
        Company company3 = new Company("kse3", "1231233");
        companyService.add(company1);
        companyService.add(company2);

        List<Company> companyList = companyService.list();

        assertTrue(companyList.stream().anyMatch(company->company.getName().equals(company1.getName())));
        assertTrue(companyList.stream().anyMatch(company->company.getName().equals(company2.getName())));
        assertFalse(companyList.stream().anyMatch(company->company.getName().equals(company3.getName())));
    }
}