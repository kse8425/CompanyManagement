package yaho.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yaho.domain.Company;
import yaho.form.CompanyForm;
import yaho.service.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/companies")
    String companiesRead(Model model){
        List<Company> companyList = companyService.readAll();
        model.addAttribute("companyForm", new CompanyForm());
        model.addAttribute("companyList", companyList);
        return "companies/total_list";
    }

    @PostMapping("/companies")
    String companiesCreate(CompanyForm companyForm){
        Company newCompany = companyService.createCompany(companyForm);
        companyService.create(newCompany);
        return "redirect:/companies";
    }

    @ResponseBody
    @PutMapping("/company/{companyId}")
    List<Company> companyUpdate(@PathVariable("companyId")Long companyId, @RequestBody CompanyForm companyForm){
        companyService.update(companyId,companyForm);
        List<Company> companyList = companyService.readAll();
        return companyList;
    }

    @ResponseBody
    @DeleteMapping("/company/{companyId}")
    List<Company> companyDelete(@PathVariable("companyId")Long companyId) {
        companyService.delete(companyId);
        List<Company> companyList = companyService.readAll();
        return companyList;
    }
}
