async function monthlyRevenueChartFn() {
    const res = await fetch(`/monthlyRevenue`, {method: "get"});
    const monthlyRevenue = await res.json();

    const ctx = document.getElementById("monthlyRevenueChart").getContext("2d");
    const data = {
        labels: monthlyRevenue['labels'],
        datasets: [
            {
                label: "매 출",
                data: monthlyRevenue['dataset'],
                backgroundColor: [
                    "rgba(255, 99, 132, 0.2)",
                    "rgba(54, 162, 235, 0.2)",
                    "rgba(255, 206, 86, 0.2)",
                    "rgba(75, 192, 192, 0.2)",
                    "rgba(153, 102, 255, 0.2)",
                    "rgba(255, 159, 64, 0.2)",
                    "rgba(255, 99, 132, 0.2)",
                    "rgba(54, 162, 235, 0.2)",
                    "rgba(255, 206, 86, 0.2)",
                    "rgba(75, 192, 192, 0.2)",
                    "rgba(153, 102, 255, 0.2)",
                    "rgba(255, 159, 64, 0.2)",
                ],
                borderColor: [
                    "rgba(255,99,132,1)",
                    "rgba(54, 162, 235, 1)",
                    "rgba(255, 206, 86, 1)",
                    "rgba(75, 192, 192, 1)",
                    "rgba(153, 102, 255, 1)",
                    "rgba(255, 159, 64, 1)",
                    "rgba(255,99,132,1)",
                    "rgba(54, 162, 235, 1)",
                    "rgba(255, 206, 86, 1)",
                    "rgba(75, 192, 192, 1)",
                    "rgba(153, 102, 255, 1)",
                    "rgba(255, 159, 64, 1)",
                ],
                borderWidth: 1,
            },
        ],
    }
    const config = {
        type: "bar",
        data: data,
        options: {
            maintainAspectRatio: false,
        },
    }
    const myChart = new Chart(ctx, config);
};

async function salesPercentChartFn() {
    const res = await fetch(`/salesPercent`, {method: "get"});
    const salesPercent = await res.json();

    const ctx = document.getElementById("salesPercentChart").getContext("2d");
    const data = {
        labels: salesPercent['labels'],
        datasets: [
            {
                data: salesPercent['dataset'],
                backgroundColor: Object.values(Utils.CHART_COLORS),
            },
        ],
    }
    const config = {
        type: "doughnut",
        data: data,
        options: {
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    position: 'top',
                }
            }
        },
    }
    const myChart = new Chart(ctx, config);
}
monthlyRevenueChartFn();
salesPercentChartFn();
