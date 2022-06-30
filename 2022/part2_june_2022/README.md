---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)
5. [Task 5](#task-5)
6. [Task 6](#task-6)
7. [Task 7](#task-7)
8. [Task 8](#task-8)
---

The tasks (Task 1 - Task 5) were copied-pasted from [here](https://github.com/b-lukaszuk/haskell_luzne_zadanka/tree/master/part4_24_06_2021).

# Task 1

[Go to: Table of contents](#table-of-contents)

Write a program that automatically converts English text to Morse code and vice versa.

# Task 2

[Go to: Table of contents](#table-of-contents)

Write a program that finds the longest palindromic substring of a given string. ‘**karak**is’, ‘ba**erre**n’, ‘**kajak**’, ‘**inni**’,’**sedes**’.

# Task 3

[Go to: Table of contents](#table-of-contents)

Given two strings, write a program that efficiently finds the longest common subsequence. ‘ka**rol** **rol**ki’

# Task 4

[Go to: Table of contents](#table-of-contents)

Write a code that multiplies two matrices together. Dimension validation required.

# Task 5

[Go to: Table of contents](#table-of-contents)

Inspired by: [Birthday problem on wiki](https://en.wikipedia.org/wiki/Birthday_problem)

## The problem

Let's say there are 30 people at a party. What is the probability that any two (or more) individuals celebrate their birthday the same day.

## What to do

Write a computer simulation to calculate the probability specified above (say 10k iterations).

## Assumptions

List of assumptions:
+ every year got exactly 365 days
+ people's births are distributed equaly throughout the year (uniform distribution)

# Task 6

[Go to: Table of contents](#table-of-contents)

[100 prisoners on rosettacode webpage](https://rosettacode.org/wiki/100_prisoners)

## The Problem

100 prisoners are individually numbered 1 to 100

A room having a cupboard of 100 opaque drawers numbered 1 to 100, that cannot be seen from outside.

Cards numbered 1 to 100 are placed randomly, one to a drawer, and the drawers all closed; at the start.

Prisoners start outside the room
- They can decide some strategy before any enter the room.
- Prisoners enter the room one by one, can open a drawer, inspect the card number in the drawer, then close the drawer.
- A prisoner can open no more than 50 drawers.
- A prisoner tries to find his own number.
- A prisoner finding his own number is then held apart from the others.
- If all 100 prisoners find their own numbers then they will all be pardoned. If any don't then all sentences stand.

## What to do

Simulate several thousand instances of the game where the prisoners randomly open drawers
Simulate several thousand instances of the game where the prisoners use the optimal strategy mentioned in the Wikipedia article, of:
- First opening the drawer whose outside number is his prisoner number.
- If the card within has his number then he succeeds otherwise he opens the drawer with the same number as that of the revealed card. (until he opens his maximum).

Show and compare the computed probabilities of success for the two strategies.

# Task 7

[Go to: Table of contents](#table-of-contents)

A task from: "Java in Two Semesters. Fourth edition" by Quentin Charatan and Aaron Kans.
Chapter 5. Methods.

> 5. (a) Write a menu-driven program that provides three options:
>
> - the first option allows the user to enter a temperature in Celsius and displays
> the corresponding Fahrenheit temperature;
>
> - the second option allows the user to enter a temperature in Fahrenheit and
> displays the corresponding Celsius temperature;
>
> - the third option allows the user to quit.
>
> The formulae that you need are as follows, where C represents a Celsius temperature
> and F a Fahrenheit temperature:
>
> F = (9C/5) + 32
>
> C = (5(F-32))/9
>
> (b) Adapt the above program so that the user is not allowed to enter a tem-
> perature below absolute zero; this is −273.15C, or −459.67F.

# Task 8

[Go to: Table of contents](#table-of-contents)

[21 game from on rosettacode webpage](https://rosettacode.org/wiki/21_game)

21 is a two player game, the game is played by choosing a number (1, 2, or 3) to be added to the running total.

The game is won by the player whose chosen number causes the running total to reach exactly 21.

The running total starts at zero. One player will be the computer.

Players alternate supplying a number to be added to the running total.

## Description

Write a computer program that will:
- do the prompting (or provide a button menu),
- check for errors and display appropriate error messages,
- do the additions (add a chosen number to the running total),
- display the running total,
- provide a mechanism for the player to quit/exit/halt/stop/close the program,
- issue a notification when there is a winner, and
- determine who goes first (maybe a random or user choice, or can be specified when the game begins).