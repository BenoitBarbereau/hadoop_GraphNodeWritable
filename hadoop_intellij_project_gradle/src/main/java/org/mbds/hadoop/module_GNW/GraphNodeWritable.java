/*
  M2 MBDS - Big Data/Hadoop
	Année 2019/2020
  --
  TP2: parcours de graphe & programmation Hadoop avancée.
  --
  GraphRecordWriter.java: recordwriter spécifique (écrit un GraphNodeWritable).
*/
package org.mbds.hadoop.module_GNW;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.Writable;

public class GraphNodeWritable implements Writable
{
	public String [] neighbors = new String [0];
	public String color = "";
	public int depth = 0;


	public GraphNodeWritable(String string)
	{
		graphinput(string);
	}

	public GraphNodeWritable()
	{
	}

	private void graphinput(String string) {
		String[] parts = string.split("\\|");
		if(parts.length!=3) // Invalid
			return;
		neighbors=parts[0].split(",");
		color=parts[1];
		depth=1;

		try
		{
			depth = Integer.parseInt(parts[2]);
		}
		catch (Exception e)
		{
			depth = -1;
		}
	}

	public String get_serialized()
	{
		return String.join(",", neighbors) + "|" + this.color + "|" + this.depth;
	}

	public void write(DataOutput out) throws IOException
	{
		out.writeChars(get_serialized());
	}

	public void readFields(DataInput in) throws IOException
	{
		String line= in.readLine();
		graphinput(line);
	}
}
