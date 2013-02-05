package fasecoldaadmin

import java.util.List;

class Model {

	String categoryId
	String name
	int externalId
	List versions


	static hasMany = [versions: Version]
	static belongsTo = Brand

	int compareTo(obj) {
		name.compareTo(obj.name)
	}
	
	static mapping = {
		table 'model'
		id generator: 'assigned', name: "categoryId", type: 'string'
	}
}
