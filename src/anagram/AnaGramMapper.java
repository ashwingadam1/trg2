package anagram;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AnaGramMapper extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String[] words = value.toString().split("[ \t]+");
		
		for (String word : words) {
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			context.write(new Text(String.valueOf(charArray)), new Text(word));
		}
	}

}
