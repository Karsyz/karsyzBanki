package com.banki;

import com.banki.db.InitializeDb;
import com.banki.routes.CardRoutes;
import com.banki.routes.DeckRoutes;
import com.banki.routes.TestRoutes;
import com.banki.routes.UserRoutes;

import static spark.Spark.before;
import static spark.Spark.ipAddress;
import static spark.Spark.port;

public class Server {
    public static void main(String[] args) {
        // Set server port
        ipAddress("0.0.0.0");
        port(3000);

        // Initialize SQLite DB and tables
        InitializeDb.initialize();

        // Register API routes
        UserRoutes.registerRoutes();
        DeckRoutes.registerRoutes();
        CardRoutes.registerRoutes();
        TestRoutes.registerRoutes();

        // Optional: global before filters (middleware)
        before((req, res) -> {
            res.type("application/json"); // all responses JSON
        });

        System.out.println("Banki backend running on http://localhost:3000");
    }
}
