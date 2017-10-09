import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class main {
	public static int beginIndex;
	public static void main (String[] args) throws IOException
	{
		
		String link = "http://www.ecs.soton.ac.uk/people/", toAdd, email;
		Scanner scan = new Scanner(System.in);
		email = scan.nextLine();
		int i = 0;
		while (email.charAt(i) != '@')
			i++;
		toAdd = email.substring(0, i);
		link = link.concat(toAdd);
		URL url = new URL (link);
		URLConnection urlConn = url.openConnection();
		InputStreamReader stream = new InputStreamReader (urlConn.getInputStream(), "UTF-8");
		BufferedReader buff = new BufferedReader(stream);
		/*String line = "nothing";
		while (line.contains("twitter") == false)
		{
			line = buff.readLine();
			
		}
		beginIndex = findBegin(line);
		int endIndex = findEnd(line);
		System.out.println(line.substring(beginIndex, endIndex - 5));
		*/
		i = 0;
		while (i <= 7)
		{
			buff.readLine();
			i++;
		}
		String line = buff.readLine();
		int beginIndex = findBegin(line);
		int endIndex = findEnd(line);
		System.out.println(line.substring(beginIndex, endIndex));
	}
	public static int findEnd (String line)
	{
		int i = beginIndex;
		while (line.charAt(i) != '|')
			i++;
		return i;
	}
	public static int findBegin (String line)
	{
		int i = 0;
		while (line.charAt(i) != '>')
			i++;
		i++;
		while (line.charAt(i) != ' ')
			i++;
		return i + 1;
	}
}