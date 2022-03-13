$(function() {
    $(".header").load("header.html");
    $(".sidebar").load("sidebar.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
    $(".toast").toast("hide");
});

function viewHomepage() {
    $(".main").load("home.html");
}

function viewGroupList() {
    $(".main").load("groupListView.html", function() {
        // Set up search Group
        $("#searchInput").on("keyup", function() {
            let value = $(this).val().toLowerCase();
            $("#table-body tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            })
        });
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
    buildTable();
}

function refreshGroupList() {
    buildTable();
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

let groups = [];

function getGroupList() {
    $.get("http://localhost:8080/api/v1/groups", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        groups = data;
        fillGroupToTable();
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();
    });
}

function fillGroupToTable() {
    let count = 0;
    groups.forEach(function(item) {
        count++;
        item.no = count;
        $('tbody').append(
            '<tr data-toggle="tooltip" title="Double click to edit" ondblclick="showDetailModal(' + item.id + ')"><td><span class="custom-checkbox"><input type="checkbox" id="checkbox' + item.no + '" name="options[]" value="' + item.no + '"><label for="checkbox' + item.no +
            '"></label></span></td><td>' + item.no +
            '</td><td>' + item.name +
            '</td><td>' + item.memberAmount +
            '</td><td>' + item.creator +
            '</td><td>' + item.createDate +
            '</td></tr>'
        )
    });

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

function buildTable() {
    $('tbody').empty();
    getGroupList();
}


function showAddAndUpdateModal() {
    $('#addAndUpdateModal').modal('show');
}

function hideAddAndUpdateModal() {
    $('#addAndUpdateModal').modal('hide');
}

function showAddGroupModal() {
    disableSaveBtn();
    resetForm();
    showAddAndUpdateModal();
    document.getElementById("id").value = "";
    document.getElementById("addAndUpdate-modal-title").innerHTML = "Create Group <i class='fas fa-users'></i>";
}

function addGroup() {
    let name = document.getElementById("name").value;

    let group = {
        name: name,
        memberAmount: 0,
        creator: "NAT",
        createDate: new Date()
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/groups',
        type: 'POST',
        data: JSON.stringify(group), // body
        contentType: "application/json", // type of body (json, xml, text)
        success: function(data, textStatus, xhr) {
            hideAddAndUpdateModal();
            showSuccessSnackBar();
            refreshGroupList();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

    // $.post("http://localhost:8080/api/v1/groups", {
    //     name: name,
    //     // member: 0,
    //     // creator: "NAT",
    //     // createDate: now
    // }, function(data, status) {
    //     if (status == "error") {
    //         alert("Error when loading data");
    //         return;
    //     }
    //     hideAddAndUpdateModal();
    //     showSuccessSnackBar();
    //     refreshGroupList();
    // });
}

function checkNameExist() {
    let name = document.getElementById("name").value;
    let errMess = document.getElementById("errMess");
    let saveBtn = document.getElementById("save-btn");
    if (isEmptyInput(name)) {
        errMess.style.display = "none";
        saveBtn.disabled = true;
    } else {
        if (isGroupNameExist(name)) {
            errMess.innerHTML = "Group name exists!";
            errMess.style.display = "block";
            saveBtn.disabled = true;
        } else {
            errMess.style.display = "none";
            saveBtn.disabled = false;
        }
    }
}

function isGroupNameExist(name) {
    for (let i = 0; i < groups.length; i++) {
        const element = groups[i];
        if (name == element.name) {
            return true;
        }
    }
    return false;
}

function isEmptyInput(input) {
    if (input == "") {
        return true;
    }
    return false;
}


function disableSaveBtn() {
    let saveBtn = document.getElementById("save-btn");
    saveBtn.disabled = true;
}

function resetForm() {
    let errMess = document.getElementById("errMess");
    errMess.style.display = "none";
    document.getElementById("name").value = "";
}

function showDeleteModal() {
    $('#deleteModal').modal('show');
}

function hideshowDeleteModalModal() {
    $('#deleteModal').modal('hide');
}

function getCheckedGroup() {
    let checkedBoxs = $(".custom-checkbox input:checked");
    // console.log(typeof(checkedBoxs));
    // console.log(checkedBoxs);

    let groupNos = [];
    checkedBoxs.each(function() {
        let checkboxValue = $(this).val();
        groupNos.push(checkboxValue);
    });

    deleteGroup(groupNos);
}

function deleteGroup(groupNos) {
    let groupIds = [];

    groupNos.forEach(groupNo => {
        groups.forEach(element => {
            if (element.no == groupNo) {
                groupIds.push(element.id);
            }
        });
    });
    console.log(groupIds)
    for (let i = 0; i < groupIds.length; i++) {
        const id = groupIds[i];
        $.ajax({
            url: 'http://localhost:8080/api/v1/groups/' + id,
            type: 'DELETE',
            success: function(result) {
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
            }
        });
        console.log(id);
    }
    hideshowDeleteModalModal();
    showSuccessSnackBar();
    setTimeout(() => {
        refreshGroupList();
    }, 1000);
}

function showDetailModal(id) {
    $('#detailModal').modal('show');
    let group;
    groups.forEach(element => {
        if (element.id == id) {
            group = element;
        }
    });
    document.getElementById("detail-name").innerHTML = group.name + '<a href="#" onclick="showUpdateModal(' + group.id + ')"><i class="fa-solid fa-pencil"></i></a>';
    document.getElementById("detail-creator").innerHTML = "Creator: " + group.creator;
    document.getElementById("detail-createDate").innerHTML = "Create Date: " + group.createDate;
    document.getElementById("detail-member").innerHTML = "Member: " + group.memberAmount;
}

function showUpdateModal(id) {
    $('#detailModal').modal('hide');
    showAddAndUpdateModal();
    document.getElementById("id").value = id;
    let name;
    groups.forEach(element => {
        if (element.id == id) {
            name = element.name;
        }
    });
    document.getElementById("name").value = name;
    document.getElementById("addAndUpdate-modal-title").innerHTML = "Edit Group name <i class='fas fa-users'></i>";
    disableSaveBtn();
}

function updateGroup() {
    let id = document.getElementById("id").value;
    let name = document.getElementById("name").value;

    let group = {
        name: name
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/groups/' + id,
        type: 'PUT',
        data: JSON.stringify(group),
        contentType: "application/json",
        success: function(data, textStatus, xhr) {
            showSuccessSnackBar();
            hideAddAndUpdateModal();
            refreshGroupList();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function save() {
    let id = document.getElementById("id").value;
    if (id == null || id == "") {
        addGroup();
    } else {
        updateGroup();
    }
}

function showSuccessSnackBar() {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
}

function convertDatetimeToDate(datimeInput) {
    let month = datimeInput.getMonth() + 1;
    let day = datimeInput.getDate();
    return datimeInput.getFullYear() + '/' + (month < 10 ? '0' : '') + month + '/' + (day < 10 ? '0' : '') + day;
}