package fasecoldaadmin

import java.util.HashMap;

class Version implements Serializable {

	String versionId
	String name
	String year
	List pictures
	List price
	static mapping = {
		table 'version'
		id generator: 'assigned', name: "versionId", type: 'string'
		id composite:["versionId","year"]
	}
	
	static belongsTo = BrandModel
	static hasMany = [pictures:Picture,price:Price]
}
