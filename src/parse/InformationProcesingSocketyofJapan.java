package parse;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InformationProcesingSocketyofJapan implements Iparse {

	final String parsedivClass = "item_title pl55";
	final private String key = "IPSJ";

	@Override
	public String parse(String keyword)
	{
		// TODO 自動生成されたメソッド・スタブ
		String thesisTitle = "";

		try {

			Document document = Jsoup.connect("https://ipsj.ixsq.nii.ac.jp/ej/?action=pages_view_main&active_action=repository_view_main_item_snippet&all=IPSJ-JNL5401039&count=20&order=16&pn=1&st=1&page_id=13&block_id=8").get();
			Elements element = document.getElementsByClass("item_title pl55");
			thesisTitle = element.text();
			System.out.println(element.text());

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return thesisTitle;
	}

	@Override
	public String toString()
	{
		return key;
	}
}
