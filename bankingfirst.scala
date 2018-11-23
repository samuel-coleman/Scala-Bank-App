import java.sql.{Connection,DriverManager}

try{
	Class.forName("com.mysql.jdbc.Driver")
	var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")
	var statement=connection.createStatement
	println("--------------------------")
	var acc=0
	
	def start(){
		println("What service do you require?")
		println("1:Create Account")
		println("2:Access Account")
		var choice=scala.io.StdIn.readInt()
		if(choice==1){
			create()
			access()
			depwit()
		}
		if(choice==2){
			access()
			depwit()
		}
	}
	
	def create(){	
		println("Please input your name and address.")
		var username=scala.io.StdIn.readLine()
		var useradd=scala.io.StdIn.readLine()
		println("Do you want to save this record? y/n")
		var save=scala.io.StdIn.readLine()
		if(save=="y"){
			statement.executeUpdate("INSERT INTO personal VALUES(null,'"+username+"','"+useradd+"')")	
			var x=statement.executeQuery("SELECT AccNo FROM personal WHERE name='"+username+"' AND address='"+useradd+"'")
			x.next
			println("Your account number is: "+x.getInt("AccNo"))
			println("Your account has been successfully created. Now enter your starting deposit.")
		}
		else{
			goodbye()
		}
	}
	
	def access(){
		println("Please input your account number")
		acc=scala.io.StdIn.readInt()
		var user=statement.executeQuery("SELECT name,address FROM personal WHERE AccNo='"+acc+"'")
		if(user.next){
			println("Welcome back "+user.getString("name")+" from "+user.getString("address"))
			println("Your balance is: £"+balance())
		}
		else{
			println("Account number does not exist.")
			goodbye()
		}
	}
	
	def update(choice:String){
		var cho=choice
		println("Enter amount to "+cho)
		var amount=scala.io.StdIn.readInt()
		if(cho=="withdraw" && amount>balance()){
			println("You cannot withdraw more than your balance.")
			goodbye()
		}
		println("Are you sure? y/n?")
		var yn=scala.io.StdIn.readLine()
		if(yn=="y"){
			statement.executeUpdate("INSERT INTO "+cho+" VALUES('"+acc+"','"+amount+"',SYSDATE())")
			println("Your account has been updated. Your new balance is: £"+balance())
			goodbye()
		}
	}
	
	def depwit(){
		println("Do you want to deposit or withdraw?")
		println("1:Deposit")
		println("2:Withdraw")
		var choice=scala.io.StdIn.readInt()
		if(choice==1){
			update("deposit")
		}
		if(choice==2){
			update("withdraw")
		}
		else{
			println("Wrong key input please restart")
			goodbye()
		}
	}
	
	def balance():Int={
		var depx=statement.executeQuery("SELECT SUM(amount) FROM deposit WHERE AccNo="+acc)
		depx.next
		var depbal=depx.getInt("SUM(amount)")
		var witx=statement.executeQuery("SELECT SUM(amount) FROM withdraw WHERE AccNo="+acc)
		witx.next
		var witbal=witx.getInt("SUM(amount)")
		depbal-witbal
	}
	
	def goodbye(){
		println("Goodbye")
		println("--------------------------")
		sys.exit(0)
	}
	
	start()
		
} 
catch {
	case e: Exception => println(e)
}
//connection.close