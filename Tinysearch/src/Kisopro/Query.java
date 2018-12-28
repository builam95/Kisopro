package Kisopro;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Query{
	public static void main(String[] args) {
	  try {
		MongoClient mongoclient = new MongoClient("localhost",27017);
		DB db = mongoclient.getDB("Kisopro");
		System.out.println("MongoDB connect");
		
		DBCollection coll = db.getCollection("GetTitle");
		DBCursor cursor = coll.find();
		
		while(cursor.hasNext()) {
			int i=1;
			System.out.println(cursor.next());
			i++;
		}
      }catch (Exception e ) {
    	  System.out.println(e);
      }
    }
}