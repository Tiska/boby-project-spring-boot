package persistence;

import com.cardiweb.generator.persistence.PersistenceGenerator;
import com.cardiweb.jdbcmetadata.Table;

import java.io.File;

public class BobiPersistenceGenerator extends PersistenceGenerator {

	@Override
	public boolean isDaoExtensible(Table t) {
		return true;
	}

	public boolean useTable(Table table) {
		return true;
	}

	//
	// @Override
	// public String toProperty(String name) {
	// if (name.toLowerCase().startsWith("jor_")) {
	// name = name.substring(4);
	// }
	// return super.toProperty(name);
	// }

	@Override
	public boolean generateBiz(Table table) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cardiweb.generator.persistence.PersistenceGenerator#useCache(com.
	 * cardiweb.jdbcmetadata.Table)
	 */
	@Override
	public boolean useCache(Table t) {
		return super.useCache(t);
	}

//	@Override
	public File getSrcRoot() throws Exception {
		File root = new File(PersistenceGenerator.class.getResource("/").getFile()).getParentFile().getParentFile();
		root = new File(root, "src/main/java");
		if (!root.exists() || !root.isDirectory()) {
			throw new Exception("Impossible de determiner ou generer les classes.");
		}

		return root;
	}

	public static void main(String[] args) throws Exception {

		BobiPersistenceGenerator generator = new BobiPersistenceGenerator();

		generator.setBasePackage("persistence.beans");
		generator.setGeneratorPackage("persistence");
		// generator.setDb("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/jordan", "postgres", "root");
		generator.setDb("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/boby-database", "tiska", "tiskabreaker");
		generator.generate();
	}


}
