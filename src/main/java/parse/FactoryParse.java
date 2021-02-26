package parse;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class FactoryParse {

	private static FactoryParse singleton = new FactoryParse();
	private List<Iparse> parseList = new ArrayList<Iparse>();

	private FactoryParse(){
		for(Iparse parse : ServiceLoader.load(Iparse.class))
		{
			parseList.add(parse);
		}
		for(Iparse parse : parseList)
		{
			if(parse instanceof IEEE)
			{
				System.out.println("ieee");
			}
		}
	}

	public static FactoryParse getInstance(){
		return singleton;
	}

	public Iparse getParce(String key){
		for(Iparse parse : parseList)
		{
			if(parse.toString().equals(key))
			{
				return parse;
			}
		}

		return null;
	}
}
