// imports
import java.util.*;
import java.lang.*;

/**
 * DAG Map Assignment Interface and Class
 *  CITS2200 Project
 * 
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 */
 
 public class Key<Value> extends Object
 {
	// properties
	public Value value;
	public LinkedHashSet<Key> successors = new LinkedHashSet<Key>();
	public LinkedHashSet<Key> predecessors = new LinkedHashSet<Key>();
	
	// constructor
	public Object Key ()
	{
		Object key = new Object();
		value = null;
		return key;
	}

	public Set<Key> getSuccessors()
	{
		return successors;
	}
}