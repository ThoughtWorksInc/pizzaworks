
/*-------------- Dropdown functions --------------*/

/* When the user clicks on the button, toggle between hiding and showing the dropdown content */
function renderDropdown() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};


/*-------------- Pizza List functions --------------*/



function showVegetarianPizzas() {
    var pizzas = document.getElementById("vegetarian-pizzas");
    if (pizzas.style.display === 'none') {
        pizzas.style.display = 'block';
    }
    document.getElementById("all-pizzas").style.display = 'none';
    document.getElementById("vegan-pizzas").style.display = 'none';
}

function showVeganPizzas() {


    // new Hider().hide("vegan");
    //
    // new FilterHelper(hider).filterBy("vegan");

    //assert one li exists, and it's content is test2

    var pizzas = document.getElementById("vegan-pizzas");
    if (pizzas.style.display === 'none') {
        pizzas.style.display = 'block';
    }
    document.getElementById("all-pizzas").style.display = 'none';
    document.getElementById("vegetarian-pizzas").style.display = 'none';
}