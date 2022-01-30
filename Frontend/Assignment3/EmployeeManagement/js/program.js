$(function () {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

var prevScrollpos = window.pageYOffset;
window.onscroll = function() {
var currentScrollPos = window.pageYOffset;
  if (prevScrollpos > currentScrollPos) {
    document.getElementById("navbar").style.top = "0";
  } else {
    document.getElementById("navbar").style.top = "-50px";
  }
  prevScrollpos = currentScrollPos;
}

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavEmployeeList() {
    $(".main").load("employeeList.html");
    buildTable();
}

var employees = [];
var counter = 0;

function Employee(name, department, phone) {
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function initEmployee() {
    if(employees == null || employees.length < 1) {
        employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
        employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
        employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
        employees.push(new Employee("Bernadina Kenner", "Programmer IV", "(689) 471-6183"));
        employees.push(new Employee("Otis Creegan", "Human Resources", "(893) 665-7826"));
        employees.push(new Employee("Katrine Di Biagi", "Data Coordiator", "(310) 535-9452"));
        employees.push(new Employee("Josh Rimer", "Recruiter", "(741) 251-1910"));
        employees.push(new Employee("Clio Tuxwell", "Staff Accountant I", "(973) 183-6370"));
        employees.push(new Employee("Ezequiel Ciccoloi", "Web Developer I", "(997) 413-7292"));
        employees.push(new Employee("Payton Marie", "Geologist IV", "(242) 451-3077"));
        employees.push(new Employee("Dyane Loughhead", "Office Assistant I", "(712) 364-0720"));
    }
}

function buildTable() {
    setTimeout(function name(params) {
        $('tbody').empty();
        initEmployee();
        employees.forEach(function(item){
            $('tbody').append(
                '<tr>' + 
                '<td>' + item.name + 
                '</td>' + 
                '<td>' + item.department + 
                '</td>' + 
                '<td>' + item.phone + 
                '</td>' + 
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons" data-bs-toggle="modal">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onclick="openDeleteConfirm(' + item.id + ')"><i class="material-icons" data-bs-toggle="modal">&#xE872;</i></a>' +
                '</td>' +
                '</tr>')
        });
    }, 500);
}

function resetFrom() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}

function showModal() {
    $("#myModal").modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function openAddModal() {
    resetFrom();
    showModal();
}

function addEmployee() {
    let name = document.getElementById("name").value;
    let department = document.getElementById("department").value;
    let phone = document.getElementById("phone").value;
    employees.push(new Employee(name, department, phone));
    hideModal();
    showSuccessAlert();
    buildTable();
    
}

function openUpdateModal(id) {
    let index = employees.findIndex(x => x.id == id);
    document.getElementById("name").value = employees[index].name;
    document.getElementById("department").value = employees[index].department;
    document.getElementById("phone").value = employees[index].phone;
    document.getElementById("id").value = employees[index].id;
    showModal();
}

function updateEmployee() {
    let id = document.getElementById("id").value;
    let index = employees.findIndex(x => x.id == id);

    employees[index].name = document.getElementById("name").value;
    employees[index].department = document.getElementById("department").value;
    employees[index].phone = document.getElementById("phone").value;
    hideModal();
    showSuccessAlert();
    buildTable();
}

function save() {
    let id = document.getElementById("id").value;
    if(id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}

function openDeleteConfirm(id) {
    let index = employees.findIndex(x => x.id == id);
    let result = confirm("Delete " + employees[index].name + "?");
    if(result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    let index = employees.findIndex(x => x.id == id);
    employees.splice(index, 1);
    showSuccessAlert();
    buildTable();
}