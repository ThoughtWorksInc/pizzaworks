require('../../src/main/resources/public/js/FilterHelper');
var jsdom = require('jsdom');
var window = jsdom.jsdom().defaultView;

describe("Filter Pizza Tests", function () {


    it("should show only vegetarian pizzas", function (done) {
        jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {
            try {

                window.$('body').append(
                    "<ul id=\"pizza-list\">\n" +
                    "<li class=\"pizza row all-pizza\">\n" +
                    "First-Mocked-Pizza</li>\n" +
                    "<li class=\"pizza row veggie-pizza\">\n" +
                    "Veggie-Mocked-Pizza</li>\n" +
                    "<li class=\"pizza row vegan-pizza\">\n" +
                    "Vegan-Mocked-Pizza</li>\n" +
                    "</ul>")

                new FilterHelper(window.$).showVegetarianPizzas();

                expect(window.$('.veggie-pizza').css("display")).toEqual('list-item');
                expect(window.$('.vegan-pizza').css("display")).toEqual('none');
                expect(window.$('.all-pizza').css("display")).toEqual('none');
            } catch (e) {
                console.log(e);
                fail('fail');
                done();
            }

            done();
        });

    });


});
