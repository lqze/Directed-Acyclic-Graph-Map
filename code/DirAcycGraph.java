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
	/*	
	public void put(Key k, Value v) throws IllegalArgumentException {
			if (k == null)
				throw new IllegalArgumentException;
			else
				
	}
	*/
	
	public void addDependency (K kReq, K kDep ){
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
