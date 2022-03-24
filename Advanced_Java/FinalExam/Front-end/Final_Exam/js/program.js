$(function() {

    $(".header").load("./common/header.html");
    $(".sidebar").load("./common/sidebar.html");
    // $(".main").load("./home/homePage.html");
    $(".footer").load("./common/footer.html");

    viewAccountPage();
});

function showSuccessSnackBar(snackbarMessage) {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");
    x.innerHTML = snackbarMessage;

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
}