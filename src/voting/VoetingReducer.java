package voting;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.regex.*;

public class VoetingReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		long value=0;
		for (Text val : values) {
			String str=val.toString();
			if(Pattern.matches("[0-9]+", str))
			{
				value=Integer.parseInt(str);
			}
			
		}
		//context.write(key, new Text(buf.toString()));

	}

}
