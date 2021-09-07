package yaho.repository;

import yaho.domain.Company;

import java.util.List;

public interface CompanyRepository {
    public Long save(Company company);

    public Company findByID(Long id);

    public Company findByName(String companyName);

    public List<Company> findAll();

    public List<String> findByMatch(String companyName);

    public void deleteByID(Long id);
}
