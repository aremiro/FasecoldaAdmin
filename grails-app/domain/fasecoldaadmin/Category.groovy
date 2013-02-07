package fasecoldaadmin

class Category {
	
	String category_id
	String version
	String name 
	
	static constraints = {
		version nullable: true
			
		}
}
