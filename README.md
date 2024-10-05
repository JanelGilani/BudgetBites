# BudgetBites: Find cheap food at UofT

Are you a student at UofT and trying to find food around campus, but are tight on your budget? You have come to the right place, welcome to BudgetBites! This UofT-based application allows you to find budget-friendly food options at the UTSG campus. You can then search for restaurants and specific food items by a number of parameters such as cuisine type, price range, food type, etc. Not only will you be given customised food suggestions, but you will also make use of ourextensive budgeting feature: every time you buy food from a restaurant, your monthly budget will reflect the spending and you can follow your budget restrictions rigorously.

Above those features we used MongoDB and Java Swing to create a seamless graphical user interface and persistent functionality. 

## How to Build and Run BudgetBites ##
- [ ] Ensure SDK version is 11.0.17 (See the image below and match it with Project Structure)

![](images/version_control.png)

- [ ] Go to the `build.gradle` file and check the dependency. If the dependency is correct then build the gradle again. **Important for MongoDB to work.** 

![](images/dependency.png)

**Now that you have build the project, it is time to start the UI. Follow the steps in the next section to ensure that you correctly open the Java Swing UI**

- [ ] Go to `src/Main/java/Main.java`
- [ ] Run the Main file, and new JFrame will be prompted. Enjoy the UI.

## Final Pull Requests Document
- [ ] https://docs.google.com/document/d/1OUL4p8HVuaO4_BQnOO3YV_1Di-jaswLo1D54788NKF4/view

## Changes after Milestone 4
- Added price range values in price preferences for filtering food items.
- Added back buttons and made every frame interconnected for better navigation.
- Made all pull requests with consistent titles and detailed descriptions of the modifications made.
- Packaged all the code using ‘by CA Layer’ packaging strategy.
- Extensively tested all functionalities, including corner (happy and unhappy flows) cases.
- Followed the suggested Java naming style where all packages are in lowercase (e.g. entities), all classes and tests have capitalized first letters (e.g. PriceFilterInteractor), and all methods follow camel case (e.g. addFood).
- Included explanatory Javadocs for every functionality and test case. Also added comments in non-trivial places for better readability.
- Thoroughly used Github features such as pull requests, actions, branches and issues, while also learning and incorporating new features such as projects and discussions.
- Identified and removed all code smells, addressed all IntelliJ warnings, and removed every redundant file.
- Used design patterns such as Iterator, Simple Factory, and Builder based on feedback received.
- Implemented Model-View-Controller architecture pattern in order to adhere to clean architecture and SOLID principles.
- Apart from user login, use sign-up and restaurant filtering in Milestone 4, we implemented more functionality such as price-filtering food items in a specific restaurant, budgeting (including viewing and modifying budget), item cart (and making orders), viewing past orders, getting customised food suggestions.
- Implemented Data Access Interfaces to allow use cases to interact with the database through dependency inversion to adhere with SOLID principles



## About Us

We are the coders behind the planning, development, and testing of the BudgetBites project. 

Group members:
- Akshayan Jeyakumar
- Aryan Goel
- Aviral Bhardwaj
- Darpan Mishra
- Janel Gilani
- Nathan Cai
- Mann Thakkar
- Vandan Patel


[//]: # ()
[//]: # (## Checklist For Your Project)

[//]: # ()
[//]: # (- [ ] Verify the correct settings for your project repository)

[//]: # ()
[//]: # (- [ ] Set up Github Projects)

[//]: # ()
[//]: # (- [ ] Create the implementation plan using issues and Github Projects)

[//]: # ()
[//]: # (- [ ] Create deveopment branches for your features)

[//]: # ()
[//]: # (- [ ] Use pull requests to merge finished features into Main branch)

[//]: # ()
[//]: # (- [ ] Conduct code reviews)

[//]: # ()
[//]: # ()
[//]: # (**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**)

[//]: # ()
[//]: # ()
[//]: # (## Workflow Documents)

[//]: # ()
[//]: # ()
[//]: # (* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.)

[//]: # ()
[//]: # ()
[//]: # (* [Project Planning and Development Guide]&#40;project_plan_dev.md&#41;: This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**)

[//]: # ()
[//]: # ()
[//]: # (## Gradle Project)

[//]: # ()
[//]: # (Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.)

[//]: # ()
[//]: # (The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. &#40;You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version&#41;)

[//]: # ()
[//]: # ()
[//]: # (You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.)

[//]: # ()
[//]: # ()
[//]: # (You will find HelloWorld in `src/Main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.Main&#40;&#41;`.)

[//]: # ()
[//]: # (This should run the program and print on your console.)

[//]: # ()
[//]: # ()
[//]: # (You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.)

[//]: # ()
[//]: # (All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.)

[//]: # ()
[//]: # ()
[//]: # (Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/Main/java` &#40;you can keep creating more subdirectories as per your project requirement&#41;. Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.)

[//]: # ()
[//]: # ()
[//]: # (![image]&#40;https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png&#41;)

[//]: # ()
[//]: # ()
[//]: # (You can create another simple class and try generating a test for this class.)
