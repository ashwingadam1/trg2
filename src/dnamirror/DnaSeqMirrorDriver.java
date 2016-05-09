package dnamirror;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DnaSeqMirrorDriver {

	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
			System.exit(-1);
		}
		JobConf conf = new JobConf();
		Job job = new Job(conf, "dnasequencemirror");
		job.setJarByClass(DnaSeqMirrorDriver.class);

		job.setMapperClass(DnaSeqMirrorMapper.class);
		job.setReducerClass(DnaSeqMirrorReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		// job.setInputFormatClass(FixedLengthInputFormat.class);
		// FixedLengthInputFormat.setRecordLength(conf, 15);

		FileInputFormat.addInputPath(job, new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path(args[2]));

		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}
}