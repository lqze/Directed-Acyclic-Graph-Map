
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
public class TestSimpleMAX {

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




