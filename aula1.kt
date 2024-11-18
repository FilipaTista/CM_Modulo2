/* EX2
fun main() {
    println("Use the val keyword when the value doesn't change. \nUse the var keyword when the value can change.\nWhen you define a function, you define the parameters that can be passed to it.\nWhen you call a function, you pass arguments for the parameters.")
}
*/
/* EX3
 fun main() { 
    println("New chat message from a friend");
}

// EX4
fun main() {
  
    val item = "Google Chromecast"
    val discountPercentage = 20
    val offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    
    println(offer)
}

// EX5
fun main() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}

// EX6
 fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = baseSalary + bonusAmount
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}

// EX 7.1
fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val result = firstNumber + secondNumber
    println("$firstNumber + $secondNumber = $result")
}

// EX 7.2 E 7.3 
fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)
	val result2 = subtract(firstNumber, secondNumber)
    val anotherResult2 = subtract(firstNumber, thirdNumber)
    
    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$firstNumber - $secondNumber = $result2")
    println("$firstNumber - $thirdNumber = $anotherResult2")
}

fun add(a: Int, b:Int): Int{
    return a+b   
}
fun subtract(a: Int, b:Int): Int{
    return a-b   
}

// EX 8.1
fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
}
// EX 8.2
fun displayAlertMessage(op: String, em: String):String{
    return "There's a new sign-in request on $op for your Google Account $em."
}

fun main() {
    val operatingSystem = "Chrome OS"
	val emailId = "user_one@gmail.com"
    val operatingSystem2 = "Windows"
    val emailId2 = "user_two@gmail.com"
    val operatingSystem3 = "Mac OS"
    val emailId3 = "user_three@gmail.com"
    
	println(displayAlertMessage(operatingSystem, emailId))
    println()
    println(displayAlertMessage(operatingSystem2, emailId2))
    println()
    println(displayAlertMessage(operatingSystem3, emailId3))
    println()
}
// EX 9
fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories") 
}

fun pedometerStepsToCalories(NumberOfSteps: Int): Double {
    val CaloriesBurnedforEachStep = 0.04
    val TotalCaloriesBurned = NumberOfSteps * CaloriesBurnedforEachStep
    return TotalCaloriesBurned
}

fun main() {
    println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
    println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
    println("Have I spent more time using my phone today: ${compareTime(200, 220)}")
}

fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}
*/
