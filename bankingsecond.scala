import java.sql.{Connection,DriverManager}

class bankapp{
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")
	var statement=connection.createStatement

	def create(choice:String)={	
		try{	
			if(choice=="1"){
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
					println("Your account has been successfully created.")
					goodbye()
				}
				else{
					goodbye()
				}
			}
			if(choice!="1" && choice!="2" && choice!="3"){
				var choExc=new Exception
				throw choExc
			}
		}
		catch{
			case choExc: Exception => println("Incorrect key input")
			case e: Exception => println(e)
		}
	}
		
	def update(choice:String)={
		try{
			if(choice=="2" || choice=="3"){
				println("Please input your account number")
				var acc=scala.io.StdIn.readInt()
				var user=statement.executeQuery("SELECT name,address FROM personal WHERE AccNo='"+acc+"'")
				if(user.next){
					println("Welcome back "+user.getString("name")+" from "+user.getString("address"))
					println("Your balance is: £"+balance(acc))
				}
				else{
					println("Account Number does not exist. Please restart.")
					goodbye()
				}
				var cho=choice
				choice match{
					case "2" => cho="deposit"
					case "3" => cho="withdraw"
				}
				println("Enter amount to "+cho)
				var amount=scala.io.StdIn.readInt()
				if((amount*0)!=0){
					var ref=new Exception
					throw ref
				}
				if(cho=="withdraw" && amount>balance(acc)){
					println("You cannot withdraw more than your balance.")
					goodbye()
				}
				println("Are you sure? y/n?")
				var yn=scala.io.StdIn.readLine()
				if(yn=="y"){
					statement.executeUpdate("INSERT INTO "+cho+" VALUES('"+acc+"','"+amount+"',SYSDATE())")
					println("Your account has been updated. Your new balance is: £"+balance(acc))
					goodbye()
				}
				else{
					goodbye()
				}
			}
		}
		catch{
			case ref: Exception => println("Incorrect Input; value is not a number.")
			case e: Exception => println(e)
		}
	}
	def balance(num:Int):Int={
		var depx=statement.executeQuery("SELECT SUM(amount) FROM deposit WHERE AccNo="+num)
		depx.next
		var depbal=depx.getInt("SUM(amount)")
		var witx=statement.executeQuery("SELECT SUM(amount) FROM withdraw WHERE AccNo="+num)
		witx.next
		var witbal=witx.getInt("SUM(amount)")
		depbal-witbal		
	}
	def goodbye()={
		println("--------------------------")
		sys.exit(0)
		//connection.close
	}
}		

def start(){
	var ref=new bankapp()
	println("--------------------------")
	println("Which service do you require?")
	println("1: Create Account.")
	println("2: Deposit.")
	println("3: Withdraw.")
	var choice=scala.io.StdIn.readLine()
	ref.create(choice)
	ref.update(choice)
}

start()