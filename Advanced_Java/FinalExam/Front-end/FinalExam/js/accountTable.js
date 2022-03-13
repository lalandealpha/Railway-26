function sortByAccountUsername() {
    var sort_order = $('#username_order').val();
    if (sort_order == "asc") {
        document.getElementById("username_order").value = "desc";
        $('#th-username .fa-sort').css('display', 'none');
        $('#th-username .fa-sort-up').css('display', 'none');
        $('#th-username .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("username_order").value = "asc";
        $('#th-username .fa-sort').css('display', 'none');
        $('#th-username .fa-sort-up').css('display', 'inline');
        $('#th-username .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-full-name .fa-sort-up, #th-full-name .fa-sort-down, ' +
        '#th-department .fa-sort-up, #th-department .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-full-name .fa-sort, #th-department .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#fe6100');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#000');

}

function sortByAccountFullName() {
    var sort_order = $('#fullName_order').val();
    if (sort_order == "asc") {
        document.getElementById("fullName_order").value = "desc";
        $('#th-full-name .fa-sort').css('display', 'none');
        $('#th-full-name .fa-sort-up').css('display', 'none');
        $('#th-full-name .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("fullName_order").value = "asc";
        $('#th-full-name .fa-sort').css('display', 'none');
        $('#th-full-name .fa-sort-up').css('display', 'inline');
        $('#th-full-name .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-username .fa-sort-up, #th-username .fa-sort-down, ' +
        '#th-department .fa-sort-up, #th-department .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-username .fa-sort, #th-department .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#fe6100');
    $('#th-department a, #th-department i').css('color', '#000');

}

function sortByDepartment() {
    var sort_order = $('#department_order').val();
    if (sort_order == "asc") {
        document.getElementById("department_order").value = "desc";
        $('#th-department .fa-sort').css('display', 'none');
        $('#th-department .fa-sort-up').css('display', 'none');
        $('#th-department .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("department_order").value = "asc";
        $('#th-department .fa-sort').css('display', 'none');
        $('#th-department .fa-sort-up').css('display', 'inline');
        $('#th-department .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-username .fa-sort-up, #th-username .fa-sort-down, ' +
        '#th-full-name .fa-sort-up, #th-full-name .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-username .fa-sort, #th-full-name .fa-sort'
    ).css('display', 'inline');

    $('#th-username a, #th-username i').css('color', '#000');
    $('#th-full-name a, #th-full-name i').css('color', '#000');
    $('#th-department a, #th-department i').css('color', '#fe6100');

}