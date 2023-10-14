fun main(args: Array<String>) {
    println("Введите сумму перевода: ")
    val inputSum = Integer.valueOf(readLine())
    var cardType: Int = 1 // VK Pay
    var currentMonthPreviousTransactionsSum: Double = 0.0
    var transactionSum = inputSum
    val amount: Double = calculateCharge (cardType, currentMonthPreviousTransactionsSum, transactionSum)
    println("Комиссия за перевод составляет " + amount + " рублей")

}


fun calculateCharge (cardType: Int = 1, currentMonthPreviousTransactionsSum: Double = 0.0, transactionSum: Int): Double {
    var charge: Double = 0.0
    if (cardType == 1) { // VK Pay
        if (transactionSum > 15000 || currentMonthPreviousTransactionsSum + transactionSum > 40000) {
            println("Вами был превышен лимит переводов") }
        else {
            charge = 0.0
        }
    }
    else if (cardType == 2 || cardType == 3) { // Mastercard и Maestro
        var masMaesCharge = transactionSum * 0.006 + 20
        if (transactionSum > 150000 || currentMonthPreviousTransactionsSum + transactionSum > 600000) {
            println("Вами был превышен лимит переводов")
        } else if (currentMonthPreviousTransactionsSum + transactionSum > 75000) {
            charge = masMaesCharge
        } else {
            charge = 0.0
        }

    } else if (cardType == 4 || cardType == 5) { // Visa и Мир
        var viMirCharge = transactionSum * 0.0075
        if (transactionSum > 150000 || currentMonthPreviousTransactionsSum + transactionSum > 600000) {
            println("Вами был превышен лимит переводов")
        } else if (viMirCharge < 35) {
            viMirCharge = 35.0
        }
        charge = viMirCharge
    }
    return charge
}