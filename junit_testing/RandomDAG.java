/**
 * Random DAG generator
 * Generates a graph from 1-10000
 */
import java.util.*; // for Random, Set, List, Map
import java.lang.IllegalArgumentException;

public class RandomDAG<Value> {


		Key[] keyArray = new Key[keySize+1];
		DirAcycGraph dm = new DirAcycGraph();

	public static void main (String[] args) {

/*		int keySize = 0;
		Key[] keyArray = new Key[keySize+1];
		int dependency = 0;
		DirAcycGraph dm = new DirAcycGraph();
*/	
		if(args.length==2)
		{

			int dependency = 0;
			int keySize = 0;
			try {
				keySize = Integer.parseInt(args[0]);
				dependency = Integer.parseInt(args[1]);
				}			//amount of verticies in graph
				catch(NumberFormatException e)
				{
					System.exit(0);
				}

			
				if (dependency > keySize) {
					throw new IllegalArgumentException ("Second arg cannot be greater than first arg.");
				}	
			
			//createKeyArray(keySize);
	


		}

	}

	public void createKey (int arrayPosition, Value value)
	{
		Key key = new Key();
		keyArray[arrayPosition] = key;
		dm.put(keyArray[arrayPosition], value);
	}

	public void createKeyArray (int keySize)
	{

		Key[] keyArray = new Key[keySize+1];
		for (int i=0;i<keySize;i++)
			createKey(i, "value");
	}
}
