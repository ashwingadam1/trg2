package dnamirror;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DnaSeqMirrorMapper extends Mapper<Object, Text, Text, Text> {
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		/*
		 * TODO implement
		 */
		String[] pairs = value.toString().split("[\n]+");
		for (String word : pairs) {
			String[] words = word.split(" ");
			char[] charArray = words[1].toCharArray();
			Arrays.sort(charArray);
			context.write(new Text(String.valueOf(charArray)), new Text(words[0]));
		}
	}
}
