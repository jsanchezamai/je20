package structures.es.uned.lsi.eped.DataStructures;

public class List<E> extends Sequence<E> implements ListIF<E> {

	/* Constructor por defecto: crea una lista vacía */
	public List(){
		super();
	}

	/* Constructor por copia: delega en el constructor por copia *
	 * de la secuencia                                           */
    public List(List<E> s) {
    	super(s);
    }

    /* Devuelve el elemento pos-ésimo de la lista */
	public E get(int pos) {
		NodeSequence node = getNode(pos);
		return node.getValue();
	}

	/* Modifica el elemento pos-ésimo de la lista */
	public void set(int pos, E e) {
		NodeSequence node = getNode(pos);
		node.setValue(e);
	}

	/* Inserta un nuevo elemento en la lista en la posición *
	 * indicada                                             */
	public void insert(int pos, E elem) {
		NodeSequence newNode = new NodeSequence(elem);
		if(pos==1){
			newNode.setNext(this.firstNode);
			this.firstNode = newNode;
		}else{
			NodeSequence previousNode = getNode(pos-1);
			NodeSequence nextNode = previousNode.getNext();
			previousNode.setNext(newNode);
			newNode.setNext(nextNode);
		}
		this.size++;
	}

	/* Elimina el elemento pos-ésimo de la lista */
	public void remove(int pos) {
		if(pos==1){
			this.firstNode = this.firstNode.getNext();
		}else{
			NodeSequence previousNode = getNode(pos-1);
			NodeSequence nextNode = previousNode.getNext().getNext();
			previousNode.setNext(nextNode);
		}
		this.size--;
	}

	public void insertarFinal(E elem) {
		NodeSequence newNode = new NodeSequence(elem);

		if (firstNode == null) {
			firstNode = newNode;
		} else { 
			NodeSequence puntero = firstNode;
			puntero.setValue(elem);
			while(puntero.next != null) {
				puntero = puntero.next;
			}
			puntero.next = newNode;
		}

		size++;
	}

	public void insertarFinal2(E elem) {
		NodeSequence newNode = new NodeSequence(elem);

		if (firstNode == null) {
			firstNode = newNode;
		} else {

			NodeSequence puntero = firstNode;
			NodeSequence punteroSiguiente = firstNode.next;
			if (punteroSiguiente == null) {
				firstNode.next = newNode;
			} else {
				while(puntero != null) {
					punteroSiguiente = puntero;
					puntero = puntero.next;
				}
				punteroSiguiente.next = newNode;
			}
		}
		size++;
	}

	public void insertarPrincipio(E elem) {
		NodeSequence newNode = new NodeSequence(elem);

		if (firstNode == null) {
			firstNode = newNode;
		} else {
			
			newNode.next = firstNode;
			firstNode = newNode;
		}
		size++;
	}
}
