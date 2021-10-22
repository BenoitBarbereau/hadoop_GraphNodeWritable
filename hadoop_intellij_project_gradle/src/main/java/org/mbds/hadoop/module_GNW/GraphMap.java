/*
  M2 MBDS - Hadoop - 2021

  --
  TP1: exemple de programme Hadoop - detecteur d'anagrammes
  --
*/
package mbds;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Classe Driver (contient le main du programme Hadoop).
public class GraphMap extends Mapper<Text, GraphNodeWritable, Text, GraphNodeWritable> {
	private static final String GREY = "GRIS";

	protected void map(Text key, GraphNodeWritable node, Context context) throws IOException, InterruptedException {
		if (node.Couleur.equals(GREY)) {
			for (int i = 0; i < node.Voisin.length; ++i) {
				if (node.Voisin[i].equals(""))
					continue;
				context.write(new Text(node.Voisin[i]), new GraphNodeWritable ("|" + GREY + "|" + Integer.toString(node.Profondeur + 1)));
			}
			context.write(key, new GraphNodeWritable (String.join("," , node.Voisin) + "|NOIR|" + Integer.toString(node.Profondeur)));
		} else
			context.write(key, node);
	}
}
