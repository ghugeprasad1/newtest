<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description>Import-Export Search</description>
   <name>Import-Export Search</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>3</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>true</rerunImmediately>
   <testSuiteGuid>93ab87df-225f-4383-b8c7-ac0c2e4c5da0</testSuiteGuid>
   <testCaseLink>
      <guid>0be9ed8b-e253-47c7-85a4-5e9b3bf23cd0</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login MCC</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>3b50621f-18af-405e-a556-45a546d0131c</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Verify All menu link</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>86e14ad5-ef8b-4d87-b864-35f00c718f3d</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Import File</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>e9f2ccdf-5c2e-49de-9c30-a9175293ca4a</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-1</value>
         </iterationEntity>
         <testDataId>Data Files/New Test Data</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>e9f2ccdf-5c2e-49de-9c30-a9175293ca4a</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>filename</value>
         <variableId>d9e55ea7-8394-461d-9370-c51049500a29</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>9ff6c5b6-a3de-4e96-821d-758420a9a3a1</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/verifybyfilename</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>d2946a25-c9a1-4bd0-9b24-57b97503ebb2</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/New Test Data</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>d2946a25-c9a1-4bd0-9b24-57b97503ebb2</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>filename</value>
         <variableId>18e348ff-598c-4e32-a045-15f77f033752</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
