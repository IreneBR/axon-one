package HelpMe;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class HtmlContent extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
	}

	void start(String header, ArrayList<String> strData, String select, String legendSteps) {

		
		PrintWriter writer;
		String filename = "HelpRequests.html";
		try {
			writer = new PrintWriter(filename, "UTF-8");
			writer.println("<FORM action=\"http://www.gpsvisualizer.com/map\" method=\"POST\">");
			writer.println("");
			writer.println("<INPUT type=\"hidden\" name=\"format\" value=\"google\">");
			writer.println("<INPUT type=\"hidden\" name=\"bg_map\" value=\"usgs_aerial\">");
			writer.println("<INPUT type=\"hidden\" name=\"wpt_colorize\" value=\"custom\">");
			writer.println("<INPUT name=\"wpt_colorize_custom\" value=\""
					+ select
					+ "\" >");
			writer.println("<INPUT type=\"hidden\" name=\"legend_placement\" value=\"bottomleft\">");
			writer.println("<INPUT type=\"hidden\" name=\"legend_steps\" value=\""
					+ legendSteps
					+ "\">");
			writer.println("<INPUT type=\"hidden\" name=\"colorize_reverse\" value=\"1\">");
			writer.println("<INPUT type=\"hidden\" name=\"hue1\" value=\"120\">");
			writer.println("<INPUT type=\"hidden\" name=\"hue2\" value=\"0\">");
			writer.println("<INPUT type=\"hidden\" name=\"units\" value=\"us\">");
			writer.println("<INPUT type=\"hidden\" name=\"legend_placement\" value=\"bottomleft\">");
			writer.println("");
			writer.println("<INPUT type=\"hidden\" name=\"special\" value=\"test\">");
			writer.println("<INPUT type=\"hidden\" name=\"data\" value=\"");
			
			writer.println(header);
			for (String s : strData) {
				writer.println("Info," + s);
			}
			writer.println("\">");
			writer.println("");
			writer.println("<INPUT type=\"submit\" name=\"submitted\" value=\"Draw the map\">");
			writer.println("");
			writer.println("</FORM>");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			Desktop.getDesktop().open(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}