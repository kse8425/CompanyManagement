package yaho.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yaho.domain.Company;
import yaho.repasitory.CompanyRepository;
import yaho.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("company/sign-up")
    String signUp(Model model) {
        model.addAttribute("companyForm", new CompanyForm());
        return "/company/sign-up";
    }

    @PostMapping("company/sign-up")
    String signUpForm(CompanyForm companyForm) {
        Company company = new Company(companyForm.getCompanyName(), companyForm.getBusinessNumber());
        company.setTelNumber(companyForm.getTelNumber());
        company.setEmail(companyForm.getEmail());
        companyService.signUp(company);
        return "redirect:/";
    }

    @GetMapping("company/list")
    String list(Model model) {
        List<Company> companyList = companyRepository.findAll();
        model.addAttribute("companyList", companyList);
        return "/company/list";
    }


}
