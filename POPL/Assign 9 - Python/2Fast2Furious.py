d = lambda x, y: x - y


def getMyFine(speed, limit):
    fine = 0
    if d(speed, limit) <= 0:
        return fine
    elif d(speed, limit) <= 5:
        return fine + 200
    elif d(speed, limit) <= 20:
        # calculate the 500 per each km per hour over
        fine = (d(speed, limit) - 5) * 500 + 200
        return fine
    elif d(speed, limit) <= 400:
        # calculate the 1000 per each km per hour over and 20 * 500 after +5
        fine = (d(speed, limit) - 25) * 1000 + (20 * 500) + 200
        return fine
    else:
        return 0  # they have achieved 2fast2furious

try:
    print("Enter the speed limit followed by your current speed")
    speed_limit = float(input())
    current_speed = float(input())
    if(speed_limit < 0 or current_speed < 0):
        raise OverflowError
    print("$", getMyFine(current_speed, speed_limit))
except ValueError:
    print("Value Error. You entered a non decimal value for speed. Curtis says you can't do that")
except OverflowError:
    print("You can't use numbers less than 0 (even if you're driving backwards)")


    # $0 for any speed equal or below the speed limit
    # $200 for any speeds less than 5 km per hour above the speed limit
    # $500 for every additional km per hour between 5 and 20 km per hour above the speed limit
    # $1000 for every additional km per hour above over 20 km per hourabove the speed limit
    # $0 for any speed greater than 400 km per hour (You are in a Bugattiso they can’t catch you