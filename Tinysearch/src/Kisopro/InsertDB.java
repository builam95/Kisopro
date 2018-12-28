package Kisopro;

import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

  public class InsertDB {
  public static void main(String[] args) {

    try {

	/**** Connect to MongoDB ****/
	// Since 2.10.0, uses MongoClient
	MongoClient mongo = new MongoClient("localhost", 27017);

	/**** Get database ****/
	// if database doesn't exists, MongoDB will create it for you
	DB db = mongo.getDB("Kisopro");

	/**** Get collection / table from 'testdb' ****/
	// if collection doesn't exists, MongoDB will create it for you
	DBCollection table = db.getCollection("GetTitle");


	/**** Find and display ****/
	BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.put("Description", "東京電機大学");

	DBCursor cursor = table.find(searchQuery);

	while (cursor.hasNext()) {
		System.out.println(cursor.next());
	}

	
	/**** Find and display ****/
	BasicDBObject searchQuery2 
	    = new BasicDBObject().append("Description", "東京電機大学");

	DBCursor cursor2 = table.find(searchQuery2);

	while (cursor2.hasNext()) {
		System.out.println(cursor2.next());
	}

	/**** Done ****/
	System.out.println("Done");

    } catch (MongoException e) {
	e.printStackTrace();
    }

  }	
  }