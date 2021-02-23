package cor;

import parse.Iparse;

public abstract class Support {

	Support next;

	protected abstract boolean resolve(String dlFilename);
	protected abstract Iparse done(String dlFilename);

	public final Iparse supportRename(String dlFilename)
	{
		if(resolve(dlFilename))
		{
			Iparse renameInstance = next.done(dlFilename);
			return renameInstance;
		}
		else if(next != null)
		{
			next.supportRename(dlFilename);
		}
		else {
			fail();
		}
		return null;
	}

	protected void fail() {
		System.out.println("変換できない");
	}
}
