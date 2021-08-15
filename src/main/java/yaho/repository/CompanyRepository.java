package yaho.repository;

import yaho.domain.Company;

import java.util.List;

public interface CompanyRepository {
    public Long save(Company company);

    public Company findByID(Long id);

    public Company findByName(String name);

    public List<Company> findAll();
}
