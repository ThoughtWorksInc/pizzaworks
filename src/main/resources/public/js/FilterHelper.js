FilterHelper = function ($) {

    return {
        showAllPizzas: function () {
            $('#pizza-list li').show();
        },

        showVegetarianPizzas: function () {
            $('#pizza-list li.veggie-pizza').show();
            $('#pizza-list li').not('.veggie-pizza , .vegan-pizza').hide();

        },

        showVeganPizzas: function () {
            $('#pizza-list li.vegan-pizza').show();
            $('#pizza-list li').not('.vegan-pizza').hide();

        }
    }
};