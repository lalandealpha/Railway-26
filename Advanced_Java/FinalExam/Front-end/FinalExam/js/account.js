function viewAccountList() {
    $(".main").load("accountListView.html", function() {
        // Set up search account
        searchAccountByName();

        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Set filter department select
        setDepartmentSelectOptionForFilter();
    });
    // Reset variable for update and delete
    filterAccountSingleResult = null;


    // Build table
    buildAccountTable();
}

function searchAccountByName() {
    $("#search-account-input").on("keyup", function(event) {
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            let name = $(this).val();
            if (name == "") {
                buildAccountTable();
            } else {
                // Call API
                buildAccountTableByRole("role");
            }

        }
    });
}

function setDepartmentSelectOptionForFilter() {
    let option = '<option value="" selected>Department</option>';
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let departments = data;
        departments.forEach(function(item) {
            option += '<option value="' + item.name + '">' + item.name + '</option>';
        });
        // console.log(departments);
        document.getElementById('filter-department-select').innerHTML = option;
    });
}

function filterAccount() {
    let role = document.getElementById('filter-role-select').value;
    let departmentName = document.getElementById('filter-department-select').value;
    if (role == "" && departmentName == "") {
        buildAccountTable();
    } else if (role != "" && departmentName == "") {
        buildAccountTableByRole(role);
    } else if (role == "" && departmentName != "") {
        buildAccountTableByDepartmentName(departmentName);
    } else {
        buildAccountTableByRoleAndDepartmentName(role, departmentName);
    }
}

function refreshAccountList() {
    filterAccount();
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

function buildAccountTable() {
    $('tbody').empty();
    getAccountList();
}

function buildAccountTableByRole(role) {
    $('tbody').empty();
    getAccountListByRole(role);
}

function buildAccountTableByDepartmentName(departmentName) {
    $('tbody').empty();
    getAccountListByDepartmentName(departmentName);
}

function buildAccountTableByRoleAndDepartmentName(role, departmentName) {
    $('tbody').empty();
    getAccountListByRoleAndDepartmentName(role, departmentName)
}

let filterAccountSingleResult = null;

function getAccountList() {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        accounts = [];

        if (Array.isArray(data)) {
            accounts = data;
        } else {
            filterAccountSingleResult = data;
        }

        fillAccountToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getAccountListByRole(role) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/6", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        accounts = [];

        if (Array.isArray(data)) {
            accounts = data;
        } else {
            filterAccountSingleResult = data;
        }

        fillAccountToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getAccountListByDepartmentName(departmentName) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/4", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        accounts = [];

        if (Array.isArray(data)) {
            accounts = data;
        } else {
            filterAccountSingleResult = data;
        }

        fillAccountToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function getAccountListByRoleAndDepartmentName(role, departmentName) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/5", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        accounts = [];

        if (Array.isArray(data)) {
            accounts = data;
        } else {
            filterAccountSingleResult = data;
        }

        fillAccountToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function fillAccountToTable() {
    let accountCount = 0;
    if (accounts.length > 0) {
        accounts.forEach(function(item) {
            accountCount++;
            item.no = accountCount;
            $('tbody').append(
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

    } else {
        accountCount++;
        filterAccountSingleResult.no = accountCount;
        let account = filterAccountSingleResult;
        $('tbody').append(
            '<tr><td><span class="account-checkbox"><input type="checkbox" id="checkbox' + account.no + '" name="options[]" value="' + account.no + '"><label for="checkbox' + account.no +
            '"></label></span></td><td>' + account.username +
            '</td><td>' + account.firstName + ' ' + account.lastName +
            '</td><td>' + account.role +
            '</td><td>' + account.departmentName +
            '</td><td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showUpdateAccountModal(' + account.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Delete" onclick="showDeleteSingleAccountModal(' + account.id + ')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td></tr>'
        )
    }

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

function showAddAndUpdateAcccountModal() {
    $('#addAndUpdateAcccountModal').modal('show');
}

function hideaddAndUpdateAcccountModal() {
    $('#addAndUpdateAcccountModal').modal('hide');
}

function showAddAccountModal() {
    resetAccountForm();
    setDepartmentSelectOptionForModal();
    showAddAndUpdateAcccountModal();
    document.getElementById("account-id").value = "";
    document.getElementById("addAndUpdateAccount-modal-title").innerHTML = "Create New Account";

}

function setDepartmentSelectOptionForModal() {
    let option = '<option value="PickADepartment" disabled selected>- Pick a department -</option>';
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/departments", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        let departments = data;
        departments.forEach(function(item) {
            option += '<option value="' + item.name + '">' + item.name + '</option>';
        });
        // console.log(departments);
        document.getElementById('modal-department-select').innerHTML = option;
    });
}

function addAccount() {
    let username = document.getElementById("modal-username").value;
    let firstName = document.getElementById("modal-first-name").value;
    let lastName = document.getElementById("modal-last-name").value;
    let role = document.getElementById("modal-role-select").value;
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
        let account = {
            username: username,
            password: username + '0000',
            firstName: firstName,
            lastName: lastName,
            role: role,
            departmentName: departmentName
        };

        $.ajax({
            url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/accounts',
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
    }
}

function validateAccountInputForm(username, firstName, lastName, role, departmentName) {
    // console.log('isEmtry ' + isAccountEmptyInput(username));
    // console.log('regex ' + isUsernameRegex(username));
    // console.log('exist ' + isAccountUsernameExist(username));
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
                    document.getElementById('modal-input-errMess').innerHTML = "First name or last name cannot contain spaces, numbers or special characters";
                    document.getElementById('modal-input-errMess').style.display = "block";
                    document.getElementById('modal-last-name').style.border = "1px solid red";
                    return false;
                }
            } else {
                document.getElementById('modal-input-errMess').innerHTML = "First name or last name cannot contain spaces, numbers or special characters";
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

function isAccountUsernameExist(username) {
    // Call API
    return false;
}

function isUsernameRegex(username) {
    let regex = new RegExp('^(?=.*[a-z])[a-zA-Z0-9_.-]{6,18}$');
    return regex.test(username);
}

function isFirstNameAndLastNameRegex(name) {
    let regex = new RegExp('^[a-zA-Z]+$');
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
    // Reset error message
    resetAccountModalErrMessage();

    // Show Modal
    showAddAndUpdateAcccountModal();

    // Set department select option
    setDepartmentSelectOptionForModal();
    // setDepartmentSelectionOptionForUpdateModal(function() {

    document.getElementById("account-id").value = id;
    accounts.forEach(element => {
        if (element.id == id) {
            document.getElementById("modal-username").value = element.username;
            document.getElementById("modal-first-name").value = element.firstName;
            document.getElementById("modal-last-name").value = element.lastName;
            document.getElementById("modal-role-select").value = element.role;
            document.getElementById("modal-department-select").value = element.departmentName;
            // console.log(element.departmentName);
        }
    });
    // })
    document.getElementById("addAndUpdateAccount-modal-title").innerHTML = "Update Account";
}

function setDepartmentSelectionOptionForUpdateModal(callback) {
    setDepartmentSelectOptionForModal();
    callback();
}

function updateAccount() {
    let id = document.getElementById("account-id").value;
    let username = document.getElementById("modal-username").value;
    let firstName = document.getElementById("modal-first-name").value;
    let lastName = document.getElementById("modal-last-name").value;
    let role = document.getElementById("modal-role-select").value;
    let departmentName = document.getElementById("modal-department-select").value;

    accounts.forEach(account => {
        if (account.id == id && account.username == username && account.firstName == firstName &&
            account.lastName == lastName && account.role == role && account.departmentName == departmentName) {
            showSuccessSnackBar("Success! Account updated.");
            hideaddAndUpdateAcccountModal();
            refreshAccountList();
        }
    })

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
        let account = {
            username: username,
            firstName: firstName,
            lastName: lastName,
            role: role,
            departmentName: departmentName
        }
        $.ajax({
            url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/' + id,
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
    }
}

function saveAccount() {
    let id = document.getElementById("account-id").value;
    if (id == null || id == "") {
        addAccount();
    } else {
        updateAccount();
    }
}

function getAccountById(id) {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/" + id, function(data, status) {
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
}

function hideDeleteSingleAccountModal() {
    $('#deleteSingleAccountModal').modal('hide');
}

function deleteSingleAccount() {
    const id = singleAccountId;
    $.ajax({
        url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/' + id,
        type: 'DELETE',
        success: function(result) {
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
        }
    });

    hideDeleteSingleAccountModal();
    showSuccessSnackBar("Success! Account deleted.");
    refreshAccountList();
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

    console.log(accountNos);
    // console.log(accounts);

    //Reset delete confirm message
    document.getElementById('delete-accounts-confirm-mess').innerHTML = "";

    if (accountNos.length == 0 || accountNos == null) {
        document.getElementById('delete-accounts-confirm-mess').innerHTML = 'Choose at least one account to delete!';
        document.getElementById('delete-multiple-accounts-btn').style.display = 'none';
    } else {
        if (accounts.length > 0) {
            document.getElementById('delete-multiple-accounts-btn').style.display = 'inline-block';
            accountIds = [];
            accountNos.forEach(accountNo => {
                accounts.forEach(element => {
                    if (element.no == accountNo) {
                        accountIds.push(element.id);
                    }
                });
            });
            // console.log(accountIds);

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
        } else {
            document.getElementById('delete-multiple-accounts-btn').style.display = 'inline-block';
            document.getElementById('delete-accounts-confirm-mess').innerHTML = 'This action can not be undone. Delete <span id="user-fullName-delete-message" style="color: red;">' + filterAccountSingleResult.firstName + ' ' + filterAccountSingleResult.lastName + '</span>?';
        }
    }
}

function deleteMultipleAccounts() {
    if (accountIds != []) {
        for (let i = 0; i < accountIds.length; i++) {
            const id = accountIds[i];
            $.ajax({
                url: 'https://61f9d3ca31f9c2001759658e.mockapi.io/accounts/' + id,
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