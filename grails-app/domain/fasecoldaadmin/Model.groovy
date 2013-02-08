package fasecoldaadmin

class Model {
	
	String category_id          
	String version 
	String external_id
	String name
	
	
	

    static constraints = {
		
		version nullable: true
		external_id nullable: true
		
		
		
    }
}
