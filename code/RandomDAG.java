/**
 * Random DAG generator
 * Generates a graph from 1-10000
 */
import java.util.*; // for Random, Set, List, Map
import java.lang.IllegalArgumentException;

public class RandomDAG {

	public static void main (String[] args) {
	
		if(args.length==2)
		{
			int density = 0;
			int keySize = 0;
			DirAcycGraph dm = new DirAcycGraph();

			try {
				keySize = Integer.parseInt(args[0]);
				density = Integer.parseInt(args[1]);
				}			//amount of verticies in graph
				catch(NumberFormatException e)
				{//error}
					System.exit(0);
				}

				Key[] keyArray = new Key[keySize+1];
			
			if (density > keySize) {
				throw new IllegalArgumentException ("Density cannot be greater than keysize.");
			} else {
				Random r  = new Random();
				//Put given amount of 
				for (int i=0;i<keySize;i++)
				{
					Key key = new Key();
					keyArray[i] = key;
				}
				//int val;
				for(Key i : keyArray)
				{
					dm.put(i, "Value");
					/*if (r.nextInt() = i)
						dm.put(i, "Wow..lucky");*/
				}
			
				/*for (Key i : density) {
					Key<Integer> val = r.nextInt(i);
					if (!isDependent(val, i))
						dm.addDependency(val, i);		
					else i++;
				}*/

			}

		}
	}

}