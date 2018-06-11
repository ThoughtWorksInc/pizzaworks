
document.addEventListener('DOMContentLoaded',function() {
    document.querySelector('select[name="pizza-options"]').onchange=changeEventHandler;
},false);

function changeEventHandler(event) {
    // You can use “this” to refer to the selected element.
    if(event.target.value == 'all-pizzas') new FilterHelper($).showAllPizzas();
    if(event.target.value == 'veggie-pizzas') new FilterHelper($).showVegetarianPizzas();
    if(event.target.value == 'vegan-pizzas') new FilterHelper($).showVeganPizzas();

}