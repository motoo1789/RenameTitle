package parse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;

public class IEEE implements Iparse{

	final String parse_spanAttribute = "xplmathjax";
	final private String key = "IEEE";
	private String url = "https://ieeexplore.ieee.org/search/searchresult.jsp?queryText=";

	public String parse(String keyword) {
		// TODO 自動生成されたメソッド・スタブ

		String thesisTitle = "";

		//Ui4j
		//System.setProperty("ui4j.headless", "true");
		BrowserEngine webkit = BrowserFactory.getWebKit();
		Page page = webkit.navigate(url + keyword);
		//page.show();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		Document document = page.getDocument();
		List<Element> spanList = document.queryAll("span");

		for(Element element : spanList)
		{
			if(element.hasAttribute(parse_spanAttribute))
			{
				System.out.println("IEEE：" + element.getText());
				thesisTitle = element.getText();
				break;
			}
		}

		return thesisTitle;

	}

	public String toString() {
		return key;
	}
}
