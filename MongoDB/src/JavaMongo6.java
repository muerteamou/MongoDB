import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class JavaMongo6 {

	public static void main(String[] args) {

		try {
			MongoClient mongo2 = new MongoClient("localhost", 27017);

			DB bbdd2 = mongo2.getDB("mibasededatos");
			DBCollection coll2 = bbdd2.getCollection("empleados");

			QueryBuilder qry = QueryBuilder.start("dep").is(10);

			BasicDBObject busqueda = new BasicDBObject();

			DBCursor cur2 = coll2.find(qry.get(), busqueda);

			while (cur2.hasNext()) {
				System.out.println(cur2.next());
			}
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");
			QueryBuilder qry2 = QueryBuilder.start("dep").in(new int[] { 10, 20 });

			BasicDBObject busqueda1 = new BasicDBObject();
			DBCursor cur3 = coll2.find(qry2.get(), busqueda1);

			while (cur3.hasNext()) {
				System.out.println(cur3.next());
			}
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------");

			QueryBuilder qry3 = QueryBuilder.start("salario").greaterThan(1300).and("oficio").is("Profesora");
			
			
			
			DBCursor cur4 = coll2.find(qry3.get(), busqueda1);
			
			while (cur4.hasNext()) {
				System.out.println(cur4.next());
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
