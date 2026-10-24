# Hotel2

A Java Swing hotel-management desktop app backed by MySQL. It includes forms for hotels, rooms, employees, customers, roles, and work assignments, plus customer stay dates and a room/date overlap check.

## Stack

- Java 11, Swing, and NetBeans-generated forms.
- MySQL/JDBC with bundled Connector/J `8.0.27`.
- JCalendar `1.4` date widgets and `rs2xml.jar` table conversion.
- Maven with a local `AbsoluteLayout` dependency under `lib/`.

## Local setup

1. Install JDK 11, a Java IDE or Maven, and a MySQL server.
2. Create an empty local database named `hotel`, review [`hotel.sql`](hotel.sql), and import it into that database. It includes schema and sample data; do not import into a database containing important records.
3. Configure the database connection calls in `Hotel_Mangment.java` and `com/tables.java`. They currently target `jdbc:mysql://localhost/hotel` using local `root` with an empty password. Use a dedicated development account instead, and do not commit real credentials.
4. Ensure the bundled `mysql-connector-java-8.0.27.jar` and `rs2xml.jar` are on the compile/runtime classpath. The POM declares `AbsoluteLayout` and JCalendar but omits these two dependencies; a plain Maven build needs dependency/classpath configuration first.
5. Launch the `Hotel_Mangment` main class in a graphical desktop session.

## Source guide

- [`src/main/java/Hotel_Mangment.java`](src/main/java/Hotel_Mangment.java): management forms, JDBC actions, selection lists, and booking-date checks.
- [`src/main/java/com/tables.java`](src/main/java/com/tables.java): database result tables.
- [`hotel.sql`](hotel.sql): relational schema and seed data.
- [`pom.xml`](pom.xml): Java and Maven dependencies.

## Limitations

This is a coursework-style app, not a production booking system. Connection details are repeated in source, database edits/deletions act directly on records, and the overlap check is application-side rather than a concurrency-safe reservation mechanism. Back up any test data you want to retain. Current-toolchain and end-to-end database behavior have not been verified.
