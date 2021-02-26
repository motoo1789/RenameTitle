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
	Support ipsj = new CoR_IPSJ();

	public FacadeRename() {
		fileNames = new ArrayList<String>();
		ieee.setNext(ipsj);
	}

	public void renameStart() {

		fileNames = fixpdf.readFiles();	// 	ファイルを読み込んで名前をリストに保存

		//検索の処理 keyword＝ファイルの名前を送る
		for(String beforeFilename : fileNames)
		{
			Iparse parse = getInstance(beforeFilename);		// インスタンスの取得

			String newFilename = parse.parse(beforeFilename);		// parseしてタイトル回収
			fixpdf.renamePDFTitle(beforeFilename, newFilename);
			System.out.println("1個終了");
			System.out.println("");
		}

	}

	private Iparse getInstance(String beforeFilename) {

		return ieee.supportRename(beforeFilename);

	}
}
