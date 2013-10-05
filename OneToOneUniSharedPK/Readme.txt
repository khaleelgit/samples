Steps to be followed to run this example
--------------------------------------------------------------------------------------------------------------------
1. Run createDDL_EclipseLink.sql to create necessary tables.

2. 
To run on hibernate set the string PERSISTENCE_UNIT_NAME  = "perContext-Hibernate" in JPATest.java as below.

private static String PERSISTENCE_UNIT_NAME  = "perContext-Hibernate";

To run on hibernate set the string PERSISTENCE_UNIT_NAME  = "perContext-EclipseLink" in JPATest.java as below.

private static String PERSISTENCE_UNIT_NAME  = "perContext-EclipseLink";

3. Run JPATest.java
--------------------------------------------------------------------------------------------------------------------