package facadeRename;

import java.util.ArrayList;

import cor.CoR_IEEE;
import cor.CoR_IPSJ;
import cor.Support;
import parse.IEEE;
import parse.InformationProcesingSocketyofJapan;
import parse.Iparse;
import reader.FixPDF;

public class FacadeRename {

	ArrayList<String> fileNames;
	FixPDF fixpdf = FixPDF.getInstance();

	Support ieee = new CoR_IEEE();
	Support ipjs = new CoR_IPSJ();

	public FacadeRename() {
		fileNames = new ArrayList<String>();
		ieee.setNext(ipjs);
	}

	public void renameStart() {


		fileNames = fixpdf.readFiles();	// 	ファイルを読み込んで名前をリストに保存

		//検索の処理 keyword＝ファイルの名前を送る
		for(String beforeFilename : fileNames)
		{
			Iparse parse = getInstance(beforeFilename);		// インスタンスの取得

			if(parse instanceof IEEE)
				System.out.println("IEEE");
			else if(parse instanceof InformationProcesingSocketyofJapan)
				System.out.println("情報処理学会");

			String newFilename = parse.parse(beforeFilename);		// parseしてタイトル回収
			fixpdf.renamePDFTitle(beforeFilename, newFilename);
			System.out.println("1個終了");
		}

	}

	private Iparse getInstance(String beforeFilename) {

		Iparse parce;

		return ieee.supportRename(beforeFilename);

	}
}
