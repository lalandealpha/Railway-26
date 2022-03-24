function viewAccountList() {
    $(".main").load("accountListView.html", function() {
        // Set up search account
        searchAccountByName();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Set filter department select
        setDepartmentSelectOptionForFilter();

        // Refresh account list
        refreshAccountList();
    });
}

function searchAccountByName() {
    $("#search-account-input").on("keyup", function(event) {
        let apiLink = "http://localhost:8080/api/v1/accounts?";
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            let name = $(this).val();
            if (name != "") {
                apiLink = apiLink + "&search=" + name;
            }
            let role = document.getElementById('filter-role-select').value;
            let departmentName = document.getElementById('filter-department-select').value;
            if (role != "" && departmentName == "") {
                apiLink = apiLink + "&role=" + role;
            } else if (role == "" && departmentName != "") {
                apiLink = apiLink + "&departmentName=" + departmentName;
            } else if (role != "" && departmentName != "") {
                apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
            }

            buildAccountTable(apiLink);
        }
    });
}

function setDepartmentSelectOptionForFilter() {
    let option = '<option value="" selected>Department</option>';
    $.get("http://localhost:8080/api/v1/departments", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let departments = data.content;
        departments.forEach(function(item) {
            option += '<option value="' + item.name + '">' + item.name + '</option>';
        });
        // console.log(departments);
        document.getElementById('filter-department-select').innerHTML = option;
    });
}

function filterAccount() {

    resetInputAndSortingValues();

    let apiLink = "http://localhost:8080/api/v1/accounts?";

    let role = document.getElementById('filter-role-select').value;
    let departmentName = document.getElementById('filter-department-select').value;
    if (role != "" && departmentName == "") {
        apiLink = apiLink + "&role=" + role;
    } else if (role == "" && departmentName != "") {
        apiLink = apiLink + "&departmentName=" + departmentName;
    } else if (role != "" && departmentName != "") {
        apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
    }

    buildAccountTable(apiLink);
}

function refreshAccountList() {
    // Reset page number
    accountPageNumber = 1;

    // Reset filter
    document.getElementById("filter-role-select").value = "";
    document.getElementById("filter-department-select").value = "";

    buildAccountTable("http://localhost:8080/api/v1/accounts");

    resetInputAndSortingValues();

}

function resetInputAndSortingValues() {
    // Reset search input
    document.getElementById("search-account-input").value = "";

    // Reset sorting
    document.getElementById("username_order").value = "asc";
    document.getElementById("fullName_order").value = "asc";
    document.getElementById("department_order").value = "asc";

    usernameSorted = false;
    fullNameSorted = false;
    departmentNameSorted = false;

    $(
        '#th-full-name .fa-sort-up, #th-full-name .fa-sort-down, ' +
        '#th-department .fa-sort-up, #th-department .fa-sort-down,' +
        '#th-username .fa-sort-up, #th-username .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-full-name .fa-sort, #th-department .fa-sort, #th-username .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#000');
}

let accounts = [];

function Account(id, username, password, firstName, lastName, role, departmentName) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.departmentName = departmentName;
}

function buildAccountTable(apiLink) {
    getAccountList(apiLink);
}

function getAccountList(apiLink) {
    $.get(apiLink, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        fillAccountToTable(data);
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function fillAccountToTable(data) {
    let accountCount = 0;
    accounts = data.content;

    // Reset table body
    $("#account-table tbody").empty();

    accounts.forEach(function(item) {
        accountCount++;
        item.no = accountCount;
        $('#account-table tbody').append(
            '<tr><td><span class="account-checkbox"><input type="checkbox" id="checkbox' + item.no + '" name="options[]" value="' + item.no + '"><label for="checkbox' + item.no +
            '"></label></span></td><td>' + item.username +
            '</td><td>' + item.firstName + ' ' + item.lastName +
            '</td><td>' + item.role +
            '</td><td>' + item.departmentName +
            '</td><td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showUpdateAccountModal(' + item.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleAccountModal(' + item.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td></tr>'
        )
    });

    // Set page infor
    setAccountPageInfo(data);

    // Select/Deselect checkboxes
    let accountCheckedBoxes = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function() {
        if (this.checked) {
            accountCheckedBoxes.each(function() {
                this.checked = true;
            });
        } else {
            accountCheckedBoxes.each(function() {
                this.checked = false;
            });
        }
    });
    accountCheckedBoxes.click(function() {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
}

function setAccountPageInfo(data) {
    let numberOfElements = data.numberOfElements;
    let pageNumber = data.pageable.pageNumber + 1;
    let totalPages = data.totalPages;
    let pageInfo = numberOfElements + " record(s) " + pageNumber + " of " + totalPages;
    document.getElementById("account-page-info").innerHTML = pageInfo;

    if (data.first == true) {
        document.getElementById("account-previousPage-btn").disabled = true;
        document.getElementById("account-nextPage-btn").disabled = false;
    }
    if (data.first == false && data.last == false) {
        document.getElementById("account-previousPage-btn").disabled = false;
        document.getElementById("account-nextPage-btn").disabled = false;
    }
    if (data.first == true && data.last == true) {
        document.getElementById("account-previousPage-btn").disabled = true;
        document.getElementById("account-nextPage-btn").disabled = true;
    }
    if (data.last == true) {
        document.getElementById("account-previousPage-btn").disabled = false;
        document.getElementById("account-nextPage-btn").disabled = true;
    }
}

let accountPageNumber = 1;

function getPreviousAccountPage() {
    accountPageNumber = accountPageNumber - 1;

    let apiLink = "http://localhost:8080/api/v1/accounts?page=" + accountPageNumber;

    if (usernameSorted == true) {
        let sort_order = $('#username_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=username,desc";
        } else {
            apiLink += "&sort=username,desc";
        }
    }

    if (fullNameSorted == true) {
        let sort_order = $('#fullName_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=fullName,desc";
        } else {
            apiLink += "&sort=fullName,desc";
        }
    }

    if (departmentNameSorted == true) {
        let sort_order = $('#department_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=departmentName,desc";
        } else {
            apiLink += "&sort=departmentName,desc";
        }
    }

    let name = $("#search-account-input").val();
    if (name != "") {
        apiLink = apiLink + "&search=" + name;
    }
    let role = document.getElementById('filter-role-select').value;
    let departmentName = document.getElementById('filter-department-select').value;
    if (role != "" && departmentName == "") {
        apiLink = apiLink + "&role=" + role;
    } else if (role == "" && departmentName != "") {
        apiLink = apiLink + "&departmentName=" + departmentName;
    } else if (role != "" && departmentName != "") {
        apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
    }

    buildAccountTable(apiLink);
}

function getNextAccountPage() {
    accountPageNumber = accountPageNumber + 1;

    let apiLink = "http://localhost:8080/api/v1/accounts?page=" + accountPageNumber;

    if (usernameSorted == true) {
        let sort_order = $('#username_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=username,desc";
        } else {
            apiLink += "&sort=username,desc";
        }
    }

    if (fullNameSorted == true) {
        let sort_order = $('#fullName_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=fullName,desc";
        } else {
            apiLink += "&sort=fullName,desc";
        }
    }

    if (departmentNameSorted == true) {
        let sort_order = $('#department_order').val();
        if (sort_order == "asc") {
            apiLink += "&sort=departmentName,desc";
        } else {
            apiLink += "&sort=departmentName,desc";
        }
    }

    let name = $("#search-account-input").val();
    if (name != "") {
        apiLink = apiLink + "&search=" + name;
    }
    let role = document.getElementById('filter-role-select').value;
    let departmentName = document.getElementById('filter-department-select').value;
    if (role != "" && departmentName == "") {
        apiLink = apiLink + "&role=" + role;
    } else if (role == "" && departmentName != "") {
        apiLink = apiLink + "&departmentName=" + departmentName;
    } else if (role != "" && departmentName != "") {
        apiLink = apiLink + "&role=" + role + "&departmentName=" + departmentName;
    }

    buildAccountTable(apiLink);
}


function showAddAndUpdateAcccountModal() {
    $('#addAndUpdateAcccountModal').modal('show');
}

function hideaddAndUpdateAcccountModal() {
    $('#addAndUpdateAcccountModal').modal('hide');
}

function showAddAccountModal() {

    console.log("Show Add");
    resetAccountForm();
    setDepartmentSelectOptionForModal();
    showAddAndUpdateAcccountModal();
    document.getElementById("account-id").value = "";
    document.getElementById("addAndUpdateAccount-modal-title").innerHTML = "Create New Account";

    // Disable Username, First name, Last name input
    $("#modal-username").prop('disabled', false);
    $("#modal-first-name").prop('disabled', false);
    $("#modal-last-name").prop('disabled', false);


}

function setDepartmentSelectOptionForModal(id) {
    let option = '<option value="PickADepartment" disabled selected>- Pick a department -</option>';
    $.get("http://localhost:8080/api/v1/departments", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let departments = data.content;
        departments.forEach(function(item) {
            option += '<option value="' + item.name + '">' + item.name + '</option>';
        });
        // console.log(departments);
        document.getElementById('modal-department-select').innerHTML = option;

        document.getElementById("account-id").value = id;
        accounts.forEach(element => {
            if (element.id == id) {
                document.getElementById("modal-department-select").value = element.departmentName;
            }
        });
    });
}

function addAccount() {
    let username = document.getElementById("modal-username").value;
    let firstName = document.getElementById("modal-first-name").value;
    let lastName = document.getElementById("modal-last-name").value;
    let role = document.getElementById("modal-role-select").value;
    if (role == "Admin") {
        role = "ADMIN";
    }
    if (role == "Employee") {
        role = "EMPLOYEE";
    }
    if (role == "Manager") {
        role == "MANAGER";
    }
    let departmentName = document.getElementById("modal-department-select").value;

    // Custom input box Css
    if (!isAccountEmptyInput(username)) {
        document.getElementById('modal-username').style.border = "none";
    }
    if (!isAccountEmptyInput(firstName)) {
        document.getElementById('modal-first-name').style.border = "none";
    }
    if (!isAccountEmptyInput(lastName)) {
        document.getElementById('modal-last-name').style.border = "none";
    }
    if (!isAccountEmptySelection(role)) {
        document.getElementById('modal-role-select').style.border = "1px solid #ccc";
    }
    if (!isAccountEmptySelection(departmentName)) {
        document.getElementById('modal-department-select').style.border = "1px solid #ccc";
    }

    if (validateAccountInputForm(username, firstName, lastName, role, departmentName)) {

        $.get("http://localhost:8080/api/v1/departments/name/" + departmentName, function(data, status) {
            if (status == "error") {
                alert("Error when loading data");
                return;
            }

            let account = {
                username: username,
                firstName: firstName,
                lastName: lastName,
                role: role,
                departmentId: data.id
            };

            $.ajax({
                url: 'http://localhost:8080/api/v1/accounts',
                type: 'POST',
                data: JSON.stringify(account), // body
                contentType: "application/json", // type of body (json, xml, text)
                success: function(data, textStatus, xhr) {
                    hideaddAndUpdateAcccountModal();
                    showSuccessSnackBar("Success! New account created!");
                    refreshAccountList();
                },
                error(jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            });
        });

    }
}

function validateAccountInputForm(username, firstName, lastName, role, departmentName) {
    // console.log('isEmtry ' + isAccountEmptyInput(username));
    // console.log('regex ' + isUsernameRegex(username));
    // console.log('exist ' + isAccountUsernameExist(username));
    // console.log(isAccountEmptySelection(departmentName));
    // console.log(isAccountEmptySelection(role))
    if (!(isAccountEmptyInput(username) || isAccountEmptyInput(firstName) || isAccountEmptyInput(lastName) || isAccountEmptySelection(role) || isAccountEmptySelection(departmentName))) {
        if (isUsernameRegex(username)) {
            if (isFirstNameAndLastNameRegex(firstName)) {
                if (isFirstNameAndLastNameRegex(lastName)) {
                    if (!isAccountUsernameExist(username)) {
                        return true;
                    } else {
                        document.getElementById('modal-input-errMess').innerHTML = "Username exists";
                        document.getElementById('modal-input-errMess').style.display = "block";
                        document.getElementById('modal-username').style.border = "1px solid red";
                        return false;
                    };
                } else {
                    document.getElementById('modal-input-errMess').innerHTML = "Last name cannot contain numbers or special characters";
                    document.getElementById('modal-input-errMess').style.display = "block";
                    document.getElementById('modal-last-name').style.border = "1px solid red";
                    return false;
                }
            } else {
                document.getElementById('modal-input-errMess').innerHTML = "First name cannot contain numbers or special characters";
                document.getElementById('modal-input-errMess').style.display = "block";
                document.getElementById('modal-first-name').style.border = "1px solid red";
                return false;
            }
        } else {
            document.getElementById('modal-input-errMess').innerHTML = "Username must be from 6 to 18 characters, contain no spaces and only allow special characters _-.";
            document.getElementById('modal-input-errMess').style.display = "block";
            document.getElementById('modal-username').style.border = "1px solid red";
            return false;
        }
    } else {
        document.getElementById('modal-input-errMess').innerHTML = "Please complete all fields";
        document.getElementById('modal-input-errMess').style.display = "block";
        if (isAccountEmptyInput(username)) {
            document.getElementById('modal-username').style.border = "1px solid red";
        }
        if (isAccountEmptyInput(firstName)) {
            document.getElementById('modal-first-name').style.border = "1px solid red";
        }
        if (isAccountEmptyInput(lastName)) {
            document.getElementById('modal-last-name').style.border = "1px solid red";
        }
        if (isAccountEmptySelection(role)) {
            document.getElementById('modal-role-select').style.border = "1px solid red";
        }
        if (isAccountEmptySelection(departmentName)) {
            document.getElementById('modal-department-select').style.border = "1px solid red";
        }
        return false;
    }
}

let isAccExists = false;

function isAccountUsernameExist(username) {
    console.log(1);
    $.get("http://localhost:8080/api/v1/accounts/username/" + username + "/exists", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
        }
        isAccExists = data;
    });
}

function isUsernameRegex(username) {
    let regex = new RegExp('^(?=.*[a-z])[a-zA-Z0-9_.-]{6,18}$');
    return regex.test(username);
}

function isFirstNameAndLastNameRegex(name) {
    let regex = new RegExp('^[a-zA-Z\\s]+$');
    return regex.test(name);
}

function isAccountEmptyInput(input) {
    if (input == "") {
        return true;
    }
    return false;
}

function isAccountEmptySelection(selection) {
    if (selection == "PickARole" || selection == "PickADepartment") {
        return true;
    }
    return false;
}

function resetAccountForm() {
    // Reset all input value
    document.getElementById("modal-username").value = "";
    document.getElementById("modal-first-name").value = "";
    document.getElementById("modal-last-name").value = "";
    document.getElementById("modal-role-select").value = "PickARole";
    document.getElementById("modal-department-select").value = "PickADepartment";

    // Reset all error message
    resetAccountModalErrMessage();
}

function resetAccountModalErrMessage() {
    document.getElementById('modal-input-errMess').style.display = "none";
    document.getElementById('modal-username').style.border = "none";
    document.getElementById('modal-first-name').style.border = "none";
    document.getElementById('modal-last-name').style.border = "none";
    document.getElementById('modal-role-select').style.border = "1px solid #ccc";
    document.getElementById('modal-department-select').style.border = "1px solid #ccc";
}

function showUpdateAccountModal(id) {

    console.log("Show Update");

    // Reset error message
    resetAccountModalErrMessage();

    // Show Modal
    showAddAndUpdateAcccountModal();

    // Disable Username, First name, Last name input
    $("#modal-username").prop('disabled', true);
    $("#modal-first-name").prop('disabled', true);
    $("#modal-last-name").prop('disabled', true);


    // Set department select option
    setDepartmentSelectOptionForModal(id);

    document.getElementById("account-id").value = id;

    accounts.forEach(element => {
        if (element.id == id) {
            document.getElementById("modal-username").value = element.username;
            document.getElementById("modal-first-name").value = element.firstName;
            document.getElementById("modal-last-name").value = element.lastName;
            document.getElementById("modal-role-select").value = element.role;

        }
    });

    document.getElementById("addAndUpdateAccount-modal-title").innerHTML = "Update Account";
}

function updateAccount() {
    let id = document.getElementById("account-id").value;
    console.log(id);

    let role = document.getElementById("modal-role-select").value;
    if (role == "Admin") {
        role = "ADMIN";
    }
    if (role == "Employee") {
        role = "EMPLOYEE";
    }
    if (role == "Manager") {
        role == "MANAGER";
    }
    let departmentName = document.getElementById("modal-department-select").value;

    accounts.forEach(account => {
        if (account.id == id && account.role == role && account.departmentName == departmentName) {
            showSuccessSnackBar("Success! Account updated.");
            hideaddAndUpdateAcccountModal();
            refreshAccountList();
        }
    })

    // if (!isAccountEmptySelection(role)) {
    //     document.getElementById('modal-role-select').style.border = "1px solid #ccc";
    // }
    // if (!isAccountEmptySelection(departmentName)) {
    //     document.getElementById('modal-department-select').style.border = "1px solid #ccc";
    // }

    $.get("http://localhost:8080/api/v1/departments/name/" + departmentName, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        let account = {
            role: role,
            departmentId: data.id
        }
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + id,
            type: 'PUT',
            data: JSON.stringify(account),
            contentType: "application/json",
            success: function(data, textStatus, xhr) {
                showSuccessSnackBar("Success! Account updated.");
                hideaddAndUpdateAcccountModal();
                refreshAccountList();
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    });



}

function saveAccount() {
    let id = document.getElementById("account-id").value;
    console.log(id);
    if (id == null || id == "" || id == "undefined") {
        addAccount();
    } else {
        updateAccount();
    }
}

function getAccountById(id) {
    $.get("http://localhost:8080/api/v1/accounts/" + id, function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let account = data;
        document.getElementById('delete-single-account-confirm-mess').innerHTML = 'This action can not be undone. Delete <span style="color:red;">' + account.firstName + ' ' + account.lastName + '</span>?';
    });
}

// Init single variable for updating or deleting
let singleAccountId = 0;

function showDeleteSingleAccountModal(id) {
    $('#deleteSingleAccountModal').modal('show');
    getAccountById(id);
    document.getElementById('delete-single-account-id').value = id;
    singleAccountId = id;
    console.log(singleAccountId);
}

function hideDeleteSingleAccountModal() {
    $('#deleteSingleAccountModal').modal('hide');
}

function deleteSingleAccount() {
    const id = singleAccountId;
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'DELETE',
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
            refreshAccountList();
        }
    });

    hideDeleteSingleAccountModal();
    showSuccessSnackBar("Success! Account deleted.");

}

function showDeleteMultipleAccountsModal() {
    $('#deleteMultipleAccountsModal').modal('show');
    getCheckedAccount();
}

function hideDeleteMultipleAccountsModal() {
    $('#deleteMultipleAccountsModal').modal('hide');
}

let accountIds = [];

function getCheckedAccount() {
    let checkedBoxs = $(".account-checkbox input:checked");
    // console.log(typeof(checkedBoxs));

    let accountNos = [];
    checkedBoxs.each(function() {
        let checkboxValue = $(this).val();
        accountNos.push(checkboxValue);
    });

    // console.log(accountNos);
    // console.log(accounts);

    //Reset delete confirm message
    document.getElementById('delete-accounts-confirm-mess').innerHTML = "";

    if (accountNos.length == 0 || accountNos == null) {
        document.getElementById('delete-accounts-confirm-mess').innerHTML = 'Choose at least one account to delete!';
        document.getElementById('delete-multiple-accounts-btn').style.display = 'none';
    } else {

        document.getElementById('delete-multiple-accounts-btn').style.display = 'inline-block';
        accountIds = [];
        accountNos.forEach(accountNo => {
            accounts.forEach(element => {
                if (element.no == accountNo) {
                    accountIds.push(element.id);
                }
            });
        });
        console.log(accountIds);

        document.getElementById('delete-accounts-confirm-mess').innerHTML = 'This action can not be undone. Delete <span id="user-fullName-delete-message"></span>?';
        for (let i = 0; i < accountIds.length; i++) {
            const id = accountIds[i];
            for (let j = 0; j < accounts.length; j++) {
                if (id == accounts[j].id) {
                    if (accountIds.length == 1) {
                        document.getElementById('user-fullName-delete-message').innerHTML += '<span style="color: red;">' + accounts[j].firstName + ' ' + accounts[j].lastName + '</span> (<span style="color: red;">1</span> account)';
                    } else {
                        if (i != (accountIds.length - 1)) {
                            document.getElementById('user-fullName-delete-message').innerHTML += '<span style="color: red;">' + accounts[j].firstName + ' ' + accounts[j].lastName + '</span>, ';
                        } else {
                            document.getElementById('user-fullName-delete-message').innerHTML += '<span style="color: red;">' + accounts[j].firstName + ' ' + accounts[j].lastName + '</span> (<span style="color: red;">' + accountIds.length + '</span> accounts)';
                        }
                    }
                };
            }
        }
    }
}

function deleteMultipleAccounts() {
    if (accountIds != []) {
        for (let i = 0; i < accountIds.length; i++) {
            const id = accountIds[i];
            $.ajax({
                url: 'http://localhost:8080/api/v1/accounts/' + id,
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

    if (accountIds.length == 1) {
        snackbarMessage = 'Success! Account deleted.';
    } else {
        snackbarMessage = 'Success! ' + accountIds.length + ' accounts deleted.';
    }

    hideDeleteMultipleAccountsModal();
    showSuccessSnackBar(snackbarMessage);
    refreshAccountList();
}