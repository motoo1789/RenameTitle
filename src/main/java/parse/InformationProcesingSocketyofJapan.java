package parse;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class InformationProcesingSocketyofJapan implements Iparse{

	final String parse_divClass = "item_title pl55";
	final private String key = "IPSJ";

	public String parse(String keyword)
	{
		// TODO 自動生成されたメソッド・スタブ
		String thesisTitle = "";

		try {

			Document document = Jsoup.connect("https://ipsj.ixsq.nii.ac.jp/ej/?all=" + keyword).get();
			Elements element = document.getElementsByClass("item_title pl55");
			thesisTitle = element.text();
			System.out.println("IPSJタイトル：" + element.text());

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
