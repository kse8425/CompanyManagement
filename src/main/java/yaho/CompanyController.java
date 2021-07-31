package yaho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired CompanyService companyService;
    @Autowired CompanyRepository companyRepository;

    @GetMapping("sign-up")
    String signUp(Model model) {
        model.addAttribute("companyForm", new CompanyForm());
        return "/sign-up";
    }

    @PostMapping("sign-up")
    String signUpForm(CompanyForm companyForm) {
        Company company = new Company(companyForm.getCompanyName(), companyForm.getBusinessNumber());
        company.setTelNumber(companyForm.getTelNumber());
        company.setEmail(companyForm.getEmail());
        companyService.signUp(company);
        return "/index";
    }

    @GetMapping("list")
    String list(Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companyList", companyList);
        return "/list";
    }


}
