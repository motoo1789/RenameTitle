package fix;

public class StringFix {

	private static StringFix singleton = new StringFix();
	private String[] inappropriate = {"\\","/",":","*","?","<",">","|","\""};

	private StringFix(){
		System.out.println("StringFixのインスタンスを生成");
	}

	public static StringFix getInstance() {
		return singleton;
	}

	public String SubstKeyword(String keyword)
	{
		int index;
		String reutrnKeyword = "";
		for(index = 0; index < keyword.length(); index++)
		{
			if(keyword.substring(index,index + 1).equals("0"))
			{
				// 何もしない
			}
			else
			{
				// 前の0をとる
				reutrnKeyword = keyword.substring(index,keyword.length());
				System.out.println(reutrnKeyword);
				break;
			}
		}
		return reutrnKeyword;
	}

	public String ReplacementInappropriateString(String newFilename)
	{
		final String space = " ";
		for(int index = 0; index < inappropriate.length; index++)
		{
			if(newFilename.contains(inappropriate[index]))
			{
				newFilename = newFilename.replace(inappropriate[index],space);
			}
		}

		return newFilename;
	}
}
