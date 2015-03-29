/**
 * puppy
 * 2015年3月23日 下午5:42:52
 * TODO
 */
package jdbc_tools_database_init;

public class PrepareDB {

	public static void main(String[] args) {

		InitDB.init();
		DataFileReader.importBasicData();
		DataFurtherDistributor.allDistribute();

		System.out.println("**************************************");
		System.out.println("Database fully prepared now! :p");
		System.out.println("**************************************");

	}

}
