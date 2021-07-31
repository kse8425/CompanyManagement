package yaho;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyRepositoryTest {


    @Autowired CompanyRepository companyRepository;

    @Test
    void 회원저장조회() {
        Company company1 = new Company("tech roll", "444-000-555555");
        Company company2 = new Company("sec roll", "444-111-555555");

        companyRepository.save(company1);
        companyRepository.save(company2);
        Company findCompany = companyRepository.findByID(2);

        assertEquals("sec roll", findCompany.getCompanyName());
    }
}