package yaho.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yaho.form.DashboardCardForm;
import yaho.service.DashBoardService;
import yaho.form.ChartForm;

@Controller
@RequiredArgsConstructor
public class DashBoardController {
    private final DashBoardService dashBoardService;

    @GetMapping("/")
    String dashBoard(Model model){
        model.addAttribute("thisMonthRevenue",dashBoardService.getThisMonthRevenue());
        model.addAttribute("thisWeekRevenue",dashBoardService.getThisWeekRevenue());
        model.addAttribute("bestProduct",dashBoardService.getBestProduct());
        model.addAttribute("bestCompany",dashBoardService.getBestCompany());
        return "index";
    }

    @ResponseBody
    @GetMapping("/monthlyRevenue")
    ChartForm monthlyRevenue(){
        return dashBoardService.makeMonthRevenueList();
    }

    @ResponseBody
    @GetMapping("/salesPercent")
    ChartForm salesPercent(){
        return dashBoardService.makeSalesPercentList();
    }

    @ResponseBody
    @GetMapping("/thisMonthRevenue")
    DashboardCardForm thisMonthRevenue(){
        return dashBoardService.getThisMonthRevenue();
    }

    @ResponseBody
    @GetMapping("/thisWeekRevenue")
    DashboardCardForm thisWeekRevenue(){
        return dashBoardService.getThisWeekRevenue();
    }

    @ResponseBody
    @GetMapping("/bestProduct")
    DashboardCardForm bestProduct(){
        return dashBoardService.getBestProduct();
    }

    @ResponseBody
    @GetMapping("/bestCompany")
    DashboardCardForm bestCompany(){
        return dashBoardService.getBestCompany();
    }

}
