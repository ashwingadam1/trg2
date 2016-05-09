package dnasequence;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DnaSeqMapper extends Mapper<Object, Text, Text, Text> {
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		/*
		 * TODO implement
		 */
		String[] pairs = value.toString().split("[\n]+");
		for (String word : pairs) {
			String[] words = word.split(" ");
			context.write(new Text(words[1]), new Text(words[0]));
		}
	}
}
