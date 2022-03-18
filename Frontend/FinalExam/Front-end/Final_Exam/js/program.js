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

function showSuccessSnackBar(snackbarMessage) {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");
    x.innerHTML = snackbarMessage;

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
}