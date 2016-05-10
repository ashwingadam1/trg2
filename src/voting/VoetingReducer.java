package voting;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class VoetingReducer extends Reducer<Text, Text, Text, LongWritable> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		long value = 0;
		for (Text val : values) {
			String str = val.toString();
			if (Pattern.matches("[0-9]+", str)) {
				value = Integer.parseInt(str);
				break;
			}
		}
		for (Text val : values) {
			String str = val.toString();
			if (Pattern.matches("[a-zA-Z]", str)) {
				context.write(new Text(val), new LongWritable(value));
			}
		}

	}

}
