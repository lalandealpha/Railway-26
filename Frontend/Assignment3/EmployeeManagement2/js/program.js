// var prevScrollpos = window.pageYOffset;
// window.onscroll = function() {
//     var currentScrollPos = window.pageYOffset;
//     if (prevScrollpos > currentScrollPos) {
//         document.getElementById("navbar").style.top = "0";
//     } else {
//         document.getElementById("navbar").style.top = "-50px";
//     }
//     prevScrollpos = currentScrollPos;
// }

$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function backToHomepage() {
    $(".main").load("home.html");
}

function viewEmployeeList() {
    $(".main").load("employeeListView.html");
    buildTable();
}


var employees = [];

function Employee(id, name, department, phone) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function getEmployeeList() {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/employess", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        employees = [];
        parseData(data);
        fillEmloyeeToTable();
    });
}

function parseData(data) {
    data.forEach(element => {
        employees.push(new Employee(element.id, element.name, element.department, element.phone));
    });
}

function fillEmloyeeToTable() {
    employees.forEach(function(item) {
        $('tbody').append(
            '<tr><td>' + item.name +
            '</td><td>' + item.department +
            '</td><td>' + item.phone +
            '</td><td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="showUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onclick="showDeleteConfirm(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td></tr>'
        )
    });
}

function buildTable() {
    $('tbody').empty();
    getEmployeeList();
}

function addEmployee() {
    let name = document.getElementById("name").value;
    let department = document.getElementById("department").value;
    let phone = document.getElementById("phone").value;

    $.post("https://61f9d3ca31f9c2001759658e.mockapi.io/employess", {
        name: name,
        department: department,
        phone: phone
    }, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        hideModal();
        showSuccessAlert();
        buildTable();
    });
}

function showModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function showAddEmpModal() {
    resetForm();
    showModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}

function showUpdateModal(id) {
    let index = employees.findIndex(x => x.id == id);
    document.getElementById("id").value = id;
    document.getElementById("name").value = employees[index].name;
    document.getElementById("department").value = employees[index].department;
    document.getElementById("phone").value = employees[index].phone;
    showModal();
}

function updateEmployee() {
    let id = document.getElementById("id").value;
    let name = document.getElementById("name").value;
    let department = document.getElementById("department").value;
    let phone = document.getElementById("phone").value;

    $.ajax({
        url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/employess/' + id,
        type: 'PUT',
        data: {
            name: name,
            department: department,
            phone: phone
        },
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
            showSuccessAlert();
            hideModal();
            buildTable();
        }
    });
}

function save() {
    let id = document.getElementById("id").value;
    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function showDeleteConfirm(id) {
    document.getElementById("id").value = id;
    let index = employees.findIndex(x => x.id == id);
    let result = window.confirm("Delete " + employees[index].name + "?");
    if (result) {
        $.ajax({
            url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/employess/' + id,
            type: 'DELETE',
            success: function(result) {
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
                showSuccessAlert();
                buildTable();
            }
        });
    }
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}