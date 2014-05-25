import CITS2200.*;
import java.util.Iterator;
import java.util.Set;
import java.util.IllegalArgumentException;

/**
 * DAG Map Assignment Interface and Class
 *  CITS2200 Project
 * 
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 */
 
 
public static class DirAcycGraph implements DAGMap {

	/**
	 * DAGMap properties
	 */
	private int size; // stores the number of nodes in DAGMap
	private Set<Key> keySet;	// all nodes in graph
	private Set<Key> subGraphs;	// all nodes with no requirement nodes

	/**
	 * Constructor Method
	 */
	public DirAcycGraph () {
		// initialise empty graph
		size = 0;
		rootKey = null;
		keySet = new Set<Key>;
	}
	
	public void put(Key newKey, V newValue) throws IllegalArgumentException
	{
		if (!containsKey(k))
		{
			Key newKey = new Key;	
			k.value = newValue;
			keySet.add(k);
			subGraphs.add(k);
		}
		else
			throw new IllegalArgumentException("Key contained in graph already, or key is null");
	}
	
	public V get(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.value;
		else
			throw new IllegalArgumentException("Key not defined in graph");
	}

	public void remove(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
		{
			// get all edges, removeEdges first
			// then remove key
			keySet.remove(k);
			k.predecessors//remove from
			k.successors//remove from
		} else
			throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public Set<Key> getPredecessors(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.predecessors;
    	else
    		throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public Set<Key> getSuccessors(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.successors;
    	else
    		throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public void addDependency (Key kReq, Key kDep ) throws IllegalArgumentException
	{
		// check that no cycle is being created
		if (!isDependent(kReq, kDep))
		{
			// update the Set<Object>s for both Keys
			kReq.successors.add(kDep);
			kDep.predecessors.add(k.Req);

			if(subGraphs.contains(kDep))
				subGraphs.remove(kDep);
		}
		else 
			// if it would create a cycle
			throw new IllegalArgumentException("Proposed dependency would create illegal cycle");
	}

	public void removeDependency (Key kReq, Key kDep)
	{
		if (isDependent(kReq, kDep))
		{
			// remove from set of dependencies
			for (Key node : kReq.successors)
				if (node.equals(kDep))
					kReq.successors.remove(node);

			// remove from set of requirements
			for (Key node : kDep.predecessors)
				if (node.equals(kReq))
					kDep.predecessors.remove(node);
		}
		else
			throw new IllegalArgumentException("No dependency found between given keys");
	}
	
	public boolean isEmpty()
	{
		return rootNode == null;
	}

	public boolean containsKey (Key k)
	{
		return k != null;
	}

	public boolean containsValue (V value)
	{
		// check if DAGMap contains value
		//   traverse/explore the entire map of keys
	}

	public boolean isDependent (Key haystackKey, Key needleKey) throws IllegalArgumentException
	{
		if (haystackKey != null && needleKey != null)
		{
			if(haystackKey.equals(needleKey))
				return true;
			else
			{
				if (getSuccessors(haystackKey) != null)
				{
					for(Key childKey : getSuccessors(haystackKey))
						if (isDependent(childKey,needleKey) return true;
				}
				else
					return false;
			}
			return false;
		}
		else
			throw new IllegalArgumentException("One or more parameters do not exist in graph!")
	}

	public Object clone() {
		// shallow clone,
		// copy all keys and dependencies?
	}
	

	public boolean equals(Object o) {
		// check if this dagmap equals another dagmap (keys, values, relations)
	}

	public Set<K> getKeySet() {
		int i = 0;
		Set<K> keysInDAG = new HashSet<K>;
		while (i.keysInDAG != null) {
			return i.keysInDAG;
			i++:
		}
	}

	public int getWidth() {
		return getAllPaths(rootNode);
	}

	/**
	 * Recursive algorithm to get all the edges
	 */
	private int getAllPaths(Key node) {
		//initialise a counter
		int numberOfPaths = 0;

		// if successors exist
		if(node.successors != null) {

			// for every successor
			for (Key childKey : getSuccessors(node)) {

				// get the successors paths
				numberOfPaths += getAllPaths(childKey);
			}

		} else
			// if has no dependents, add 1 path
			numberOfPaths++;

		return numberOfPaths;
	}


	public int getLongestPath()
	{
		// do something 
	}
	
	// return the number of paths that do not share a vertex from source to sink
	public int getMaxFlow(Key source, Key sink) {
		int maxFlow = 0;
		Set<Key> flowGraph = new HashSet();

		for(Key currentParent : getPredecessors(sink))
			if(isDependent(currentParent, source) &&
				!flowGraph.contains(currentParent) &&
				!getSuccessors(currentParent).contains(source))
			{
				flowGraph.add(currentParent);
				maxFlow += getMaxFlow(source, currentParent);
			}
			else return 1;
		return maxFlow;
	}

	// needs to output keys and values in DAGMap
	// e.g. keys : values
	public String toString() {
	}

	public Iterator iterator() {
		public boolean hasNext() {
		}
		
		public next() {
		}
	}
	
	/**
	 * private class Key represents each Key node
	 *   on the map, storing a set of successors
	 *   and predecessors
	 */
	private class Key extends Object {
		int value;
		Set successors;
		Set predecessors;
		
		public Object Key () {
			value = null;
			successors = new HashSet();
			predecessors = new HashSet();
		} 
	}

}

	
