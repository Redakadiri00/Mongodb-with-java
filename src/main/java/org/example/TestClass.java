package org.example;


import org.bson.Document;

import java.awt.*;

public class TestClass {
    public static void main(String[] args) {
        Methodes methodes = new Methodes();
        Document doc = new Document("name", "Reda kadiri")
                .append("age", 29)
                .append("email", "waaareda@example.com")
                .append("address", new Document("street", "hhh")
                        .append("city", "hhh")
                        .append("postalCode", "12345"));
        //methodes.listDatabases();
        //methodes.listCollections("gi2");
        //methodes.CreateDatabase("newDatabase2222");
        //methodes.DeleteDatabase("newDatabase2222");
        //methodes.CreateCollection("Second_Collection_test" );
        methodes.ShowCollection("Second_Collection_test");
        //methodes.DeleteCollection("First_Collection_test");
        //methodes.addDocumentToCollection(doc,"Second_Collection_test");
        //methodes.ShowDocument_Of_Collection("John Doe", "Second_Collection_test");
        //methodes.deleteDocument("Second_Collection_test", "hahaha");
        //methodes.updateDocument("Second_Collection_test", "Reda kadiri", "NewReda@gmail.com");

        //methodes.countDocumentsInCollection("Second_Collection_test");

    }
}