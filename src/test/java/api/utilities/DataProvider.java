package api.utilities;

import java.io.IOException;

public class DataProvider {

	@org.testng.annotations.DataProvider(name = "Data")
	String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//testdata//usersdata.xlsx";

		int rownum = XLUtility.getRowCount(path, "Sheet1");
		int colnum = XLUtility.getCellCount(path, "Sheet1", 1);

		String progdata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				progdata[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
			}
		}
		return progdata;
	}
	
	
	@org.testng.annotations.DataProvider(name = "UserNames")
	String[] getUserNames() throws IOException {

		String path = System.getProperty("user.dir") + "//testdata//usersdata.xlsx";

		int rownum = XLUtility.getRowCount(path, "Sheet1");

		String apidata[] = new String[rownum];
		for (int i = 1; i <= rownum; i++) {
				apidata[i - 1] = XLUtility.getCellData(path, "Sheet1", i,1);
			}
		
		return apidata;
	}
	

}
