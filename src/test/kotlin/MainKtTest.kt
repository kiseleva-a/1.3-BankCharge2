import org.junit.Assert.*

class MainKtTest {

    @org.junit.Test
    fun calculateChargeVkPayOverLimit() {
        var cardType: Int = 1
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 50000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeVkPaySuitable() {
        var cardType: Int = 1
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 10000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeMastercardSuitable() {
        var cardType: Int = 2
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 100000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(620.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeMastercardOverLimit() {
        var cardType: Int = 2
        var currentMonthPreviousTransactionsSum: Double = 510000.0
        var transactionSum = 100000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeMastercardLowerThanLimit() {
        var cardType: Int = 3
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 200

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }


    @org.junit.Test
    fun calculateChargeVisaOverLimit() {
        var cardType: Int = 4
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 200000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeVisaSuitable() {
        var cardType: Int = 4
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 130000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(975.0, result, 0.0)
    }



    @org.junit.Test
    fun calculateChargeMirOverLimit() {
        var cardType: Int = 5
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 400000

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(0.0, result, 0.0)
    }

    @org.junit.Test
    fun calculateChargeMirSuitable() {
        var cardType: Int = 5
        var currentMonthPreviousTransactionsSum: Double = 0.0
        var transactionSum = 34

        val result = calculateCharge(cardType, currentMonthPreviousTransactionsSum, transactionSum)
        assertEquals(35.0, result, 0.0)
    }
}
