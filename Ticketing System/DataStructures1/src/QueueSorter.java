
public class QueueSorter {
	private Node NewRoot; //In case the root of the Linked List changes
	private int Changes = 1; //Count how many changes are done
	private int PrevChanges = 0; //To compare to see if the pointer needs changing
	
	public Node SortNewQueue(Node node, int length){ //This is a Bubble sort algorithm which sorts the queue based on priority. This is only run when a node's priority has been manually changed.
		if(node.Priority == 0 || node == null) { //Check to see if the Root has a priority set, or if the given queue is empty
			System.out.println("Queue is invalid");
			return(node); //Returns the head so no errors are thrown
		}
		else {//If a priority is set then we're good to go
			NewRoot = node; //To make sure the NewHead has a value
			Changes = 1; //Make sure the loop works
			while(Changes != 0) {//Keep looping until no changes has happened. Logically this would mean the list is sorted
				PrevChanges = 0; //Set counter variables to 0
				Changes = 0;
				node = NewRoot; //The head will equal the new Root every loop
				for(int i = 1; i < length; i++) { //Loop through the Linked List, apart from the last element
					if(i > 1 && i < length-1) { //Check if the current node is between 2 and 5 (depending on the length value). This is because 6 pointers need to be changed, due to this being in the mid part of the Linked List
						if(node.Priority > node.Tail.Priority) {//Check if the current node's priority is lower than its tail's (Higher than symbol due to number priority: 1(highest),2,3,4)
							node.Tail.Head = node.Head; //Changing the next node's head pointer to the previous node
							node.Head = node.Tail; //Changing the current node's head pointer to the next node
							node.Tail.Head.Tail = node.Tail;//Changing the previous node's tail pointer to the next node
							node.Tail.Tail.Head = node;//Changing the node next to the next's head pointer to the current node
							node.Tail = node.Head.Tail;//Changing the current node's tail pointer to the node next to the next
							node.Head.Tail = node;//Changing the next node's tail pointer to the current node
							Changes ++;//A change has been made, so this is incremented by 1
						}
					}
					if(i == 1) {//Check if the current node is the Root. If this does need a swap then 4 pointers are changed
						if(node.Priority > node.Tail.Priority) {//Check if the current node's priority is lower than its tail's (Higher than symbol due to number priority: 1(highest),2,3,4)
							node.Tail.Head = node.Head;//Setting the new Root's head to null
							node.Head = node.Tail;//Changing the old Root node's head pointer to the new Root node
							node.Tail = node.Tail.Tail;//Changing the old Root node's tail pointer to the next node after the new Root node
							node.Head.Tail.Head = node;//Changing the node after the new Root node's head pointer to the old Root node
							node.Head.Tail = node;//Changing the new Root node's tail pointer to the old Root node
							NewRoot= node.Head;//The new Root node now replaces the old Root node as the Root
							Changes ++;//A change has been made, so this is incremented by 1
							}
							
						}
					if(i == length-1) {//Check if the current node is 2nd to last. This is because a different form of swapping needs to occur, similar to the Root node.
						if(node.Priority > node.Tail.Priority) {//Check if the current node's priority is lower than its tail's (Higher than symbol due to number priority: 1(highest),2,3,4)
							node.Head.Tail = node.Tail;//Changing the previous node's tail pointer to the last node
							node.Tail.Head = node.Head;//Changing the last node's head pointer to the previous node
							node.Head = node.Tail;//Changing the current node's head pointer to the last node
							node.Tail.Tail = node;//Changing the last node's tail pointer to the current node
							node.Tail = null;//Changing the current node's tail pointer to null, making it the new last node
							Changes ++;//A change has been made, so this is incremented by 1
						}
					}
					
					if(Changes == PrevChanges) {//Seeing if no changes have occurred, if so then it'll increment the List pointer to the next node. If a change has occurred then the pointer is naturally incremented by the node moving along the list
						node = node.Tail;//The head is now the next node in the list
					}
				}
			}
			return(NewRoot);//Return the new Root
		}
	}
	
	public Node SetPriority(Node node, int id, int pri, int length) {//Allows the changing of priority
		Node root = node;//Save the Root node to this variable
		if(node == null) {//Checks if the queue is empty
			System.out.println("Queue is empty!");
		}
		else {//If the queue isn't empty
			for(int i = 1; i <= length; i++) {//Loop Through the whole queue
				if(node.ID == id) {//Check if the node is the right node
					node.Priority = pri;//Change the node's priority to the value given
					root = SortNewQueue(root,length);//Re-sort the queue into correct priority
					break;//Stop the loop, as the task is complete
				}
				node = node.Tail;//Increment the pointer to the next node
				
			}
		}
		return(root);//Return the Root of the queue
	}
	
	public Node Execute(Node node) {//Executes the first item in the queue
		if(node == null) {//Checks if the queue is empty
			System.out.println("Queue is empty!");
		}
		else {
			if(node.Head == null) {//Checks if the node is the first item in the queue
				if(node.Tail == null) {//Checks if it's the last item in the queue
					node = null;//Sets the queue to empty
				}
				else {//If it's not the last item in the queue
					node = node.Tail;//node now equals the 2nd item
					node.Head.Tail = null;//First item now points to nothing
					node.Head = null;//Cuts the first item out of the queue
				}
			}
			else {//If the node isn't the first item in the queue
				System.out.println("This node is not the Root of the queue!");
				while(node.Head != null) {//Finds the first item in the queue
					node = node.Head;
				}
			}
		}
		return(node);//Returns the new queue
	}
	
	public int GetLength(Node node) {//Finds the length of the queue
		int count = 0;//Counter starts at 0
		if(node == null) {//Checks if the queue is empty
			System.out.println("Queue is empty!");
		}
		while(node != null) {//Loop through the whole queue
			count ++;//A node is found, so count goes up by 1
			node = node.Tail;//node now equals the next item in the queue
		}
		return(count);//Return the count total
	}
	
	public Node DeleteNode(Node node, int id) {//Deletes the node with the given ID
		Node Root = node;//Save the Root node
		if(node == null) {
			System.out.println("Queue is empty!");
		}
		while(node != null) {//Loop through the whole queue
			if(node.ID == id) {//If the node has the correct ID
				if(node.Head == null) {//If the node is the first item in the queue
					if(node.Tail == null) {//Checks if node is the last item in the queue
						Root = null;//Sets the queue to empty
					}
					else {
						node = node.Tail;//node now equals the 2nd item in the queue
						node.Head.Tail = null;//First node now points to nothing
						node.Head = null;//First node is cut off of the queue
						Root = node;//New Root node is set
						break;//Break out loop, as task is complete
					}
				}
				else if(node.Tail == null) {//If the node is the last item in the queue
					node = node.Head;//node now equals the 2nd to last item in the list
					node.Tail.Head = null;//The last node now points to nothing
					node.Tail = null;//The last node is cut off of the list
					break;//Break out loop, as task is complete
				}
				else {//If the node is a regular node
					node.Head.Tail = node.Tail;//The previous node's tail pointer now points to the next node
					node.Tail.Head = node.Head;//The next node's head pointer now points to the previous node
					node.Tail = null;//The current node's tail pointer is set to null
					node.Head = null;//The current node's head pointer is set to null
					break;//The selected node is now cut, so we break out the loop
				}
			}
			node = node.Tail;//node now equals the next node
		}
		return(Root);//Return new Root node
	}
	
	public Node InsertNode(Node node, String problem, String creator) {//Inserts a brand new ticket into the queue
		Node Root = node;//Save the Root node
		Node NewNode = new Node();//Make the new node
		int HighestID = 0;//Prepare the ID generation
		if(node == null) {//If the queue is empty
			Root = NewNode;//Set the root to the new node
			Root.Setup(1,problem,creator);//set up the new node
		}
		else {
			while(node != null) {//Creates a unique ID for the new ticket
				if(node.ID >= HighestID) {//Checks for highest current ID and adds 1 to make a new ID
					HighestID = node.ID + 1;
				}
				node = node.Tail;//node now equals the next item in the queue
			}
			NewNode.Setup(HighestID, problem, creator);//Adds data to the new ticket
			node = Root;//node is reset to the start of the queue
			while(node != null) {//Loop through the whole queue
				if(NewNode.Priority < node.Priority) {//Checks if the new node's priority is higher than the current node's priority (Less than symbol due to priority numbers(1 highest,2,3,4)
					if(node.Head == null) {//Checks if the node is the first item in the queue
						node.Head = NewNode;//Current node's head pointer is set to the new node
						NewNode.Tail = node;//New node's tail pointer is set to the current node
						Root = NewNode;//Root is set to the new root node
						break;//Break out of the loop, as the task is complete
					}
					else{//Checks if the current node is any other node than the Root node
						NewNode.Head = node.Head;//New node's head pointer now equals the previous node in the queue
						NewNode.Tail = node;//New node's tail pointer now equals the current node
						NewNode.Head.Tail = NewNode;//Previous node's tail pointer now equals the new node
						NewNode.Tail.Head = NewNode;//Current node's head pointer now equals the new node
						break;//Break out the list, as the task is complete
					}
				}
				else if(node.Tail == null) {//If the new node has lower priority than the other nodes in the queue
					node.Tail = NewNode;//The last node's tail pointer now equals the new node
					NewNode.Head = node;//New node's head pointer now equals the last node in the queue
					break;//The new node has been added to the end of the queue, so we break out the loop
				}
				node = node.Tail;//node now equals the next item in the queue
			}
		}
		return(Root);//Return the new Root node
	}
	
	public void PrintQueue(Node node) {//Allows displaying the queue to the console in any state
		if(node == null) {//If the queue is empty
			System.out.println("No queue given!");
		}
		else {
			System.out.println("Priority    "+"ID    "+"Creator    "+"Owner    "+"Problem");
			while(node != null) {//While not at the end of the queue
				System.out.println("    "+node.Priority+"       "+node.ID+"     "+node.Creator+"       "+node.Owner+"     "+node.Case);
				node = node.Tail;//Pointer changes to the next node
			}
		}
		System.out.println();//Prints a new line after the queue is printed, so that everything is readable if this function is called again
	}
}
