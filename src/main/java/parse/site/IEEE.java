package parse.site;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import fix.StringFix;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;
import parse.Iparse;

public class IEEE implements Iparse{

	StringFix stringfix = StringFix.getInstance();

	final String parse_spanAttribute = "_ngcontent-qvp-c26";
	final private String key = "IEEE";
	private String url = "https://ieeexplore.ieee.org/document/";
	final String title_className = "document-title";


	public String parse(String keyword) {
		// TODO 自動生成されたメソッド・スタブ

		String thesisTitle = "";

		//前に0がついてたら削除
		keyword = stringfix.SubstKeyword(keyword);
		System.out.println(url + keyword);

		//Ui4j
//		System.setProperty("ui4j.headless", "true");
		BrowserEngine webkit = BrowserFactory.getWebKit();
		Page page = webkit.navigate(url + keyword);
//		page.show();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		Document document = page.getDocument();
		List<Element> spanList = document.queryAll("h1");

		for(Element element : spanList)
		{
			if(element.hasClass(title_className))
			{
				Element spanElement = element.after(element.getInnerHTML());
				System.out.println("IEEE：" + spanElement.getText());
				thesisTitle = spanElement.getText();
				break;
			}
		}

		return thesisTitle;

	}

	public String toString() {
		System.out.println("1111ieee");
		return key;
	}

}
