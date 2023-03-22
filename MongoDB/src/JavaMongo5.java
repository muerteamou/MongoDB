import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class JavaMongo5 {

	public static void main(String[] args) {
		try {
			MongoClient mongo2 = new MongoClient("localhost", 27017);

			DB bbdd2 = mongo2.getDB("CatalogoPintura");
			DBCollection coll2 = bbdd2.getCollection("Pintores");
			QueryBuilder qry = QueryBuilder.start("Pais").greaterThan("Esp");
			BasicDBObject Velazquez = new BasicDBObject();
			
			BasicDBObject find = new BasicDBObject("Name", "Velázquez");
			BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("Pais", "Francia"));
			
			coll2.update(find, update);

			DBCursor cur2 = coll2.find(qry.get(), Velazquez);
			while (cur2.hasNext()) {
				System.out.println(cur2.next());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
