import java.util.NoSuchElementException;
//-----------------------------------------------------
//Assignment 4
//Question: CellList
//Written by: Michael Nittolo 40203394
//-----------------------------------------------------

/**
 * CellList is a class that is a linked list. It has the CellNode class.
 * @author Gamer
 *
 */
public class CellList {
	/**
	 * CellNode inner class
	 * @author Gamer
	 *
	 */
	public class CellNode {
		CellPhone cell;
		CellNode next;
		public CellNode() {
			cell = null;
			next = null;
		}
		/**
		 * regular constructor
		 * @param cell
		 * @param next
		 */
		public CellNode(CellPhone cell, CellList.CellNode next) {
			super();
			this.cell = cell;
			this.next = next;
		}
		/**
		 * Copy constructor
		 * @param o
		 */
		public CellNode(CellNode o) {
			this.cell = o.cell;
			this.next = o.next;
		}
		//accesor and mutator methods
		public CellPhone getCell() {
			if (cell == null)
				return null;
			return cell;
		}
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}
		public CellNode getNext() {
			return next;
		}
		public void setNext(CellNode next) {
			this.next = next;
		}
		public CellNode clone() {
			return new CellNode(this);
		}
	}
	private CellNode head;
	private int size;
	/**
	 * Default constructor
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}
	public CellNode getHead() {
		return head;
	}

	public void setHead(CellNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Copy construcotr that makes a deep copy
	 * @param o
	 */
	public CellList(CellList o) {
		if (o == null) {
			head = null;
			size = 0;
		}
		CellNode head = new CellNode(o.head);
		CellNode temp = head;
		CellNode end = head;
		while (temp.next != null) {
			end.next = new CellNode(temp.next);
			end = end.next;
			temp = temp.next;
		}
		this.head = head;
		this.size = o.size;
	}
	/**
	 * Adds CellNode to start of CellList
	 * @param cell used to create CellNode
	 */
	public void addToStart(CellPhone cell) {
		CellNode start = new CellNode(cell, null);
		if (this.size <= 0) {
			this.head = start;
			this.size++;
			return;
		} 
		start.next = this.head;
		this.head = start;
		this.size++;
	}
	/**
	 * Adds CellNode to end of CellList
	 * @param cell used to create CellNode
	 */
	public void addToEnd(CellPhone cell) {
		CellNode node = new CellNode(cell, null);
		CellNode temp = this.head;
		if (this.size <= 0) {
			this.head = node;
			this.size++;
			return;
		} 
		while (temp.next!=null) {
			temp = temp.next;
		}
		temp.next = node;
		this.size++;
	}
	/**
	 * Adds CellNode in given index of CellList
	 * @param cell used to create CellNode
	 * @param index index to find the CellNode
	 */
	public void insertAtIndex(CellPhone cell, int index) {
		CellNode node = new CellNode(cell, null);
		CellNode temp = this.head;
		if (index < 0 || index > size) {throw new NoSuchElementException();}
		if (index == 0) {this.addToStart(cell); return;}
		if (index == size) {this.addToEnd(cell); return;};
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}
	/**
	 * deletes CellNode from start of CellList
	 */
	public void deleteFromStart() {
		this.head = this.head.next;
		this.size--;
	}
	/**
	 * deletes CellNode from end of CellList
	 */
	public void deleteFromEnd() {
		CellNode temp = this.head;
		if (size == 0) return;
		if (size == 1) this.head.next = null;
		while (temp.next.next!=null) {
			temp = temp.next;
		}
		temp.next = null;
		this.size--;
	}
	/**
	 * deletes CellNode from given index of CellList
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		CellNode temp = this.head;
		if (index < 0 || index > size) {throw new NoSuchElementException();}
		if (index == 0) {this.deleteFromStart(); return;}
		if (index == size) {this.deleteFromEnd(); return;};
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		if (index == size-1) {
			temp.next = null;
		}
		else {
			temp.next = temp.next.next;
		}
		this.size--;
	}
	/**
	 * 
	 * @param cell
	 * @param index
	 */
	public void replaceAtIndex(CellPhone cell, int index) {
		CellNode node = new CellNode(cell, null);
		CellNode temp = this.head;
		if (index < 0 || index > size) {throw new NoSuchElementException();}
		if (index == 0) {this.addToStart(cell); return;}
		if (index == size) {this.addToEnd(cell); return;};
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		if (index == size-1) {
			temp.next = node;
			return;
		}
		node.next = temp.next.next;
		temp.next = node;
	}
	/**
	 * 
	 */
	public void showContents() {
		CellNode temp = this.head;
		for (int i = 0 ; i < this.size; i++) {
			System.out.println(temp.cell);
			temp = temp.next;
		}
	}
	/**
	 * returns CellNode if CellNode is found containing given serialNum
	 * @param serialNum
	 * @return
	 */
	public CellNode find(long serialNum) {
		if (this.size == 0)
			return null;
		CellNode temp = this.head;
		while (temp.next != null) {
			if (temp.getCell().getSerialNum() == serialNum)
				return temp;
			temp = temp.next;
		}
		return null;
	}
	/**
	 * returns boolean if CellNode is found containing given serialNum
	 * @param serialNum
	 * @return
	 */
	public boolean contains(int serialNum) {
		if (this.size == 0)
			return false;
		CellNode temp = this.head;
		while (temp.next != null) {
			if (temp.getCell().getSerialNum() == serialNum)
				return true;
			temp = temp.next;
		}
		return false;
	}
	/**
	 * 
	 * @param o
	 * @return
	 */
	public boolean equals(CellList o) {
		if (this.size != o.size)
			return false;
		CellNode temp = this.head;
		CellNode tempo = o.head;
		int count = 0;
		int currentCount = 0;
		while (temp.next != null) {
			while (tempo.next != null) {
				if (tempo.equals(temp))
					count++;
				tempo = tempo.next;
			}
			if (currentCount == count)
				return false;
			currentCount=count;
			temp = temp.next;
		}
		return true;
	}
}
