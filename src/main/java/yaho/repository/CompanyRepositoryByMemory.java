package yaho.repository;

import org.springframework.stereotype.Repository;
import yaho.domain.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Repository
public class CompanyRepositoryByMemory implements CompanyRepository{

    private Long id=0L;

    Map<Long, Company> companyList = new HashMap<>();

    @Override
    public Long save(Company company) {
        id++;
        company.setId(id);
        companyList.put(id, company);
        return company.getId();
    }

    @Override
    public Company findByID(Long id) {
        return companyList.get(id);
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(companyList.values());
    }

    @Override
    public Company findByName(String companyName) {
        return findAll().stream().filter(company -> company.getName().equals(companyName)).findFirst().get();
    }

    @Override
    public List<String> findByMatch(String name) {
        return null;
    }

    @Override
    public void deleteByID(Long id) {

    }
}
