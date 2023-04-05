@Library('docker') _
pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
        stage('Dockerize') {
            steps {
                sh 'docker build -t test2 .'
                sh 'docker tag test2 bbnerino/test2'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub', url: 'https://index.docker.io/v1/']) {
                    sh 'docker push bbnerino/test2'
                }
            }
        }
        stage('Deploy') {
            steps {
                sshagent(['my-ssh-credential']) {
                    sh '''
                        ssh user@your_server "docker pull bbnerino/test2"
                        ssh user@your_server "docker run -d -p 5005:80 --name my-app bbnerino/test2"
                    '''
                }
            }
        }
    }
}