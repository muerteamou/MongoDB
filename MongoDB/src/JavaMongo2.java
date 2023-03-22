import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class JavaMongo2 {

	public static void main(String[] args) {

		MongoClient mongo2;
		try {
			mongo2 = new MongoClient("localhost", 27017);

			DB bbdd2 = mongo2.getDB("CatalogoPintura");

			DBCollection coll2 = bbdd2.getCollection("Pintores");

			DBCursor cur2 = coll2.find();
			while (cur2.hasNext()) {
				System.out.println(cur2.next());
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
