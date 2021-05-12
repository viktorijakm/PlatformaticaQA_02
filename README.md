# PlatformaticaQA_02
## Project Coding Convention
### Naming conventions
We shall use Camel cased for naming conventions.<br> 
Camel case stylized as lower camel case: `camelCase`,<br>
or upper camel: `CamelCase`.
### Directory Naming
Directory names shall follow the lower camel case.<br>
The directory names shall be short and meaningful.
### Java naming conventions
#### Package names
The reverse of the organization’s domain name should be used as the prefix.<br> 
All letters should be in lower case.<br> 
According to the need of the project shall use subsequent directory names.<br>
To indicate the content within the package shall use a meaningful directory name.
```
com.project.selenium
com.project.selenium.pages
com.project.selenium.tests
com.project.selenium.utils
```
#### Class names
The class names should use the upper camel case.<br> 
The class name should be a noun.<br>
Try to make the name simple and descriptive.<br>
All the tests shall end with the suffix Test.<br>
All the pages shall end with the suffix Page.
```
LoginTest.java
LoginPage.java
```
#### Method names
For the method, names should use a lower camel case.<br>
Method name should start with a verb.<br>
For example: `get`, `is`, `create`, etc.<br>
Try to make the name simple and descriptive.<br> 
Use whole word instead of abbreviations.<br>
All methods with `@Test` annotation shall start with the prefix `test`.
```
getValues()
createInstance(WebDriver driver)
`testDeleteRecord()`
```
#### Variable names
The variable names should use a lower camel case.<br> 
The given name shall indicate the intent of the variable.<br> 
The variable name should be a noun.<br> 
Try to make the name simple and descriptive using full words.<br>
For example: `button`, NOT `btn`.
```
actualValues
randomUser
```
#### Constants
Constants (final static variables) must be all upper Snake cases, stylized as `SNAKE_CASE`.<br> 
All letters should be in uppercase. Words shall be separated with underscore `_`.<br>
All the global constants shall be defined in a property file,<br>
and loaded into the constants defined in the Constant class.<br>
Constants shall be defined as public static in the Constant class.
```
public static final String ERROR_MESSAGE;
```
#### Comments
Comments shall be used to explain the code to make the test scripts more readable for others.<br>
Javadoc format should be used comments for methods and classes. 
```
/**
* @param username the login username
*/
```
_**Comments in feature files (Cucumber)**_<br>
You can add your comments in the lines followed by the keywords:<br>
`Feature`, `Scenario`, `Scenario Outline`, or `Examples`.<br>
Also, you can use `#` for line comments.<br><br>
_**Comments in property files**_<br>
Comment lines in .properties files are denoted by the number sign `#`,<br> 
or the exclamation mark `!` as the first non-blank character<br><br>
_**Comments in XML**_<br>
The syntax for writing comments in XML is similar to that of HTML.
```
<!-- This is a comment -->
```
_**Property File and properties**_<br>
All the global properties and values that can be defined by the user shall be defined in the property file.<br> 
This will allow you to run your tests with different configurations without recompiling your code.
```
default.username=user
default.password=password
```
