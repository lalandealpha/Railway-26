function viewAccountPage() {
    $(".main").load("./account/accountPage.html", function() {
        setupSearchAccountEvent();
        setupDepartmentFilter();
        buildAccountTable();
    });
}


// search
function setupSearchDepartmentEvent() {
    $("#search-department-selection").on("keyup", function(event) {
        // enter key code = 13
        if (event.keyCode === 13) {
            departmentName = document.getElementById("search-department-selection").value;
            setDepartmentSelectOptionForFilter();
        }
    });
}

function buildAccountTable() {
    $('#account-table tbody').empty();
    getListAccounts();
}

let accounts = [];

// paging
let currentPage = 1;
let size = 10;

// sorting
let sortField = "id";
let isAsc = true;


// get account list
function getListAccounts() {

    let url = "http://localhost:8080/api/v1/accounts";

    // paging
    url += "?page=" + currentPage + "&size=" + size;

    // sorting
    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    // filtering
    let role = document.getElementById("filter-role-select").value;
    if (role && role != "All Roles") {
        url += "&role=" + role;
    }

    var departmentName = $("#filter-department-select option:selected").text();
    console.log($("#filter-department-select option:selected"));
    if (departmentName && departmentName != "All Departments") {
        url += "&departmentName=" + departmentName;
    }

    // search
    let search = document.getElementById("search-account-input").value;
    if (search) {
        url += "&search=" + search;
    }

    $.get(url, function(data, status) {

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        accounts = data.content;
        fillAccountToTable();
        fillAccountPaging(data.numberOfElements, data.totalPages);
        fillAccountSorting();
    });
}

function fillAccountToTable() {
    accounts.forEach(function(item, index) {
        $('#account-table tbody').append(
            '<tr>' +
            '<td> ' +
            '<span class="account-checkbox"> ' +
            '<input id="checkbox-' + index + '" type="checkbox" onClick="onChangeCheckboxItem()"/>' +
            '<label></label>' +
            '</span>' +
            '</td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.role + '</td>' +
            '<td>' + item.departmentName + '</td>' +

            '<td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showUpdateAccountModal(' + item.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleAccountModal(' + item.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td>' +
            '</tr>'
        );
    });
}

// fill paging info
function fillAccountPaging(numberOfElements, totalPages) {

    // prev button
    if (currentPage > 1) {
        document.getElementById("account-previousPage-btn").disabled = false;
    } else {
        document.getElementById("account-previousPage-btn").disabled = true;
    }

    // next button
    if (currentPage < totalPages) {
        document.getElementById("account-nextPage-btn").disabled = false;
    } else {
        document.getElementById("account-nextPage-btn").disabled = true;
    }

    document.getElementById("account-page-info").innerHTML = numberOfElements + (numberOfElements > 1 ? " records " : " record ") + currentPage + " of " + totalPages;
}

function prevAccountPage() {
    changeAccountPage(currentPage - 1);
}

function nextAccountPage() {
    changeAccountPage(currentPage + 1);
}

function changeAccountPage(page) {
    currentPage = page;
    buildAccountTable();
}

// sorting
function fillAccountSorting() {
    var sortTypeClazz = isAsc ? "fa-sort-up" : "fa-sort-down";
    var defaultSortType = "fa-sort";

    switch (sortField) {
        case 'username':
            // show sort type
            changeSortIcon("username-sort", sortTypeClazz);
            changeSortIcon("fullname-sort", defaultSortType);
            changeSortIcon("departmentName-sort", defaultSortType);

            // custom css
            $('#th-username a, #th-username i').css('color', '#fe6100');
            $('#th-full-name a, #th-full-name i').css('color', '#000');
            $('#th-department a, #th-department i').css('color', '#000');
            break;
        case 'fullName':
            // show sort type
            changeSortIcon("username-sort", defaultSortType);
            changeSortIcon("fullname-sort", sortTypeClazz);
            changeSortIcon("departmentName-sort", defaultSortType);

            // custom css
            $('#th-username a, #th-username i').css('color', '#000');
            $('#th-full-name a, #th-full-name i').css('color', '#fe6100');
            $('#th-department a, #th-department i').css('color', '#000');
            break;
        case 'departmentName':
            // show sort type
            changeSortIcon("username-sort", defaultSortType);
            changeSortIcon("fullname-sort", defaultSortType);
            changeSortIcon("departmentName-sort", sortTypeClazz);

            // custom css
            $('#th-username a, #th-username i').css('color', '#000');
            $('#th-full-name a, #th-full-name i').css('color', '#000');
            $('#th-department a, #th-department i').css('color', '#fe6100');
            break;

            // sort by id
        default:
            changeSortIcon("username-sort", defaultSortType);
            changeSortIcon("fullname-sort", defaultSortType);
            changeSortIcon("departmentName-sort", defaultSortType);
            break;
    }
}

function changeSortIcon(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-up", "fa-sort-down");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeAccountSort(field) {
    if (sortField == field) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }

    buildAccountTable();
}

// search
function setupSearchAccountEvent() {

    $("#search-account-input").on("keyup", function(event) {
        // enter key code = 13
        if (event.keyCode === 13) {
            buildAccountTable();
        }
    });
}

// filtering
function filterAccount() {
    buildAccountTable();
}

function setupDepartmentFilter() {

    // setup call API
    $("#filter-department-select").select2({
        ajax: {
            url: "http://localhost:8080/api/v1/departments",
            dataType: 'json',
            type: "GET",
            data: function(params) {
                var query = {
                    // paging
                    page: 1,
                    size: 5,
                    // sorting
                    sort: "id,asc",
                    // search
                    search: params.term
                }

                // Query parameters will be ?page=1&size=5&sort=id,asc&search=[term]
                return query;
            },
            processResults: function(data) {
                var defaultValue = {
                    "id": 0,
                    "name": "All Departments"
                };

                var departments = data.content;
                departments.splice(0, 0, defaultValue);

                return {
                    results: $.map(departments, function(item) {
                        return {
                            text: item.name,
                            id: item.id
                        }
                    })
                };
            }
        }
    });
}

// refresh 
function refreshAccountList() {

    // refresh paging
    currentPage = 1;
    size = 10;

    // refresh sorting
    sortField = "id";
    isAsc = true;

    // reset sorting css
    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#000');

    // refresh search
    document.getElementById("search-account-input").value = "";

    // refresh filter


    buildAccountTable();
}

function setupRole() {
    // let data = [{
    //     id:
    // }]
}