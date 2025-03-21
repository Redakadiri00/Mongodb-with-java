package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;
import java.util.List;

public class Methodes {
    private MongoDbConnection ConnectionInstance;


    public Methodes() {


        this.ConnectionInstance = MongoDbConnection.getInstance();
    }

    public void listDatabases() {
        for (String dbName : ConnectionInstance.getConnexion().listDatabaseNames()) {
            System.out.println("Base de donnees: " + dbName);
        }
    }



    public void CreateDatabase(String dbname){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase(dbname);
        database.createCollection("Default_Collection");
        System.out.println("The new database created is: " + dbname  );
    }

    public void DeleteDatabase(String dbName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase(dbName);
        database.drop();
        System.out.println("The database deleted is: " + dbName  );
    }

    public void listCollections(String dbName) {
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase(dbName);
        System.out.println("Collections dans la base de données '" + dbName + "' :");
        for (String collectionName : database.listCollectionNames()) {
            System.out.println("- " + collectionName);
        }
    }

    public void CreateCollection(String Collection ){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        database.createCollection(Collection);
        System.out.println("the collection Created is: "+ Collection );
    }

    public FindIterable<Document> ShowCollection(String CollectionName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(CollectionName)   ;
        FindIterable<Document> documents_de_collection = collection.find();
        Iterator<Document> it = documents_de_collection.iterator();
        System.out.println("The Collection selected is: " + CollectionName);
        while (it.hasNext()) {
            System.out.println(it.next().toJson());  //on peut enlever json
        }
        return documents_de_collection;
    }

    public void DeleteCollection(String CollectionName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(CollectionName)   ;

        try {
            if(Collection_Exist(CollectionName)){
                collection.drop();
                System.out.println("The collection '" + CollectionName + "' has been deleted.");
            }else{
                System.err.println("Error: The collection '" + CollectionName + "' does not exist.");
            }
        } catch (RuntimeException e) {
            System.err.println("Error deleting collection '" + CollectionName + "': " + e.getMessage());
        }
    }

    public void addDocumentToCollection(Document document, String CollectionName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(CollectionName);

        try{
            collection.insertOne(document);
            System.out.println("The document has been added to the collection '" + CollectionName + "'.");
        }catch (RuntimeException e){
            System.err.println("Error adding document to collection '" + CollectionName + "': " + e.getMessage());
        }

    }

    public void ShowDocument_Of_Collection(String DocName, String CollectionName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(CollectionName);

        Document filter = new Document("name", DocName);
        Document document = collection.find(filter).first();  // .first() renvoie le premier résultat ou null
        if (document != null) {
            // Afficher le document trouvé
            System.out.println("Document trouvé : " + document.toJson());
        } else {
            System.out.println("Aucun document trouvé avec le nom '" + DocName + "'.");
        }

    }

    public  void deleteDocument(String collectionName, String name) {
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document filter = new Document("fruit", name);
        try {
            collection.deleteOne(filter);
            System.out.println("Le document avec le nom '" + name + "' a été supprimé.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du document : " + e.getMessage());
        }
    }


    public void updateDocument(String collectionName, String name, String newEmail) {
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(collectionName);

        // Filtrer le document par nom
        Document filter = new Document("name", name);

        // Mettre à jour le champ "email" du document trouvé
        Document update = new Document("$set", new Document("email", newEmail));

        try {
            // Mettre à jour le premier document qui correspond au filtre
            collection.updateOne(filter, update);

            System.out.println("Le document avec le nom '" + name + "' a été mis à jour avec le nouvel email : " + newEmail);
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du document : " + e.getMessage());
        }
    }



    public Boolean Collection_Exist(String CollectionName){
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        for (String name : database.listCollectionNames()) {
            if (name.equals(CollectionName)) {
                return true;
            }
        }
        return false;
    }

    public long countDocumentsInCollection(String collectionName) {
        MongoDatabase database = ConnectionInstance.getConnexion().getDatabase("NewDatabase");
        MongoCollection<Document> collection = database.getCollection(collectionName);

        long count = collection.countDocuments();
        System.out.println("La collection '" + collectionName + "' contient " + count + " documents.");
        return count;
    }




}