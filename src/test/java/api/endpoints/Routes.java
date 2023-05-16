package api.endpoints;

/*
 * swagger -->https://petstore.swagger.io
 * 
 * createuser  --> https://petstore.swagger.io/v2/user
 * getuser     --> https://petstore.swagger.io/v2/user/{username}
 * updateuser  --> https://petstore.swagger.io/v2/user/{username}
 * deleteuser  --> https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	//base url for swagger user module
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	//users Module urls
	
	public static String post_url = base_url+"/user";
	public static String get_url  = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	//store module urls 
	
	
	//pet module urls

}
