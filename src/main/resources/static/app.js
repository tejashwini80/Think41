document.addEventListener("DOMContentLoaded", function () {
    const API_URL = "http://localhost:8080/api/customers"; //  Your Spring Boot API
    const table = document.getElementById("customerTable");
    const searchInput = document.getElementById("searchInput");
    const loading = document.getElementById("loading");

    let customers = [];

    //  Fetch customers from API
    fetch(API_URL)
        .then(response => {
            if (!response.ok) throw new Error("Failed to load data");
            return response.json();
        })
        .then(data => {
            loading.style.display = "none";
            customers = Array.isArray(data) ? data : data.customers;
            displayCustomers(customers);
        })
        .catch(err => {
            loading.textContent = "Failed to load customers!";
            console.error("API Error:", err);
        });

    //  Display customers in table
    function displayCustomers(list) {
        table.innerHTML = "";
        if (list.length === 0) {
            table.innerHTML = "<tr><td colspan='3'>No customers found</td></tr>";
            return;
        }
        list.forEach(c => {
            const row = `<tr>
                <td>${c.firstName} ${c.lastName}</td>
                <td>${c.email}</td>
                <td>${c.orderCount}</td>
            </tr>`;
            table.innerHTML += row;
        });
    }

    // Search Functionality
    searchInput.addEventListener("input", function () {
        const term = this.value.toLowerCase();
        const filtered = customers.filter(c =>
            ${c.firstName} ${c.lastName}.toLowerCase().includes(term) ||
            c.email.toLowerCase().includes(term)
        );
        displayCustomers(filtered);
    });
});