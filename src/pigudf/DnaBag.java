package pigudf;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class DnaBag extends EvalFunc<String>{
	public String exec(Tuple input) throws IOException {
		if (input == null || input.size() == 0)
			return null;
		try {
			if (input.get(0) != null) {
				String str = input.get(0).toString();
				String[] str1=str.split(",");
				StringBuffer strbuf=new StringBuffer();
				for(int i=0;i<str1.length;i++)
				{
					String[] temp=str1[i].split(":");
					strbuf.append(temp[1]);
				}
				return strbuf.toString();
			} else
				return null;
		} catch (Exception e) {
			throw new IOException("Caught exception processing input row ", e);
		}
	}
}
