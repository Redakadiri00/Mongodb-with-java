# MongoDB with Java

This mini-project demonstrates how to establish a connection between a Java application and a MongoDB database using the MongoDB Java driver. It also includes some implemented methods for interacting with the database.

## Prerequisites

Before running the project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- MongoDB installed and running
- Maven (if using a Maven project) or manually add dependencies

## Setting Up the Project

### Step 1: Add MongoDB Driver Dependency

If you are using **Maven**, add the following dependency to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver-sync</artifactId>
        <version>4.8.0</version>
    </dependency>
</dependencies>
```

If you are using **Gradle**, add this to your `build.gradle`:

```gradle
dependencies {
    implementation 'org.mongodb:mongodb-driver-sync:4.8.0'
}
```

## Implemented Methods

This project includes some basic database operations such as:
- **Insert Data**
- **Retrieve Data**
- **Update Documents**
- **Delete Documents**

## Running the Project

1. Ensure MongoDB is running locally or provide the correct connection URI.
2. Compile and run the Java files using your preferred IDE or via terminal.
3. Use the provided methods to interact with the database.

## Author
Created by **Redakadiri00**

## License
This project is open-source and available for use under the MIT License.
