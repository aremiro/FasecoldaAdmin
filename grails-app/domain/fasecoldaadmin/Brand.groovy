package fasecoldaadmin

import java.io.Serializable;
import java.util.List;



/**TABLA BRAND */
class Brand {

	String categoryId
	String name
	String version
	String external_id
	
	static constraints = {
		version nullable: true
		external_id nullable: true		
		}
	
	
   // boolean     isLeaf
    //String      parentCategory
	//String site_Id

	//static hasMany = [models: Model]
	//static belongsTo = Category

	//int compareTo(obj) {
		//name.compareTo(obj.name)
	//}
	
	
	//static mapping = {
		//table 'brand'
		//id generator: 'assigned', name: "categoryId", type: 'string'
	//}
}