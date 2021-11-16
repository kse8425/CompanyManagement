async function thisMonthRevenue() {
    const revenue = document.getElementById("thisMonthRevenue");
    const percent = document.getElementById("thisMonthPercent");
    const res = await fetch(`/thisMonthRevenue`, {method: "get"});
    const thisMonthRevenue = await res.json();
    revenue.innerText = thisMonthRevenue['content'];
    percent.innerText = thisMonthRevenue['percent'] + "%";
    if(thisMonthRevenue['percent']<0) percent.className="percent_minus";
}

async function thisWeekRevenue() {
    const revenue = document.getElementById("thisWeekRevenue");
    const percent = document.getElementById("thisWeekPercent");
    const res = await fetch(`/thisWeekRevenue`, {method: "get"});
    const thisWeekRevenue = await res.json();
    revenue.innerText = thisWeekRevenue['content'];
    percent.innerText = thisWeekRevenue['percent'] + "%";
    if(thisWeekRevenue['percent']<0) percent.className="percent_minus";
}

async function bestProduct() {
    const revenue = document.getElementById("bestProduct");
    const percent = document.getElementById("bestProductPercent");
    const res = await fetch(`/bestProduct`, {method: "get"});
    const bestProduct = await res.json();
    revenue.innerText = bestProduct['content'];
    percent.innerText = bestProduct['percent'] + "%";
    if(bestProduct['percent']<0) percent.className="percent_minus";
}

thisMonthRevenue();
thisWeekRevenue();
bestProduct();