pipeline {
    agent any

    tools{
        maven 'my-maven'
        jdk 'my-jdk'
    }

    stages {
        stage('Git') {
            steps {
                echo 'Pull code from github'
                git url : 'https://github.com/anxgh-n/Book-project-authordetails.git',branch:'master'
            }
        }
        stage('Build') {
            steps {
                echo 'Build project using maven'
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                echo 'Test your application'
                bat "mvn test"
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploy the project'
                bat 'docker rm -f authordetails-container || true'
                bat 'docker rmi -f authordetails-image || true'
                bat 'docker build -t authordetails-image .'
                bat 'docker run --network eurekabook-network -p 7071:7071 -d --name authordetails-container authordetails-image'
            }
        }
    }
}
