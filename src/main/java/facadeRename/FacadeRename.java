package facadeRename;

import java.util.ArrayList;

import reader.FixPDF;

public class FacadeRename {

	ArrayList<String> fileNames;
	FixPDF fixpdf = FixPDF.getInstance();

	public FacadeRename() {
		fileNames = new ArrayList<String>();
	}

	public void renameStart() {

		fileNames = fixpdf.readFiles();	// 	ファイルを読み込んで名前をリストに保存

		//検索の処理 keyword＝ファイルの名前を送る

	}
}
