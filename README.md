# Investing at the Market #

You have money `M` to invest and a forecast of a commodity price `P` for each month in the coming year. Of course you want profit! Figure out when to buy and sell in order to maximize your profit. You cannot buy a fraction of an item. You can assume that the price will be different each month. If two scenarios exist that result in the same profit, you should choose to buy at the lowest price per unit. You can only make a single purchase. If it is impossible to make a profit given the market trends, you should output `IMPOSSIBLE`.

## Input ##

The first line of input gives the number of cases, `N`. `N` test cases follow. For each test case there will be:

- One line containing the amount of money `M` that you have to invest.
- One line containing a space separated list of 12 integers `P` indicating the price at the beginning of each month.

## Output ##

For each test case, output one line containing `Case #x: ` followed by either the word `IMPOSSIBLE` or three space separated integers:

1. The index `B` of the month when you should buy the goods. An integer between 1 and 11 (inclusive).
1. The index of the month when you should sell the goods. An integer between `(B + 1)` and 12 (inclusive).
1. The amount of profit that your investment plan will return.

## Limits ##

    100 ≤ M ≤ 500
      1 ≤ P ≤ 250 
          N ≤ 200

## Example ##

### Input: ###
    3
    100
    1 2 3 4 5 6 7 8 9 10 11 12
    100
    52 50 25 100 61 63 70 51 71 55 10 5
    100
    200 150 250 132 125 110 210 220 180 176 108 113

### Output: ###

    Case #1: 1 12 1100
    Case #2: 3 4 300
    Case #3: IMPOSSIBLE
