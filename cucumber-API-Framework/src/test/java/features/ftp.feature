Feature: Testing the FTP file

Scenario: Test the FTP scheduler
Given I get the file from the location G:\NJC_work\Ftp_emp\country.csv path
And I get Activemq endpoint tcp://64.227.37.97:61616 and queue name testAutomation and outputFile location G:\NJC_work\projects\Automation_personal\apiops-anypoint-bdd-sapi\cucumber-API-Framework\src\DqueueDatafile.csv path
And Dequeue json objects into a file in location G:\NJC_work\projects\Automation_personal\apiops-anypoint-bdd-sapi\cucumber-API-Framework\src\DqueueDatafile.csv path
Then I need to compare the two files where to match the content of the data by making assertion as true value