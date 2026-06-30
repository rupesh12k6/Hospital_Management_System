# Hospital Management System

> **A comprehensive, enterprise-grade Hospital Management System designed to streamline healthcare operations, enhance patient care, and optimize administrative workflows.**

---

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API & Modules](#api--modules)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Support](#support)
- [License](#license)
- [Contact](#contact)

---

## About

The **Hospital Management System** is a robust, scalable Java-based solution that provides healthcare institutions with a centralized platform to manage end-to-end hospital operations. Built with enterprise-grade architecture principles, this system streamlines patient management, clinical workflows, staff coordination, and financial operations.

**Key Objectives:**
- Centralize patient data and medical records
- Optimize appointment scheduling and resource allocation
- Enhance operational efficiency across departments
- Ensure data security and compliance with healthcare regulations
- Provide real-time insights into hospital operations

---

## ✨ Features

### 👥 Patient Management
- **Patient Registration & Profiles**: Comprehensive patient onboarding with detailed demographic and contact information
- **Medical History Tracking**: Maintain complete patient medical history including past treatments, allergies, and conditions
- **Digital Health Records**: Secure centralized repository for all patient documents and reports
- **Emergency Contacts**: Multi-level emergency contact management

### 🏥 Staff Management
- **Doctor & Nurse Directory**: Complete staff information management
- **Role-Based Access Control**: Fine-grained permissions for different staff roles
- **Department Assignment**: Organize staff across departments and specialties
- **Availability Management**: Real-time tracking of staff availability and schedules

### 📅 Appointment System
- **Intelligent Scheduling**: Smart appointment booking with conflict detection
- **Doctor Availability**: Real-time availability tracking and scheduling optimization
- **Appointment Status Management**: Track appointment lifecycle (scheduled, completed, cancelled, rescheduled)
- **Reminder Notifications**: Automated appointment reminders for patients
- **Waiting List Management**: Efficient queue management for walk-in patients

### 📋 Medical Records & Clinical Management
- **Prescription Management**: Digital prescription tracking and dispensation
- **Lab Reports Integration**: Store and manage laboratory test results
- **Clinical Notes**: Detailed clinical observations and treatment notes
- **Diagnostic Reports**: Integration with diagnostic imaging and test systems
- **Patient Discharge Summary**: Comprehensive discharge documentation

### 💰 Billing & Finance
- **Automated Invoicing**: Generate detailed patient bills
- **Payment Tracking**: Track payment status and history
- **Insurance Integration**: Manage insurance claims and reimbursements
- **Financial Reports**: Revenue analytics and financial dashboards
- **Department-wise Billing**: Cost allocation across departments

### 🔐 Security & Data Management
- **Encrypted Data Storage**: Patient data encryption at rest and in transit
- **Audit Logs**: Complete audit trail of all system activities
- **Backup & Recovery**: Automated backup mechanisms with disaster recovery options
- **HIPAA Compliance**: Adherence to healthcare data privacy standards
- **Role-Based Access Control**: Granular permission management

---

## Architecture

### System Design

The Hospital Management System follows a **3-tier layered architecture** designed for scalability, maintainability, and high availability:

```
┌──────────────────────────────────────────────────────────┐
│              Presentation Layer                          │
│      (Web UI / Desktop Application / Mobile App)         │
└────────────────────┬─────────────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────────────┐
│              Business Logic Layer                        │
│   (Services, Controllers, Business Rules Engine)         │
├──────────────────────────────────────────────────────────┤
│  • PatientService      • AppointmentService              │
│  • BillingService      • StaffService                    │
│  • ReportService       • SecurityService                 │
└────────────────────┬─────────────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────────────┐
│              Data Access Layer (DAO)                     │
│   (Repository Pattern, Database Queries)                 │
└────────────────────┬─────────────────────────────────────┘
                     │
┌────────────────────▼─────────────────────────────────────┐
│              Database Layer                              │
│        (MySQL 5.7+ / PostgreSQL 10+)                     │
└──────────────────────────────────────────────────────────┘
```

### Key Architectural Patterns
- **MVC Pattern**: Clean separation of concerns
- **DAO Pattern**: Abstract database operations
- **Service Layer Pattern**: Centralized business logic
- **Repository Pattern**: Data access abstraction
- **Singleton Pattern**: Shared resource management

---

## Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java (JDK 8+) |
| **Database** | MySQL 5.7+ / PostgreSQL 10+ |
| **Build Tool** | Maven 3.6+ / Gradle 6.0+ |
| **IDE** | IntelliJ IDEA / Eclipse / VS Code |
| **Frameworks** | Core Java, JDBC |
| **Testing** | JUnit, Mockito |
| **Version Control** | Git |

---

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

```bash
✓ Java Development Kit (JDK) 8 or higher
✓ MySQL 5.7+ or PostgreSQL 10+
✓ Maven 3.6+ or Gradle 6.0+
✓ Git
✓ IntelliJ IDEA / Eclipse / VS Code (optional but recommended)
```

### Quick Start

```bash
# 1. Clone the repository
git clone https://github.com/rupesh12k6/Hospital_Manage.git
cd Hospital_Manage

# 2. Setup database (see Configuration section below)

# 3. Build the project
mvn clean install

# 4. Run the application
mvn exec:java -Dexec.mainClass="com.hospital.Main"
```

---

## Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/rupesh12k6/Hospital_Manage.git
cd Hospital_Manage
```

### Step 2: Create Database

```bash
# Using MySQL
mysql -u root -p

CREATE DATABASE hospital_manage;
CREATE USER 'hospital_user'@'localhost' IDENTIFIED BY 'secure_password';
GRANT ALL PRIVILEGES ON hospital_manage.* TO 'hospital_user'@'localhost';
FLUSH PRIVILEGES;
EXIT;
```

### Step 3: Import Database Schema

```bash
# Import the provided schema
mysql -u hospital_user -p hospital_manage < database/schema.sql
```

### Step 4: Build the Project

#### Using Maven
```bash
mvn clean install
```

#### Using Gradle
```bash
gradle build
```

### Step 5: Verify Installation

```bash
# Run tests to verify everything is set up correctly
mvn test
```

---

## Configuration

### Database Connection Configuration

Update the database configuration file at `src/main/resources/config/database.properties`:

```properties
# Database Connection Settings
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/hospital_manage
db.username=hospital_user
db.password=secure_password

# Connection Pool Settings
db.connection.pool.size=20
db.connection.timeout=30000

# SSL Configuration (Optional)
db.useSSL=true
db.serverTimezone=UTC
```

### Application Configuration

Edit `src/main/resources/config/application.properties`:

```properties
# Application Settings
app.name=Hospital Management System
app.version=1.0.0

# Server Configuration
server.port=8080
server.host=localhost

# Logging
logging.level=INFO
logging.file=logs/app.log

# Session Configuration
session.timeout=3600
```

---

## Usage

### Starting the Application

```bash
# Run using Maven
mvn exec:java -Dexec.mainClass="com.hospital.Main"

# Or run the compiled JAR
java -jar target/Hospital_Manage.jar
```

### Core Operations

#### Add a Patient
```java
import com.hospital.models.Patient;
import com.hospital.services.PatientService;

Patient patient = new Patient();
patient.setName("John Doe");
patient.setEmail("john@example.com");
patient.setPhone("123-456-7890");
patient.setDOB("1990-05-15");

PatientService.addPatient(patient);
System.out.println("Patient added successfully!");
```

#### Schedule an Appointment
```java
import com.hospital.models.Appointment;
import com.hospital.services.AppointmentService;
import java.time.LocalDateTime;

Appointment appointment = new Appointment();
appointment.setPatientId(1);
appointment.setDoctorId(5);
appointment.setAppointmentDate(LocalDateTime.of(2026, 6, 15, 10, 30));
appointment.setReason("Regular Checkup");

AppointmentService.scheduleAppointment(appointment);
System.out.println("Appointment scheduled!");
```

#### Generate Patient Invoice
```java
import com.hospital.models.Invoice;
import com.hospital.services.BillingService;
import java.time.LocalDate;

Invoice invoice = new Invoice();
invoice.setPatientId(1);
invoice.setAmount(5000.00);
invoice.setIssueDate(LocalDate.now());
invoice.setDescription("Consultation + Lab Tests");

BillingService.generateInvoice(invoice);
System.out.println("Invoice generated successfully!");
```

---

## API & Modules

### Core Modules

| Module | Purpose |
|--------|---------|
| **Patient Module** | Patient registration, profile management, medical history |
| **Appointment Module** | Scheduling, availability management, appointment tracking |
| **Staff Module** | Doctor/nurse management, scheduling, assignments |
| **Billing Module** | Invoicing, payment tracking, financial reports |
| **Medical Records Module** | Prescriptions, lab reports, clinical notes |
| **Security Module** | Authentication, authorization, audit logging |

### Service Layer

```java
// Available Services
PatientService         - Patient CRUD operations
AppointmentService     - Appointment management
StaffService           - Staff management
BillingService         - Billing and invoicing
MedicalRecordService   - Medical records management
ReportService          - Report generation
SecurityService        - Authentication and authorization
```

---

## Project Structure

```
Hospital_Manage/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hospital/
│   │   │       ├── models/              # Entity classes (Patient, Doctor, Appointment, etc.)
│   │   │       │   ├── Patient.java
│   │   │       │   ├── Doctor.java
│   │   │       │   ├── Appointment.java
│   │   │       │   ├── Staff.java
│   │   │       │   ├── Invoice.java
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── services/            # Business logic services
│   │   │       │   ├── PatientService.java
│   │   │       │   ├── AppointmentService.java
│   │   │       │   ├── BillingService.java
│   │   │       │   ├── StaffService.java
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── controllers/         # Request handlers and application controllers
│   │   │       │   ├── PatientController.java
│   │   │       │   ├── AppointmentController.java
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── dao/                 # Database access objects
│   │   │       │   ├── PatientDAO.java
│   │   │       │   ├── AppointmentDAO.java
│   │   │       │   ├── StaffDAO.java
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── utils/               # Utility classes
│   │   │       │   ├── DatabaseUtil.java
│   │   │       │   ├── DateUtil.java
│   │   │       │   ├── ValidationUtil.java
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── config/              # Configuration classes
│   │   │       │   ├── DatabaseConfig.java
│   │   │       │   └── AppConfig.java
│   │   │       │
│   │   │       └── Main.java            # Application entry point
│   │   │
│   │   └── resources/
│   │       ├── config/
│   │       │   ├── database.properties
│   │       │   └── application.properties
│   │       └── sql/
│   │           └── schema.sql
│   │
│   └── test/
│       └── java/
│           └── com/hospital/
│               ├── services/            # Service unit tests
│               ├── dao/                 # DAO unit tests
│               └── utils/               # Utility tests
│
├── database/
│   ├── schema.sql                       # Database schema
│   └── sample_data.sql                  # Sample data for testing
│
├── docs/                                # Documentation
│   ├── ARCHITECTURE.md
│   ├── SETUP_GUIDE.md
│   └── USER_GUIDE.md
│
├── lib/                                 # External libraries and dependencies
│
├── target/                              # Compiled output (generated by Maven)
│
├── pom.xml                              # Maven configuration (if using Maven)
├── build.gradle                         # Gradle configuration (if using Gradle)
├── .gitignore
├── LICENSE
└── README.md
```

---

## Testing

### Run All Tests

```bash
# Using Maven
mvn test

# Using Gradle
gradle test
```

### Run Specific Test Class

```bash
mvn test -Dtest=PatientServiceTest

# With Gradle
gradle test --tests PatientServiceTest
```

### Test Coverage

```bash
# Generate test coverage report
mvn clean test jacoco:report

# View coverage in target/site/jacoco/index.html
```

### Unit Test Example

```java
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatientServiceTest {
    
    private PatientService patientService;
    
    @Before
    public void setUp() {
        patientService = new PatientService();
    }
    
    @Test
    public void testAddPatient() {
        Patient patient = new Patient("Jane Doe", "jane@example.com");
        boolean result = patientService.addPatient(patient);
        assertTrue("Patient should be added successfully", result);
    }
}
```

---

## Deployment

### Build for Production

```bash
# Build with optimizations
mvn clean package -DskipTests=true

# Output: target/Hospital_Manage.jar
```

### Deployment Steps

1. **Prepare Production Server**
   - Install Java JDK 8+
   - Install and configure MySQL/PostgreSQL
   - Create production database

2. **Deploy Application**
   ```bash
   # Copy JAR to server
   scp target/Hospital_Manage.jar user@server:/opt/app/
   
   # Create systemd service for auto-start
   sudo systemctl start hospital-manage
   sudo systemctl enable hospital-manage
   ```

3. **Monitor Application**
   ```bash
   # View application logs
   tail -f logs/app.log
   
   # Monitor system resources
   watch -n 1 'ps aux | grep Hospital_Manage'
   ```

### Docker Deployment (Optional)

```dockerfile
FROM openjdk:8-jdk
COPY target/Hospital_Manage.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

---

## Troubleshooting

### Common Issues

#### 1. Database Connection Failed
**Error**: `Connection refused to host: localhost:3306`

**Solution**:
- Verify MySQL is running: `mysql -u root -p`
- Check database credentials in `database.properties`
- Ensure firewall allows port 3306

#### 2. Maven Build Failures
**Error**: `Cannot find symbol` or `compilation error`

**Solution**:
```bash
# Clean and rebuild
mvn clean install -U

# Check Java version
java -version  # Should be 8 or higher
```

#### 3. Out of Memory Error
**Error**: `Exception in thread "main" java.lang.OutOfMemoryError`

**Solution**:
```bash
# Increase heap size
java -Xmx1024m -Xms512m -jar Hospital_Manage.jar
```

#### 4. Port Already in Use
**Error**: `Address already in use: 8080`

**Solution**:
```bash
# Find process using port 8080
lsof -i :8080

# Kill the process or change port in application.properties
```

---

## Contributing

We welcome contributions! Please follow these guidelines:

### 1. Fork the Repository
```bash
git clone https://github.com/YOUR_USERNAME/Hospital_Manage.git
cd Hospital_Manage
```

### 2. Create a Feature Branch
```bash
git checkout -b feature/YourFeatureName
# or for bug fixes
git checkout -b bugfix/YourBugFixName
```

### 3. Make Your Changes
- Follow the existing code style and conventions
- Add comments for complex logic
- Write unit tests for new features

### 4. Commit Your Changes
```bash
git add .
git commit -m "feat: Add patient appointment reminders"
# or
git commit -m "fix: Resolve database connection timeout issue"
```

### 5. Push to Your Fork
```bash
git push origin feature/YourFeatureName
```

### 6. Submit a Pull Request
- Provide a clear description of your changes
- Link to any related issues
- Ensure all tests pass

### Code Style Guidelines
- Use meaningful variable and method names
- Follow Java naming conventions (camelCase for variables, PascalCase for classes)
- Keep methods focused and under 30 lines when possible
- Add Javadoc comments for public methods

---

## Support

### Getting Help

- **Documentation**: Check the `/docs` directory for detailed guides
- **Issue Tracker**: Report bugs and feature requests on [GitHub Issues](https://github.com/rupesh12k6/Hospital_Manage/issues)
- **Email**: rupesh12k6@example.com
- **Discussion Forum**: Use GitHub Discussions for general questions

### Reporting Bugs

Include the following information:
- Operating system and Java version
- Step-by-step reproduction instructions
- Error messages and stack traces
- Screenshots (if applicable)

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

### What You Can Do
✅ Use for commercial or personal projects  
✅ Modify the source code  
✅ Distribute the software  
✅ Use the software privately  

### What You Must Do
✓ Include a license and copyright notice  
✓ Provide a copy of the license with distributions  

---

## Contact

**Project Owner**: [rupesh12k6](https://github.com/rupesh12k6)  
**Email**: rupesh12k6@example.com  
**Repository**: [Hospital_Manage](https://github.com/rupesh12k6/Hospital_Manage)  

---

## Changelog

### Version 1.0.0 (Current)
- ✅ Patient management system
- ✅ Appointment scheduling
- ✅ Staff management
- ✅ Billing and invoicing
- ✅ Medical records storage
- ✅ Security and audit logging

### Upcoming Features (v1.1.0)
- 🔄 Mobile app integration
- 🔄 Advanced analytics dashboard
- 🔄 Multi-hospital support
- 🔄 Insurance claim automation

---

**Last Updated**: June 2026  
**Maintained By**: rupesh12k6  
**Status**: ✅ Active & Maintained
