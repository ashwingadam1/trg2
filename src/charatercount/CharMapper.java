package charatercount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CharMapper extends Mapper<Object, Text, Text, LongWritable> {

	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		/*
		 * TODO implement
		 */
		String[] words = value.toString().split("[ \t]+");
		for (String word : words) {
			System.out.println("ddd");
			System.err.println("erorr");

			for(int i=0;i<word.length();i++)
			{
				char letter=word.charAt(i);
				context.write(new Text(letter+""), new LongWritable(1));
			}
		}
	}
}
