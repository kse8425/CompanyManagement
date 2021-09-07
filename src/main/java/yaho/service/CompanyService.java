package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yaho.domain.Company;
import yaho.repository.CompanyRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public void add(Company company) {
        companyRepository.save(company);
    }

    public Company findByName(String companyName) {
        return companyRepository.findByName(companyName);
    }

    public List<Company> list() {
        return companyRepository.findAll();
    }

    public List<String> findByMatch(String companyName) {
        if (companyName == "") return null;
        return companyRepository.findByMatch(companyName);
    }

    @Transactional
    public void deleteById(Long id){
        companyRepository.deleteByID(id);
    };
}
