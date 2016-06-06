package HelpMe;

public class DataObj {
	public DataObj(String key, String val, String lat, String longi, String time) {
		this.key = key;
		this.value = val.substring("name_".length());
		this.longitude = longi;
		this.latitude = lat;
		this.time = time;
	}

	public String key, value, longitude, latitude, time;
}
