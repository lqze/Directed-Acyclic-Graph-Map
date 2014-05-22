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
	
	public void put(K key, V value) throws IllegalArgumentException {
			if (k == null)
				throw new IllegalArgumentException;
			else
				//???
	}
	
	public K get(K key) throws IllegalArgument {
		// remove this line once complete.
		int i = 0;
		while (i < size) {
			
			if (value[i] != null){
				return values[i].get(k);
			} else throw new IllegalArgument;
			
			i++;
			
			
		}	
	}
	
	public Set<K> getPredecessors(K key) {
		// return the set of keys that are immediate requirements for given keys.
	}
	
	public Set<K> getSuccessors(K key) {
		// return the set of keys that are immediately dependent on the given key
	}
	public void addDependency (K kReq, K kDep ) {
		//Reece Code
	}

	public void removeDependency (K kReq, K kDep) {
	}
	
	public boolean isEmpty() {// return verticesVariable == null; 
	}

	public boolean containsKey (K key) {
	}

	public boolean containsValue (int val) {
	}

	public boolean isDependent (int kOne, int kTwo) {
	}

	public Object clone() { // return clonedMap;
	}
	

	public boolean equals(Object o) {
	}

	public void getKeySet() throws IllegalArgument {
		return keys;
	}

	public void getDependents(K key) throws IllegalArgument {
	}

	public getRequirements(K key) throws IllegalArgument {
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
}
