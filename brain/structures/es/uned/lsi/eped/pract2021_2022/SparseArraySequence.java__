package structures.es.uned.lsi.eped.pract2021_2022;

import structures.es.uned.lsi.eped.DataStructures.Collection;
import structures.es.uned.lsi.eped.DataStructures.IteratorIF;
import structures.es.uned.lsi.eped.DataStructures.List;

public class SparseArraySequence<E> extends Collection<E> implements SparseArrayIF<E> {

	protected List<IndexedPair<E>> sequence;

	SparseArraySequence() {
		sequence = new List<>();
	}

	private class IndexIterator implements IteratorIF<Integer> {

		IteratorIF<IndexedPair<E>> iterator;

		IndexIterator(){
			this.iterator = sequence.iterator();
		}

		public Integer getNext() {
			return this.iterator.getNext().getIndex();
		}

		public boolean hasNext() {
			return this.iterator.hasNext();
		}

		public void reset() {
			this.iterator.reset();
		}

	}

	private class Iterator implements IteratorIF<E> {

		IteratorIF<IndexedPair<E>> iterator;

		Iterator(){
			this.iterator = sequence.iterator();
		}

		public E getNext() {
			return this.iterator.getNext().getValue();
		}

		public boolean hasNext() {
			return this.iterator.hasNext();
		}

		public void reset() {
			this.iterator.reset();
		}

	}

	private class Searcher {
		Integer position = -1;
		boolean found = false;
	}

	private void getCurrentPosition(int index, Searcher searcher) {

		IteratorIF<Integer> iterator = indexIterator();
		int pos = 0;
		boolean found = false;
		boolean passed = false;
		while(iterator.hasNext() && !found && !passed) {
			pos++;
			Integer itI = iterator.getNext();
			found = itI == index;
			passed = itI > index;
		}

		searcher.found = found;

		if (found || passed) {
			searcher.position = pos;
			return;
		} else {
			searcher.position = size() + 1;
		}

	}

	private int getCurrentValuePosition(E value) {

		IteratorIF<E> iterator = iterator();
		int pos = -1;
		boolean found = false;
		while(iterator.hasNext() && !found) {
			pos++;
			E itV = iterator.getNext();
			found = itV.equals(value);
		}
		return found ? pos : -1;
	}

	@Override
	public IteratorIF<E> iterator() {
		return new Iterator();
	}

	@Override
	public void set(int pos, E elem) {

		IndexedPair<E> pair = new IndexedPair<E>(pos, elem);

		Searcher s = new Searcher();
		getCurrentPosition(pos, s);
		if (s.found) {
			sequence.set(s.position, pair);
		} else {
			sequence.insert(s.position, pair);
			size++;
		}

	}

	@Override
	public E get(int pos) {

		Searcher s = new Searcher();
		getCurrentPosition(pos, s);
		if (s.found) {
			return sequence.get(s.position).getValue();
		}
		return null;
	}

	@Override
	public void delete(int pos) {

		Searcher s = new Searcher();
		getCurrentPosition(pos, s);
		if (s.found) {
			sequence.remove(s.position);
			size--;
		}
	}

	@Override
	public IteratorIF<Integer> indexIterator() {
		return new IndexIterator();
	}

	@Override
	public boolean contains(E e) {
		int i = getCurrentValuePosition(e);
		return i != -1;
	}

	public void clear() {
		sequence.clear();
		super.clear();
	}
}
