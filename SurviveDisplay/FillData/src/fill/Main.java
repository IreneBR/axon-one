package fill;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		makeEarthquakePoints();
}
	

	private static void makeEarthquakePoints() {
		StringBuilder sb = new StringBuilder();
		String orig = "{\n    \"stuck\": \"::name_1::37.785834::-122.406417::2016/04/23 06:20:39\"\n}, {\n    \"injured\": \"::name_1::37.785834::-122.406417::2016/04/23 06:20:39\"\n}, {\n    \"destruction\": \"::name_1::37.785834::-122.406417::2016/04/23 06:20:39\"\n}, {\n    \"survive\": \"::name_3::37.785834::-122.406417::2016/04/23 06:38:18\"\n}, {\n    \"stuck\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:18\"\n}, {\n    \"destruction\": \"::name_2::37.785834::-122.406417::2016/04/23 06:38:18\"\n}, {\n    \"urgent-help\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:18\"\n}, {\n    \"injured\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:18\"\n}, {\n    \"water-level\": \"::name_3::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"destruction\": \"::name_3::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"stuck\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"urgent-help\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"survive\": \"::name_3::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"injured\": \"::name_1::37.785834::-122.406417::2016/04/23 06:38:38\"\n}, {\n    \"survive\": \"::name_1::37.785834::-122.406417::2016/04/23 06:40:25\"\n}, {\n    \"injured\": \"::name_1::37.785834::-122.406417::2016/04/23 06:40:25\"\n}, {\n    \"urgent-help\": \"::name_1::37.785834::-122.406417::2016/04/23 06:40:25\"\n}, {\n    \"stuck\": \"::name_1::37.785834::-122.406417::2016/04/23 06:40:25\"\n}, {\n    \"destruction\": \"::name_0::37.785834::-122.406417::2016/04/23 06:40:25\"\n}";
		
		
		double latitude = -21.976696;
		double longitude = 46.004037;
		
		String key = "survive";
		
		Random rn = new Random();
		int max = 3;
		int min = 0;
		//sb.append(orig+",");

		for (double i = 0.0; i < 1; i += 0.005) {
			int result = newRand(rn, max, min);
			
			
			sb.append("{\""
					+ key
					+ "\": \"::name_"
					+ result
					+ "::"
					+ (latitude + (i*Math.cos(rn.nextDouble()*2*Math.PI)))
					//+ (latitude + (i*Math.cos(0)))
					+ "::"
					+ (longitude + (i*Math.sin(rn.nextDouble()*2*Math.PI)))
					//+ (longitude + (i*Math.sin(0)))
					+ "::2016/04/23 06:20:39\"},\n");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		System.out.println("[" + sb.toString() + "]");
	}

	private static int newRand(Random rn, int max, int min) {
		return rn.nextInt(max - min + 1) + min;
	}}
