require('../../src/main/resources/public/js/FilterHelper');
var jsdom = require('jsdom');
var window = jsdom.jsdom().defaultView;
//var test1 = window.$;

describe("Filter Pizza Tests", function () {

    var pizzaList =
        "<ul id=\"pizza-list\">\n" +
            "<li class=\"pizza row meaty-pizza\">\n" +
            "First-Mocked-Pizza</li>\n" +
            "<li class=\"pizza row veggie-pizza\">\n" +
            "Veggie-Mocked-Pizza</li>\n" +
            "<li class=\"pizza row vegan-pizza\">\n" +
            "Vegan-Mocked-Pizza</li>\n" +
        "</ul>";


    it("should show only vegetarian pizzas", function (done) {
        jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {

            try {

                window.$('body').html(pizzaList);

                new FilterHelper(window.$).showVegetarianPizzas();

                expect(window.$('.veggie-pizza').css("display")).toEqual('list-item');
                expect(window.$('.vegan-pizza').css("display")).toEqual('list-item');
                expect(window.$('.meaty-pizza').css("display")).toEqual('none');
            } catch (e) {
                fail('fail');
                done();
            }

            done();
        });

    });

    it("should show only vegan pizzas", function (done) {
        jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {
            try {
                window.$('body').html(pizzaList);

                new FilterHelper(window.$).showVeganPizzas();

                expect(window.$('.vegan-pizza').css("display")).toEqual('list-item');
                expect(window.$('.veggie-pizza').css("display")).toEqual('none');
                expect(window.$('.meaty-pizza').css("display")).toEqual('none');
            } catch (e) {
                fail('fail');
                done();
            }

            done();
        });

    });

    it("should show all pizzas", function (done) {
        jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {
            try {
                window.$('body').html(pizzaList);

                new FilterHelper(window.$).showAllPizzas();

                expect(window.$('.vegan-pizza').css("display")).toEqual('list-item');
                expect(window.$('.veggie-pizza').css("display")).toEqual('list-item');
                expect(window.$('.meaty-pizza').css("display")).toEqual('list-item');
            } catch (e) {
                fail('fail');
                done();
            }

            done();
        });

    });

    it("should show all vegetarian pizzas after vegan has been selected", function (done) {
        jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {
            try {
                window.$('body').html(pizzaList);

                new FilterHelper(window.$).showVeganPizzas();
                new FilterHelper(window.$).showVegetarianPizzas();

                expect(window.$('.vegan-pizza').css("display")).toEqual('list-item');
                expect(window.$('.veggie-pizza').css("display")).toEqual('list-item');
                expect(window.$('.meaty-pizza').css("display")).toEqual('none');
            } catch (e) {
                fail('fail');
                done();
            }

            done();
        });

    });


});
