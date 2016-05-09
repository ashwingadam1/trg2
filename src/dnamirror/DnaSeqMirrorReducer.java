package dnamirror;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DnaSeqMirrorReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		StringBuffer buf = new StringBuffer();
		for (Text val : values) {
			buf.append(val);
		}
		context.write(key, new Text(buf.toString()));

	}
}