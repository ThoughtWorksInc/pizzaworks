describe("Player", function () {
    var FilterHelper = require('../../lib/src/FilterHelper');
    var Song = require('../../lib/jasmine_examples/Song');
    var jsdom = require('jsdom');
    var window = jsdom.jsdom().defaultView;
    // var $ = require('../../src/main/resources/public/js/vendor/jquery-3.3.1');
    var player;
    var song;

    describe("when song has been paused", function () {

        it("should indicate that the song is currently paused", function (done) {
            jsdom.jQueryify(window, "https://code.jquery.com/jquery-3.3.1.min.js", function () {
                window.$('body').append("<ul><li class='vegetarian'>veggie-pizza</li><li class='vegan'>test2</li></ul>");

                //Method Under Test
                new FilterHelper().something()

                expect(window.$('.vegetarian').text()).toEqual('veggie-pizza');

                done();
            });

        });

    });

});
