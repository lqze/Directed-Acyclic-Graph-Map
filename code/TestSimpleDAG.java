import CITS2200.*;
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
public class TestSimpleDAG extends DirAcycGraph {
	/**
	 * A setup method for the Test methods
	 */
	@Before
	public void setup() {
		DAGMap<Key, Value> dm = new DAGMAP<Key, Value>();
		rootKey = null;
		Set<Key> keySet = new HashSet<Key>();
		
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
	 * testRemove tests that for any given vertex, it is successfully removed
	 * and the vertex's no longer has a dependent or requirement.
	 */
	@Test
	public void testRemove(expected=IllegalArgumentException.class)
	{
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
	
	// The following methods still need test cases

	/**public Set<Key> getPredecessors(Key k) throws IllegalArgumentException
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
	
	public boolean isEmpty() { return rootNode == null; }

	public boolean containsKey (Key k) { return k != null; }

	public boolean containsValue (V value)
	{
		// check if DAGMap contains value
		//   traverse/explore the entire map of key
		for(Key curKey : getKeySet)
			if (curKey.value == value)
				return true;
		return false; // if no true is returned after searching through graph
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
	**/
}