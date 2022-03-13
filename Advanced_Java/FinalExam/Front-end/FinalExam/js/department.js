function viewDepartmentList() {
    $(".main").load("departmentListView.html", function() {
        // Set up search Department
        searchDepartmentByName();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Set filter date min max value
        setDateValueForFilter();
    });
    // Reset variable for update and delete
    filterDepartmentSingleResult = null;

    // Build table
    buildDepartmentTable();
}

function searchDepartmentByName() {
    $("#search-department-input").on("keyup", function(event) {
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            let name = $(this).val();
            if (name == "") {
                buildDepartmentTable();
            } else {
                // Call API
                console.log("get department")
            }

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
    let minDate = document.getElementById('filter-min-date-select').value;
    let maxDate = document.getElementById('filter-max-date-select').value;
    let type = document.getElementById('filter-type-select').value;
    if (maxDate == "") {
        maxDate = maxDate = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
    }
    if (minDate == "" && type == "") {
        buildDepartmentTableByMaxDate(maxDate);
    } else if (minDate != "" && type == "") {
        buildDepartmentTableByMinDateAndMaxDate(minDate, maxDate);
    } else if (minDate == "" && type != "") {
        buildDepartmentTableByMaxDateAndType(maxDate, type);
    } else {
        buildDepartmentTableByMinDateAndMaxDateAndType(minDate, maxDate, type);
    }
}

function refreshDepartmentList() {
    filterDepartment();
    $(
        '#th-number .fa-arrow-up-short-wide, #th-number .fa-arrow-down-short-wide, ' +
        '#th-name .fa-arrow-up-short-wide, #th-name .fa-arrow-down-short-wide, ' +
        '#th-member .fa-arrow-up-short-wide, #th-member .fa-arrow-down-short-wide, ' +
        '#th-creator .fa-arrow-up-short-wide, #th-creator .fa-arrow-down-short-wide, ' +
        '#th-createDate .fa-arrow-up-short-wide, #th-createDate .fa-arrow-down-short-wide'
    ).css('display', 'none');

    $('#th-number a, #th-number i').css('color', '#000');
    $('#th-name a, #th-name i').css('color', '#000');
    $('#th-member a, #th-member i').css('color', '#000');
    $('#th-creator a, #th-creator i').css('color', '#000');
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

function buildDepartmentTable() {
    $('tbody').empty();
    getDepartmentList();
}

function buildDepartmentTableByMaxDate(maxDate) {
    $('tbody').empty();
    getDepartmentListByMaxDate(maxDate);
}

function buildDepartmentTableByMinDateAndMaxDate(minDate, maxDate) {
    $('tbody').empty();
    getDepartmentListByByMinDateAndMaxDate(minDate, maxDate);
}

function buildDepartmentTableByMaxDateAndType(maxDate, type) {
    $('tbody').empty();
    getDepartmentListByMaxDateAndType(maxDate, type);
}

function buildDepartmentTableByMinDateAndMaxDateAndType(minDate, maxDate, type) {
    $('tbody').empty();
    getDepartmentListByMinDateAndMaxDateAndType(minDate, maxDate, type);
}

let filterDepartmentSingleResult = null;

function getDepartmentList() {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = [];

        if (Array.isArray(data)) {
            departments = data;
        } else {
            filterDepartmentSingleResult = data;
        }

        fillDepartmentToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getDepartmentListByMaxDate(maxDate) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments/2", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = [];

        if (Array.isArray(data)) {
            departments = data;
        } else {
            filterDepartmentSingleResult = data;
        }

        fillDepartmentToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getDepartmentListByByMinDateAndMaxDate(minDate, maxDate) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments/3", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = [];

        if (Array.isArray(data)) {
            departments = data;
        } else {
            filterDepartmentSingleResult = data;
        }

        fillDepartmentToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getDepartmentListByMaxDateAndType(maxDate, type) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments/4", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = [];

        if (Array.isArray(data)) {
            departments = data;
        } else {
            filterDepartmentSingleResult = data;
        }

        fillDepartmentToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getDepartmentListByMinDateAndMaxDateAndType(minDate, maxDate, type) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments/5", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        departments = [];

        if (Array.isArray(data)) {
            departments = data;
        } else {
            filterDepartmentSingleResult = data;
        }

        fillDepartmentToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function fillDepartmentToTable() {
    // console.log(departments);
    // console.log(filterDepartmentSingleResult);
    let departmentCount = 0;
    if (departments.length > 0) {
        departments.forEach(function(item) {
            departmentCount++;
            item.no = departmentCount;
            $('tbody').append(
                '<tr><td><span class="department-checkbox"><input type="checkbox" id="checkbox' + item.no + '" name="options[]" value="' + item.no + '"><label for="checkbox' + item.no +
                '"></label></span></td><td>' + item.name +
                '</td><td>' + item.totalMember +
                '</td><td>' + item.type +
                '</td><td>' + item.createDate.substring(0, 10) +
                '</td><td class="td-actions"> ' +
                '<a href="#" data-toggle="tooltip" title="Add accounts" onclick="showAddAccountToModal(' + item.id + ')"><i class="fa-solid fa-plus"></i></a>' +
                '<a href="#" data-toggle="tooltip" title="Edit" onclick="showUpdateDepartmentModal(' + item.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
                '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleDepartmentModal(' + item.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
                '</td></tr>'
            )
        });

    } else {
        departmentCount++;
        filterDepartmentSingleResult.no = departmentCount;
        let department = filterDepartmentSingleResult;
        $('tbody').append(
            '<tr><td><span class="department-checkbox"><input type="checkbox" id="checkbox' + department.no + '" name="options[]" value="' + department.no + '"><label for="checkbox' + department.no +
            '"></label></span></td><td>' + department.name +
            '</td><td>' + department.totalMember +
            '</td><td>' + department.type +
            '</td><td>' + department.createDate +
            '</td><td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Add Department" onclick="showAddDepartmentModal()"><i class="fa-solid fa-plus"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showAddDepartmentModal()"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleDepartmentModal(' + department.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td></tr>'
        )
    }

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
    $('#deleteSingleDeparmentModal').modal('show');
    getDepartmentById(id);
    document.getElementById('delete-single-department-id').value = id;
    singleDepartmentId = id;
}

function hideDeleteSingleDepartmentModal() {
    $('#deleteSingleDeparmentModal').modal('hide');
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

            // document.getElementById('delete-departments-confirm-mess').innerHTML = 'This action can not be undone. Delete <span id="department-name-delete-message"></span>?';
            // for (let i = 0; i < departmentIds.length; i++) {
            //     const id = departmentIds[i];
            //     for (let j = 0; j < departments.length; j++) {
            //         if (id == departments[j].id) {
            //             if (i != (departmentIds.length - 1)) {
            //                 document.getElementById('department-name-delete-message').innerHTML += '<span style="color: red;">' + departments[j].name + '</span>, ';
            //             } else {
            //                 document.getElementById('department-name-delete-message').innerHTML += '<span style="color: red;">' + departments[j].name + '</span>';
            //             }
            //         };
            //     }
            // }
        } else {
            document.getElementById('delete-multiple-departments-btn').style.display = 'inline-block';
            document.getElementById('delete-departments-confirm-mess').innerHTML = 'This action can not be undone. Delete <span id="department-name-delete-message" style="color: red;">' + filterDepartmentSingleResult.name + '</span>?';
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

// function deleteDepartment(departmentNos) {
//     let departmentIds = [];

//     departmentNos.forEach(departmentNos => {
//         departmentNos.forEach(element => {
//             if (element.no == departmentNos) {
//                 departmentNos.push(element.id);
//             }
//         });
//     });
//     console.log(departmentIds)
//     for (let i = 0; i < departmentIds.length; i++) {
//         const id = departmentIds[i];
//         $.ajax({
//             url: 'http://localhost:8080/api/v1/groups/' + id,
//             type: 'DELETE',
//             success: function(result) {
//                 if (result == undefined || result == null) {
//                     alert("Error when loading data");
//                     return;
//                 }
//             }
//         });
//         console.log(id);
//     }
//     hideshowDeleteModalModal();
//     showSuccessSnackBar();
//     setTimeout(() => {
//         refreshDepartmentList();
//     }, 1000);
// }