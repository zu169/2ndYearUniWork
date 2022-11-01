
import locale
locale.setlocale(locale.LC_ALL, 'en_GB')
#question 1
def sum():
    num1 = int(input("Please input a number: "))
    num2 = int(input("Please input another number: "))
    return num1 + num2

#question 2
def dictionary(stock, price, cymraeg):
    customer1 = ["apple", "orange", "apple", "beetroot", "beetroot"]
    totalprice = 0
    orderprice = 0
    newsmoothie = ""
    #part a
    for key, value in stock.items():
        totalprice += (price[key] * value)
    print(f"Total stock value: {locale.currency(totalprice)}")
    #part b
    for item in customer1:
        stock[item] = stock[item] - 1
        orderprice += price[item]
    print(f"Customer's bill: {locale.currency(orderprice)}")
    print(f"Updated stock: {stock}")
    #part c
    newsmoothie = input("Please enter the english name for the new smoothie: ")
    cymraeg[newsmoothie] = input(f"Enter the Welsh word for {newsmoothie}: ")
    stock[newsmoothie] = int(input(f"Enter the amount of stock for the {newsmoothie} smoothie: "))
    price[newsmoothie] = int(input(f"Please enter the price of the {newsmoothie} smoothie: "))
    #part d
    print("English menu: ") 
    for key in stock.keys():
        print(f"{key} smoothie: {locale.currency(price[key])}, ") 
    print("Welsh menu: ")
    for key in stock.keys():
        print(f"{cymraeg[key]} smwddi: {locale.currency(price[key])}, ") 
    
stock = {
    "apple": 10,
    "strawberry": 35,
    "orange": 9,
    "beetroot": 20,
    "carrot": 13
    }

price = {
    "apple": 1.4,
    "strawberry": 2.0,
    "orange": 1.0,
    "beetroot": 2.5,
    "carrot": 1.2
}

cymraeg = {
    "apple": "afal",
    "strawberry": "mefus",
    "orange": "oren",
    "beetroot": "betys",
    "carrot": "moron"
}

print(sum())
dictionary(stock, price, cymraeg)