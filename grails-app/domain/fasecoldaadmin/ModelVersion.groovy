package fasecoldaadmin


/**TABLA model_version */
class ModelVersion {
	
	String model_versions_id 
	String version_version_id
	String version_year
	String versions_idx
	
	
	static constraints = {	
		version_version_id nullable: true
		version_year nullable: true
		versions_idx nullable: true
		}
	
	
}
