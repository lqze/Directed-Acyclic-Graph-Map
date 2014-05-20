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
	
	/**
	 * DAG operation: adds a directed edge between two vertices, provided no cycle is created
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/	
	public void addDependency (K kReq, K kDep ){
		//Reece Code
	}

	/**
	 * DAG operation: removes an edge between two vertices, if it exists
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/
	public void removeDependency (K kReq, K kDep) {
	}
	
	/**
	 * Tests whether there are any vertices defined in the graph
	 * @return true if and only if there are no vertices in the graph
	 **/
	public boolean isEmpty() {
		// return verticesVariable == null; 
	}

	/**
	 * Tests whether a key is defined in the map, using the equals method
	 * @param k - the key to be tested
	 * @return - true if and only if the key is a vertex of the graph
	 **/
	public boolean containsKey (K key) {
	}

	/** 
	 * @param val, value to be tested
	 * @return true if and only if there is at
	 * least one vertex in the graph with a label equal to value
	 **/
	public boolean containsValue (int val) {
	}


	/**
	 * Tests whether kOne is a requirement for kTwo (or is kTwo dependent on kOne).	
	 * This is defined by either there being an edge from kOne to kTwo, or there being
	 * some other vertex v that is dependent on kOne, where there is an edge from v to kTwo.
	 * @param kOne - the requirement vertex
	 * @param kTwo - the dependent vertex
	 * @return true if and only if kOne is a requirement for kTwo. 
	 * If either key is not an element,
	 * of the graph, return false.
	 **/
	public boolean isDependent (int kOne, int kTwo) {
	}

	/**
	 * Creates a shallow clone of the DAGMap, by cloning the keys (vertices) 
	 * but not the values.
	 * @return - A DAGMap that is equal to the map, but with cloned vertices
	 **/
	public Object clone() {
		// return clonedMap;
	}
	
	/**
	 * Produces an iterator that is guaranteed to process the elements
	 * in some topologically sorted order, where each call to next will 
	 * return the next vertex. That is, the iterator will never return a dependent
	 * vertex until all of the requirements of the vertex have been returned.
	 * @return an iterator that will process the labels of the graph in
	 * topologically sorted order.
	 **/
	public Iterator iterator() {
		public boolean hasNext() {
		}
		
		public next() {
		}
	}

	/**
	 *@param o - the object to be tested
	 *@return true if and only this is equal to
	 **/
	public boolean equals(Object o) {
	}

	/** 
	 *@return the set of vertices in the graph
	 **/
	public getKeySet() throws IllegalArgument {
	}

	/**
	 *@param the vertex on which the returned set must be dependent
	 *@return the set of vertices dependent on key
	 *@exception IllegalArgumentException - if key is not a vertex of DAG
	 **/
	public getDependents(K key) throws IllegalArgument {
	}

	/**
	 *@param key the vertex on which the returned set must meet the requirements
	 *@return the set of vertices required for the key
	 *@exception IllegalArgumentException if key is not a vertex of the DAG
	 **/
	public getRequirements(K key) throws IllegalArgument {
	}

	
	/**
	 *@return the width of the DAGMap
	 **/
	public int getWidth() {
	}

	/**
	 *@return the length of the longest possible path in the DAGMap
	 **/
	public int getLongestPath(){ 
	}

	/**
	 *@param source - the start vertex
	 *@param sink - the end vertex
	 *@return the maximum flow through the DAG
	 */
	public int getMaxFlow(int source, int sink) {
	}

	/**
	 *@override toString in class Object
	 *@return a String representation of the DAGMap
	 */
	public String toString() {
	}
		

}
