package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public int leftChildIndex(int currentIndex) {
	    if(currentIndex == 0) {
	        return 1;
        }
        return (2 * currentIndex) - 1;
    }

    public int rightChildIndex(int currentIndex) {
	    if(currentIndex == 0) {
	        return 2;
        }
        return 2 * currentIndex;
    }

    private void swapTopWithLastElement() {
        Double maxValue = top();
        Double lastValue = tab.get(heapSize-1);
        tab.set(0, lastValue);
        tab.set(heapSize-1, maxValue);
    }

    private void restoreHeapFromTop() {
        int parent = 0;
        while(true) {
            if(leftChildIndex(parent) > (heapSize - 1)) {
                break;
            }
            if(isChildGreaterThanParent(leftChildIndex(parent), parent)) {
                swapElements(leftChildIndex(parent), parent);
                parent = leftChildIndex(parent);
            }
            else if(isChildGreaterThanParent(rightChildIndex(parent), parent)) {
                swapElements(rightChildIndex(parent), parent);
                parent = rightChildIndex(parent);
            }
        }
    }

	public double extractMax() {
        swapTopWithLastElement();
	    Double maxValue = tab.remove(heapSize - 1);
        heapSize--;
        restoreHeapFromTop();
	    return maxValue;
    }

    public void deleteMax() {
	    swapTopWithLastElement();
	    tab.remove(heapSize - 1);
	    heapSize--;
	    restoreHeapFromTop();
    }

    public void replace(double value) {
	    tab.set(0, value);
	    restoreHeapFromTop();
    }

    public void heapify(Collection<Double> collection) {
        for(Double n : collection) {
            insert(n);
        }
    }

    public ArrayList<Double> getTab() {
        return tab;
    }

    public void merge(Heap h1, Heap h2) {
	    ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.addAll(h1.getTab());
        arrayList.addAll(h2.getTab());
        heapify(arrayList);
    }

    public void meld(Heap h2) {
	    for(Double n : h2.getTab()) {
	        insert(n);
        }
    }
}
