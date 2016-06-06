package HelpMe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HelpMe {

	public static void main(String[] args) {
		String rawResponse = getRawResponse();
//		DataTypes select = DataTypes.URGENT_HELP;
		DataTypes select = DataTypes.SURVIVE;
		
		
		ArrayList<DataObj> resData = extractData(rawResponse, select.toString());

		// Make string to send
		// String header = "name,desc,latitude,longitude,color";
		ArrayList<String> strData = new ArrayList<>();

		String header = "name,latitude,longitude," + select.toString();
		System.out.println(header);
		for (DataObj o : resData) {
			// System.out.println(o.latitude + "," + o.longitude + "," +
			// o.value);
			strData.add(o.latitude + "," + o.longitude + "," + o.value);
		}
		new HtmlContent().start(header, strData, select.toString(), getLegendSteps(select));
	}

	private static String getLegendSteps(DataTypes select) {
		if (select.equals(DataTypes.DESTRUCTION)) {
			return "4";
		}
		if (select.equals(DataTypes.INJURED)) {
			return "2";
		}
		if (select.equals(DataTypes.STUCK)) {
			return "2";
		}
		if (select.equals(DataTypes.SURVIVE)) {
			return "4";
		}
		if (select.equals(DataTypes.URGENT_HELP)) {
			return "2";
		}
		if (select.equals(DataTypes.WATER_LEVEL)) {
			return "4";
		}
		return "";
	}

	private static ArrayList<DataObj> extractData(String rawResponse, String select) {
		String[] data = rawResponse.split(",");
		ArrayList<DataObj> resData = new ArrayList<>();
		for (String d : data) {
			if (d.split("\"")[1].equals(select)) {
				String[] v = d.split("::");
				resData.add(new DataObj(select, v[1], v[2], v[3], v[4]));
			}
		}
		return resData;
	}

	private static String getRawResponse() {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			String sUrl = "http://axonserver-mistelip.c9users.io:8080/";
			URL url = new URL(sUrl);
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				stringBuilder.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		stringBuilder.deleteCharAt(0);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

}
