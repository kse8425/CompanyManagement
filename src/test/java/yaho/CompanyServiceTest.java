package yaho;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceTest {

    @Autowired CompanyRepository companyRepository;
    @Autowired CompanyService companyService;

    @Test
    void 업체등록() {
        Company company1 = new Company("tech roll", "444-000-555555");
        Company company2 = new Company("sec roll", "444-111-555555");
        Company company3 = new Company("trd roll", "444-111-555555");
        companyService.signUp(company1);
        companyService.signUp(company2);

        List<Company> companyList = companyService.companyList();
        Company findCompany1 = companyRepository.findByID(1);
        Company findCompany2 = companyRepository.findByID(2);

        assertEquals("tech roll",findCompany1.getCompanyName());
        assertEquals("sec roll",findCompany2.getCompanyName());
        assertTrue(companyList.contains(company1));
        assertTrue(companyList.contains(company2));
        assertFalse(companyList.contains(company3));
    }
}
