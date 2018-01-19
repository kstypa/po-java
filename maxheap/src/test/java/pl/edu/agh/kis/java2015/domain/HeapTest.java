package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import com.google.common.primitives.Doubles;
import org.junit.Test;

import java.util.ArrayList;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}

	@Test
    public void extractMaxWhenTopIs6_topIs5AndReturnedValueIs6() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);

        assertEquals(6, heap.extractMax(), 0.001);
        assertEquals(5, heap.top(), 0.001);
        assertEquals(4,heap.size());
    }

    @Test
    public void deleteMaxWhenTopIs6_topIs5SizeIs4() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.deleteMax();

        assertEquals(5, heap.top(), 0.001);
        assertEquals(4, heap.size());
    }

    @Test
    public void replaceWith1WhenTopIs8_topIs7SizeIs5() {
        Heap heap = new Heap();
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(7);
        heap.insert(8);
        heap.replace(1);

        assertEquals(7, heap.top(), 0.001);
        assertEquals(5, heap.size());
    }

    @Test
    public void heapifyList_topIs15SizeIs12() {
        Heap heap = new Heap();
        double[] array = {5,2,7,11,4,12,15,3,1,0,6,8};
        heap.heapify(new ArrayList<>(Doubles.asList(array)));

        assertEquals(15, heap.top(), 0.001);
        assertEquals(12, heap.size());
    }

    @Test
    public void mergeTwoHeaps_topIs33SizeIs19() {
        Heap heap1 = new Heap();
        double[] array1 = {5,2,7,11,4,12,15,3,1,0,6,8};
        heap1.heapify(new ArrayList<>(Doubles.asList(array1)));

        Heap heap2 = new Heap();
        double[] array2 = {20,9,33,17,13,1,5};
        heap2.heapify(new ArrayList<>(Doubles.asList(array2)));

        Heap heap3 = new Heap();
        heap3.merge(heap1, heap2);

        assertEquals(33, heap3.top(), 0.001);
        assertEquals(19, heap3.size());
    }

    @Test
    public void meldHeap2IntoHeap1_topIs33SizeIs19() {
        Heap heap1 = new Heap();
        double[] array1 = {5,2,7,11,4,12,15,3,1,0,6,8};
        heap1.heapify(new ArrayList<>(Doubles.asList(array1)));

        Heap heap2 = new Heap();
        double[] array2 = {20,9,33,17,13,1,5};
        heap2.heapify(new ArrayList<>(Doubles.asList(array2)));

        heap1.meld(heap2);

        assertEquals(33, heap1.top(), 0.001);
        assertEquals(19, heap1.size());
    }

}
