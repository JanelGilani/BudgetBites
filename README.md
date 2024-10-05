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
