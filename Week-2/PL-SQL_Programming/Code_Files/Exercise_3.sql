CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 

BEGIN
  INSERT INTO Customers VALUES (1011, 'Deepikaa', TO_DATE('1985-03-15', 'YYYY-MM-DD'), 31000, SYSDATE);
  INSERT INTO Customers VALUES (1021, 'Pramilaa', TO_DATE('2005-05-30', 'YYYY-MM-DD'), 11000, SYSDATE);
  INSERT INTO Customers VALUES (1031, 'Rishuti', TO_DATE('1947-06-26', 'YYYY-MM-DD'), 1000, SYSDATE);
  INSERT INTO Customers VALUES (1041, 'Lalithya', TO_DATE('1950-07-01', 'YYYY-MM-DD'), 1000, SYSDATE);
  INSERT INTO Customers VALUES (1051, 'Rishithaa', TO_DATE('1949-08-05', 'YYYY-MM-DD'), 21000, SYSDATE);
  INSERT INTO Customers VALUES (1061, 'Pranitha', TO_DATE('2015-09-03', 'YYYY-MM-DD'), 1000, SYSDATE);
END;
/

BEGIN
  INSERT INTO Accounts VALUES (11014, 1011, 'Savings', 11000, SYSDATE);
  INSERT INTO Accounts VALUES (11015, 1021, 'Current', 10000, SYSDATE);
  INSERT INTO Accounts VALUES (11016, 1031, 'Savings', 21000, SYSDATE);
  INSERT INTO Accounts VALUES (11017, 1041, 'Savings', 9000, SYSDATE);
  INSERT INTO Accounts VALUES (11018, 1051, 'Current', 1000, SYSDATE);
  INSERT INTO Accounts VALUES (11019, 1061, 'Savings', 6000, SYSDATE);
END;
/

BEGIN
  INSERT INTO Employees VALUES (4501, 'Millie', 'Manager', 70000, 'HR', TO_DATE('2005-07-15', 'YYYY-MM-DD'));
  INSERT INTO Employees VALUES (4502, 'Bobby', 'Intern', 70000, 'Dev', TO_DATE('2025-06-20', 'YYYY-MM-DD'));
  INSERT INTO Employees VALUES (4503, 'Brown', 'Intern', 70000, 'Cloud Service', TO_DATE('2025-02-15', 'YYYY-MM-DD'));
  INSERT INTO Employees VALUES (4504, 'Stevee', 'SOC Analyst', 70000, 'Cybersecurity', TO_DATE('2021-01-29', 'YYYY-MM-DD'));
  INSERT INTO Employees VALUES (4505, 'Maxwell', 'Manager', 70000, 'HR', TO_DATE('2018-01-31', 'YYYY-MM-DD'));
END;
/

-- Scenario-1 : Processing Monthly Interest for all saving Accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR record IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings')
  LOOP
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01), LastModified = SYSDATE
    WHERE AccountID = record.AccountID;
    DBMS_OUTPUT.PUT_LINE('Updated balance for AccountID = ' || record.AccountID);
  END LOOP;
END;
/

BEGIN
  ProcessMonthlyInterest;
END;
/

--Scenario-2 : Implementing bonus for the employees based on performance
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (dept IN VARCHAR2, bonusPoints IN integer) IS
BEGIN
  FOR record IN (SELECT EmployeeID, Department, Salary FROM Employees WHERE Department = dept)
  LOOP
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPoints)
    WHERE record.EmployeeID = EmployeeID;
    DBMS_OUTPUT.PUT_LINE('Added Bonus points to employee : ' || record.EmployeeID);
  END LOOP;
END;
/

BEGIN
  UpdateEmployeeBonus('Cybersecurity', 0.09);
END;
/

--Scenario-3 : Transfering funds between Customers Accounts
CREATE OR REPLACE PROCEDURE TransferFunds (
  from_account IN NUMBER, 
  to_account IN NUMBER, 
  fund IN NUMBER) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;
  
  IF from_balance < fund THEN 
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance in the Account.');
  END IF;
  
  UPDATE Accounts
  SET Balance = Balance - fund, LastModified = SYSDATE
  WHERE AccountID = from_account;
  
  UPDATE Accounts
  SET Balance = Balance + fund, LastModified = SYSDATE
  WHERE AccountID = to_account;
  
  DBMS_OUTPUT.PUT_LINE('Transfered Funds successfully from ' || from_account || ' to account ' || to_account || ' amount ' || fund);
END;
/

BEGIN
  TransferFunds(11015, 11017, 1000);
  TransferFunds(11017, 11018, 3000);
  TransferFunds(11018, 11014, 6000);
END;
/


