package com.blu.testcase.data

import com.blu.testcase.R

object Transactions {
    fun generatingFakeData(): ArrayList<TransactionDto> {
        val transactions = ArrayList<TransactionDto>()
        transactions.add(TransactionDto(1,"افزایش موجودی",1664828725,
            13650015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(2,"کارمزد",1664728725,
            20000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(3,"برداشت از خودپرداز",1664728725,
            20000, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(4,"دریافت از حساب",1664628725,
            20000, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(5,"انتقال وجه",1664528725,
            20000, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(6,"کارمزد",1664428725,
            25000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(7,"افزایش موجودی",1655828725,
            1265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(8,"برداشت از خودپرداز",1664458725,
            810000, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(9,"انتقال وجه",1664418725,
            475132, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(10,"افزایش موجودی",1664458725,
            98765432, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(11,"کارمزد",1664444725,
            55000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(12,"برداشت از خودپرداز",1664114725,
            88800, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(13,"دریافت از حساب",1664024725,
            145000, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(14,"انتقال وجه",1660004725,
            258300, R.drawable.ic_remittance_transfer,TransactionType.TRANSFER_BANK_DEPOSIT))

        transactions.add(TransactionDto(15,"کارمزد",1660000725,
            5000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(16,"افزایش موجودی",1660104725,
            1265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        transactions.add(TransactionDto(17,"برداشت از خودپرداز",1662224725,
            78700, R.drawable.ic_atm,TransactionType.OFFLINE_SHOP))

        transactions.add(TransactionDto(18,"کارمزد",1662344725,
            85000, R.drawable.ic_fee,TransactionType.FEES))

        transactions.add(TransactionDto(19,"افزایش موجودی",1662224725,
            8265015, R.drawable.ic_deposit_gift,TransactionType.WITHDRAW))

        return transactions
    }
}