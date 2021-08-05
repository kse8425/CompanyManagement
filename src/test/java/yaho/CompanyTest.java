package yaho;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yaho.domain.Company;
import yaho.repasitory.CompanyRepository;
import yaho.service.CompanyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyTest {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CompanyService companyService;

    @Test
    void 업체등록() {
        //준비
        Company company1 = new Company("tech roll", "444-000-555555");
        Company company2 = new Company("sec roll", "444-111-555555");
        Company company3 = new Company("trd roll", "444-111-555555");
        companyService.add(company1);
        companyService.add(company2);

        //실행
        List<Company> companyList = companyService.list();
        Company findCompany1 = companyRepository.findByID(1);
        Company findCompany2 = companyRepository.findByID(2);

        //검사
        assertEquals("tech roll",findCompany1.getName());
        assertEquals("sec roll",findCompany2.getName());
        assertTrue(companyList.contains(company1));
        assertTrue(companyList.contains(company2));
        assertFalse(companyList.contains(company3));
    }
}
