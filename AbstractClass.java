public class AbstractClass{
	public static void main(String[] args){
		chessPlayer1 obj = new chessPlayer2();
		obj.queen();
		obj.bishop();
		obj.knight();
		obj.rook();
	}
}

abstract class chessPlayer1{
	public void queen(){
		System.out.println("Move Any Direction like King");
	}
	public abstract void bishop();
	public abstract void knight();
	public abstract void rook();
}

class chessPlayer2 extends chessPlayer1{
	public void bishop(){
		System.out.println("Move in any Direction Diagonally");
	}
	public void knight(){
		System.out.println("Move two squares vertically and one square Diagonally");
	}
	public void rook(){
		System.out.println("Move Forward, Backward, or Sideway but not in Diagonal");
	}
}	

		 