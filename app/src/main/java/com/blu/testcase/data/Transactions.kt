package com.blu.testcase.data

import com.blu.testcase.R

object Transactions {
    fun generatingFakeData(): ArrayList<TransactionDto> {
        val transactions = ArrayList<TransactionDto>()
        transactions.add(TransactionDto(1,"افزایش موجودی",System.currentTimeMillis(),
            13650015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(2,"کارمزد",System.currentTimeMillis(),
            20000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(3,"برداشت از خودپرداز",System.currentTimeMillis(),
            20000, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(4,"دریافت از حساب",System.currentTimeMillis(),
            20000, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(5,"انتقال وجه",System.currentTimeMillis(),
            20000, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(6,"کارمزد",System.currentTimeMillis(),
            25000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(7,"افزایش موجودی",System.currentTimeMillis(),
            1265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(8,"برداشت از خودپرداز",System.currentTimeMillis(),
            810000, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(9,"انتقال وجه",System.currentTimeMillis(),
            475132, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(10,"افزایش موجودی",System.currentTimeMillis(),
            98765432, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(11,"کارمزد",System.currentTimeMillis(),
            55000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(12,"برداشت از خودپرداز",System.currentTimeMillis(),
            88800, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(13,"دریافت از حساب",System.currentTimeMillis(),
            145000, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(14,"انتقال وجه",System.currentTimeMillis(),
            258300, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(15,"کارمزد",System.currentTimeMillis(),
            5000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(16,"افزایش موجودی",System.currentTimeMillis(),
            1265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(17,"برداشت از خودپرداز",System.currentTimeMillis(),
            78700, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(18,"کارمزد",System.currentTimeMillis(),
            85000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(19,"افزایش موجودی",System.currentTimeMillis(),
            8265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        return transactions
    }
}