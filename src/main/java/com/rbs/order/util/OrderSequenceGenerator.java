package com.rbs.order.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class OrderSequenceGenerator {

	
	
	public static Object getNextSequence(String name) throws Exception{
		
		System.out.println("Connecting to Database");

	    MongoClient mongoClient = new MongoClient( new MongoClientURI( "mongodb://admin:admin@ds023432.mlab.com:23432/orders" ));
	    
	    // Now connect to your databases
	   /* DB db = mongoClient.getDB("orders");
	    DBCollection collection = db.getCollection("counters");
	    BasicDBObject searchQuery = new BasicDBObject("_id", name);
	    BasicDBObject increase = new BasicDBObject("seq", 1);
	    BasicDBObject updateQuery = new BasicDBObject("$inc", increase);
	    DBObject result = collection.findAndModify(searchQuery, null, null,
	            false, updateQuery, true, false);

	    return result.get("seq"); */
	    
	    
	    String sequence_collection = "seq"; // the name of the sequence collection
	    String sequence_field = "seq"; // the name of the field which holds the sequence

	    DB db = mongoClient.getDB("orders");
	    
	    DBCollection seq = db.getCollection(sequence_collection); // get the collection (this will create it if needed)

	    // this object represents your "query", its analogous to a WHERE clause in SQL
	    DBObject query = new BasicDBObject();
	    query.put("_id", name); // where _id = the input sequence name

	    // this object represents the "update" or the SET blah=blah in SQL
	    DBObject change = new BasicDBObject(sequence_field, 1);
	    DBObject update = new BasicDBObject("$inc", change); // the $inc here is a mongodb command for increment

	    // Atomically updates the sequence field and returns the value for you
	    DBObject res = seq.findAndModify(query, new BasicDBObject(), new BasicDBObject(), false, update, true, true);
	    return res.get(sequence_field).toString();
	}
	
	
	/*public static void main(String[] args) throws Exception {

	    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	    // Now connect to your databases
	    DB db = mongoClient.getDB("test");
	    DBCollection collection = db.getCollection("counters");
	    BasicDBObject document = new BasicDBObject();

	    document.put("_id", getNextSequence("userid"));
	    document.put("name","Sarah C.");
	    collection.insert(document); // insert first doc

	    document.put("_id", getNextSequence("userid"));
	    document.put("name", "Bob D.");
	    collection.insert(document); // insert second doc
	}
	*/
	
}
