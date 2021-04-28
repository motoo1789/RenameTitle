package facadeRename;

import java.util.ArrayList;

import cor.CoR_IEEE;
import cor.CoR_IPSJ;
import cor.Support;
import parse.Iparse;
import parse.site.IEEE;
import parse.site.InformationProcesingSocketyofJapan;
import reader.FixPDF;

public class FacadeRename {

	ArrayList<String> fileNames;
	FixPDF fixpdf = FixPDF.getInstance();

	Support ieee = new CoR_IEEE();
	Support ipsj = new CoR_IPSJ();

	public FacadeRename() {
		fileNames = new ArrayList<String>();
		ipsj.setNext(ieee);
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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}

	}

	private Iparse getInstance(String beforeFilename) {

		return ipsj.supportRename(beforeFilename);

	}
}
