package anagram;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AnaGramReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		StringBuffer temp = null;
		for (Text text : values) {
			temp = new StringBuffer();
			temp.append(text + " ");
		}
		context.write(key, new Text(temp.toString()));
	}
}
