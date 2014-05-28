
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

		DirAcycGraph dm = new DirAcycGraph();
		rootKey = null;
		boolen[] expected; //	a boolean variable which is set to the expected result.

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();

		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "vil");
		dm.put(F, "hiyaya");

		dm.addDependency(A, C);
		dm.addDependency(A, B);
		dm.addDependency(B, D);
		dm.addDependency(C, E);
		
	}
	
	
	/** 
	 * Tests that the corresponding value to a given key is returned correctly.
	 * e.g.: key A should return the value "one".
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGet() {
		assertEquals("Failure - value for A is incorrect", "one", dm.get(A));
	}
	/** 
	 * Tests that for any given vertex, it is successfully removed
	 * and that it is no longer a requirement and/or dependent vertex
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRemove()
	{
		assertEquals("Failure - Key was not successfully removed", contains(k), !contains(k));
		assertEquals("Failure - Key is still part of successors", successors.contains(k),!successors.contains(k));
		assertEquals("Failure - Key is still part of predecessors", predecessors.contains(k), !predecessors.contains(k));
		
	}
    
	/**
	 * Test to retrieve all the predecessors of a given key.
	 * The expected case is all the predecessors of the given key.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetPredecessors()
	{
		boolean[] expecting;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> predKeys = new HashSet<Key>();
		predKeys.add(A);
		predKeys.add(D);
		expecting = ( (containsAll(predKeys)) == (containsAll(getPredecessors(dm.keys)) ) );
		assertEquals("Failure - not all predecessors wereretrieved", expecting, !expecting);
	}
	/**
	 * Test for a given key the correct set of successors is returned
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetSuccessors()
	{
		boolean[] expecting;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> succKeys = new HashSet<Key>();
		succKeys.add(B);
		succKeys.add(C);
		expecting = ( (containsAll(succKeys)) == (containsAll(getSuccessors(dm.keys)) ) );
		assertEquals("Failure - not all successors were retrieved", expecting, !expecting);
	}
	/**
	 * Test that adding a dependency between two vertices, k1, k2, sets
	 * k2 to have the predecessor k1, and k1 to have the successor k2.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddDependency ()
	{
		boolean[] expecting;
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		Set<Key> succKeys = new HashSet<Key>();
		Set<Key> predKeys = new HashSet<Key>();
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
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveDependency ()
	{
	//..	
		boolean[] expected;
		Set<Key> succKeys = new HashSet<Key>();
		Set<Key> predKeys = new HashSet<Key>();
		succKeys.add(B);
		succKeys.add(C);
		predKeys.add(A);
		predKeys.add(D);
		// test that B no longer has predecessor A and successor D
		// after removing it
		expected = ( !(succKeys.contains(D)) );
		expected2 = ( !(predKeys.contains(A)) );
		assertEquals("Fail - A is still predecessor of B", expected, removeDependency(A, B));
		assertEquals("Fail - D is still a successor of B", expected2, removeDependency(B, D));	
	}
	/* May not need to test isEmpty..
	public boolean isEmpty() { return rootNode == null; }
	*/
	
	/**
	 * Test that a given key is contained in the DAGMap
	 */
	@Test
	public void testContainsKey() {
		boolean[] expected;		
		expected = ( dm.contains(A) );
		
		assertEquals("Fail - DM does not contain element A", A, expected);
	}
	/**
	 * Test that any key in the DAGMap contains the given value.
	 */
	@Test
	public void testContainsValue()
	{
		// check if DAGMap contains value
		//   traverse/explore the entire map of key
		assertEquals("Failure - incorrect value returned", "one", containsValue("one") );
		assertEquals("Failure - incorrect value returned", 2, containsValue(2) );
		assertEquals("Failure - incorrect value returned", Beepis, containsValue(Beepis) );
	}
	/**
	 * Tests that there exists a dependency between k1 and k2, where k2 is dependent on k1.
	 */
	/*
	@Test(expected=IllegalArgumentException.class)
	public void testIsDependent ()
	{
		expected = ( (succKeys.contains(D)) && (predKeys.contains(A)) );
		assertEquals = ("Failure - B is not dependent on C", true, isDependent(B, C));
	}
	*/
	
	/**
	 * Tests that all the keys in the DAGMap are returned
	 */
	@Test
	public void testGetKeySet() {
		trueKeySet.add(A);
		trueKeySet.add(B);
		trueKeySet.add(C);
		trueKeySet.add(D);
		assertEquals ("Not all Keys returned", trueKeySet, getKeySet());
	}

	/**
	 * Test the getWidth method
	@Test
	public void testGetWidth() {
	
	}

	*/ 
}




