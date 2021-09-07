package yaho.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import yaho.domain.Company;
import yaho.service.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/company/sign-up")
    String signUp(Model model) {
        List<Company> companyList = companyService.list();
        model.addAttribute("companyForm", new CompanyForm());
        model.addAttribute("companyList", companyList);
        return "/company/sign-up";
    }

    @PostMapping("/company/sign-up")
    String signUpForm(CompanyForm companyForm) {
        Company company = new Company(companyForm.getCompanyName(), companyForm.getBusinessNumber());
        company.setTelNumber(companyForm.getTelNumber());
        company.setEmail(companyForm.getEmail());
        companyService.add(company);
        return "redirect:/company/sign-up";
    }

    @GetMapping("/company/remove/{companyId}")
    String remove(@PathVariable("companyId")Long companyId,Model model){
        companyService.deleteById(companyId);
        List<Company> companyList = companyService.list();
        model.addAttribute("companyList", companyList);
        return "/company/list :: .table";
    }

    @GetMapping("company/list")
    String list(Model model) {
        List<Company> companyList = companyService.list();
        model.addAttribute("companyList", companyList);
        return "/company/list";
    }


}
