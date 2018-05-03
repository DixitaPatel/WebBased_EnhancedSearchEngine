import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import org.apache.tika.language.LanguageIdentifier;

@SuppressWarnings("deprecation")
public class TikaParser {

	public static void main(final String[] args) throws IOException, SAXException, TikaException {
		String path = "/Users/dixitapatel/Downloads/HTML Files";
		File dir = new File(path);	
	
		File output = new File("big.txt");
	    output.createNewFile();
	    FileWriter writer = new FileWriter(output);
		int count = 0;
		for(File file: dir.listFiles()){			
			BodyContentHandler handler = new BodyContentHandler(-1);
			Metadata metadata = new Metadata();
			FileInputStream inputstream = new FileInputStream(new File(path+"/"+file.getName()));
			System.out.println(count++ +"\n");
			ParseContext pcontext = new ParseContext();
			HtmlParser htmlparser = new HtmlParser();
			htmlparser.parse(inputstream, handler, metadata, pcontext);
			LanguageIdentifier object = new LanguageIdentifier(handler.toString());			
			if(object.getLanguage().equals("en")){
			writer.write(handler.toString().replaceAll("\\s+", " "));
			writer.write("\n");
			}
		}		
		writer.flush();
	    writer.close();
	}
}
