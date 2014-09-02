
import CITS2200.*;
import java.util.*; //For Map, Set
import org.junit.Before;
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
public class TestSimpleDAGLOCAL {

/*	@Test(expected=IllegalArgumentException.class)
	public void testRemove()
	{
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean[] expected; //	a boolean variable which is set to the expected result.

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key key = new Key();
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

		assertEquals("Failure - Key was not successfully removed", contains(key), !contains(key));
		assertEquals("Failure - Key is still part of successors", successors.contains(key),!successors.contains(key));
		assertEquals("Failure - Key is still part of predecessors", predecessors.contains(key), !predecessors.contains(key));
		
	}
    
	/**
	 * Test to retrieve all the predecessors of a given key.
	 * The expected case is all the predecessors of the given key.
	 */
/*	@Test(expected=IllegalArgumentException.class)
	public void testGetPredecessors()
	{

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();

		boolean[] expected;
		Set predKeys = new HashSet();
		predKeys.add(A);
		predKeys.add(D);
		assertEquals("Failure - not all predecessors wereretrieved", predKeys, getPredecessors(A));
	}
	/**
	 * Test for a given key the correct set of successors is returned
	 */
/*	@Test(expected=IllegalArgumentException.class)
	public void testGetSuccessors()
	{
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		//boolean expected; //	a boolean variable which is set to the expected result.

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
		Set succKeys = new HashSet();
		succKeys.add(B);
		succKeys.add(C);
		assertEquals("Failure - not all successors were retrieved", succKeys, false);
	}
	/**
	 * Test that adding a dependency between two vertices, k1, k2, sets
	 * k2 to have the predecessor k1, and k1 to have the successor k2.
	 */
/*	@Test(expected=IllegalArgumentException.class)
	public void testAddDependency ()
	{

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();

		Set<Key> succKeys = new HashSet<Key>();
		Set<Key> predKeys = new HashSet<Key>();
		succKeys.add(B);
		succKeys.add(C);
		predKeys.add(A);
		predKeys.add(D);
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean expected; //	a boolean variable which is set to the expected result.

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
		// test that B has predecessor A and successor D
		expected = ( (succKeys.contains(D)) && (predKeys.contains(A)) );
		
		assertEquals("Fail - incorrect child||parents returned", expected, !expected); 
	}

	/**
	 * Test that removing a dependency between two vertices, changes the state
	 * of the successors and predecessors of the vertices.
	 */
/*	@Test(expected=IllegalArgumentException.class)
	public void testRemoveDependency ()
	{
	//..	
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean expected; //	a boolean variable which is set to the expected result.

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
		Set succKeys = new HashSet();
		Set predKeys = new HashSet();
		succKeys.add(B);
		succKeys.add(C);
		predKeys.add(A);
		predKeys.add(D);
		// test that B no longer has predecessor A and successor D
		// after removing it
		expected = ( !(succKeys.contains(D)) );
		//expected2 = ( !(predKeys.contains(A)) );
		assertEquals("Fail - A is still predecessor of B", expected, true);
	//	assertEquals("Fail - D is still a successor of B", expected2, removeDependency(B, D));	
	}
	/* May not need to test isEmpty..
	public boolean isEmpty() { return rootNode == null; }
	*/
	
	/**
	 * Test that a given key is contained in the DAGMap
	 */
/*	@Test
	public void testContainsKey() {
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean expected; //	a boolean variable which is set to the expected result.

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key key = new Key();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "vil");
		dm.put(F, "hiyaya");
		expected = ( dm.containsKey(A) );
		
		assertEquals("Fail - DM does not contain element A", A, expected);
	}
	/**
	 * Test that any key in the DAGMap contains the given value.
	 */
/*	@Test
	public void testContainsValue()
	{
		// check if DAGMap contains value
		//   traverse/explore the entire map of key
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean expected; //	a boolean variable which is set to the expected result.
		//Value Beepis = new Value();
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key key = new Key();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "vil");
		dm.put(F, "hiyaya");
		assertEquals("Failure - incorrect value returned", "one", true);
		assertEquals("Failure - incorrect value returned", 2, true);
		//assertEquals("Failure - incorrect value returned", Beepis, containsValue(Beepis) );
	
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
		DirAcycGraph dm = new DirAcycGraph();
		Key rootKey = new Key();
		rootKey = null;
		boolean[] expected; //	a boolean variable which is set to the expected result.
		Set trueKeySet = new HashSet();
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key key = new Key();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		trueKeySet.add(A);
		trueKeySet.add(B);
		trueKeySet.add(C);
		trueKeySet.add(D);
		assertEquals ("Not all Keys returned", trueKeySet, dm.getKeySet());
	}

	/**
	 * Test the getWidth method
	 */
/*	@Test
	public void testGetWidth() {
	assertEquals ("Width of dag should be: 3\nWidth Returned: " + , 3, )
	}

	/**
	 * Test the getLongestPath method.
	 */
	@Test
	public void testGetLongestPath() {

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "ennis");
		dm.put(F, "ennis");
		dm.put(G, "ennis");
		dm.addDependency(A, B);
		dm.addDependency(B, C);
		dm.addDependency(B, D);
		//dm.addDependency(D, F);
		dm.addDependency(C, E);
		//dm.addDependency(E, F);
		dm.addDependency(G, F);
		assertEquals("Failure - Get LP = 4", 3, dm.getLongestPath());
	}
	@Test
	public void testGetLongestPathSmaller() {

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "ennis");
	
		dm.addDependency(A, B);
		dm.addDependency(B, C);
		dm.addDependency(C, D);
		dm.addDependency(D, E);

		assertEquals("Failure - Get LP = 3", 4, dm.getLongestPath());
	}
@Test
	public void testGetLongestPathSmallest() {

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.addDependency(A, B);
		dm.addDependency(B, C);
		assertEquals("Failure - Get LP = 2", 2, dm.getLongestPath());
	}
	/**
	 * Test the getMaximumFlow method.
	 */
	@Test
	public void testGetMaxFlow() {
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "ennis");
		dm.put(F, "ennis");
		dm.put(G, "ennis");
		dm.addDependency(A, B);
		dm.addDependency(B, C);
		dm.addDependency(B, D);
		dm.addDependency(D, F);
		dm.addDependency(C, E);
		dm.addDependency(E, F);
		dm.addDependency(G, F);
		assertEquals("Failure - MaxFlow = 1", 1, dm.getMaxFlow(A, F));

	}
	@Test
	public void testGetMaxFlowTwo() {
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "ennis");
		dm.put(F, "ennis");
		dm.put(G, "ennis");
		dm.addDependency(A, B);
		dm.addDependency(B, C);
		dm.addDependency(B, D);
		dm.addDependency(D, F);
		dm.addDependency(C, E);
		dm.addDependency(E, F);
		dm.addDependency(G, F);
		assertEquals("Failure - MaxFlow = 2", 2, dm.getMaxFlow(B, F));

	}
	@Test
	public void testGetMaxFlowThree() {

		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key G = new Key();
		Key H = new Key();
		Key L = new Key();
		DirAcycGraph dm = new DirAcycGraph();
		dm.put(A, "one");
		dm.put(B, "bee");
		dm.put(C, "hello");
		dm.put(D, "ennis");
		dm.put(E, "ennis");
		dm.put(F, "ennis");
		dm.put(G, "ennis");
		dm.put(H, "v");
		dm.put(L, "v");
		dm.addDependency(A, D);
		dm.addDependency(B, C);
		dm.addDependency(D, E);
		dm.addDependency(C, E);
		dm.addDependency(E, G);
		dm.addDependency(E, H);
		dm.addDependency(E, F);
		dm.addDependency(H, L);
		dm.addDependency(G, L);
		assertEquals("Failure - A,L-MaxFlow = 1", 1, dm.getMaxFlow(A, L));
		assertEquals("Failure - B,L-MaxFlow = 1", 1, dm.getMaxFlow(B, L));
	}
 
}




