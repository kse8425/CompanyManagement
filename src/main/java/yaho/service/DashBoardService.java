package yaho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaho.domain.Company;
import yaho.domain.Order;
import yaho.domain.Product;
import yaho.form.DashboardCardForm;
import yaho.form.ChartForm;
import yaho.repository.OrderRepository;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.abs;

@Service
@RequiredArgsConstructor
public class DashBoardService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CompanyService companyService;

    public List<Order> thisMonthOrderList() {
        YearMonth yearMonth = YearMonth.now();
        LocalDate start = yearMonth.atDay(1);
        LocalDate end = yearMonth.atEndOfMonth();
        List<Order> orders = orderRepository.findByDateBetween(start, end);
        return orders;
    }

    public List<Order> lastMonthOrderList() {
        YearMonth yearMonth = YearMonth.now().minusMonths(1);
        LocalDate start = yearMonth.atDay(1);
        LocalDate end = yearMonth.atEndOfMonth();
        List<Order> orders = orderRepository.findByDateBetween(start, end);
        return orders;
    }

    public List<Order> thisWeekOrderList() {
        LocalDate today = LocalDate.now();
        int dayOfWeek = today.getDayOfWeek().getValue();
        LocalDate start = today.minusDays(dayOfWeek - 1); //이번 주 월요일을 찾기 위해 (오늘 요일 - 1)
        LocalDate end = today;
        List<Order> orders = orderRepository.findByDateBetween(start, end);
        return orders;
    }

    public List<Order> lastWeekOrderList() {
        LocalDate today = LocalDate.now().minusWeeks(1);
        int dayOfWeek = today.getDayOfWeek().getValue();
        LocalDate start = today.minusDays(dayOfWeek - 1);
        LocalDate end = today;
        List<Order> orders = orderRepository.findByDateBetween(start, end);
        return orders;
    }

    public HashMap<String, LocalDate> getMonthStartEnd(int month) {
        HashMap<String, LocalDate> startEnd = new HashMap();
        YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(), month);
        startEnd.put("start", yearMonth.atDay(1));
        startEnd.put("end", yearMonth.atEndOfMonth());
        return startEnd;
    }

    public List<Order> findByDateBetween(HashMap<String, LocalDate> startEnd) {
        List<Order> orders = orderRepository.findByDateBetween(startEnd.get("start"), startEnd.get("end"));
        return orders;
    }

    public int sumRevenueInList(List<Order> orders) {
        int totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }

    public ChartForm makeMonthRevenueList() {
        ChartForm monthRevenue = new ChartForm();
        List<String> month = new ArrayList<>();
        List<Integer> revenue = new ArrayList<>();
        List<Order> orderList;

        for (int i = 1; i <= 12; i++) {
            String mon = i + "월";
            orderList = findByDateBetween(getMonthStartEnd(i));
            Integer rev = sumRevenueInList(orderList);
            month.add(mon);
            revenue.add(rev);
        }
        monthRevenue.setLabels(month);
        monthRevenue.setDataset(revenue);
        return monthRevenue;
    }

    public DashboardCardForm getThisMonthRevenue() {
        List<Order> thisMonthOrderList = thisMonthOrderList();
        List<Order> lastMonthOrderList = lastMonthOrderList();
        return getRevenueForm(thisMonthOrderList, lastMonthOrderList);
    }

    public DashboardCardForm getThisWeekRevenue() {
        List<Order> thisWeekOrderList = thisWeekOrderList();
        List<Order> lastWeekOrderList = lastWeekOrderList();
        return getRevenueForm(thisWeekOrderList, lastWeekOrderList);
    }

    private DashboardCardForm getRevenueForm(List<Order> thisOrderList, List<Order> lastOrderList) {
        int thisRevenue = sumRevenueInList(thisOrderList);
        int lastRevenue = sumRevenueInList(lastOrderList);
        if (lastRevenue == 0) lastRevenue = 1;
        double percent = ((thisRevenue - lastRevenue) / (double) lastRevenue) * 100.0;
        String sRevenue = new DecimalFormat("###,###").format(thisRevenue) + '원';
        String sPercent = String.format("%.2f", percent);
        return new DashboardCardForm(sRevenue, sPercent);
    }

    public DashboardCardForm getBestProduct() {
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate end = LocalDate.now();
        Product bestProduct = new Product();
        int bestProductPrice = 0;
        int totalRevenue = sumRevenueInList(lastMonthOrderList());

        for (Product product : productService.readAll()) {
            int totalPrice = 0;
            for (Order order : orderRepository.findByProductAndDateBetween(product, start, end)) {
                totalPrice += order.getPrice();
            }
            if(totalPrice > bestProductPrice) {
                bestProduct = product;
                bestProductPrice = totalPrice;
            }
        }
        String percent = String.format("%.2f",(bestProductPrice / (double) totalRevenue * 100));
        return new DashboardCardForm(bestProduct.getName(),percent);
    }
    public DashboardCardForm getBestCompany() {
        LocalDate start = YearMonth.now().atDay(1);
        LocalDate end = LocalDate.now();
        Company bestCompany = new Company();
        int bestCompanyPrice = 0;
        int totalRevenue = sumRevenueInList(lastMonthOrderList());

        for (Company company : companyService.readAll()) {
            int totalPrice = 0;
            for (Order order : orderRepository.findByCompanyAndDateBetween(company, start, end)) {
                totalPrice += order.getPrice();
            }
            if(totalPrice > bestCompanyPrice) {
                bestCompany = company;
                bestCompanyPrice = totalPrice;
            }
        }
        String percent = String.format("%.2f",(bestCompanyPrice / (double) totalRevenue * 100));
        return new DashboardCardForm(bestCompany.getName(),percent);
    }

    public ChartForm makeSalesPercentList() {
        ChartForm salesPercent = new ChartForm();
        List<String> products = new ArrayList<>();
        List<Integer> percent = new ArrayList<>();
        salesPercent.setLabels(products);
        salesPercent.setDataset(percent);
        return salesPercent;
    }
}