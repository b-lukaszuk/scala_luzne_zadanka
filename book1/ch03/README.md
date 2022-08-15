---

# Table of contents

1. [Task 1](#task-1)
2. [Task 2](#task-2)
3. [Task 3](#task-3)
4. [Task 4](#task-4)

---

# Task 1

[Go to: Table of contents](#table-of-contents)

## Description

Write a script that has the user input a location as x and y coordinate values which tells whether the point specified is in the unit circle (a circle centered on the origin with radius 1).

# Task 2

[Go to: Table of contents](#table-of-contents)

Write a script that accepts the month, day, and year of a date and outputs the number of that day within its year (i.e. Jan 1st is always 1, Dec 31st is either 365 or 366)

# Task 3

[Go to: Table of contents](#table-of-contents)

It is customary to express colors on a computer as a combination of red, green, and blue along with another value called alpha that indicates transparency. A single Int has 32 bits or 4 bytes. The four different color values are often packed into a single Int as an ARGB value. The highest byte is the alpha and below that you have red, green, and blue in order. Each byte can store values between 0 and 255. For alpha, 0 is completely transparent and 255 is completely opaque.

Write code that reads four Int values for alpha, red, green, and blue and calculates an Int with the combined ARGB value. If one of the numbers passed in is outside the 0 to 255 range, use 0 or 255, whichever it is closer to. Note that bitwise operations are appropriate for this exercise. You might find hexadecimal representation of numbers to be useful as well.

# Task 4

[Go to: Table of contents](#table-of-contents)

You are trying to determine how many and what type of calories you need in a day. However, that depends on several factors including your age, height, gender, activity level, and goals (e.g. lose weight, stay the same, or gain weight). In order to solve this problem, you will need to calculate your Basal Metabolic Rate (BMR), your Total Energy Expended (TEE), and how many additional or fewer calories you might want to consume.

The formula for the BMR for Men = 10 x weight(kg) + 6.25 * height(cm) - 5 x age(years) + 5. The formula for the BMR for Women = 10 x weight(kg) + 6.25 * height(cm) - 5 x age(years) - 161. To calculate your TEE you need to decide your activity level: sedentary = BMR * 1.2, lightly active = BMR * 1.375, moderately active = BMR * 1.55, very active = BMR * 1.725, and extra active = BMR * 1.9. Next you need to consider your goals. If you want to lose 1 pound, you need to consume 3500 less calories. The inverse is true if you want to gain weight (e.g. body building). The Centers for Disease Control and Prevention suggest that if you want to lose weight, aim to lose about 1 to 2 pounds each week.

After you have determined your weight goals and included them in your calculations, then you calculate the amount of carbohydrates, fat and protein you need to stay active and healthy. Men and women of all ages should get 45 to 65 percent of their total daily calories from carbohydrates, 10 to 30 percent of their total daily calories from protein, and 20 to 35 percent of their total daily calories from fats. Write a script to determine how much carbohydrates, fat, and protein you should eat daily to meet your goals.
