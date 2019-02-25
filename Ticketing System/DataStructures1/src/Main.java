
public class Main {
	public static void main(String Args[]) {//Main code space
	    QueueSorter Q = new QueueSorter();//Setting up the sorter
		Node Root = null;//Holds the root of the linked list
		int length = 0;//Holds the length of the queue
		
		//This is where the initial data is set. It's set in a muddled order (See Node class and how priorities are set) to prove that the insert algorithm inserts the nodes into correct order.
		Root = Q.InsertNode(Root,"Software install","Jeff");//Priority 3
		Root = Q.InsertNode(Root,"Network issue","Bill");//Priority 2
		Root = Q.InsertNode(Root,"Security issue","Jack");//Priority 1
		Root = Q.InsertNode(Root,"Network issue","Phil");//Priority 2
		Root = Q.InsertNode(Root,"New computer config","Till");//Priority 4
		Root = Q.InsertNode(Root,"Security issue","Paul");//Priority 1
		Root = Q.InsertNode(Root,"Software install","Ryan");//Priority 3
		length = Q.GetLength(Root); //Gets the length of the queue
		
		//Main Program
		Q.PrintQueue(Root);//Print out the new organised queue
		Root = Q.SetPriority(Root,3,4,length);//Change the priority of the node with ID 3 to 4
		Q.PrintQueue(Root);//Print out the new queue
		Root = Q.Execute(Root);//Execute the first item in the queue
		length = Q.GetLength(Root);//Gets the new length of the queue
		Q.PrintQueue(Root);//Print out the new queue
		Root = Q.DeleteNode(Root,7);//Deletes the node with ID of 7
		Q.PrintQueue(Root);//Print out the new queue
		Root = Q.InsertNode(Root,"Security issue","Ivor");//Insert a new node with this data
		Root = Q.InsertNode(Root,"New computer config","Fran");//Insert a new node with this data
		Root = Q.InsertNode(Root,"Software install","Hans");//Insert a new node with this data
		length = Q.GetLength(Root);//Gets the new length of the queue
		Q.PrintQueue(Root);//Print out the new queue
	}
}
