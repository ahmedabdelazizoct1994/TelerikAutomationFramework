                                        "Hello Qoyod"
                                 "Telerik Automation Framework"


1. Project Description
This is a Selenium-based Test Automation Framework for testing the key functionalities of Telerik.
The framework uses the Page Object Model (POM) design pattern and incorporates modular test scripts,
making it highly scalable and maintainable.

2-The framework covers the following scenario:
Trying to choose kendo UI plan and register to activate

3-Project Structure
telerik-automation/
├── src/
│   ├── main/
│   │   ├── java/
|   |   |   |__Pages
│   │   │   └── utils/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │
│       │
│       │
│       │
│       └── resources/
├── test-output/
Testng.xml
├── pom.xml
└── README.md                       # Maven configuration file for dependencies

4- Technologies and Tools Used
  Programming Language: Java 11
  Testing Framework: TestNG
  Automation Tool: Selenium WebDriver with DDT
  Browser Driver Management: WebDriverManager
  Reporting Tool: Extent Reports
  Build Tool: Maven
  Design Pattern: Page Object Model (POM)
  IDE: IntelliJ IDEA (Recommended)

5-Setting Up the Project
*Clone the repository to your local machine.
**Open the project in your IDE (e.g., IntelliJ ).
***Navigate to the config.properties file under src/main/resources and configure your own Data:
****Running Tests Using TestNG:Navigate to testng.xml file to run.
*****Check Test_output for reports


note :I don't prefer writing comments as the code clean enough
but little block of code needs comments due to behaviour of the system


THANKS
