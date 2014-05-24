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
	private Key rootKey; // stores the root node
	
	/**
	 * Constructor Method
	 */
	public DirAcycGraph () {
		// initialise empty graph
		size = 0;
		rootKey = null;
	}
	
	public void put(Key k, V value) throws IllegalArgumentException {
			if ( (k != null) || (!containsKey(k)) ) {
				key.add(k);	
				value.add(v);	
			} else throw new IllegalArgumentException("Key contained in graph already, or key is null");
				
	}
	
	public Key get(Key k) throws IllegalArgumentException {
		// remove this line once complete.
		int i = 0;
		while (i < k.size) {
			
			if (value[i] != null){
				return values[i].get(k);
			} else throw new IllegalArgumentException;
			
			i++;
			
			
		}	
	}
	
	public Set<Key> getPredecessors(Key k) throws IllegalArgumentException {
		// return the set of keys that are immediate requirements for given keys.
    		if(!containsKey(k)) {
	    		return k.predecessors;
	    	} else {
	    		throw new IllegalArgumentException("Key not defined in graph");
		}
	}
	
	public Set<Key> getSuccessors(Key k) throws IllegalArgumentException {
		// return the set of keys that are immediately dependent on the given key
		if(!containsKey(k)) {
	    		return k.successors;
	    	} else {
	    		throw new IllegalArgumentException("Key not defined in graph");
	    	}
	}
	
	public void addDependency (Key kReq, Key kDep ) throws IllegalArgumentException {
		// check that no cycle is being created
		if (!isDependent(kReq, kDep)) {
			// update the Set<Object>s for both Keys
			kReq.successors.add(kDep);
			kDep.predecessors.add(k.Req);
		} else 
			// if it would create a cycle
			throw new IllegalArgumentException("Proposed dependency would create illegal cycle");
	}

	public void removeDependency (Key kReq, Key kDep) {
		if (isDependent(kReq, kDep)) {
			for (Key i : kReq.successors)
				if (i.equals(kDep))
					// remove requir INCOMPLETE
			for (Key j : kDep.predecessors)
				if (i.equals(kReq))
					// remove depend INCOMPLETE
		} else
			throw new IllegalArgumentException("No dependency found between given keys");
	}
	
	public boolean isEmpty() {
		// ifEmpty applies to the DAGMap
		return rootNode.size() == null;
	}

	public boolean containsKey (K key) {
		// return key.contains(key); //check if key contains itself?
		
		// check if DAGMap contains key
		//   traverse/explore the entire map of keys
		//   and detect if this key is one of those
		//   return true
	}

	public boolean containsValue (V value) {
		
		// check if DAGMap contains value
		//   traverse/explore the entire map of keys
		//   and detect if this value is the same as
		//   the value of each or any key
		//   return true and break when value occurs
	}

	public boolean isDependent (int kReq, int kDep) {
		// test if kDep is dependent on kReq,
		//   this involves a->b->c, so check the
		//   predecessors of every predecessor
		//   (of every predecessor etc.) <- RECURSIVE
		//   ALGORITHM FOR A RECURSIVE ADT
	}

	public Object clone() {
		// shallow clone,
		//   copy all keys and dependencies?
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
