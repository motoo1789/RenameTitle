package cor;

import parse.FactoryParse;
import parse.InformationProcesingSocketyofJapan;
import parse.Iparse;

public abstract class Support {

	private Support next;
	protected FactoryParse singletonFactoryParse;

	protected abstract boolean resolve(String dlFilename);
	protected abstract Iparse done(String dlFilename);

	public Support() {
		singletonFactoryParse = FactoryParse.getInstance();
	}

	public Support setNext(Support next) {

		this.next = next;
		return next;
	}

	public final Iparse supportRename(String dlFilename){

		Iparse renameInstance = null;

		if(resolve(dlFilename))
		{
			renameInstance = done(dlFilename);
		}
		else if(next != null)
		{
			renameInstance = next.supportRename(dlFilename);
		}
		else {
			fail();
		}

		return renameInstance;

	}

	protected void fail() {
		System.out.println("変換できない");
	}
}
