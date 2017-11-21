a = 5230
k = 551
b = 990


def calculate(base, exponent, mod):
    iterate = 1
    figure = base % mod
    total = figure
    while iterate < exponent:
        total = figure * total
        iterate-1
    return total


print calculate(a, k, b)