package yaho;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void signUp(Company company) {
        companyRepository.save(company);
    }

    public List<Company> companyList() {
        return companyRepository.findAll();
    }




}
