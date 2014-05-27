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
 
 
public class DirAcycGraph<Value> {

	/**
	 * DAGMap properties
	 */
	private Set<Key> keySet;	// all nodes in graph
	private Set<Key> orphanSet;	// all nodes with no requirement nodes

	/**
	 * Constructor Method
	 */
	public DirAcycGraph () {
		// initialise empty graph
		keySet = new TreeSet<Key>();
		orphanSet = new TreeSet<Key>();
	}
	
	public void put(Key newKey, Value newValue) throws IllegalArgumentException
	{
		if (!containsKey(newKey))
		{	
			newKey.value = newValue;
			keySet.add(newKey);
			orphanSet.add(newKey);
		}
		else
			throw new IllegalArgumentException("Key contained in graph already, or key is null");
	}
	
	public Object get(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.value;
		else
			throw new IllegalArgumentException("Key not defined in graph");
	}

	public void remove(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
		{
			for(Key eachParent : getPredecessors(k))
				eachParent.successors.remove(k);
			for(Key eachChild : getSuccessors(k))
				eachChild.successors.remove(k);
			keySet.remove(k);
		} else
			throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public Set<Key> getPredecessors(Key k) throws IllegalArgumentException
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
			kDep.predecessors.add(kReq);

			if(orphanSet.contains(kDep))
				orphanSet.remove(kDep);
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
			for (Key node : getSuccessors(kReq))
				kReq.successors.remove(node);

			// remove from set of requirements
			for (Key node : getPredecessors(kDep))
				kDep.predecessors.remove(node);
		}
		else
			throw new IllegalArgumentException("No dependency found between given keys");
	}
	
	public boolean isEmpty() { return keySet.size()==0; }

	public boolean containsKey (Key k) { return k != null; }

	public boolean containsValue (Value value)
	{
		// check if DAGMap contains value
		//   traverse/explore the entire map of key
		for(Key curKey : getKeySet())
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
						if (isDependent(childKey,needleKey)) return true;
				}
				else
					return false;
			}
			return false;
		}
		else
			throw new IllegalArgumentException("One or more parameters do not exist in graph!");
	}

	public Object clone() {
		// shallow clone,
		// copy all keys and dependencies?
		return 0;
	}
	

	public boolean equals(Object o) {
		// check if this dagmap equals another dagmap (keys, values, relations)
		return false ;
	}

	public Set<Key> getKeySet() { return keySet; }

	public int getWidth()
	{
		return 0;
	}

	
	public int getLongestPath()
	{
		int curMax = 0;
		int curCount = 0;
		for(Key eachKey : keySet) {
			curCount = getPathToTop(eachKey,0);
			if (curCount>curMax) curMax=curCount;
		}
		return curMax;
	}

	public int getPathToTop(Key bottomNode, int currentTop)
	{
		int 	levelMax = 0;
		if(!getPredecessors(bottomNode).isEmpty())
		{
			for(Key eachParent : getPredecessors(bottomNode))
			{
				int result = getPathToTop(eachParent,currentTop++);
				if(result>levelMax) levelMax = result;
			}
		} else
			return currentTop;

		return levelMax;
	}

	// return the number of paths that do not share a vertex from source to sink
	public int getMaxFlow(Key source, Key sink)
	{
		int maxFlow = 0;
		Set<Key> flowGraph = new HashSet<Key>();

		for(Key currentParent : getPredecessors(sink))
			if(isDependent(currentParent, source) &&
				!flowGraph.contains(currentParent) &&
				!getSuccessors(currentParent).contains(source))
			{
				flowGraph.add(currentParent);
				maxFlow += getMaxFlow(source, currentParent);
			}
			else return 1;
		return maxFlow;
	}

	// needs to output keys and values in DAGMap
	// e.g. keys : values
	public String toString()
	{
		return "string";
	}
	
	/**
	 * public iterator subclass
	 */
	public class Iterator
	{
		int index;
		Set<Key> keyArray;
		Object[] keyToArray;

		public void iterator(Set<Key> inputKeySet)
		{
			// Constructor
			keyArray = new TreeSet<Key>();
			this.addToArray(inputKeySet);
			keyToArray = keyArray.toArray();
			index = 0;
		}

		private void addToArray(Set<Key> currentKeySet)
		{
			for(Key currentKey : currentKeySet)
				if(!keyArray.contains(currentKey))
				{
					keyArray.add(currentKey);
					if(getSuccessors(currentKey).size() != 0)
						addToArray(getSuccessors(currentKey));
				}
		}

		public boolean hasNext()
		{
			return keyToArray.length > index;
		}
		
		public Object next() throws NoSuchElementException
		{
			if(this.hasNext())
			{
				return keyToArray[index];
			} else
				throw new NoSuchElementException("No object exists");
		}
	}

	public class Key<Key,Value> extends Object {
		public Value value;
		public Set<Key> successors;
		public Set<Key> predecessors;
		
		public Object Key ()
		{
			Object key = new Object();
			value = null;
			successors = new TreeSet<Key>();
			predecessors = new TreeSet<Key>();
			return key;
		}
	}
}