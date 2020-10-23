# Catalog-Integration

## How to run the project
1. Clone github project
2. This includes an executable jar file
3. It also includes a sample input file
4. How to run the application (command-line):
    
    a. cd \<root directory of project\>
    
    b. \<path to java\>/bin/java  -Dfile.encoding=UTF-8 -jar target/Catalog-Integration-1.0-SNAPSHOT.jar src/main/resources/data/input-sample.txt
5. For the provided file, there are four lines; each representing a different product. The output is:

        Report on product list:
           Number of product objects: 4
           IDs        Description                  Display-$       Calc-$        Promo-$       Promo-calc-$   Tax     Size       Unit
        -----------------------------------------------------------------------------------------------------------------------------
         80000001  Kimchi-flavored white rice      $5.67           5.6700        null          null          0.000%  18oz        Each   
         14963801  Generic Soda 12-pack            2 for $13.00    6.5000        $5.49         5.4900        7.775%  12x12oz     Each   
         40123401  Marlboro Cigarettes             $10.00          10.0000       $5.49         5.4900        0.000%  null        Each   
         50133333  Fuji Apples (Organic)           $3.49           3.4900        null          null          0.000%  lb          Pounds 
        

       
## Link to CICD locations
// todo

## Overview of project
Basic Requirements:

1. Apply a schema to a set of strings to parse out a set of fields which are then integrated to produce a product record object.

    a. Assume that the basic schema is very stable and that parsing does not need to be error checked.
 
    b. Assume that any lines that do not follow the schema can be ignored
 
    c. Assume that extensibility of this core functionality is likely; design the project to be extended.

2. Wrap this functionality in a Java app, in such a way that the accuracy of the implementation can be evaluated.  In this case, the app prints out a table of the fields of the base product objects.

3. Integrate this project in a CIDC context.

Before describing the project, it is worth saying a few things about my approach. In particular, I try to focus on Clean Code practices.  Not to outline it here, but I value readability.  As such, I aim for well-named fields, methods, and classes.  I try to minimize documentation; except to explain decisions and such.  But I believe that, as much as possible, the code should explain itself.

To implement this project, we break the conversion operation into two parts:  

1. parsing schema-fields of specified types from each string

2. integrate these schema-fields to produce product fields; these integrations may include: one to one; one to many; and many to one. Some schema fields are required.  Some are optional. 

There are several aspects of this problem that are very stable.  As such, enums implementing appropriate interfaces are created.

The Fields enum implements the FieldSetter interface.  We see that it conveniently handles the different required mappings from schema-field to product-field.

It leverages both the schema-field String extractors - to pull out the needed pieces of text and the FieldType parsers - to convert those text pieces to the prescribed product field types.

### API
For this project, I've created an API focused on supporting extension of the core implementation classes.
The application itself is mainly to demonstrate the implementation; so I was not as concerned about its extensibility.

There are two main sets of interfaces supporting the core:
1.  Interfaces supporting conversion of lines into product fields.  These are:
   
      a. **Extractor** - implemented by StringExtractor class to pull out Substring specified by location
   
    b. **Parse** - implemented by FieldTypes enum to convert substrings (in this case from a StringExtractor to a specific Java type)
  
    c. **FieldSetter** - implemented by Fields enum to leverage the preceeding functionality to create product fields.

2. Interface supporting conversion of lines into product objects

   * **ProductFieldParser** is implemented by StringProductFieldParser class to convert schema-lines into product objects.

For our demo application, the StringProductFieldParser class is used by the ProductFieldParserManager class to process an iteration of lines into a list of product instances
### Extension Example
Of course, we would like to see how easy it is to extend this base implementation to support a fuller set of product fields.
While I did not expose such an extension in the application, I did implement one in the example_extension package; and performed some minor validations of it in the unit tests.
This extension added to the line schema; created an extended product object that inherits from the base product and added to the product fields and added a new field type "Date".
The extensions continue to use enums.

In the ExtendedProductFieldParser, I chose to leverage the base StringProductFieldParser via composition; as it more cleanly resolved parameter typing.


### Tests
I make a handful of unit tests; leveraging the TestNG testing framework and the AssertJ fluency library.
In this case, I did not follow TDD, as I figured I would be learning during the coding phase; and wanted to maintain flexibility.

Since the extended logic is not exercised by the application, one can look at it in action with the tests:
* ExtendedFieldTypesTest
* StringProductFieldParserTest