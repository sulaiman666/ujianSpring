-seleksi company_budget yg amount di atas 5000000
http://localhost:8085/budget/getabove

- Seleksi company budget yg amountnya sesuai keinginan user
http://localhost:8085/budget/getabovevalue/{userinput}
example : http://localhost:8085/budget/getabovevalue/1000000

-seleksi company_budget yg amount minus
http://localhost:8085/budget/getindebt

-seleksi company berdasarkan address nya
http://localhost:8085/company/getbyaddress/{userInput}
example : http://localhost:8085/company/getbyaddress/ala

-seleksi user berdasarkan id company
http://localhost:8085/user/findusercompanyid/{userInput}
example : http://localhost:8085/user/findusercompanyid/1

-seleksi user berdasarkan namanya
http://localhost:8085/user/finduserbyname/{userInput}
example : http://localhost:8085/user/finduserbyname/s


-seleksi transaction yg tipe nya R
http://localhost:8085/transaction/gettransactiontyper

-seleksi transaction yg tipe nya S
http://localhost:8085/transaction/gettransactiontypes

- Seleksi transaction berdasarkan input user
http://localhost:8085/transaction/gettransactiontype/{userInput}
example : http://localhost:8085/transaction/gettransactiontype/r




// Insert

===Company===

- Insert company satu satu
http://localhost:8085/company/addcompany
Json: 
{
    "company_name": "a",
    "company_address": "Jakarta Selatan"
}

- Insert company list
http://localhost:8085/company/addcompanys
Json:
[
    {
        "company_name" : "a",
        "company_address" : "Jakarta Selatan"
    },
    {
        "company_name" : "a",
        "company_address" : "Jakarta Selatan"
    }
]



===Budget===

- Insert budget satu satu
http://localhost:8085/budget/addbudget
Json: 
{
    "budget_company_id": 4,
    "budget_amount": 3500000
}

- Insert budget list
http://localhost:8085/budget/addbudgets
Json:
[
    {
        "budget_company_id": 6,
        "budget_amount": 6500000
    },
    {
        "budget_company_id": 7,
        "budget_amount": 2500000
    }
]



===User===

- Insert user satu satu
http://localhost:8085/user/adduser
Json: 
{
    "user_name": "Lieur",
    "user_email": "adadaaja@gmail.com",
    "user_instagram": "ada6598",
    "user_company_id": 7
}

- Insert user list
http://localhost:8085/user/addusers
Json:
[
    {
        "user_name": "Lieur",
        "user_email": "adadaaja@gmail.com",
        "user_instagram": "ada6598",
        "user_company_id": 7
    },
    {
        "user_name": "Aing",
        "user_email": "adadaaja@gmail.com",
        "user_instagram": "ada6598",
        "user_company_id": 6
    }
]




===Transaction===

- Insert transaction satu satu
http://localhost:8085/transaction/addtransaction
Json: 
{
    "transaction_type": "s",
    "transaction_user_id": 10,
    "transaction_company_id": 6,
    "transaction_amount": 1500000,
    "transaction_date": "2021-05-06"
}

- Insert user list
http://localhost:8085/transaction/addtransactions
Json:
[
    {
        "transaction_type": "r",
        "transaction_user_id": 1,
        "transaction_company_id": 1,
        "transaction_amount": 5000000,
        "transaction_date": "2021-05-06"
    },
    {
        "transaction_type": "s",
        "transaction_user_id": 7,
        "transaction_company_id": 7,
        "transaction_amount": 2500000,
        "transaction_date": "2021-05-06"
    }
]
