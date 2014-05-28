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
 
 
public class DirAcycGraph<Value> implements DAGMap<Key,Value> {

	/**
	 * DAGMap properties
	 */
	public LinkedHashSet<Key> keySet = new LinkedHashSet<Key>();	// all nodes in graph
	private LinkedHashSet<Key> orphanSet = new LinkedHashSet<Key>();	// all nodes with no requirement nodes

	/**
	 * Constructor Method
	 */
	public Object DirAcycGraph () {
		Object dirAcycGraph = new Object();
		return dirAcycGraph;
	}
	
	public void put(Key newKey, Value newValue) throws IllegalArgumentException
	{
		if (!containsKey(newKey))
		{
			keySet.add(newKey);
			orphanSet.add(newKey);
			newKey.value = newValue;
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
	
	public LinkedHashSet<Key> getPredecessors(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.predecessors;
    	else
    		throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public LinkedHashSet<Key> getSuccessors(Key k) throws IllegalArgumentException
	{
		if(containsKey(k))
			return k.successors;
    	else
    		throw new IllegalArgumentException("Key not defined in graph");
	}
	
	public void addDependency (Key kReq, Key kDep ) throws IllegalArgumentException
	{
		// check that no cycle is being created
		if (!isDependent(kDep, kReq))
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

	public boolean containsKey (Key k) {
		if(!getKeySet().isEmpty()) {
			for(Key eachKey : getKeySet())
				if(eachKey.equals(k)) return true;
		}
		else
			return false;
		return false;
	}

	public boolean containsValue (Value value)
	{
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
				if (!getSuccessors(haystackKey).isEmpty())
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

	public LinkedHashSet<Key> getKeySet() { return keySet; }

	public DirAcycGraph clone() {
		DirAcycGraph newDAG = new DirAcycGraph();

		// copy all keys
		for(Key allKeys : getKeySet())
		{
			newDAG.put(allKeys,allKeys.value);
		}
		for(Key allKeys : getKeySet())
			for(Key dependent : getSuccessors(allKeys))
				newDAG.addDependency(allKeys,dependent);

		return newDAG;
	}

	public boolean equals(DirAcycGraph<Value> otherGraph) throws NullPointerException
	{
		// check if this dagmap equals another dagmap (keys, values, relations)
		if(otherGraph !=  null)
		{
			// if graphs dont contain the same amount of nodes
			if(otherGraph.keySet.size() != keySet.size())
				return false;

			// test the validity of the keys
			for(Key keyInSet : keySet)
			{
				boolean matchesValue = false;
				boolean matchesSuccessors = false;

				// if node does not exist in other set
				if(!otherGraph.containsKey(keyInSet)) return false;

				for(Key keyInOtherSet : otherGraph.keySet)
				{
					// if matching keyset found
					if (keyInOtherSet.value == keyInSet.value)
					{
						// compare sucessors
						matchesSuccessors = getSuccessors(keyInOtherSet).equals(getSuccessors(keyInSet));
						matchesValue = true;
					}
				}
				
				if(!matchesValue || !matchesSuccessors)
					return false;
			}
			return true;
		} else
			throw new NullPointerException("Parameter graph is a null pointer");
	}

	public int getWidth()
	{
		LinkedHashSet<Key> visited = new LinkedHashSet<Key>();
		
		return 0;
	}
	
	public int getLongestPath()
	{
		int curMax = 0;
		int curCount = 0;
		for(Key eachKey : keySet) {
			curCount = getPathToTop(eachKey,0,0);
			if (curCount>curMax) curMax=curCount;
		}
		return curMax;
	}

	public int getPathToTop(Key bottomNode, int currentVal, int currentTop)
	{
		int i = 0;
		int result = 0;
		if(!getPredecessors(bottomNode).isEmpty())
		{
			for(Key eachParent : getPredecessors(bottomNode))
			{
				currentVal -= i++; // for each iteration
				result = getPathToTop(eachParent,++currentVal,currentTop);
			}
		} else {
			if(currentVal>currentTop) currentTop = currentVal;
			return currentVal;
		}
		return result;
	}

	// return the number of paths that do not share a vertex from source to sink
	public int getMaxFlow(Key source, Key sink) {
		Set<Key> markedNodes = new HashSet<Key>();
		return getNextFlow(source, sink, markedNodes);
	}

	private int getNextFlow(Key source, Key sink, Set<Key> markedNodes)
	{
		if(source.equals(sink)) return 1; // return if reached top

		int curFlow = 0;
		for(Key currentParent : getPredecessors(sink))
			if(isDependent(source, currentParent) && !markedNodes.contains(currentParent))
			{
				if(!currentParent.equals(source)) markedNodes.add(currentParent); // mark the node
				curFlow += getNextFlow(source, currentParent, markedNodes); // accumulate recursively
			}
		return curFlow;
	}

	// needs to output keys and values in DAGMap
	// e.g. keys : values
	public String toString()
	{
		// define multi-line outputString
		String outputString = "Key : Value pairs" + "\n";

		// intialise the top-sort iterator
		DAGIterator itr = new DAGIterator();

		// for every top-sorted node
		while(itr.hasNext())
		{
			Key next = itr.next();
			outputString += next+" : "+next.value+"\n";
		}

		outputString += "\n" + "Requirement : Dependent pairs" + "\n";

		for(Key everyKey : keySet)
		{
			if(!getSuccessors(everyKey).isEmpty())
				for(Key successor : getSuccessors(everyKey))
				outputString += everyKey + " : " + successor + "\n";
		}

		return outputString;
	}

	public Iterator<Key> iterator()
	{
		DAGIterator itr = new DAGIterator();
		return itr;
	}
	
	/**
	 * public iterator subclass
	 */
	public class DAGIterator implements Iterator
	{
		int index;
		Set<Key> keyArray;
		Key[] keyToArray;

		public DAGIterator()
		{
			// Constructor
			keyArray = new LinkedHashSet<Key>();
			addToArray(orphanSet);
			keyToArray = keyArray.toArray(new Key[keySet.size()+1]);
			index = 0;
		}

		private void addToArray(Set<Key> currentKeySet)
		{
			for(Key currentKey : currentKeySet)
				if(!keyArray.contains(currentKey))
				{
					keyArray.add(currentKey);
					if(!getSuccessors(currentKey).isEmpty())
						addToArray(getSuccessors(currentKey));
				}
		}

		@Override
		public boolean hasNext()
		{
			return keyToArray[index]!=null;
		}
		
		@Override
		public Key next() throws NoSuchElementException
		{
			if(hasNext())
			{
				return keyToArray[index++];
			} else
				throw new NoSuchElementException("No object exists");
		}

		public void remove()
		{
			// do nothing
		}
	}
}
