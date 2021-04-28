package cor;

import parse.IEEE;
import parse.Iparse;

public class CoR_IEEE extends Support{

	public CoR_IEEE() {
		super();
	}

	@Override
	protected boolean resolve(String dlFilename) {

		// TODO 自動生成されたメソッド・スタブ
		if(dlFilename.contains("_") == false && dlFilename.contains("-") == false && dlFilename.contains("IPSJ") == false) {
			return true;
		}
		return false;
	}

	@Override
	protected Iparse done(String dlFilename) {
		// TODO 自動生成されたメソッド・スタブ
		return super.singletonFactoryParse.getParce("IEEE");
		//return new IEEE();
	}

}
