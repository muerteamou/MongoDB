import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class JavaMongo1 {

	public static void main(String[] args) {

		try {
			MongoClient mongo1 = new MongoClient("localhost", 27017);
			DB bbdd1 = mongo1.getDB("CatalogoPintura");

			DBCollection coll1 = bbdd1.createCollection("Pintores", null);

			// Insertar data en la collection
			BasicDBObject d1 = new BasicDBObject("Name", "Kandinsky").append("Pais", "Rusia");
			BasicDBObject d2 = new BasicDBObject("Name", "Velázquez").append("Pais", "España");
			BasicDBObject d3 = new BasicDBObject("Name", "Kahlo").append("Pais", "México");

			coll1.remove(d1);
			coll1.remove(d2);
			coll1.remove(d3);
			coll1.insert(d1);
			coll1.insert(d2);
			coll1.insert(d3);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
