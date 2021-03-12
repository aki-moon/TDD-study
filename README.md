# Study-OOP
オブジェクト指向について学習しながら、実際にjavaでソースコードを書いてみるためのリポジトリ。

## 自動販売機のエクササイズを使用して、実際にjavaでソースコードを書いてみる。
1. As a vendor
I want a vending machine that accepts coins
So that I can collect money from the customer

The vending machine will accept valid coins (nickels, dimes, and quarters) and reject invalid ones (pennies). When a valid coin is inserted the amount of the coin will be added to the current amount and the display will be updated. When there are no coins inserted, the machine displays INSERT COIN. Rejected coins are placed in the coin return.

NOTE: The temptation here will be to create Coin objects that know their value. However, this is not how a real vending machine works. Instead, it identifies coins by their weight and size and then assigns a value to what was inserted. You will need to do something similar. This can be simulated using strings, constants, enums, symbols, or something of that nature.

※ https://github.com/guyroyse/vending-machine-kata

