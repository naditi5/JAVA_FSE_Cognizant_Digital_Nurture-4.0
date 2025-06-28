CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);


CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
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
  INSERT INTO Loans VALUES (1101, 1011, 5000, 5, SYSDATE, SYSDATE + 20);
  INSERT INTO Loans VALUES (1102, 1021, 5000, 5, SYSDATE, SYSDATE + 73);
  INSERT INTO Loans VALUES (1103, 1031, 5000, 5, SYSDATE, SYSDATE + 30);
  INSERT INTO Loans VALUES (1104, 1041, 5000, 5, SYSDATE, SYSDATE + 67);
  INSERT INTO Loans VALUES (1105, 1051, 5000, 5, SYSDATE, SYSDATE + 80);
  INSERT INTO Loans VALUES (1106, 1061, 5000, 5, SYSDATE, SYSDATE + 25);
END;
/

-- Scenario-1 : Applying Discount to Loan Interest to Customers above age 60
BEGIN
  FOR record IN (SELECT c.CustomerID, l.LoanID, l.InterestRate,
                     TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS age
              FROM Customers c
              JOIN Loans l ON c.CustomerID = l.CustomerID)
  LOOP
    IF record.age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = record.LoanID;
      DBMS_OUTPUT.PUT_LINE('InterestRate updated for CustomerID: ' || record.CustomerID || ' whose age is: ' || record.age);
    END IF;
  END LOOP;
END;
/

-- Scenario-2 : Promoting Customers to VIP based on Balance
ALTER TABLE Customers ADD IsVIP VARCHAR2(10);

BEGIN
  FOR record IN (SELECT CustomerID, Balance FROM Customers)
  LOOP
    IF record.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = record.CustomerID;
      DBMS_OUTPUT.PUT_LINE(record.CustomerID || ' is now a VIP');
    END IF;
  END LOOP;
END;
/

-- Scenario-3 : Sending reminder to Customers whoes loans are due in 30 days
BEGIN
  FOR record IN (
    SELECT c.Name, l.EndDate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan for ' || record.Name || ' is due on ' || TO_CHAR(record.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/

-- CREATE TABLE Accounts (
--     AccountID NUMBER PRIMARY KEY,
--     CustomerID NUMBER,
--     AccountType VARCHAR2(20),
--     Balance NUMBER,
--     LastModified DATE,
--     FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
-- );

-- CREATE TABLE Transactions (
--     TransactionID NUMBER PRIMARY KEY,
--     AccountID NUMBER,
--     TransactionDate DATE,
--     Amount NUMBER,
--     TransactionType VARCHAR2(10),
--     FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
-- );



-- CREATE TABLE Employees (
--     EmployeeID NUMBER PRIMARY KEY,
--     Name VARCHAR2(100),
--     Position VARCHAR2(50),
--     Salary NUMBER,
--     Department VARCHAR2(50),
--     HireDate DATE
-- ); 


