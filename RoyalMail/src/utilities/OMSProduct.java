package utilities;

public class OMSProduct {
	public static String sku, attributeSetCode, productType, categories, productWebsites, 
		name, description, shortDescription, productOnline, taxClassName, visibility, price, metaTitle, brand, 
		europeDeliveryCost, supplier, ukDeliveryCost, worldDeliveryCost, minCartQty, useConfigMinSaleQty, maxCartQty, 
		useConfigMaxSaleQty, isOMSProduct;
	  

	
	public static void RandomProduct() {
		  
		  ConfigFileReader configFileReader = new ConfigFileReader();
		  String omsProducts = configFileReader.getOMSProducts();
		  
		  String[] row = utilities.CSV.random(omsProducts);
		  
		  sku = row[0];
		  attributeSetCode = row[1];
		  productType = row[2];
		  categories = row[3];
		  productWebsites = row[4];
		  name = row[5];
		  description = row[6];
		  shortDescription = row[7];
		  productOnline = row[8]; 
		  taxClassName = row[9];
		  visibility = row[10];
		  price = row[11];
		  metaTitle = row[12];
		  brand = row[13];
		  europeDeliveryCost = row[14]; 
		  supplier = row[15];
		  ukDeliveryCost = row[15];
		  worldDeliveryCost = row[16];
		  minCartQty = row[17];
		  useConfigMinSaleQty = row[18];
		  maxCartQty = row[19];
		  useConfigMaxSaleQty = row[20];
		  isOMSProduct = row[21];

	}
	
	public static void specificProduct(String productCode) {
		  
		  ConfigFileReader configFileReader = new ConfigFileReader();
		  String omsProducts = configFileReader.getOMSProducts();
		  
		  String[] row = utilities.CSV.specific(omsProducts, productCode);
		  
		  sku = row[0];
		  attributeSetCode = row[1];
		  productType = row[2];
		  categories = row[3];
		  productWebsites = row[4];
		  name = row[5];
		  description = row[6];
		  shortDescription = row[7];
		  productOnline = row[8]; 
		  taxClassName = row[9];
		  visibility = row[10];
		  price = row[11];
		  metaTitle = row[12];
		  brand = row[13];
		  europeDeliveryCost = row[14]; 
		  supplier = row[15];
		  ukDeliveryCost = row[15];
		  worldDeliveryCost = row[16];
		  minCartQty = row[17];
		  useConfigMinSaleQty = row[18];
		  maxCartQty = row[19];
		  useConfigMaxSaleQty = row[20];
		  isOMSProduct = row[21];

	}

}
