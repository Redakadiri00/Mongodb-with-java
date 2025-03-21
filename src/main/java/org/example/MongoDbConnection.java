package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

class MongoDbConnection {
    private static MongoDbConnection instance;
    private final MongoClient mongoClient;
    private static final String url = "mongodb://localhost:27017";

    private MongoDbConnection() {
        mongoClient = MongoClients.create(url);
    }

    public static synchronized MongoDbConnection getInstance() {
        if (instance == null) {
            instance = new MongoDbConnection();
        }
        return instance;
    }

    public MongoClient getConnexion() {
        return mongoClient;
    }
}