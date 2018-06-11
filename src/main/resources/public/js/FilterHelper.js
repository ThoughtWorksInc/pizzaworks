console.log('I have loaded the filter helper');


FilterHelper = function ($) {

    return {
        showAllPizzas: function () {
            $('li').show();
        },

        showVegetarianPizzas: function() {

            $('li').not('.veggie-pizza , .vegan-pizza').hide();

        },

        showVeganPizzas: function() {
            $('li').not('.vegan-pizza').hide();

        }

    }
};