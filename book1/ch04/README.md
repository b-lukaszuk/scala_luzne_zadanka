---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)
5. [Task 5](#task-5)

---

# Task 1

[Go to: Table of contents](#table-of-contents)

## Description

Write two functions that takes four numbers and returns the smallest. The first can use min, but the second cannot.

# Task 2

[Go to: Table of contents](#table-of-contents)

## Description

Write a function that sums all of the digits in an integer number entered by the user. For example, if the user enters 723, the function would return 12 which is equal to 7+2+3.

# Task 3

[Go to: Table of contents](#table-of-contents)

## Description

Write two functions for converting between Cartesian and polar coordinate systems. The first takes x:Double and y:Double and returns a (Double, Double) with r and θ. The second takes r:Double and theta:Double and returns (Double, Double) with x and y. You can use the Math.atan2(y:Double, x:Double) function to get an angle. This avoids the problem of using division when x is zero.

# Task 4

## Description

[Go to: Table of contents](#table-of-contents)

Neglecting air resistance, objects that are thrown or fired into the air travel on a parabolic path of the form $x(t) = v_x t$, $y(t) = − \frac{1}{2} gt^2 + v_y t + h$, where $v_x$ and $v_y$ are the components of the velocity, $g$ is the acceleration due to gravity, and $h$ is the initial height.

Write a function that is passed the speed, the angle relative to the ground, and the initial height of a projectile and results in the distance the projectile will go before it hits the ground with $y(t) = 0$.

# Task 5

[Go to: Table of contents](#table-of-contents)

## Description

Craps is a popular dice game in Las Vegas. Write a program to play a variation of the game, as follows: Ask the player to place a bet on any or all of four sections: the FIELD section; the NUMBER section; OVER or UNDER 7 section; or the 7, 11, or CRAPS section.

If the player placed their bet in the FIELD section:
– The player may be on a 2, 3, 4, 9, 10, 11, or 12.
– If the total of the 2 dice equals a 2, 3, 4, 9, 10, 11, or 12, the player wins.
– If the total of the 2 dice equals 5, 6, 7, or 8, the House wins.

If the player placed their bet in the NUMBER section:
– The player may bet on a 4, 5, 6, 8, 9, or 10.
– If the dice total 4, 5, 6, 8, 9, or 10 the player wins.
– House wins on all other numbers on that roll.

If the player placed their bet in the OVER or UNDER 7 section:
– Player bet that the total of the 2 dice will be either Under 7 or Over 7.
– Both over and under lose to the House if a total of 7 is thrown.

If the player placed their bet in the 7, 11, or CRAPS section:
– The player may bet on a 7, or an 11 or any Craps (dice totaling either 2, 3,
or 12) coming up on the throw of the dice.
– House wins if the number selected does not come up.

Roll two dice. Each die has six faces representing values 1, 2, 3, 4, 5, and 6, respectively. You can generate a random Int between 0 and n in Scala using util.Random.nextInt(n). Check the sum of the two dice and tell the player if they won or if the house won.
