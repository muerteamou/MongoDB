import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class JavaMongo8 {

	public static void main(String[] args) {
		try {
			MongoClient mongo2 = new MongoClient("localhost", 27017);

			DB bbdd2 = mongo2.getDB("CatalogoPintura");
			DBCollection coll2 = bbdd2.getCollection("Pintores");

			//Añadimos nueva info
			BasicDBObject find = new BasicDBObject("Name", "Velázquez");
			BasicDBObject update = new BasicDBObject().append("$set",
					new BasicDBObject().append("Localidad", "Sevilla"));

			coll2.update(find, update, false, true);

			DBCursor cur2 = coll2.find();

			while (cur2.hasNext()) {
				System.out.println(cur2.next());
			}
			
			//Borramos la info
			BasicDBObject find2 = new BasicDBObject("Name", "Velázquez");
			BasicDBObject update2 = new BasicDBObject().append("$unset",
					new BasicDBObject().append("Localidad", "Sevilla"));

			coll2.update(find2, update2, false, true);
			

			DBCursor cur3 = coll2.find();
			while (cur3.hasNext()) {
				System.out.println(cur3.next());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
