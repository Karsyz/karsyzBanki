package com.banki.routes;

import org.json.JSONObject;

import static spark.Spark.get;
import static spark.Spark.post;

public class TestRoutes {

    public static void registerRoutes() {
        get("/test", (req, res) -> {
            res.type("application/json");
            return "{ \"message\": \"Server is running!\" }";
        });

        post("/test", (req, res) -> {
            res.type("application/json");

            String body = req.body();
            JSONObject json = new JSONObject(body);

            String name = json.optString("name", "Guest");

            JSONObject response = new JSONObject();
            response.put("message", "Hello " + name + "!" );           

            return response.toString();
        });
    }
}
