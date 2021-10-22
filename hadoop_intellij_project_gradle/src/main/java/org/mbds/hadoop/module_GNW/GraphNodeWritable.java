/*
  M2 MBDS - Big Data/Hadoop
	Année 2019/2020
  --
  TP2: parcours de graphe & programmation Hadoop avancée.
  --
  GraphRecordWriter.java: recordwriter spécifique (écrit un GraphNodeWritable).
*/
package org.mbds.hadoop.module_GNW;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.fs.FSDataOutputStream;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class GraphNodeWritable implements Writable {
	
	public String[] Voisin = null;
	public String Couleur = "" ;
	public int Profondeur = 0;

	public GraphNodeWritable(String string) {
		graphInput(string);
	}

	public void graphInput(String string) {
		// TODO Auto-generated constructor stub
				String[] parts = string.split("\\|");
				if (Voisin.length != 3) // Invalide.
					return;
				Voisin = parts[0].split(",");
				Couleur = parts[1];
				Profondeur = -1;
				try {
					Profondeur = Integer.parseInt(parts[2]);
				} catch (Exception e) {
					Profondeur = -1;
				}
	}

	public void write(DataOutput out) throws IOException {
		out.writeChars(get_serialized());

	}

	public void readFields(DataInput in) throws IOException {
		String line = in.readLine();
		graphInput(line);
	}

	public String get_serialized() {
		return String.join("," , Voisin) + "|" + Couleur + "|"+ Profondeur;
	}
}