function sortByName() {
    var sort_order = $('#name_order').val();
    if (sort_order == "asc") {
        document.getElementById("name_order").value = "desc";
        $('#th-name .fa-sort').css('display', 'none');
        $('#th-name .fa-sort-up').css('display', 'none');
        $('#th-name .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("name_order").value = "asc";
        $('#th-name .fa-sort').css('display', 'none');
        $('#th-name .fa-sort-up').css('display', 'inline');
        $('#th-name .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-totalMember .fa-sort-up, #th-totalMember .fa-sort-down, ' +
        '#th-createDate .fa-sort-up, #th-createDate .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-totalMember .fa-sort, #th-createDate .fa-sort'
    ).css('display', 'inline');

    $('#th-name a, #th-name i').css('color', '#fe6100');
    $('#th-totalMember a, #th-totalMember i').css('color', '#000');
    $('#th-createDate a, #th-createDate i').css('color', '#000');

}

function sortByTotalMember() {
    var sort_order = $('#totalMember_order').val();
    if (sort_order == "asc") {
        document.getElementById("totalMember_order").value = "desc";
        $('#th-totalMember .fa-sort').css('display', 'none');
        $('#th-totalMember .fa-sort-up').css('display', 'none');
        $('#th-totalMember .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("totalMember_order").value = "asc";
        $('#th-totalMember .fa-sort').css('display', 'none');
        $('#th-totalMember .fa-sort-up').css('display', 'inline');
        $('#th-totalMember .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-name .fa-sort-up, #th-name .fa-sort-down, ' +
        '#th-createDate .fa-sort-up, #th-createDate .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-name .fa-sort, #th-createDate .fa-sort'
    ).css('display', 'inline');

    $('#th-name a, #th-name i').css('color', '#000');
    $('#th-totalMember a, #th-totalMember i').css('color', '#fe6100');
    $('#th-createDate a, #th-createDate i').css('color', '#000');

}

function sortByCreateDate() {
    var sort_order = $('#createDate_order').val();
    if (sort_order == "asc") {
        document.getElementById("createDate_order").value = "desc";
        $('#th-createDate .fa-sort').css('display', 'none');
        $('#th-createDate .fa-sort-up').css('display', 'none');
        $('#th-createDate .fa-sort-down').css('display', 'inline');

        // Call API 
    }
    if (sort_order == "desc") {
        document.getElementById("createDate_order").value = "asc";
        $('#th-createDate .fa-sort').css('display', 'none');
        $('#th-createDate .fa-sort-up').css('display', 'inline');
        $('#th-createDate .fa-sort-down').css('display', 'none');

        // Call API
    }

    $(
        '#th-name .fa-sort-up, #th-name .fa-sort-down, ' +
        '#th-totalMember .fa-sort-up, #th-totalMember .fa-sort-down'
    ).css('display', 'none');

    $(
        '#th-name .fa-sort, #th-totalMember .fa-sort'
    ).css('display', 'inline');

    $('#th-name a, #th-name i').css('color', '#000');
    $('#th-totalMember a, #th-totalMember i').css('color', '#000');
    $('#th-createDate a, #th-createDate i').css('color', '#fe6100');

}