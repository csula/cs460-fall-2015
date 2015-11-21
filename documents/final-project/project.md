# Vindinium

[Live example](http://vindinium.org/)
[Project page](http://45.55.89.0:9000/doc)

Your job here in this project is to implement a bot that can be ran in Vindinium world. You will be fighting against your colleagues in next class (after ThanksGiving).

Please commit your code frequently on your private Github repository so that I can check and grade your work accordingly.

Please note that the top 5 students automatically gets an 100% out of project.

> You are still required to explain briefly on what you have done in your pull request. Please write up your description as clear as you can.

For rest of students that do not get top 5, we will have final for you to explain to me what you have implement in a presentation format. And I will grade you based on how much you have accomplish in your project with your understanding on the implementation.

# Brief Description of Project

Vindinium is small world with 4 heroes that are controlled by bots. Each hero's goal is the same -- get highest point. That being said, 4 heroes need to compete against each other to get point.

Objectives of game can be split into 3 different points:

1. Mine
    > Each controlled mine generates 1 gold per turn
2. Tavern
    > You can spend 2 gold in tavern to regain 50 HP (no more than 100 HP at most)
3. Hero (whether you or enemy)
    > They may come and kill you if you are not careful about them :\

And last not least your hero needs to take HP into consideration while deciding which objective to go.

Combined with above few objectives, your job is to determine what is your best next move and so on. That being said, each turn you have to generate a MOVE back to the server. (Check starter kit for detail)

# Get started

1. Create a bot with your name
2. Download the starter set (use Java one)
3. Start hacking!

# Starting point

1. Able to read the map
    > Oh look you have done it in homework 3
2. Able to store map in two dimension array
3. Able to generate possible next moves (NEWS)
4. Start by finding non-yours mine and control those mines
5. When hp is lower than 20 go find a tavern to regain health!
6. When low health enemy around, kill them (for glory and honor!)

# Grading Metrics

- [ ] Able to parse map info [1 pt]
- [ ] Able to store map information [1 pt]
- [ ] Able to do path finding from one point to the other [3 pts]
    > Please make this as an individual method for ease of grading
- [ ] Able to control mine [3 pts]
- [ ] Able to avoid death situation (being killed randomly) [2 pts]
- [ ] Able to run to tavern when low health [2 pts]
- [ ] Able to kill low health enemy [3 pts]
- [ ] Explanation on your code in both PR and presentation [5 pts]
