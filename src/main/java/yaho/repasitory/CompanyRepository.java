package yaho.repasitory;

import org.springframework.stereotype.Repository;
import yaho.domain.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//@RequiredArgsConstructor
public class CompanyRepository {

    private int id=0;

    Map<Integer, Company> companyList = new HashMap<>();

    public void save(Company company) {
        id++;
        company.setId(id);
        companyList.put(id, company);
    }

    public Company findByID(int id) {
        return companyList.get(id);
    }

    public List<Company> findAll() {
        return new ArrayList<>(companyList.values());
    }
}
