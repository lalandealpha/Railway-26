$(function() {
    'use strict';

    $('.form-control').on('input', function() {
        var $field = $(this).closest('.form-group');
        if (this.value) {
            $field.addClass('field--not-empty');
        } else {
            $field.removeClass('field--not-empty');
        }
    });

});

let users = [];

function User(id, name, password) {
    this.id = id;
    this.name = name;
    this.password = password;
}

function getUserList() {
    $.get("https://61f9d3ca31f9c2001759658e.mockapi.io/users", function(data, status) {
        if (status == "error") {
            alert("Error when loading data");
            return;
        }
        users = [];
        parseData(data);
    });
}

function parseData(data) {
    data.forEach(element => {
        users.push(new User(element.id, element.name, element.password));
    });
}

function login() {
    let username = $('#username').val();
    let password = $('#password').val();
    getUserList();
    users.forEach(element => {
        if (username == "" || password == "" || username != element.username || password != element.password) {
            alert('Incorrect username or password. Please try again!')
        } else {
            window.location = 'http://127.0.0.1:5500/Frontend/crudGroup/html/program.html'
        }
    });
}