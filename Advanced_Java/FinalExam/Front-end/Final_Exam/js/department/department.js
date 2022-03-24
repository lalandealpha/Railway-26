function viewDepartmentList() {
    $(".main").load("departmentListView.html", function() {
        // Set up search Department
        searchDepartmentByName();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Set filter date min max value
        setDateValueForFilter();

        // Build table
        buildDepartmentTable("http://localhost:8080/api/v1/departments");
    });

    // Reset page number
    departmentPageNumber = 1;
}

function searchDepartmentByName() {
    $("#search-department-input").on("keyup", function(event) {
        let apiLink = "http://localhost:8080/api/v1/departments?";
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            let name = $(this).val();
            if (name != "") {
                apiLink = apiLink + "&search=" + name;
            }

            let minDate = document.getElementById('filter-min-date-select').value;
            let maxDate = document.getElementById('filter-max-date-select').value;
            let type = document.getElementById('filter-type-select').value;

            if (minDate != "") {
                apiLink = apiLink + "&minCreateDate=" + minDate;
            }
            if (maxDate != "") {
                apiLink = apiLink + "&maxCreateDate=" + maxDate;
            }
            if (type != "") {
                apiLink = apiLink + "&type=" + type;
            }

            buildDepartmentTable(apiLink);

        }
    });
}

function setDateValueForFilter() {
    // Set up min date, max date
    document.getElementById('filter-max-date-select').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
    document.getElementById('filter-min-date-select').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
    document.getElementById('filter-max-date-select').value = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
}

function filterDepartment() {

    let apiLink = "http://localhost:8080/api/v1/departments?";

    let name = document.getElementById('search-department-input').value;
    let minDate = document.getElementById('filter-min-date-select').value;
    let maxDate = document.getElementById('filter-max-date-select').value;
    let type = document.getElementById('filter-type-select').value;

    if (name != "") {
        apiLink = apiLink + "&search=" + name;
    }

    if (minDate != "") {
        apiLink = apiLink + "&minCreateDate=" + minDate;
    }
    if (maxDate != "") {
        apiLink = apiLink + "&maxCreateDate=" + maxDate;
    }
    if (type != "") {
        apiLink = apiLink + "&type=" + type;
    }

    buildDepartmentTable(apiLink);
}

function refreshDepartmentList() {
    buildDepartmentTable();
    $(
        '#th-totalMember .fa-sort-up, #th-totalMember .fa-sort-down, ' +
        '#th-createDate .fa-sort-up, #th-createDate .fa-sort-down' +
        '#th-name .fa-sort-up, #th-name .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-totalMember .fa-sort, #th-createDate .fa-sort, #th-name .fa-sort'
    ).css('display', 'inline');


    $('#th-name a, #th-name i').css('color', '#000');
    $('#th-totalMember a, #th-totalMember i').css('color', '#000');
    $('#th-createDate a, #th-createDate i').css('color', '#000');
}

let departments = [];

function Department(id, name, totalMember, type, createDate) {
    this.id = id;
    this.name = name;
    this.totalMember = totalMember;
    this.type = type;
    this.createDate = createDate;
}

function buildDepartmentTable(apiLink) {
    getDepartmentList(apiLink);
}


function getDepartmentList(apiLink) {
    $.get(apiLink, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        // console.log(data);

        fillDepartmentToTable(data);
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}


function fillDepartmentToTable(data) {
    let departmentCount = 0;
    departments = data.content;

    // Reset table body
    $("#mytable tbody").empty();

    departments.forEach(function(item) {
        departmentCount++;
        item.no = departmentCount;
        $('#mytable tbody').append(
            '<tr><td><span class="department-checkbox"><input type="checkbox" id="checkbox' + item.no + '" name="options[]" value="' + item.no + '"><label for="checkbox' + item.no +
            '"></label></span></td><td>' + item.name +
            '</td><td>' + item.totalMember +
            '</td><td>' + item.type +
            '</td><td>' + item.createDate.substring(0, 10) +
            '</td><td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Add accounts" onclick="showAddAccountsToDepartmentModal(' + item.id + ')"><i class="fa-solid fa-plus"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showUpdateDepartmentModal(' + item.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleDepartmentModal(' + item.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td></tr>'
        )
    });

    // Set page infor
    setDepartmentPageInfo(data);

    // Select/Deselect checkboxes
    let checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function() {
        if (this.checked) {
            checkbox.each(function() {
                this.checked = true;
            });
        } else {
            checkbox.each(function() {
                this.checked = false;
            });
        }
    });
    checkbox.click(function() {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
}

function setDepartmentPageInfo(data) {
    let numberOfElements = data.pageable.pageSize;
    let pageNumber = data.pageable.pageNumber + 1;
    let totalPages = data.totalPages;
    let pageInfo = numberOfElements + " record(s) " + pageNumber + " of " + totalPages;
    document.getElementById("department-page-info").innerHTML = pageInfo;

    if (data.first == true) {
        document.getElementById("department-previousPage-btn").disabled = true;
    }
    if (data.first == false && data.last == false) {
        document.getElementById("department-previousPage-btn").disabled = false;
        document.getElementById("department-nextPage-btn").disabled = false;
    }
    if (data.last == true) {
        document.getElementById("department-nextPage-btn").disabled = true;
    }

}

let departmentPageNumber = 1;

function getPreviousDepartmentPage() {
    departmentPageNumber = departmentPageNumber - 1;

    let apiLink = "http://localhost:8080/api/v1/departments?page=" + departmentPageNumber;

    getDepartmentList(apiLink);
}

function getNextDepartmentPage() {
    departmentPageNumber = departmentPageNumber + 1;

    let apiLink = "http://localhost:8080/api/v1/departments?page=" + departmentPageNumber;

    getDepartmentList(apiLink);
}

function showAddAndUpdateDepartmentModal() {
    $('#addAndUpdateDepartmentModal').modal('show');
}

function hideAddAndUpdateDepartmentModal() {
    $('#addAndUpdateDepartmentModal').modal('hide');
}

function showAddDepartmentModal() {
    resetDepartmentForm();
    showAddAndUpdateDepartmentModal();
    document.getElementById("department-id").value = "";
    document.getElementById("addAndUpdateDepartment-modal-title").innerHTML = "Create New Department";
}

function addDepartment() {
    let name = document.getElementById("modal-department-name").value;
    let type = document.getElementById("modal-type-select").value;

    // Custom input box Css
    if (!isDepartmentEmptyInput(name)) {
        document.getElementById('modal-department-name').style.border = "none";
    }
    if (!isDepartmentEmptySelection(type)) {
        document.getElementById('modal-type-select').style.border = "1px solid #ccc";
    }
    if (validateDepartmentInputForm(name, type)) {
        let department = {
            name: name,
            totalMember: 0,
            type: type,
            createDate: new Date()
        };

        $.ajax({
            url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/departments',
            type: 'POST',
            data: JSON.stringify(department), // body
            contentType: "application/json", // type of body (json, xml, text)
            success: function(data, textStatus, xhr) {
                hideAddAndUpdateDepartmentModal();
                showSuccessSnackBar("Success! New department created.");
                refreshDepartmentList();
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }

}

function validateDepartmentInputForm(name, type) {
    // console.log('isEmtry ' + isAccountEmptyInput(username));
    // console.log('regex ' + isUsernameRegex(username));
    // console.log('exist ' + isAccountUsernameExist(username));

    if (!(isDepartmentEmptyInput(name) || isDepartmentEmptySelection(type))) {
        if (isDepartmentNameRegex(name)) {
            if (!isDepartmentNameExist(name)) {
                return true;
            } else {
                document.getElementById('modal-department-input-errMess').innerHTML = "Department name exists";
                document.getElementById('modal-department-input-errMess').style.display = "block";
                document.getElementById('modal-department-name').style.border = "1px solid red";
                return false;
            }
        } else {
            document.getElementById('modal-department-input-errMess').innerHTML = "Department cannot contain special characters";
            document.getElementById('modal-department-input-errMess').style.display = "block";
            document.getElementById('modal-department-name').style.border = "1px solid red";
            return false;
        }
    } else {
        document.getElementById('modal-department-input-errMess').innerHTML = "Please complete all fields";
        document.getElementById('modal-department-input-errMess').style.display = "block";

        if (isDepartmentEmptyInput(name)) {
            document.getElementById('modal-department-name').style.border = "1px solid red";
        }
        if (isDepartmentEmptySelection(type)) {
            document.getElementById('modal-type-select').style.border = "1px solid red";
        }
        return false;
    }
}

function isDepartmentNameExist(name) {
    // Call API
    return false;
}

function isDepartmentNameRegex(name) {
    let regex = new RegExp('^[a-zA-Z0-9\\s]+$');
    return regex.test(name);
}

function isDepartmentEmptyInput(input) {
    if (input == "") {
        return true;
    }
    return false;
}

function isDepartmentEmptySelection(selection) {
    if (selection == "PickAType") {
        return true;
    }
    return false;
}

function resetDepartmentForm() {
    // Reset all input value
    document.getElementById("modal-department-name").value = "";
    document.getElementById("modal-type-select").value = "PickAType";

    // Reset all error message
    document.getElementById('modal-department-input-errMess').style.display = "none";
    document.getElementById('modal-department-name').style.border = "none";
    document.getElementById('modal-type-select').style.border = "1px solid #ccc";

    // Reset all error message
    resetDepartmentModalErrMessage();
}

function resetDepartmentModalErrMessage() {
    document.getElementById('modal-department-input-errMess').style.display = "none";
    document.getElementById('modal-department-name').style.border = "none";
    document.getElementById('modal-type-select').style.border = "1px solid #ccc";
}

function getDepartmentById(id) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments/" + id, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let department = data;
        document.getElementById('delete-single-department-confirm-mess').innerHTML = 'This action can not be undone. Delete <span style="color:red;">' + department.name + '</span>?';
    });
}

function showUpdateDepartmentModal(id) {
    // Reset error message
    resetDepartmentModalErrMessage();

    // Show Modal
    showAddAndUpdateDepartmentModal();

    // Disable Department name input
    $("#modal-department-name").prop('disabled', true);

    document.getElementById("department-id").value = id;
    departments.forEach(element => {
        if (element.id == id) {
            document.getElementById("modal-department-name").value = element.name;
            document.getElementById("modal-type-select").value = element.type;
        }
    });

    document.getElementById("addAndUpdateDepartment-modal-title").innerHTML = "Update Department";
}

function updateDepartment() {
    let id = document.getElementById("department-id").value;
    let name = document.getElementById("modal-department-name").value;
    let type = document.getElementById("modal-type-select").value;

    departments.forEach(department => {
        if (department.id == id && department.name == name && department.type == type) {
            showSuccessSnackBar("Success! Department updated.");
            hideAddAndUpdateDepartmentModal();
            refreshDepartmentList();
        }
    })

    // Custom input box Css
    if (!isDepartmentEmptyInput(name)) {
        document.getElementById('modal-department-name').style.border = "none";
    }
    if (!isDepartmentEmptySelection(type)) {
        document.getElementById('modal-type-select').style.border = "1px solid #ccc";
    }

    if (validateDepartmentInputForm(name, type)) {
        let department = {
            name: name,
            type: type
        }
        $.ajax({
            url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/departments/' + id,
            type: 'PUT',
            data: JSON.stringify(department),
            contentType: "application/json",
            success: function(data, textStatus, xhr) {
                showSuccessSnackBar("Success! Department updated.");
                hideAddAndUpdateDepartmentModal();
                refreshDepartmentList();
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }
}

function saveDepartment() {
    let id = document.getElementById("department-id").value;
    if (id == null || id == "") {
        addDepartment();
    } else {
        updateDepartment();
    }
}

// Init single variable for updating or deleting
let singleDepartmentId = 0;

function showDeleteSingleDepartmentModal(id) {
    $('#deleteSingleDepartmentModal').modal('show');
    getDepartmentById(id);
    document.getElementById('delete-single-department-id').value = id;
    singleDepartmentId = id;
}

function hideDeleteSingleDepartmentModal() {
    $('#deleteSingleDepartmentModal').modal('hide');
}

function deleteSingleDepartment() {
    const id = singleDepartmentId;
    $.ajax({
        url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/departments/' + id,
        type: 'DELETE',
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
        }
    });

    hideDeleteSingleDepartmentModal();
    showSuccessSnackBar("Success! Department deleted.");
    refreshDepartmentList();
}

function showDeleteMultipleDepartmentsModal() {
    $('#deleteMultipleDepartmentsModal').modal('show');
    getCheckedDepartment();
}

function hideDeleteMultipleDepartmentsModal() {
    $('#deleteMultipleDepartmentsModal').modal('hide');
}

let departmentIds = [];

function getCheckedDepartment() {
    let checkedBoxs = $(".department-checkbox input:checked");
    // console.log(typeof(checkedBoxs));
    // console.log(checkedBoxs);

    let departmentNos = [];
    checkedBoxs.each(function() {
        let checkboxValue = $(this).val();
        departmentNos.push(checkboxValue);
    });
    // console.log(departmentNos);

    //Reset delete confirm message
    document.getElementById('delete-departments-confirm-mess').innerHTML = "";

    if (departmentNos.length == 0 || departmentNos == null) {
        document.getElementById('delete-departments-confirm-mess').innerHTML = 'Choose at least one department to delete!';
        document.getElementById('delete-multiple-departments-btn').style.display = 'none';
    } else {
        if (departments.length > 0) {
            document.getElementById('delete-multiple-departments-btn').style.display = 'inline-block';
            departmentIds = [];
            departmentNos.forEach(departmentNo => {
                departments.forEach(department => {
                    if (department.no == departmentNo) {
                        departmentIds.push(department.id);
                    }
                });
            });
            // console.log(departmentIds);

            document.getElementById('delete-departments-confirm-mess').innerHTML = 'This action can not be undone. Delete these (<span style="color: red;">' + departmentIds.length + '</span>) departments?';

        }
    }
}

function deleteMultipleDepartments() {
    if (departmentIds != []) {
        for (let i = 0; i < departmentIds.length; i++) {
            const id = departmentIds[i];
            $.ajax({
                url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/departments/' + id,
                type: 'DELETE',
                success: function(result) {
                    if (result == undefined || result == null) {
                        alert("Error when loading data");
                        return;
                    }
                }
            });
            // console.log(id);
        }
    }

    let snackbarMessage = "";

    if (departmentIds.length == 1) {
        snackbarMessage = 'Success! Department deleted.';
    } else {
        snackbarMessage = 'Success! ' + departmentIds.length + ' departments deleted.';
    }

    hideDeleteMultipleDepartmentsModal();
    showSuccessSnackBar(snackbarMessage);
    refreshDepartmentList();
}

function showAddAccountsToDepartmentModal(id) {
    $('#addAccountsToDepartmentModal').modal('show');

    let department = null;

    // Set modal title
    departments.forEach(element => {
        if (element.id == id) {
            department = element;
            if (element.name.length < 15) {
                document.getElementById('addAccountToDepartment-modal-title').innerHTML = 'Add accounts into ' + element.name;
            } else {
                document.getElementById('addAccountToDepartment-modal-title').innerHTML = 'Add accounts into ' + element.name.slice(0, 14) + '...';
            }
        }
    });

    getAccountListForDepartmentModal(department);
}

function hideAddAccountsToDepartmentModal() {
    $('#addAccountsToDepartmentModal').modal('hide');
}


function getAccountListForDepartmentModal(department) {
    let modalAccountList = [];

    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        modalAccountList = data;
        fillAccountToModalTable(modalAccountList);
        getDepartmentAccounts(department, modalAccountList);
    });
}

function fillAccountToModalTable(modalAccountList) {

    resetSorting();

    // Reset table body
    $("#department-accounts-table tbody").empty();

    let modalAccountCount = 0;
    modalAccountList.forEach(function(item) {
        modalAccountCount++;
        item.no = modalAccountCount;
        $('#department-accounts-table tbody').append(
            '<tr><td><span class="department-accounts-checkbox"><input type="checkbox" id="modalCheckbox' + item.no + '" name="options[]" value="' + item.no + '"><label for="modalCheckbox' + item.no +
            '"></label></span></td><td>' + item.username +
            '</td><td>' + item.firstName + ' ' + item.lastName +
            '</td><td>' + item.role +
            '</td></tr>'
        )
    });
}

function getDepartmentAccounts(department, modalAccountList) {
    modalAccountList.forEach(function(item) {
        if (item.departmentName == department.name) {
            checkedBoxId = 'modalCheckbox' + item.no;
            $("#" + checkedBoxId).prop('checked', true);
        }
    });
}

function saveAccountToDepartment() {
    hideAddAccountsToDepartmentModal();
}

function resetSorting() {
    // Reset sorting
    $('#department-accounts-th-full-name a, #department-accounts-th-full-name i').css('color', '#000');
    $('#department-accounts-th-username a, #department-accounts-th-username i').css('color', '#000');

    document.getElementById('department-accounts-username_order').value = "asc";
    document.getElementById('department-accounts-fullName_order').value = "asc";

    $('#department-accounts-th-username .fa-sort').css('display', 'inline');
    $('#department-accounts-th-username .fa-sort-up').css('display', 'none');
    $('#department-accounts-th-username .fa-sort-down').css('display', 'none');

    $('#department-accounts-th-full-name .fa-sort').css('display', 'inline');
    $('#department-accounts-th-full-name .fa-sort-up').css('display', 'none');
    $('#department-accounts-th-full-name .fa-sort-down').css('display', 'none');
}