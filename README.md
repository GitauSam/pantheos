# pantheos

## overview

Simple fullstack solution that displays all customers in the datastore and provides filter functionality.

## dependencies

  - docker
  
## how to run
  
  1. Clone the application
  
  2. cd into the parent folder
      - cd pantheos
      
  3. cd into the back-end solution
      - cd jumia-backend
  
  4. run the back-end solution
      - docker build --tag=jumia-backend:latest .
      - docker run -p7600:7600 jumia-backend
      
  5. open another terminal and cd into the front-end solution
      - cd jumia-backend
      
  6. run the front-end solution
      - docker build --tag=jumia-frontend:latest .
      - docker run -p3300:3000 jumia-frontend
      - access the front-end via your browser: 'http://localhost:3300'
      
## how to stop

  1. open another terminal and take note of container ids
      - docker ps
  
  2. stop front-end solution
      - docker stop 'front-end-container-id'
          
  3. stop back-end solution
      - docker stop 'back-end-container-id'
