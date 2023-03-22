import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class JavaMongo3 {

	public static void main(String[] args) {

		try {
			MongoClient mongo3 = new MongoClient("localhost", 27017);

			DB bbdd3 = mongo3.getDB("CatalogoPintura");
			DBCollection coll3 = bbdd3.getCollection("Pintores");

			BasicDBObject r3 = new BasicDBObject("Name", "Kandinsky");

			BasicDBObject d1 = new BasicDBObject("Name", "Chuck Close").append("Pais", "EEUU").append("Edad", 83);
			BasicDBObject d2 = new BasicDBObject("Name", "Damien Hirst").append("Pais", "Inglaterra").append("Edad",
					58);
			
			coll3.insert(d1);
			coll3.insert(d2);

			
			
			coll3.remove(r3);
			System.out.println("Pintores tras eliminar a Kandisnky");
			DBCursor cur3 = coll3.find();
			while (cur3.hasNext()) {
				System.out.println(cur3.next());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
