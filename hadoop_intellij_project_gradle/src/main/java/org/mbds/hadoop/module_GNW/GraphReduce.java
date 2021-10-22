/*
  M2 MBDS - Hadoop - 2021

  --
  TP1: exemple de programme Hadoop - detecteur d'anagrammes
  --
*/
package org.mbds.hadoop.module_GNW;

import java.util.Iterator;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class GraphReduce extends Reducer<Text, GraphNodeWritable , Text, GraphNodeWritable> {
	public void reduce(Text key, Iterable<GraphNodeWritable> nodes, Context context) throws IOException, InterruptedException {
		GraphNodeWritable New_Graph = new GraphNodeWritable("||-1");

		Iterator<GraphNodeWritable> i = nodes.iterator();
		while (i.hasNext()) {
			GraphNodeWritable node = i.next();

			/*
			if (node.Profondeur == -2)
				continue;
			 */

			if (node.Profondeur > New_Graph.Profondeur)
				New_Graph.Profondeur = node.Profondeur;

			if (node.Voisin.length > New_Graph.Voisin.length)
				New_Graph.Voisin = node.Voisin;

			if ((New_Graph.Couleur.equals(""))
					|| ((New_Graph.Couleur.equals("BLANC") && (node.Couleur.equals("GRIS") || node.Couleur.equals("NOIR")))
					|| (New_Graph.Couleur.equals("GRIS") && (node.Couleur.equals("NOIR"))))) {
				New_Graph.Couleur = node.Couleur;
			}
		}
		if (!New_Graph.Couleur.equals("NOIR"))
			context.getCounter(Graph.GRAPH_COUNTERS.NB_NODES_UNFINISHED).increment(1);
		context.write(key, New_Graph);
	}
}
	/*
		if (!node.Couleur.equals("NOIR"))
			context.getCounter(Graph.GRAPH_COUNTERS.NB_NODES_UNFINISHED).increment(1);
		context.write(key, new GraphNodeWritable (String.join("," , node.Voisin) + node.Couleur + Integer.toString(node.Profondeur)));
	}
}	*/
