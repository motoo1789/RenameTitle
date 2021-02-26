package parse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;

public class IEEE implements Iparse {

	final String parse_spanAttribute = "xplmathjax";
	final String parsed_divClass = "col result-item-align";
	final private String key = "IPSJ";
	private String url = "https://ieeexplore.ieee.org/search/searchresult.jsp?queryText=";

	public String parse(String keyword) {
		// TODO 自動生成されたメソッド・スタブ

		String thesisTitle = "";


		//Ui4j
		//System.setProperty("ui4j.headless", "true");
		BrowserEngine webkit = BrowserFactory.getWebKit();
		Page page = webkit.navigate(url + keyword);

		//page.show();

		Document document = page.getDocument();
//		Element bodyElement = document.getBody();
//		String attributeElement = bodyElement.getInnerHTML();

		List<Element> aaa = document.queryAll("span");

		for(Element element : aaa)
		{
			if(element.hasAttribute(parse_spanAttribute))
			{
				System.out.println("あった　論文名：" + element.getText());
				thesisTitle = element.getText();
				break;
			}
		}

		return thesisTitle;

	}

}
