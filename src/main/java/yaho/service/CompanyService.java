package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Company;
import yaho.form.CompanyForm;
import yaho.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public void create(Company company) {
        companyRepository.save(company);
    }

    public List<Company> readAll() {
        return companyRepository.findAll();
    }

    @Transactional
    public void update(Long id, CompanyForm companyForm) {
        Company company = companyRepository.findById(id).get();
        company.setName(companyForm.getCompanyName());
        company.setTelNumber(companyForm.getTelNumber());
        company.setEmail(companyForm.getEmail());
        company.setLocation(companyForm.getLocation());
        companyRepository.save(company);
    }

    @Transactional
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }


    public Company findByName(String companyName) {
        return companyRepository.findByName(companyName);
    }

    public Company findByNameLike(String companyName) {
        if (companyName == "") return null;
        return companyRepository.findByNameLike(companyName);
    }

    public Company buildCompany(CompanyForm companyForm) {
        Company company = Company.builder()
                .name(companyForm.getCompanyName())
                .telNumber(companyForm.getTelNumber())
                .location(companyForm.getLocation())
                .email(companyForm.getEmail())
                .build();
        return company;
    }
}
