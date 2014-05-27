
import CITS2200.*;
import java.util.*; //For Map, Set

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


/**
 * DAG Map Assignment Test Cases
 *  CITS2200 Project
 * 
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 * 
 * Testing class. JUnit tests will be run on the
 * simple methods.
 */
 
@RunWith(JUnit4.class) 
public class TestSimpleDAG{
	/**
	 * A setup method for the Test methods
	 */
	@Before
	public void setup() {
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		rootKey = null;
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "vil");
	}
	/** 
	 * Tests that the corresponding value to a given key is returned correctly.
	 * e.g.: key A should return the value "one".
	 */
	@Test
	public void testGet(expected=IllegalArgumentException.class) {
		Key k = new Key;
		assertEquals("Failure - value for A is incorrect", k.get(A), "one");
	}
	/** 
	 * Tests that for any given vertex, it is successfully removed
	 * and that it is no longer a requirement and/or dependent vertex
	 */
	@Test
	public void testRemove(expected=IllegalArgumentException.class)
	{
		assertEquals("Failure - Key was not successfully removed", contains(k), !contains(k));
		assertEquals("Failure - Key is still part of successors", successors.contains(k),!successors.contains(k));
		assertEquals("Failure - Key is still part of predecessors", predecessors.contains(k), !predecessors.contains(k));
		
	/*	if(containsKey(k))
		{
			// get all edges, removeEdges first
			// then remove key
			keySet.remove(k);
			k.predecessors//remove from
			k.successors//remove from
		} else
	*/
		
	}
    
	/**
	 * Test to retrieve all the predecessors of a given key.
	 * The expected case is all the predecessors of the given key.
	 */
	@Test
	public void testGetPredecessors(expected=IllegalArgumentException.class)
	{
		boolean[] expected;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> predKeys = new HashSet<Key>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.addDepedency(A, D);
		dm.addDepedency(C, D);
		predKeys.add(A);
		predKeys.add(D);
		expecting = ( (containsAll(predKeys)) == (containsAll(getPredecessors(dm.keys)) ) );
		assertEquals("Failure - not all predecessors wereretrieved", expecting, !expecting);
	}
	
	public void testGetSuccessors(expected=IllegalArgumentException.class)
	{
		boolean[] expected;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> succKeys = new HashSet<Key>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.addDependency(A, C);
		dm.addDependency(A, B);
		dm.addDependency(B, D);
		dm.addDependency(C, E);
		succKeys.add(B);
		succKeys.add(C);
		expecting = ( (containsAll(succKeys)) == (containsAll(getSuccessors(dm.keys)) ) );
		assertEquals("Failure - not all successors were retrieved", expecting, !expecting);
	}
	
	public void testAddDependency (expected=IllegalArgumentException.class)
	{
		boolean[] expected;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> succKeys = new HashSet<Key>();
		Set<Key> predKeys = new HashSet<Key>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.addDependency(A, C);
		dm.addDependency(A, B);
		dm.addDependency(B, D);
		dm.addDependency(C, E);
		succKeys.add(B);
		succKeys.add(C);
		predKeys.add(A);
		predKeys.add(D);
		// test that B has predecessor A and successor D
		expected = ( (succKeys.contains(D)) && (predKeys.contains(A)) );
		
		assertEquals("Fail - incorrect child||parents returned", expected, !expected); 
	}

	/**
	 * Test that removing a dependency between two vertices, changes the state
	 * of the successors and predecessors of the vertices.
	 */
	public void testRemoveDependency (expected=IllegalArgumentException.class)
	{
	//..	
		boolean[] expected;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> succKeys = new HashSet<Key>();
		Set<Key> predKeys = new HashSet<Key>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.addDependency(A, C);
		dm.addDependency(A, B);
		dm.addDependency(B, D);
		dm.addDependency(C, E);
		succKeys.add(B);
		succKeys.add(C);
		predKeys.add(A);
		predKeys.add(D);
		// test that B no longer has predecessor A and successor D
		// after removing it
		expected = ( !(succKeys.contains(D)) );
		expected2 = ( !(predKeys.contains(A)) );
		assertEquals("Fail - A is still predecessor of B", expected, removeDependency(A, B);
		assertEquals("Fail - D is still a successor of B", 2expected, removeDependency(B, D);	
	}
	/* May not need to test isEmpty..
	public boolean isEmpty() { return rootNode == null; }
	*/
	
	/**
	 * Test that a given key is contained in the DAGMap
	 */
	public void testContainsKey() {
		boolean[] expected;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		
		expected = ( dm.contains(A) );
		
		assertEquals("Fail - DM does not contain element A", null, expected);
	}
	/**
	 * Test that any key key has the given value
	 */
	public void testContainsValue()
	{
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Value<V> Beepis = new Value<V>();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, 2);
		dm.put(D, Beepis);
		// check if DAGMap contains value
		//   traverse/explore the entire map of key
		assertEquals("Failure - incorrect value returned", "one", containsValue("one") );
		assertEquals("Failure - incorrect value returned", 2, containsValue(2) );
		assertEquals("Failure - incorrect value returned", Beepis, containsValue(Beepis) );
	}

	public void testIsDependent (expected=IllegalArgumentException.class)
	{
		
	}
	
	*/
}
