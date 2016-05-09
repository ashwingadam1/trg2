package voting;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class VoteingMapper extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String[] line = value.toString().split("[\n]+");
		for (String pair : line) {
			String[] word = pair.split("[\" \"]+");
			context.write(new Text(word[0]), new Text(word[1]));
		}
	}

}
