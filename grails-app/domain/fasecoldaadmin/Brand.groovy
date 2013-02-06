package fasecoldaadmin

import java.util.List;

class Brand implements Comparable{

	String categoryId
	String name
     boolean     isLeaf
    String      parentCategory
	String site_Id

	//static hasMany = [models: Model]
	static belongsTo = Category

	int compareTo(obj) {
		name.compareTo(obj.name)
	}
	
	
	static mapping = {
		table 'brand'
		id generator: 'assigned', name: "categoryId", type: 'string'
	}
}