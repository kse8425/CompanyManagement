package yaho;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//@RequiredArgsConstructor
public class CompanyRepository {

    private int id=0;

    Map<Integer, Company> companyList = new HashMap<>();

    void save(Company company) {
        id++;
        company.setId(id);
        companyList.put(id, company);
    }

    Company findByID(int id) {
        return companyList.get(id);
    }

    List<Company> findAll() {
        return new ArrayList<>(companyList.values());
    }
}
