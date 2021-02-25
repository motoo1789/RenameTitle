package parse;

import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;
import io.webfolder.ui4j.api.dom.Document;

public class IEEE implements Iparse {

	final String parse_spanAttribute = "xplmathjax";
	final String parsed_divClass = "col result-item-align";
	final private String key = "IPSJ";
	private String url = "https://ieeexplore.ieee.org/search/searchresult.jsp?queryText=";

	@Override
	public String parse(String keyword) {
		// TODO 自動生成されたメソッド・スタブ

		String thesisTitle = "";


		//Ui4j
		System.setProperty("ui4j.headless","true");
		Page page = BrowserFactory.getWebKit().navigate(url + keyword);
		page.show();

		Document document = page.getDocument();
		String str = document.toString();

		System.out.println(str);
//		List elements = new List();
//		elements = document.parseHTML(document.toString());

//		Elements element = document.getElementsByClass(parsed_divClass);
//
//		FileWriter fw = new FileWriter("test.txt",false);
//		fw.write(document.html());

		//element = element.ge



		return thesisTitle;

	}

}
