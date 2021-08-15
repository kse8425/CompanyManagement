package yaho.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yaho.domain.Company;
import yaho.repository.CompanyRepository;
import yaho.repository.CompanyRepositoryByMemory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyRepoByMemoryTest {

    CompanyRepository companyRepository = new CompanyRepositoryByMemory();
    Company company;
    Long saveId;

    @BeforeEach
    void save() {
        company = new Company("kse", "123123");
        saveId = companyRepository.save(company);
    }

    @Test
    void findByID() {
        Company company1 = companyRepository.findByID(saveId);
        assertEquals(company.getName(),company1.getName());
    }

    @Test
    void findByName() {
        Company company1 = companyRepository.findByName("kse");
        assertEquals(company.getName(),company1.getName());
    }

    @Test
    void findAll() {
        Company company1 = new Company("kse1", "1231231");
        Company company2 = new Company("kse2", "1231232");
        Company company3 = new Company("kse3", "1231233");
        companyRepository.save(company1);
        companyRepository.save(company2);

        List<Company> companyList = companyRepository.findAll();

        assertTrue(companyList.stream().anyMatch(company->company.getName().equals(company1.getName())));
        assertTrue(companyList.stream().anyMatch(company->company.getName().equals(company2.getName())));
        assertFalse(companyList.stream().anyMatch(company->company.getName().equals(company3.getName())));
    }
}
