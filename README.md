## CleverDev test task

### Overview

The application consists of 2 components:
1. __Old system__: stores clients in the old format
2. __New system__: imports data from old system, maps it and store it in the db

### Data Import
Data import occurs every 2 hours, at 15 minutes past the first hour.

### Running the Application:

To start the application, use the following command:
```shell
    docker compose up -d --build
```

### Stopping the Application:

To stop the application, use the following command:

```shell
    docker compose down -v
```