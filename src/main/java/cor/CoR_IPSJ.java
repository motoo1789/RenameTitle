package cor;

import parse.InformationProcesingSocketyofJapan;
import parse.Iparse;

public class CoR_IPSJ extends Support {


	@Override
	protected boolean resolve(String dlFilename) {
		// TODO 自動生成されたメソッド・スタブ
		return dlFilename.contains("IPSJ") ? true : false;
	}

	@Override
	protected Iparse done(String dlFilename) {
		// TODO 自動生成されたメソッド・スタブ
		//return super.singletonFactoryParse.getParce("IPSJ");
		return new InformationProcesingSocketyofJapan();
	}

}
