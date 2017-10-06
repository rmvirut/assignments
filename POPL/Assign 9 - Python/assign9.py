#version 3.6.1
#answers to question 1 and 2

def fOnly(listItem):
    return [x for x in listItem if isinstance(x, float)]

def fNonPrimes(n):
    return filter(lambda x: x % 2==0 and x % 3==0, range(0, n+1))