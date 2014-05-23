import CITS2200.*;
import java.util.Iterator;
import java.util.Set;

/**
 * DAG Map Assignment Interface and Class
 * For CITS2200. Project 1.
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 */

/**
 * DAGMap implementation of DirAcycGraph Interface
 */
public static class DirAcycGraph implements DAGMap {
	
	private int size; //variable - for size of DAGMap
	private Key rootKey; // root node
	
	/**
	 * Constructor
	 */
	public DirAcycGraph () {

	}
	
	public void put(Key k, V value) throws IllegalArgument {
			if ( (k != null) || (!containsKey(k)) ) {
				k.add;
				value.add;
			} else throw new IllegalArgument("Key contained in graph already, or key is null");
				
	}
	
	public Key get(Key k) throws IllegalArgument {
		// remove this line once complete.
		int i = 0;
		while (i < size) {
			
			if (value[i] != null){
				return values[i].get(k);
			} else throw new IllegalArgument;
			
			i++;
			
			
		}	
	}
	
	public Set<Key> getPredecessors(Key k) throws IllegalArgumentException {
		// return the set of keys that are immediate requirements for given keys.
    		if(!containsKey(k)) {
	    		return k.predecessors;
	    	} else {
	    		throw new IllegalArgumentException;
		}
	}
	
	public Set<Key> getSuccessors(Key k) throws IllegalArgumentException {
		// return the set of keys that are immediately dependent on the given key
		if(!containsKey(k)) {
	    		return k.successors;
	    	} else {
	    		throw new IllegalArgumentException;
	    	}
	}
	
	public void addDependency (Key kReq, Key kDep ) throws IllegalArgumentException {
		// check that no cycle is being created
		if (!isDependent(kReq, kDep)) {
			kReq.successors.add(kDep);
			kDep.predecessors.add(k.Req);
		} else {
			// if it would create a cycle
			throw new IllegalArgumentException;
		}
	}

	public void removeDependency (Key kReq, Key kDep) {
		if (isDependent(kReq, kDep)) {
			for (Key i : kReq.successors)
				if (i.equals(kDep))
					// remove requir
			for (Key j : kDep.predecessors)
				if (i.equals(kReq))
					// remove depend
		}
	}
	
	public boolean isEmpty() {
		return key.size == null;
	}

	public boolean containsKey (K key) {
		return key.contains(key);
	}

	public boolean containsValue (V value) {
		return key.contains(value);
	}

	public boolean isDependent (int kOne, int kTwo) {
		
	}

	public Object clone() {
		// return clonedMap;
	}
	

	public boolean equals(Object o) {
		
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
	}

	public int getLongestPath(){ 
	}

	public int getMaxFlow(int source, int sink) {
	}

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
	private class Key {
		int value;
		Set<Object> successors;
		Set<Object> predecessors;
		
		public Object Key () {
			value = null;
			successors = null;
			predecessors = null;
		}
	}
}
