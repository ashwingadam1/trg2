package anagram;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AnaGramMapper extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String[] words = value.toString().split("[ \t]+");
		StringBuffer temp = null;
		char tempChar = 'a';
		for (String word : words) {
			temp = new StringBuffer();
			temp.append(word);
			System.gc();

			for (int i = 0; i < temp.length(); i++)
				for (int j = i; j < temp.length(); j++) {
					if (temp.charAt(i) > temp.charAt(j)) {
						tempChar = temp.charAt(i);
						temp.replace(i, i, temp.charAt(j) + "");
						temp.replace(j, j, tempChar + "");
						System.gc();
					}
				}
			context.write(new Text(temp.toString()), new Text(word));
		}
	}

}
