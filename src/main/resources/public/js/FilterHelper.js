console.log('I have loaded the filter helper');
FilterHelper = function () {
    return {
        showAllPizzas: function () {
            var pizzas = document.getElementById("all-pizzas");
            if (pizzas.style.display === 'none') {
                pizzas.style.display = 'block';
            }

            document.getElementById("vegetarian-pizzas").style.display = 'none';
            document.getElementById("vegan-pizzas").style.display = 'none';
        }
    }
};