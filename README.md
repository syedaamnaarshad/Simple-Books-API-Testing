# Simple-Books-API-Testing
Simple Books API Testing

This project is an API automation testing suite for the Simple Books API, implemented using **Java**, **Cucumber**, **Rest-Assured**, **TestNG**, and **Allure Reports** for generating visually appealing test reports.

## 📋 Project Features

 **Frameworks and Tools**:
  - **Java** for scripting.
  - **Rest-Assured** for API testing.
  - **Cucumber** for behavior-driven development (BDD).
  - **TestNG** for test execution.
  - **Allure Reports** for generating comprehensive test reports.

  **Testing Features**:
  - Validation of various HTTP methods (GET, POST, PUT, DELETE).
  - Parameterized testing for multiple scenarios.
  - Custom hooks for setup and teardown.
  - Integration with Allure for detailed test reports.

## ⚙️ Prerequisites

1. **Java JDK** (version 11 or above)
2. **Maven** for dependency management
3. **Allure Command-Line Tool** (for report generation):
   - Install via [Scoop](https://scoop.sh/) (for Windows):
     ```bash
     scoop install allure
     ```
   - Or download from the [Allure website](https://github.com/allure-framework/allure2).

4. **Git** (optional, for version control)

---

## 🚀 How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/syedaamnaarshad/Simple-Books-API-Testing.git
   cd Simple-Books-API-Testing
Install dependencies:

🖥️ Generating Allure Reports
After running the tests, an allure-results folder will be created.
Generate the Allure report:
bash
allure generate allure-results --clean -o allure-report
Open the Allure report in your browser:
bash
allure open allure-report
📂 Project Structure

Simple-Books-API-Testing/
├── src/
│   ├── main/
│   │   └── java/                  # Application source code (if applicable)
|   |       |── utilities/         # Helper methods and reusable functions
|   |           |── Configutils/   # Helper method to read cnfiguration properties
|   |           |── TokenUtil/     # Helper method to set and get bearer token
|   |           |── OrderID util/  # Helper method to set and get order ID
│   ├── test/
│       ├── java/
│       │   ├── baseService/   
│       │       ├── BaseService/   # Helper method for http methods(get,put,post and delete)
│       │   ├── stepDefinitions/   
│       │       ├── Hooks/         # Setup and teardown logic
│       │       ├── API_Test_Steps # Step definition files for Cucumber
│       │   ├── runners/           # TestNG and Cucumber runners
│       │   
│       ├── resources/
│           └── APT_Test.features/  # Cucumber feature files
│           └── config.properties/  # Configuration properties
├── allure-report/                  # Allure report (generated after tests)
├── allure-results/                 # Raw results for Allure (generated after tests)
├── pom.xml                        # Maven configuration file
└── README.md                      # Project documentation

🔗 Key Dependencies
Rest-Assured: Maven Repository
Cucumber: Maven Repository
TestNG: Maven Repository
Allure Reports: Allure Documentation

