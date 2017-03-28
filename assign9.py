k = [0.12, "kojo", '32.09', 3.029,4534, 2.874,'dfsd']
k2 = 10

def fOnly(listItem):
    return [x for x in listItem if isinstance(x, float)]

def fNonPrimes(n):
    return filter(lambda x: x % 2==0 and x % 3==0, range(0, n+1))

r = fNonPrimes(k2)

print(r)