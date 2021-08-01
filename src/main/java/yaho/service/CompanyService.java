package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaho.domain.Company;
import yaho.repasitory.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void signUp(Company company) {
        companyRepository.save(company);
    }

    public List<Company> list() {
        return companyRepository.findAll();
    }




}
