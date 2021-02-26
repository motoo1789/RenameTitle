package parse;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class FactoryParse {

	private static FactoryParse singleton = FactoryParse.getInstance();
	private List<Iparse> parseList = new ArrayList<Iparse>();

	private FactoryParse(){
		for(Iparse parse : ServiceLoader.load(Iparse.class))
		{
			parseList.add(parse);
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
