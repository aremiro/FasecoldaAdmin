package fasecoldaadmin

class ImportarController {

    def index = {

		redirect(action: "list", params: params)

    }
	

	
	
	def loadData={
		
		
		//"/Users/nicolasmoraes/Desktop/Autoplaza/GuiaPrueba.csv"
		File reader = new File("/Users/nicolasmoraes/Desktop/Autoplaza/GuiaPrueba.csv")
		
		boolean primeraIteracion= true
		
		reader.splitEachLine(',') { line ->
			String[] fields = line;
			
			FilaCSV importar = new FilaCSV();
			
			importar.Novedad =line[0].encodeAsComillas()
			importar.Marca =line[1].encodeAsComillas()
			importar.Clase=line[2].encodeAsComillas()
			importar.Codigo=line[3].encodeAsComillas()
			importar.HomologoCodigo=line[4].encodeAsComillas()
			importar.Referencia1=line[5].encodeAsComillas()
			importar.Referencia2=line[6].encodeAsComillas()
			importar.Referencia3=line[7].encodeAsComillas()
			importar.Peso=line[8].encodeAsComillas()
			importar.IdServicio=line[9].encodeAsComillas()
			importar.Servicio=line[10].encodeAsComillas()
			importar._1970=line[11].encodeAsComillas()
			importar._1971=line[12].encodeAsComillas()
			importar._1972=line[13].encodeAsComillas()
			importar._1973=line[14].encodeAsComillas()
			importar._1974=line[15].encodeAsComillas()
			importar._1975=line[16].encodeAsComillas()
			importar._1976=line[17].encodeAsComillas()
			importar._1977=line[18].encodeAsComillas()
			importar._1978=line[19].encodeAsComillas()
			importar._1979=line[20].encodeAsComillas()
			importar._1980=line[21].encodeAsComillas()
			importar._1981=line[22].encodeAsComillas()
			importar._1982=line[23].encodeAsComillas()
			importar._1983=line[24].encodeAsComillas()
			importar._1984=line[25].encodeAsComillas()
			importar._1985=line[26].encodeAsComillas()
			importar._1986=line[27].encodeAsComillas()
			importar._1987=line[28].encodeAsComillas()
			importar._1988=line[29].encodeAsComillas()
			importar._1989=line[30].encodeAsComillas()
			importar._1990=line[31].encodeAsComillas()
			importar._1991=line[32].encodeAsComillas()
			importar._1992=line[33].encodeAsComillas()
			importar._1993=line[34].encodeAsComillas()
			importar._1994=line[34].encodeAsComillas()
			importar._1995=line[36].encodeAsComillas()
			importar._1996=line[37].encodeAsComillas()
			importar._1997=line[38].encodeAsComillas()
			importar._1998=line[39].encodeAsComillas()
			importar._1999=line[40].encodeAsComillas()
			importar._2000=line[41].encodeAsComillas()
			importar._2001=line[42].encodeAsComillas()
			importar._2002=line[43].encodeAsComillas()
			importar._2003=line[44].encodeAsComillas()
			importar._2004=line[45].encodeAsComillas()
			importar._2005=line[46].encodeAsComillas()
			importar._2006=line[47].encodeAsComillas()
			importar._2007=line[48].encodeAsComillas()
			importar._2008=line[49].encodeAsComillas()
			importar._2009=line[50].encodeAsComillas()
			importar._2010=line[51].encodeAsComillas()
			importar._2011=line[52].encodeAsComillas()
			importar._2012=line[53].encodeAsComillas()
			importar._2013=line[54].encodeAsComillas()
			importar.Bcpp=line[55].encodeAsComillas()
			importar.Importado=line[56].encodeAsComillas()
			importar.Potencia=line[57].encodeAsComillas()
			importar.TipoCaja=line[58].encodeAsComillas()
			importar.Cilindraje=line[59].encodeAsComillas()
			importar.Nacionalidad=line[60].encodeAsComillas()
			importar.CapacidadPasajeros=line[61].encodeAsComillas()
			importar.CapacidadCarga=line[62].encodeAsComillas()
			importar.Puertas=line[63].encodeAsComillas()
			importar.AireAcondicionado=line[64].encodeAsComillas()
			importar.Ejes=line[65].encodeAsComillas()
			importar.Estado=line[66].encodeAsComillas()
			importar.Combustible=line[67].encodeAsComillas()
			importar.Transmision=line[68].encodeAsComillas()
			importar.Um=line[69].encodeAsComillas()
			importar.PesoCategoria=line[70].encodeAsComillas()
			
			if(primeraIteracion==true){
				primeraIteracion=false
			}
			else{
				importar.save();
				}
			
			
		}

		redirect(controller:"filaCSV", action: "list")
			//render "hola mundo"	
		}
	
	
	
	
	
	def list = {
		
		params.max = Math.min(params.max ? params.int('max') : 100, 100)
		[importarInstanceList: Importar.list(params), filaCSVInstanceTotal: Importar.count()]
	}
	
	
	def deleteOldVersions={
		def version
		//Borrar de la BD las versiones que ya no formen parte de ACARA.
		def databaseUrl = ConfigurationHolder.getConfig().getProperty('databaseUrl')
		def user = ConfigurationHolder.getConfig().getProperty('user')
		def pass = ConfigurationHolder.getConfig().getProperty('pass')
		def driver = ConfigurationHolder.getConfig().getProperty('driver')
		def sql = Sql.newInstance(databaseUrl,user,pass,driver)
		//def sql = Sql.newInstance('jdbc:mysql://localhost:3306/motors?autoreconnect=true', 'motors','t0rm0sMl', 'com.mysql.jdbc.Driver')


		sql.eachRow("SELECT  v.version_id vv FROM version v LEFT JOIN temp_version tv ON tv.temp_version_id = v.version_id WHERE tv.temp_version_id IS NULL"){ row ->
			println row.vv
			version = Version.findByVersionId(row.vv)
			version.delete()
		}

		//SELECT  `version_version_id` FROM  `model_version` WHERE  `version_version_id` NOT IN (SELECT version_id FROM  `version`) //Limpieza de versions_id
		//SELECT id FROM price where id not in(SELECT  `price_id` FROM  `version_price`)//Limpieza precios



	}
	
	
	

}
