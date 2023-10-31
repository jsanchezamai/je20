package structures.es.uned.lsi.eped.pract2021_2022;

import structures.es.uned.lsi.eped.DataStructures.BTree;
import structures.es.uned.lsi.eped.DataStructures.BTreeIF;
import structures.es.uned.lsi.eped.DataStructures.Collection;
import structures.es.uned.lsi.eped.DataStructures.IteratorIF;
import structures.es.uned.lsi.eped.DataStructures.Stack;
import structures.es.uned.lsi.eped.DataStructures.StackIF;

public class SparseArrayBTree<E> extends Collection<E> implements SparseArrayIF<E> {

	protected BTreeIF<IndexedPair<E>> btree;

	IndexedPair<E> EMPTY = new IndexedPair<E>(-1, null);

	SparseArrayBTree() {
		btree = new BTree<>();
		btree.setRoot(EMPTY);
	}

	private boolean isEmpty(IndexedPair<E> pair) {
		return pair == null || (pair.getIndex() == -1 && pair.getValue() == null);
	}

	private class Iterator {

		IteratorIF<IndexedPair<E>> iterator;
		IndexedPair<E> actual;

		Iterator(){
			this.iterator = btree.iterator(BTreeIF.IteratorModes.BREADTH);
			actual = siguiente();
		}

		private IndexedPair<E> siguiente() {

			boolean encontrado = false;
			while(iterator.hasNext() && !encontrado) {
				IndexedPair<E> pair = iterator.getNext();
				encontrado = !isEmpty(pair);
				if (encontrado) {
					return pair;
				}
			}
			return null;
		}

		private IndexedPair<E> getNext() {
			IndexedPair<E> elemento = actual;
			actual = siguiente();
			return elemento;
		}

		public boolean hasNext() {
			return actual != null;
		}

		public void reset() {
			this.iterator.reset();
		}

	}

	private class IndexIterator extends Iterator implements IteratorIF<Integer> {

		public Integer getNext() {
			return super.getNext().getIndex();
		}

	}

	private class ValueIterator extends Iterator implements IteratorIF<E> {

		public E getNext() {
			return super.getNext().getValue();
		}

	}

	private StackIF<Boolean> num2bin(int n) {
		Stack<Boolean> salida = new Stack<Boolean>();
		if ( n == 0 ) {
			salida.push(false);
		} else {
			while ( n != 0 ) {
				salida.push((n % 2) == 1);
				n = n / 2;
			}
		}
		return salida;
	}

	private BTreeIF<IndexedPair<E>> write(IteratorIF<Boolean> iterator, BTreeIF<IndexedPair<E>> btree) {

		BTreeIF<IndexedPair<E>> levelTree = null;

		if (iterator.hasNext()) {
			boolean it = iterator.getNext();
			if (it) {
				levelTree = btree.getRightChild();
			} else {
				levelTree = btree.getLeftChild();
			}
			if (levelTree == null) {
				levelTree = new BTree<>();
				levelTree.setRoot(EMPTY);
				if (it) {
					btree.setRightChild(levelTree);
				} else {
					btree.setLeftChild(levelTree);
				}
			}
		}
		if (iterator.hasNext()) {
			return write(iterator, levelTree);
		} else {
			return levelTree;
		}
	}

	private boolean mustDelete(BTreeIF<IndexedPair<E>> btree) {
		return btree != null && (isEmpty(btree.getRoot()) && btree.isLeaf());
	}

	private  BTreeIF<IndexedPair<E>> read(IteratorIF<Boolean> iterator, BTreeIF<IndexedPair<E>> btree, boolean delete)  {

		if (btree == null)  return btree;

		if (iterator.hasNext()) {

			BTreeIF<IndexedPair<E>> it;
			if (iterator.getNext()) {
				it = read(iterator, btree.getRightChild(), delete);
			} else {
				it = read(iterator, btree.getLeftChild(), delete);
			}

			if (delete && mustDelete(btree.getLeftChild())) {
				btree.removeLeftChild();
			}

			if (delete && mustDelete(btree.getRightChild())) {
				btree.removeRightChild();
			}

			return it;

		} else {

			if (delete && !isEmpty(btree.getRoot())) {
				size--;
				btree.setRoot(EMPTY);
			}
		}

		return btree;
	}

	@Override
	public IteratorIF<E> iterator() {
		return new ValueIterator();
	}

	@Override
	public IteratorIF<Integer> indexIterator() {
		return new IndexIterator();
	}

	@Override
	public boolean contains(E e) {

		IteratorIF<E> iterator = new ValueIterator();
		boolean found = false;
		while(iterator.hasNext() && !found) {
			E value = iterator.getNext();
			found = value.equals(e);
		}
		return found;
	}

	@Override
	public void clear() {

		super.clear();
		btree.clear();
	}

	@Override
	public void set(int pos, E elem) {

		BTreeIF<IndexedPair<E>> target;
		target = write(num2bin(pos).iterator(), btree);

		if (isEmpty(target.getRoot())) size++;

		IndexedPair<E> pair = new IndexedPair<>(pos, elem);
		target.setRoot(pair);

	}

	@Override
	public E get(int pos) {
		BTreeIF<IndexedPair<E>> target = read(num2bin(pos).iterator(), btree, false);
		if (target == null || target.getRoot() == null) {
			return null;
		} else {
			return target.getRoot().getValue();
		}
	}

	@Override
	public void delete(int pos) {
		read(num2bin(pos).iterator(), btree, true);
	}

}
