
public class Node { //Node class
	int Priority = 0; //The priority of the Node
	Node Head = null; //The Node before this Node
	Node Tail = null; //The Node after this Node
	int ID;//Unique ID
	String Case;//The problem
	String Creator;//Creator of case
	String Owner;//Solver of the problem
	public void Setup(int id, String problem, String creator) { //Setup method for giving the node data
		switch(problem){//Switch statement for choosing priority based on problem and which person sorts which case
		case "Security issue": Priority = 1; Owner = "Grey"; break;
		case "Network issue": Priority = 2; Owner = "Tash"; break;
		case "Software install": Priority = 3; Owner = "Dave"; break;
		case "New computer config": Priority = 4; Owner = "Lill"; break;
		default: Priority = 5; Owner = "Sam"; break; //If not any stated problem, then give priority of 5
		}
		ID = id;
		Case = problem;
		Creator = creator;
	}
}
