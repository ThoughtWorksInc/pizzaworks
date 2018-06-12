package controllers;

import dal.OrderService;
import dal.PizzaService;
import model.Order;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.get;
import static spark.Spark.post;
import static util.TemplateHelper.renderTemplate;

public class ConfirmationController {


    private static OrderService orderService;
    private static PizzaService pizzaService;

    public static void initialize(OrderService orderService, PizzaService pizzaService) {
        ConfirmationController.orderService = orderService;
        ConfirmationController.pizzaService = pizzaService;
        post("/confirmation", ConfirmationController::saveOrder);
        get("/confirmation", ConfirmationController::renderConfirmationPage);
    }

    private static Object saveOrder(Request req, Response res) {
        String pizza_id = req.queryParams("pizza_id");
        String customer_name = req.queryParams("customer_name");
        String pizzaSlug = req.queryParams("pizza_slug");
        if(customer_name.equals("")){
            res.redirect("/checkout/" + pizzaSlug + "/notValid");
           return res;
        } else {
            Order order = orderService.createOrder(customer_name, pizza_id);
            res.redirect("/confirmation?" +
                    "pizza_id=" + order.getPizza_id() +
                    "&customerName=" + order.getCustomer_name() +
                    "&orderNumber=" + order.getOrder_number());
            return res;
        }
    }


    private static Object renderConfirmationPage(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String pizza_id = req.queryParams("pizza_id");
        String customer_name = req.queryParams("customerName");
        String orderNumber = req.queryParams("orderNumber");
        model.put("confirmedPizza", pizzaService.getPizzaFromOrder(UUID.fromString(pizza_id)).get());
        model.put("orderName", customer_name);
        model.put("orderNumber", orderNumber);
        return renderTemplate("velocity/confirmation.vm", model, req);
    }


}
